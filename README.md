Automation Framework details:
Different components used in this Framework: 
1. Feature Files 
2. Step Definition Classes 
3. Configuration File 
4. Cucumber Hooks with before and after 
5. Element Utilities/Libraries/Generic Functions 
6. Cucumber 6 Extent Report Adaptor for Spark HTML / PDF Reports 
7. Test Runners in JUnit 
8. Page Classes for POM 
9. Maven with pom.xml with different dependencies and plugins 
10. Parallel Execution 
11. Cucumber 6 Web HTML Reports 
12. Screenshot for Failure scenarios 
13. Integration with GIT Repo 
Technologies Used: 
1. Selenium WebDriver with Java Language binding 
2. Cucumber JVM library 
3. JDK 1.8 5. Maven (Build tool) 
4. Maven Plugins 
5. Cucumber extent report 6 adapter 
6. JUnit library 
7. Log4j 
8. GIT HUB - Git Repo
9. Jenkins 
10. Eclipse (IDE)



Instruction on how to Run the Tests:
1: Import the project from the given Git URL to eclipse
2: Navigate to the path /ToDoProject/src/test/java/TestRunner
3: Open the TestRunner file and Right click -> Run the file as Junit Test
4: The chrome browser will be launched with the tests
5: Once the execution is completed refresh the project and navigate to the (path/ToDoProject/target) open the report in local browse for reports form file lacation.
Hybrid Framework implementation Testing approach:
Implemented Page Object Model with Cucumber & Selenium below are the details .
1. Feature Files
Feature files are written in Gherkin language and this describe the behavior of the application in simple English language. They are denoted as test scenarios.
2. Step Definition Classes
Step definition classes have been mapped with the Feature file with actual code implementations.
They contain all the methods that execute the actions corresponding to each step.
3. Configuration File
The configuration file stores environment-specific settings, such as URLs, browser configurations, and timeouts.
With the help of cucumber options like Glue,Plugins,etc.
This configuration file is called as Test Runner File where the execution starts.
4. Cucumber Hooks with Before and After
Hooks have been used to run code before or after for specific scenarios or steps.
Common use cases include setting up and tearing down resources (e.g., opening/closing browsers).
5. Element Utilities/Libraries/Generic Functions
These folders are created for utility classes where we write the reusable methods for interacting with web elements (e.g., clicking, typing, verifying).
There folders are maintained to mainly optimize the code.
For Storing the properties files, Utilities files etc.
6. Desing pattern POM (Page Object Model) 
We have used the POM model to maintain all the pages and methods related to the elements.  
POM improves maintainability and reusability by separating page logic from test code.
We can update the pages in future without effecting the other pages.
7. Maven with pom.xml (Build tool)
Used Maven as build tool and for updating dependencies.
The pom.xml file played a vital role for all project configurations.
8. Reports
Cucumber 7 generates HTML reports with detailed information about test execution.
These reports help identify failing scenarios and provide insights for debugging.
Html and extent reports have been generated for Test Report.

 9. Integration with GIT Repo
To store the code used Git repository for version control and collaboration.

