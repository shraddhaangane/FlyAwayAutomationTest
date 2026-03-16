# ✈️ FlyAway Automation Test Suite

A complete Selenium + TestNG automation framework for validating the **FlyAway** flight booking web application.  
This project follows the **Page Object Model (POM)** design pattern and uses **Java**, **Maven**, and **WebDriver** to ensure scalability, maintainability, and clean separation of concerns.

---

## 🏷️ Badges

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-43B02A)
![TestNG](https://img.shields.io/badge/TestNG-Automation-blue)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![POM](https://img.shields.io/badge/Design-POM-yellow)
![License](https://img.shields.io/badge/License-MIT-green)

---

## 📌 Overview

The FlyAwayAutomationTest suite automates end‑to‑end scenarios for the FlyAway flight booking system.  
It covers:

- User registration and login  
- Searching for flights  
- Booking a flight  
- Admin login and management  
- Navigation and UI validation  

The framework is modular and easy to extend with new test cases.

---

## 🧱 Tech Stack

- **Java 8+**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**
- **TestNG HTML Reports**

---

## 📁 Project Structure

```
FlyAwayAutomationTest/
│
├── src/
│   └── com/flyaway/
│       ├── pages/          # Page Object classes
│       ├── tests/          # Test classes
│       └── utils/          # Utility classes (if present)
│
├── pom.xml                 # Maven dependencies
├── testNG.xml              # Test suite configuration
└── .gitignore
```

---

## ⚙️ Setup & Installation

### 1. Install prerequisites

- Java 8 or later  
- Maven 3.x  
- Chrome browser  
- ChromeDriver (matching your Chrome version)

### 2. Clone the repository

```bash
git clone https://github.com/shraddhaangane/FlyAwayAutomationTest.git
cd FlyAwayAutomationTest
```

### 3. Install dependencies

```bash
mvn clean install
```

---

## ▶️ Running the Tests

### Run the entire suite

```bash
mvn test
```

### Run using TestNG directly

```bash
testng testNG.xml
```

---

## 📊 Test Reports

After execution, TestNG generates HTML reports:

```
test-output/index.html
```

Reports include:

- Passed/Failed test summary  
- Execution logs  
- Failure stack traces  
- Suite execution time  

---

## 🧩 Framework Design

### Page Object Model (POM)

Each page in the FlyAway application has a corresponding Java class under:

```
src/com/flyaway/pages/
```

Each class contains:

- Web element locators  
- Page actions  
- Reusable methods  

### Test Classes

All test cases are located under:

```
src/com/flyaway/tests/
```

Each test class:

- Extends a base test (if present)  
- Uses TestNG annotations  
- Calls POM methods for UI interactions  

---

## 🔧 Extending the Framework

To add a new test:

1. Create a new Page Object in `pages/`  
2. Add a test class in `tests/`  
3. Add the test class to `testNG.xml`  
4. Run the suite  

The modular structure ensures minimal duplication and easy maintenance.

---

## 🧪 Sample Test Flow

A typical test includes:

1. Launching the FlyAway application  
2. Registering or logging in  
3. Searching for flights  
4. Selecting a route  
5. Booking a ticket  
6. Validating confirmation  

---

## 🤝 Contribution Guidelines

- Fork the repository  
- Create a feature branch  
- Commit changes  
- Submit a pull request  

---

## 📬 Contact

For questions, improvements, or issues, please open a GitHub issue in the repository.

