# Load tests for todo application
- Java 17 or higher
- Kotlin 2.0.x
- Gradle 8.x
- Docker

## Getting Started

### Before running tests

To set up the Docker container for the tested todo list application, follow these steps:
The image of the tested todo list application in [app](/app) folder.

Complete this command:

`docker load -i ./app/todo-app.tar`

`docker run -d -p 8080:4242 --name todo-app todo-app:latest`

Application available by address http://127.0.0.1:8080

### Run test

To run the tests, execute the following command:

Volume tests

`./gradlew gatlingRun --simulation com.bhft.simulations.Volume`

Stress tests

`./gradlew gatlingRun --simulation com.bhft.simulations.Stress`

Stability tests

`./gradlew gatlingRun --simulation com.bhft.simulations.Stability`

Performance tests

`./gradlew gatlingRun --simulation com.bhft.simulations.Perfomance`

### Report

After test execution reports in `/build/reports/gatling/_/index.html`.

### Test parameters

List of available variables:
- `intensity` - maximal number of users on the last load stage (equals to requests per second)
- `rampDuration` - time for ramp-up stage (seconds)
- `stageDuration` - time for load stage (seconds)
- `stages` - number of load stages (applicable only for max performance test)
- `stages` - number of load stages (applicable only for performance test)
- `atOnceUsers` - number of users (applicable only for volume test)

