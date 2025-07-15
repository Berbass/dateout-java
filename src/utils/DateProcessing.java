package utils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateProcessing {
    public static int getCurrentCentury() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return year - (year % 100);
    }

    public static Date getDateFromInts(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();

        if (year < 1900 || month < 1 || month > 12 || day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid date values provided.");
        }

        calendar.set(year, month - 1, day, 0, 0, 0); // Calendar months are 0-based

        return calendar.getTime();
    }

    protected static Date getPossibleEnglishNumericSpacedDate(String input) {
        String regexEnglishMaybe = "\\d{4}\\s+\\d{1,2}\\s+\\d{1,2}";
        Pattern pattern = Pattern.compile(regexEnglishMaybe);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String dateString = matcher.group();
            String[] parts = dateString.split("\\s+");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]); // Calendar months are 0-based
            int day = Integer.parseInt(parts[2]);

            if (month > 12 && day <= 12) {
                // If the month is greater than 12 and the day is less than or equal to 12,
                // we assume the day and month are swapped
                int temp = month;
                month = day;
                day = temp;
            }

            try {
                // Create a Date object using the parsed year, month, and day
                return getDateFromInts(year, month, day); // Date constructor is deprecated but used for simplicity
            } catch (IllegalArgumentException e) {
                // If the date is invalid, return null
                return null;
            }
        }


        return null;
    }

    protected static Date getPossibleFrenchNumericSpacedDate(String input) {
        String regexFrenchMaybe = "\\d{1,2}\\s+\\d{1,2}\\s+\\d{4}";
        Pattern pattern = Pattern.compile(regexFrenchMaybe);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String dateString = matcher.group();
            String[] parts = dateString.split("\\s+");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]); // Calendar months are 0-based
            int year = Integer.parseInt(parts[2]);

            if (month > 12 && day <= 12) {
                // If the month is greater than 12 and the day is less than or equal to 12,
                // we assume the day and month are swapped
                int temp = month;
                month = day;
                day = temp;
            }

            try {
                // Create a Date object using the parsed year, month, and day
                return getDateFromInts(year, month, day); // Date constructor is deprecated but used for simplicity
            } catch (IllegalArgumentException e) {
                // If the date is invalid, return null
                return null;
            }
        }

        return null;
    }

    public static Date getMatchedFullNumbersDate(String input) {
        String cleanedInput = StringProcessing.getCleanedInput(input);

        Date date;

        if ((date = getPossibleEnglishNumericSpacedDate(cleanedInput)) != null) {
            return date;
        }

        if ((date = getPossibleFrenchNumericSpacedDate(cleanedInput)) != null) {
            return date;
        }

        String regexNonSpacedDate = "\\b(\\d{6,8})\\b|\\d{2}\\s+\\d{2}\\s+\\d{2}";
        Pattern pattern = Pattern.compile(regexNonSpacedDate);
        Matcher matcher = pattern.matcher(cleanedInput);

        if (matcher.find()) {
            String dateString = matcher.group();
            dateString = dateString.replaceAll("\\s+", ""); // Remove any spaces

            Function<String, String> getObviousYearPartPosition = (dateStr) -> {
                if (dateStr.length() == 8) {
                    int monthCandidateFirst = Integer.parseInt(dateStr.substring(2, 4));
                    int monthCandidateSecond = Integer.parseInt(dateStr.substring(4, 6));

                    if (monthCandidateFirst > 12 && monthCandidateSecond <= 12) {
                        return "head";
                    } else if (monthCandidateSecond > 12 && monthCandidateFirst <= 12) {
                        return "tail";
                    }
                } else if (dateStr.length() == 6) {
                    Calendar calendar = Calendar.getInstance();
                    int currentYear = calendar.get(Calendar.YEAR) % 100; // Get the last two digits of the current year

                    int yearCandidateAtHead = Integer.parseInt(dateStr.substring(0, 2));
                    int yearCandidateAtTail = Integer.parseInt(dateStr.substring(4, 6));

                    if (yearCandidateAtHead == currentYear && yearCandidateAtTail != currentYear ||
                            yearCandidateAtHead > 31 && yearCandidateAtTail <= 31) {
                        return "head";
                    } else if (yearCandidateAtTail == currentYear && yearCandidateAtHead != currentYear ||
                            yearCandidateAtTail > 31 && yearCandidateAtHead <= 31) {
                        return "tail";
                    }
                }

                return null;
            };

            int year = 0, month = 0, day = 0;
            int yearCandidateAtHead = 0, yearCandidateAtTail = 0;

            if (dateString.length() == 8) {
                yearCandidateAtHead = Integer.parseInt(dateString.substring(0, 4));
                yearCandidateAtTail = Integer.parseInt(dateString.substring(4, 8));
            } else if (dateString.length() == 6) {
                yearCandidateAtHead = Integer.parseInt(dateString.substring(0, 2)) + getCurrentCentury();
                yearCandidateAtTail = Integer.parseInt(dateString.substring(4, 6)) + getCurrentCentury();
            }

            if (Objects.equals(getObviousYearPartPosition.apply(dateString), "head")) {
                year = yearCandidateAtHead;
                month = dateString.length() == 8 ?
                        Integer.parseInt(dateString.substring(4, 6)) :
                        Integer.parseInt(dateString.substring(2, 4));
                day = dateString.length() == 8 ?
                        Integer.parseInt(dateString.substring(6, 8)) :
                        Integer.parseInt(dateString.substring(4, 6));
            } else if (Objects.equals(getObviousYearPartPosition.apply(dateString), "tail")) {
                year = yearCandidateAtTail;
                month = Integer.parseInt(dateString.substring(2, 4));
                day = Integer.parseInt(dateString.substring(0, 2));
            }

            if (year != 0 && month != 0 && day != 0) {
                try {
                    return getDateFromInts(year, month, day);
                } catch (IllegalArgumentException e) {
                    return null;
                }
            }
        }

        return null;
    }

    protected static Date getPossibleFrenchTextMonthDate(String input) {
        String[][] monthNames = {
                {"janvier", "janv", "jan",},
                {"février", "fevrier", "févr", "fevr", "fév", "fev"},
                {"mars", "mar"},
                {"avril", "avr", "avrl"},
                {"mai"},
                {"juin"},
                {"juillet", "juil"},
                {"août", "aout", "aou", "aoû"},
                {"septembre", "sept", "sep"},
                {"octobre", "oct"},
                {"novembre", "nov"},
                {"décembre", "decembre", "déc", "dec"}
        };

        String joinedMonthNames = String.join("|",
                Arrays.stream(monthNames)
                        .flatMap(Arrays::stream)
                        .toArray(String[]::new));

        String regexTextMonthDate = "(\\d{1,2}(?:er|ier)?)\\s+(" + joinedMonthNames + ")\\.?\\s+(\\d{2,4})";
        Pattern pattern = Pattern.compile(regexTextMonthDate, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String dayNumber = matcher.group(1).replaceAll("[^\\d]", ""); // Remove any suffix like 'ier', 'er'
            int day = Integer.parseInt(dayNumber);
            String monthString = matcher.group(2).toLowerCase();
            int year = Integer.parseInt(matcher.group(3));

            if (year < 100) {
                year += getCurrentCentury();
            }

            for (int i = 0; i < monthNames.length; i++) {
                for (String monthName : monthNames[i]) {
                    if (monthString.startsWith(monthName)) {
                        int month = i + 1; // Convert to 1-based month index
                        return getDateFromInts(year, month, day);
                    }
                }
            }
        }

        return null;
    }

    protected static Date getPossibleEnglishTextMonthDate(String input) {
        String[][] monthNames = {
                {"january", "jan"},
                {"february", "feb", "febr"},
                {"march", "mar"},
                {"april", "apr", "aprl"},
                {"may"},
                {"june", "jun"},
                {"july", "jul"},
                {"august", "aug"},
                {"september", "sep", "sept"},
                {"october", "oct"},
                {"november", "nov"},
                {"december", "dec"}
        };

        String joinedMonthNames = String.join("|",
                Arrays.stream(monthNames)
                        .flatMap(Arrays::stream)
                        .toArray(String[]::new));

        String regexTextMonthDate1 = "(" + joinedMonthNames + ")\\.?\\s+(\\d{1,2}(?:st|nd|rd|th)?)\\s+(\\d{2,4})";
        String regexTextMonthDate2 = "(\\d{1,2}(?:st|nd|rd|th)?)\\s+(" + joinedMonthNames + ")\\.?\\s+(\\d{2,4})";
        String regexTextMonthDate3 = "(\\d{2,4})\\s+(" + joinedMonthNames + ")\\.?\\s+(\\d{1,2}(?:st|nd|rd|th)?)";

        String[] regexesToTry = {regexTextMonthDate1, regexTextMonthDate2, regexTextMonthDate3};

        for (int i = 0; i < regexesToTry.length; i++) {
            String regexTextMonthDate = regexesToTry[i];

            Pattern pattern = Pattern.compile(regexTextMonthDate, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String monthString, dayNumber;
                int day, year;

                switch (i) {
                    case 0 -> {
                        monthString = matcher.group(1).toLowerCase();
                        dayNumber = matcher.group(2).replaceAll("[^\\d]", ""); // Remove any suffix like 'st', 'nd', 'rd', 'th'
                        day = Integer.parseInt(dayNumber);
                        year = Integer.parseInt(matcher.group(3));
                    }
                    case 1 -> {
                        dayNumber = matcher.group(1).replaceAll("[^\\d]", ""); // Remove any suffix like 'st', 'nd', 'rd', 'th'
                        day = Integer.parseInt(dayNumber);
                        monthString = matcher.group(2).toLowerCase();
                        year = Integer.parseInt(matcher.group(3));
                    }
                    case 2 -> {
                        year = Integer.parseInt(matcher.group(1));
                        monthString = matcher.group(2).toLowerCase();
                        dayNumber = matcher.group(3).replaceAll("[^\\d]", ""); // Remove any suffix like 'st', 'nd', 'rd', 'th'
                        day = Integer.parseInt(dayNumber);
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + i);
                }

                if (year < 100) {
                    year += getCurrentCentury();
                }

                for (int j = 0; j < monthNames.length; j++) {
                    for (String monthName : monthNames[j]) {
                        if (monthString.startsWith(monthName)) {
                            int month = j + 1; // Convert to 1-based month index
                            return getDateFromInts(year, month, day);
                        }
                    }
                }
            }

        }

        return null;
    }

    public static Date getMatchedTextMonthDate(String input) {
        String cleanedInput = StringProcessing.getCleanedInput(input);
        Date date;

        if ((date = getPossibleEnglishTextMonthDate(cleanedInput)) != null) {
            return date;
        }

        if ((date = getPossibleFrenchTextMonthDate(cleanedInput)) != null) {
            return date;
        }

        return null;
    }

    public static Date getMatchedDate(String input) {
        Date date;

        if ((date = getMatchedFullNumbersDate(input)) != null) {
            return date;
        }

        if ((date = getMatchedTextMonthDate(input)) != null) {
            return date;
        }

        return null;
    }
}
