# api-automation
Repository include automated tests of an github API  

## Prerequisites
* Java 8+

## Setup

* Clone the repo
* Install [Maven](https://maven.apache.org/download.cgi)
* Add it to PATH system variable
* Check if maven is configured corectly 
```
  mvn --version
  ```
* Install dependencies `mvn compile`

## Running your tests

1. To run all test, run `mvn test -P all_tests`
2. Right click on /config/all_tests.testng.xml and click run

## TO BE DONE:

- add other DTOs
- add basic authentication for secured endpoints
- add Jenkins integration
- add Slack notifications with tests results


## Notes 

* You can change default username and server in a config file: conf/config.conf.json
* You can also define them as system variables:
Linux:
  ```
  export TEST_USER = <github-username> &&
  export BASE_URL=<github-server> &&
  ```
 Windows:
 ```
  SETX TEST_USER <github-username>
  SETX BASE_URL <github-server>
  ```
