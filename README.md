# Demo project with Test-driven development (TDD) approach 

## Requirements: 
- Java 11

## Business requirements: 
* As a user I want to provide my address and internet speed in Mb\sec and retrieve average internet speed by this address. 

## Stages of the development:
1. [Project initialization](https://github.com/DmRomantsov/tdd-demo-speedpoll/commit/0a6cdd83ffb1cd2a568cd7518765263e80275ef7)
2. [H2 database configuration. RED stage](https://github.com/DmRomantsov/tdd-demo-speedpoll/commit/cfd35f48a937fcc8eff287909f7f7423dc425e52).
Test created, project even not compiled, which was expected. 
3. [H2 database configuration. GREEN stage](https://github.com/DmRomantsov/tdd-demo-speedpoll/commit/e289d1226534a7885159ae3c5e709f71f3e60450)
Test passed. 
4. [H2 database configuration. REFACTOR stage](https://github.com/DmRomantsov/tdd-demo-speedpoll/commit/e289d1226534a7885159ae3c5e709f71f3e60450)
All test and temporary classes deleted, because they were part of implementation, not business requirements.
5. [Speed pool implementation. RED stage. Tests, interfaces, pojo](https://github.com/DmRomantsov/tdd-demo-speedpoll/commit/3eaa8da12026d17a2454b6607982432e7a245dfd)
Here I also added some interfaces and POJO for sake of code autocomplete and typo check.
6. [Speed pool implementation. GREEN stage. Implementation.](https://github.com/DmRomantsov/tdd-demo-speedpoll/commit/fa71b762cac51d361aef242be0c3a448f2b949f7)
7. There is no refactoring stage because code isn't so complicated.

## How to
### Run tests
```shell script
./gradlew test
````

### Start service
```shell script
./gradlew bootRun
````

## What's missing here

* Domain object `Answer` is not separated from entity. In cases where DB interactions are obvious 
I prefer not adding additional mapping level.  In other cases I recommend using some mapper library (ex. MapStruct).

## Recommended links:
- [Test Driven Development: By Example - Kent Beck](https://www.amazon.com/Test-Driven-Development-Kent-Beck/dp/0321146530)
- [Ian Cooper - TDD, Where Did It All Go Wrong](https://youtu.be/EZ05e7EMOLM)
