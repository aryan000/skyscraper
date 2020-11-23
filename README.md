# skyscraper
SkyScraper - Apache Camel Data Transformation Integration Series - 2

#Installation
* Install Maven Dependency: brew install maven
* Install Java 11
* brew install kafka
* zookeeper
To have launchd start zookeeper now and restart at login:
  `brew services start zookeeper`
Or, if you don't want/need a background service you can just run:
  `zkServer start`
* kafka
To have launchd start kafka now and restart at login:
  `brew services start kafka`
Or, if you don't want/need a background service you can just run:
  `zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & kafka-server-start /usr/local/etc/kafka/server.properties`
* To start zookeper in Mac: 
  `zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties`
  
* To start kafka in Mac: 
  `kafka-server-start /usr/local/etc/kafka/server.properties`
  
  

#Setup 
* Run `mvn clean install` to install dependencies from pom.xml
* Run `mvn spring-boot:run` to start the application
* Swagger Link : Swagger link : http://localhost:8080/camel/api-doc
* Curl command to test Camel API: `curl -X POST http://localhost:8090/camel/api/bean -H 'Content-Type: application/json' -d '{"id":1,"name":"World"}'`


#Endpoints
* GET `/home` - a sample Controller
* GET `/kafka/send` - send topic to kafka
* POST `/kafka/publish` - post request topic to kafka with message query param
