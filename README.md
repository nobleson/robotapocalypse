# Robot Apocalypse
Robot Apocalypse is a last hope for hamanking a digital solution to help identify and register survivals of robot attack.

# About The Solution
This apllication is developed using Spring Boot to build a RESTFul backend that communicate with front end build with Vuejs, by recieving API request and processing it. It currecntly uses an in-memory database H2 for data storage.

# System Requirements
The solution is develop and tested on a Windows platform 64 bit, but it should run on any operating system.
For following tools where used for development and testing:

- Windows Os 64bit
- Spring Tool Suit (STS) 4
- VS Code Editor
- NPM (version 6.14.12)
- @vue/cli 4.4.1
- JDK 8
- Maven 3.8
- Browser (Chrome Opera)
- POSTMAN

# Project Setup
The backend of the application is build on Spring Boot, and it requires Port 8080 to be available for it to run. While the front end build with Vuejs is configured to run on Port 4000, however you can edit from script section of the package.json (/client/package.json) 
##### Spring Boot backend setup:
Open the terminal of your system and run the following command
```
git clone https://github.com/nobleson/robotapocalypse.git
cd robotapocalypse
mvn clean spring-boot:run
```
If everything goes well, you will see your backend application running on port 8080
```
http://localhost:8080
```
There is a preloaded data to help you test the front end.
##### Vuejs front end setup:
We assumed that you have already deployed the backend application on your localhost and is running ok.
Open a new terminal and execute the following command
```
 cd robotapocalypse/client
 npm install
 npm run serve
```
If averything goes well, you should see your application running on localhost port 4000. Open it from the browswer using this link:
```
http://localhost:4000
```
![home](https://user-images.githubusercontent.com/14866971/154072531-812545e5-cdfc-46ab-836e-3d1e25e6bca5.PNG)

![manage](https://user-images.githubusercontent.com/14866971/154072577-3149a611-a724-4556-973b-dba5da01106a.PNG)

# API Endpoints
#### Survivor End Point
This API allow you to perform CRUD operations on Survivor Data that is store in H2 immemory database. For security purpose, you may not be able to register,or delete, or update a survivor using POSTMAN. however CORS is enable on port:4000 so you can perform all that from the Vuejs application
Read data with this GET url: 
```
http://localhost:8080/survivors
```
Register survivor's data with this POST url: 
```
http://localhost:8080/survivor
```
Update survivor's data with this PUT url: 
```
http://localhost:8080/survivor/{id}
```
Delete survivor's data with this DELETE url: 
```
http://localhost:8080/survivor/{id}
```
# Database Details
We use H2 database which is an open-source lightweight database build with Java and is configured to run as un-memory database. 
It is not used for production development, but mostly used for development and testing. However Spring Data, JPA and Hibernate is used to connect the H2 database therefore any database such as mysql can be used in the production environment without any neccessary code change.
