# skyscraper
SkyScraper - Apache Camel Data Transformation Integration Series - 2

#Installation
* Install Maven Dependency: brew install maven
* Install Java 11
* brew install kafka


#Setup 
* Run `mvn clean install` to install dependencies from pom.xml
* Run `mvn spring-boot:run` to start the application
* Swagger Link : Swagger link : http://localhost:8080/camel/api-doc
* Curl command to test Camel API: `curl -X POST http://localhost:8080/camel/api/bean -H 'Content-Type: application/json' -d '{id:1,name:World}'`


#Endpoints
* GET `/home` - a sample Controller
* GET `/kafka/send` - send topic to kafka
* POST `/kafka/publish` - post request topic to kafka with message query param
