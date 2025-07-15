# DateOut _- Extract Embedded Date_

This project is a Java-based application designed to extract and process dates embedded in text. It uses regular expressions to identify date patterns and provides functionality to validate and process these dates.

## Features

- Extract dates from user-provided text.
- Supports multiple date formats, in both numeric and textual representations, English and French:
  - `DDMMYY` (e.g., `100523`)
  - `DD MM YY` (e.g., `10 05 23`)
  - `DD MM YYYY` (e.g., `10 05 2023`)
  - `DD MMM YY` (e.g., `11 Apr 23`)
  - `MMM DD YYYY` (e.g., `Jun 10th 2023`)
  - `DD MMMM YY` (e.g., `10 Juillet 23`)
  - ...
- Validates extracted dates to ensure they are meaningful.
- Provides test cases to verify functionality.
- ⚠️ Dates can not always be extracted correctly, especially when the date format is ambiguous.

## Prerequisites

- **Java 8 or higher**: Ensure you have Java installed on your system.
- **JUnit 5**: Used for running the test cases.

## How to Run

1. Clone the repository:
   ```bash
   git clone <repository-url> <dir_name>
   cd <dir_name>
   ```

2. Compile and run the application:

This project is built to be integrated easily with IntelliJ IDEA as it uses a .iml file for project configuration. You can also compile and run it using standard java commands.

3. Once the Main process is ran, follow the prompts in the console to input text and extract dates.

## Project Structure

- `src/Main.java`: Entry point of the application.
- `src/utils/DateProcessing.java`: Contains logic for extracting and validating dates.
- `src/test/java/date_processing/*`: Unit tests for date extraction and validation.
- `LICENSE`: Apache License 2.0 for the project.

## Example Usage

When you run the application, you can input text containing dates. For example:

Input:
```
The event is scheduled for jan. 12 24.
```

Output:
```
Processing the provided text: "The event is scheduled for jan. 12 24."...
The following date was matched: "Fri Jan 12 00:00:00 CET 2024"
```

## Running Tests

The project includes unit tests to verify the functionality of date extraction and validation. You can run the tests using your IDE or via command line.

Ensure the `JUnit 5` dependencies are correctly set up in your environment.

## License

This project is licensed under the [Apache License 2.0](LICENSE).
