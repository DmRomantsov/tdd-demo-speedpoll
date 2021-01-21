# Demo project with Test-driven development (TDD) approach 

## Requirements: 
- Java 11

## Business requirements: 
* As a user I want to provide my address and internet speed in Mb\sec and retrieve average internet speed by this address. 

## Stage of development
* [Project initialization](https://github.com/DmRomantsov/tdd-demo-speedpoll/commit/0a6cdd83ffb1cd2a568cd7518765263e80275ef7)
* [H2 database configuration. RED stage](https://github.com/DmRomantsov/tdd-demo-speedpoll/commit/cfd35f48a937fcc8eff287909f7f7423dc425e52).
Test created, project even not compiled, which was expected. 
* [H2 database configuration. GREEN stage](https://github.com/DmRomantsov/tdd-demo-speedpoll/commit/e289d1226534a7885159ae3c5e709f71f3e60450)
Test passed. 
* [H2 database configuration. REFACTOR stage]()
All test and temporary classes deleted, because they were part of implementation, not business requirements.

## How to
### Run tests
```shell script
./gradlew test
````

### Start service
```shell script
./gradlew bootRun
````

## Recommended links:
- [Test Driven Development: By Example - Kent Beck](https://www.amazon.com/Test-Driven-Development-Kent-Beck/dp/0321146530)
- [Ian Cooper - TDD, Where Did It All Go Wrong](https://youtu.be/EZ05e7EMOLM)