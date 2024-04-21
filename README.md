WEB & API Automation Project 
In this project following tools and languages used for Web Automation : java , selenium , testng 
following tools and languages used for API Automation : java , rest-assured , testng
reporting of testcase : extent spark report with screenshot
Framework : cucumber BDD Framework
Project structure :
*src/test/main
  - AbstractComponent
   -AbstractComponent.java
  - pageObject
   -landingloginPage.java
*src/test/java
   -cucumber
    -TestNGTestRunner.java
    -Wrongcredentials.feature
   -StepDefinitions
    -Stepdefinition.java
   -TestComponents
    -BaseTest.java
*src/test/resources
    -extent.properties
*target
  -Reports
    -screenshots
    -spark.html
    -sparkPDF.pdf
*pom.xml
