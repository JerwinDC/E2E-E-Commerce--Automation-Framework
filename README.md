# E2E-E-Commerce--Automation-Framework

🚀 Automation Framework Project
This is a Selenium-based Automation Testing Framework built using Java, Maven, and TestNG. Designed using the Page Object Model (POM) design pattern, this framework is modular, maintainable, and scalable for testing the SauceDemo e-commerce web application.

📌 Project Highlights
Automates core e-commerce user flows on saucedemo.com
Validates end-to-end functionality: login, shopping cart, checkout, and logout
Built with extensibility and reusability in mind using POM
Supports configuration via properties file
Cross-browser support (Chrome, Firefox, Edge)
Integrated ExtentReports for detailed HTML reports

🧪 Features Covered
The framework currently supports automation of the following features:

✅ Login functionality
✅ Adding two items to the cart
✅ Validating items in the cart
✅ Completing the checkout flow
✅ Validating checkout completion
✅ Logging out of the application  


🛠️ Tech Stack
Language: Java  
Automation Tool: Selenium WebDriver  
Build Tool: Maven  
Test Framework: TestNG  
Reporting: ExtentReports  
Design Pattern: Page Object Model (POM)


🌐 Site Under Test
https://www.saucedemo.com
🗂️ Project Structure
.
├── src
│   ├── main
│   │   └── java
│   │       └── com/framework/base/            
│   │       └── com/framework/pages/             
│   │       └── com/framework/utils/       
│   │   └── resources
│   │       └── com/framework/config/             
│   ├── test
│       └── java
│           └── com/framework/tests/             
├── Reports/                       // ExtentReport HTML output
└── pom.xml


⚙️ Configuration
The framework uses a config.properties file to manage environment-level and test settings. You can configure:
browser = chrome | firefox | edge  
url = https://www.saucedemo.com  
username = standard_user  
password = secret_sauce

🔁 Cross-Browser Support

Update the browser property in config.properties file to run tests in different browsers:
browser = chrome
browser = firefox
browser = edge  

📄 How to Run the Tests
Clone the repository:
git clone https://github.com/your-username/automation-framework.git

Navigate to the project directory:
Run tests using Maven

View reports in:
/Reports/[current date and time folder name]/index.html


✅ Reporting
Uses ExtentReports to generate visual, structured, and informative test execution reports.

📂 Sample Report Output
\Reports\Fri-Apr-11-17_59_34-CST-2025]\index.html


Test Summary (Pass/Fail/Skipped)
Timestamps and logs


📌 Best Practices Followed
Page Object Model design pattern
Configuration-driven
Clean code structure with reusable components
Separation of test logic and element locators
Error handling and assertion validations


🙌 Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to modify.

📧 Contact
For questions or feedback, reach out to me via GitHub or email.
Email: decastrojerwindj@gmail.com
