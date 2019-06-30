# demomvcwar
## Prerequisites
* Tomcat >= 8.5
## Instructions
* create mysql database demo_mvc_db
* `mvn clean package -Dmaven.test.skip=true`
* start tomcat
* `cp target/demomvcwar.war ${TOMCAT_ROOT}/webapps`
The application is bound on port 8080

## Main url
* http://localhost:8080/demomvcwar/products/list
