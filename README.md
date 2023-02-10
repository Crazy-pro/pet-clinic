### Pet Clinic
This repository contains an example of a multi-module Spring Boot project with Back-End and Front-End parts. 

  

### How to start:
1. Install and run any IDE for working with Java.
2. Install the latest version of docker if you still haven't done it.
3. Chose MySQL or MariaDB profile in resources package (Default MySQL).
4. Run MySQL or MariaDB Docker Container or just use the PC client:
   - docker pull mysql
   - docker run --name mysqldb -p 3306:3306 -e MYSQL_USER=mysql -e MYSQL_PASSWORD=admin -d mysql
   - docker pull mariadb
   - docker run --name mdb -p 3306:3306 -e MARIADB_USER=mariadb -e MARIADB_PASSWORD=admin -d mariadb
5. Run the application and check end-points work using Postman using link below:
   - http://localhost:8080/



### Technologies:
- Programming language: Java 11;
- Frameworks:
  - Spring (Boot, Core, Data, WebMVC, Test, Actuator);
  - Hibernate.
- IDE: IntelliJ IDEA;
- Databases:
  - MySQL, MariaDB.
- Tools: JUnit 5, Mockito, Lombok, Postman, Maven, Git, Docker, JDBC, JPA, JMS, HTTPs, XML, YAML, JSON;
- Others: GitHub, CircleCI, CodeCov, SonarLint, SonarCloud, HTML, CSS, ThymeLeaf.

[![CircleCI](https://circleci.com/gh/Crazy-pro/pet-clinic.svg?style=svg)](https://app.circleci.com/gh/Crazy-pro/pet-clinic)
[![CodeCov](https://codecov.io/gh/Crazy-pro/pet-clinic/branch/master/graph/badge.svg)](https://codecov.io/gh/Crazy-pro/pet-clinic)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Crazy-pro_pet-clinic&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Crazy-pro_pet-clinic)

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-black.svg)](https://sonarcloud.io/summary/new_code?id=Crazy-pro_pet-clinic)

[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=Crazy-pro_pet-clinic&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=Crazy-pro_pet-clinic)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Crazy-pro_pet-clinic&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=Crazy-pro_pet-clinic)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Crazy-pro_pet-clinic&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Crazy-pro_pet-clinic)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Crazy-pro_pet-clinic&metric=bugs)](https://sonarcloud.io/summary/new_code?id=Crazy-pro_pet-clinic)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=Crazy-pro_pet-clinic&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=Crazy-pro_pet-clinic)

[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=Crazy-pro_pet-clinic&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=Crazy-pro_pet-clinic)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=Crazy-pro_pet-clinic&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=Crazy-pro_pet-clinic)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=Crazy-pro_pet-clinic&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=Crazy-pro_pet-clinic)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=Crazy-pro_pet-clinic&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=Crazy-pro_pet-clinic)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Crazy-pro_pet-clinic&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Crazy-pro_pet-clinic)
