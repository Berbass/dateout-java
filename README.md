# Extract Embedded Date

This project is a Java-based application designed to extract and process dates embedded in text. It uses regular expressions to identify date patterns and provides functionality to validate and process these dates.

## Features

- Extract dates from user-provided text.
- Supports multiple date formats:
  - `DDMMYY` (e.g., `100523`)
  - `DD MM YY` (e.g., `10 05 23`)
- Validates extracted dates to ensure they are meaningful.
- Provides test cases to verify functionality.

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
   ```bash
   javac -d out src/**/*.java
   java -cp out Main
   ```

3. Follow the prompts in the console to input text and extract dates.

## Project Structure

- `src/Main.java`: Entry point of the application.
- `src/utils/DateProcessing.java`: Contains logic for extracting and validating dates.
- `src/test/java/date_processing/FullNumbersDateTest.java`: Unit tests for date extraction and validation.
- `LICENSE`: Apache License 2.0 for the project.

## Example Usage

When you run the application, you can input text containing dates. For example:

Input:
```
The event is scheduled for 10 05 23.
```

Output:
```
Processing the provided text: "The event is scheduled for 10 05 23."...
The following date was matched: "Wed May 10 00:00:00 UTC 2023"
```

## Running Tests

To run the test cases, use the following command:

```bash
java -jar junit-platform-console-standalone-1.8.1.jar --class-path out --scan-class-path
```

Ensure the `JUnit 5` dependencies are correctly set up in your environment.

## License

This project is licensed under the [Apache License 2.0](LICENSE).
