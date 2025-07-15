# Supported Date Formats

The date processing logics of this project can handle the following date formats:

## Numeric Date Formats
1. **YYYY MM DD**  
   Example: `2023 05 10`

2. **DD MM YYYY**  
   Example: `10 05 2023`

3. **YYYYMMDD**  
   Example: `20230510`

4. **DDMMYY**  
   Example: `100523`

5. **DD MM YY**  
   Example: `10 05 23`

6. **DD.MM.YY**  
   Example: `10.05.23`

7. **YYYY-MM-DD**  
   Example: `2023-05-10`

8. **DD/MM/YY**  
   Example: `10/05/23`

## Textual Month Date Formats (English)
1. **MMM DD YYYY**  
   Example: `May 10 2023`

2. **MMM DD, YYYY**  
   Example: `May 10, 2023`

3. **DD MMM YYYY**  
   Example: `10 May 2023`

4. **DD MMMM YYYY**  
   Example: `10 May 2023`

5. **MMM DD YY**  
   Example: `May 10 23`

6. **DD MMM YY**  
   Example: `10 May 23`

7. **YYYY MMM DD**  
   Example: `2023 May 10`

8. **MMM DDth YYYY**  
   Example: `May 10th 2023`

## Textual Month Date Formats (French)
1. **DD MMM YYYY**  
   Example: `10 Mai 2023`

2. **DD MMMM YYYY**  
   Example: `10 Mai 2023`

3. **DD MMM YY**  
   Example: `10 Mai 23`

4. **DD MMMM YY**  
   Example: `10 Mai 23`

5. **DD MMM YYYY (with suffix)**  
   Example: `1er Mai 2023`

6. **DD MMMM YY (with suffix)**  
   Example: `1ier Mai 23`

7. **YYYY MMM DD**  
   Example: `2023 Mai 10`

## Notes
- The file supports both **numeric** and **textual** date formats in **English** and **French**.
- It can handle **ambiguous formats** by attempting to guess the correct interpretation (e.g., swapping day and month if necessary).
- **Suffixes** like `st`, `nd`, `rd`, `th` (English) and `er`, `ier` (French) are also supported.
- ⚠️ The date guessing capability is limited, especially for 6-digit dates, as it relies on the current year being obvious from the text.
