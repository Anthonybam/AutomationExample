# AutomationExample
WebUI Automation using Selenium with TestNG

This is an example project of what I experienced when doing UI Automation using Selenium WebDriver. 
The project is a Maven Selenium Web Driver Project written in Java and using TestNG test framework consisting of 3 test cases for the Health Web UI (svcqa1.bamlabs.com),
and requires the following to be installed before running it:
- Latest Version of Maven (https://maven.apache.org/)
- Java JDK 
- IDE (IntelliJ)
- Firefox

In addition, the test "testLogin1()" requires admin account (without Backoffice) with login 'anthony', password 'Test1234', account name 'achung'.
After install and configure all of the above mentioned software:
1) Check out the project 
2) Open it in IDE (IntelliJ)
3) Open Maven Projects window
4) In Maven Projects window, expand Profiles node. Make sure the "mytest" profile is selected. If not, select it.
5) In Maven Projects window, expand Health node and double click on "clean" menu item to clean the project.
6) In the same Health node, doubble click on the install menu item to start running the project.
7) After the run, the result is in ..\target\surefile-reports\emailable-report.html


The following is the lay out of project structure:
1) All classes under ..\src\main\java\com\webui are page object classes modeling Health Web UI (Version 1.8.2 [1505052214] | Algo [22611])
2) Under ..\src\test\java\com\qa is sample "LoginTests" class consisting of 3 TestNG test cases.
3) Under ..\src\test\resources:
    a) log4j.properties:  properties file for logging
    b) mytest.xml: TestNG xml file specifying which test classes to run and how they will be run such thing as single thread or multi-threaded.
    
4) The project also creates file WebDriver.log file which is helpful for debugging purposes.
