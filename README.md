🧾 Keyword-Driven Test Automation Framework
A Selenium-TestNG-Maven based Keyword-Driven Test Automation Framework that enables execution of tests via easily configurable Excel sheets. 
Built for reusability, maintainability, and scalability in UI test automation.

✅ 1. Tech Stack
Language: Java

Automation Tool: Selenium WebDriver

Test Framework: TestNG

Build Tool: Apache Maven (v3.9.10)

Framework Pattern: Keyword-Driven

CI/CD: Jenkins Compatible

Reporting: TestNG Reports / ExtentReports (optional)



✅ 2. Features
🔑 Test steps defined using keywords in Excel

🔁 Supports data-driven testing and Hybrid Testing

🔧 High reusability of keyword methods

✅ 4. How to Run the Project
🔧 Prerequisites:

Java 8 or above installed

Maven 3.6+ (you’re using 3.9.10)

Git (optional if cloning)

🚀 Steps to Execute:

Clone the project:

bash

git clone https://github.com/DebajyotiSDET/SeleniumFramework.git
cd SeleniumFramework
Make sure testng.xml and pom.xml are configured correctly.

Run using Maven:

bash
mvn clean test
✅ This will execute the DriverCode class defined in your testng.xml, which reads steps from the Excel sheet and runs the automation.



✅ 5. CI/CD Integration
Jenkins-compatible: just add a build step as mvn clean test

Can be triggered via batch file, cron, or Git webhook

ExtentReports or TestNG reports can be archived in Jenkins



✅ 6. Author
👤 Debajyoti Goswami
SDET | Java | Selenium | TestNG | Maven | Jenkins
📧 Email: goswamidebajyoti00@gmail.com
🌐 GitHub: DebajyotiSDET


📂 Easy to maintain and scale for any project

📊 Generates detailed test execution reports

🔗 Integrates seamlessly with Jenkins or GitHub Actions

