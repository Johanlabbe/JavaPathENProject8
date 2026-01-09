# TourGuide

TourGuide is a Spring Boot application that provides travel information and rewards to users based on their location.

## Technologies

> Java 17
> Spring Boot 3.1.1
> JUnit 5
> Maven

## Installation & Dependencies

This project relies on local libraries located in the `libs` folder. To build the project, you **must** install them into your local Maven repository first.

Run the following commands from the project root:

```bash
mvn install:install-file -Dfile=libs/gpsUtil.jar -DgroupId=gpsUtil -DartifactId=gpsUtil -Dversion=1.0.0 -Dpackaging=jar
mvn install:install-file -Dfile=libs/RewardCentral.jar -DgroupId=rewardCentral -DartifactId=rewardCentral -Dversion=1.0.0 -Dpackaging=jar
mvn install:install-file -Dfile=libs/TripPricer.jar -DgroupId=tripPricer -DartifactId=tripPricer -Dversion=1.0.0 -Dpackaging=jar
```

## Improvements & Features

### 1. Performance Optimization (100k Users)
The application has been optimized to handle high volumes of users using **Multithreading** and **Non-blocking concurrency**.

- **GPS Tracking:** Time reduced from ~14 hours (sequential estimate) to **< 5 minutes** for 100,000 users.
- **Rewards Calculation:** Time reduced from > 20 minutes to **< 5 minutes** for 100,000 users.

**Technical Strategy:**
- Implementation of `ExecutorService` with a fixed thread pool (1000 threads).
- Use of `CompletableFuture` for asynchronous processing.
- Resolved `ConcurrentModificationException` by migrating `ArrayList` to thread-safe `CopyOnWriteArrayList` in the `User` domain.

### 2. New Feature: Nearby Attractions
A new endpoint `/getNearbyAttractions` has been added. It returns the 5 closest tourist attractions to the user, regardless of distance.

**Response Format (JSON):**
- Attraction Name
- Attraction Location (Lat/Long)
- User Location (Lat/Long)
- Distance (Miles)
- Reward Points

## CI/CD
The project’s industrialization is managed through two distinct **GitHub Actions** workflows to ensure code quality and streamlined delivery:

**Continuous Integration (CI)**: The ci.yml workflow is triggered on every push and pull request. It handles environment setup, installs local dependencies, and executes unit and integration tests (excluding performance tests) to provide rapid feedback.

**Continuous Deployment (CD)**: The cd.yml workflow is triggered only on the master and main branches. It packages the application and generates a downloadable Artifact (executable .jar file), making it ready for production deployment.
