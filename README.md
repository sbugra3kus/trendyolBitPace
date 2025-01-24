# Trendyol BitPace Project

## Overview
This project is a Gauge-based test automation framework designed to interact with the Trendyol website and perform various operations such as element interaction, validations, and navigation. The framework is structured to ensure maintainability, scalability, and ease of use for testing or automating Trendyol functionalities.

The framework also incorporates the Log4j library for effective logging and debugging. Log4j provides customizable logging levels and outputs, helping developers trace issues and monitor test execution more effectively.
This project is a Gauge-based test automation framework designed to interact with the Trendyol website and perform various operations such as element interaction, validations, and navigation. The framework is structured to ensure maintainability, scalability, and ease of use for testing or automating Trendyol functionalities.

---

## Features
- Automated navigation and interaction with Trendyol.
- Element location using dynamic XPath.
- Handling multiple browser tabs and windows.
- Dynamic waits for element presence and interactivity.
- Assertion and validation mechanisms.
- Logging for better traceability and debugging.

---

## Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher.
- Apache Maven.
- Gauge (Install from [Gauge](https://gauge.org)).
- A supported browser (e.g., Chrome or Firefox) and its corresponding WebDriver.
- An IDE like IntelliJ IDEA 

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/sbugra3kus/trendyolBitPace.git
   ```

2. Navigate to the project directory:
   ```bash
   cd trendyolBitPace
   ```

3. Install dependencies using Maven:
   ```bash
   mvn clean install
   ```

4. Download the browser WebDriver and add it to your system PATH.
   - For Chrome: [Download ChromeDriver](https://chromedriver.chromium.org/downloads)
   - For Firefox: [Download GeckoDriver](https://github.com/mozilla/geckodriver/releases)

5. Install Gauge plugins:
   ```bash
   gauge install java
   ```

---

## Usage

### Running Tests
1. Configure the `config.properties` file to set the desired browser and base URL.
2. Run the tests using Gauge:
   ```bash
   gauge run specs
   ```

### Example Code
Here’s an example of interacting with an element:

```java
WebDriver driver = new ChromeDriver();
driver.get("https://www.trendyol.com");

// Wait for an element
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='example']")));

// Interact with the element
element.click();
```

---

## Project Structure

```
trendyolBitPace/
├── specs
│   ├── ... (Gauge specifications for tests)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ... (core framework files)
│   ├── test/
│   │   ├── java/
│   │   │   └── ... (test cases)
├── pom.xml
├── config.properties
└── README.md
```

### Key Files
- `specs/`: Contains Gauge specifications written in Markdown.
- `pom.xml`: Maven configuration file for managing dependencies.
- `src/main/java`: Contains the core framework implementation.
- `src/test/java`: Contains test cases and helper classes.
- `config.properties`: Configuration file for test parameters (browser, base URL, etc.).

---

## Contributing
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch for your feature/bugfix.
3. Commit your changes and push the branch.
4. Create a pull request explaining your changes.


## Acknowledgements
- Selenium WebDriver
- Apache Maven
- Gauge Framework
- Trendyol website for testing scenarios

