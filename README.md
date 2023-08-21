# spring-microservices: Employee Application and Mail Server

This project demonstrates a microservices architecture using Spring Boot and Apache Kafka for event-driven communication between an "Employee" application (producer) and a "Mail Server" application (consumer).

## Table of Contents

- [Introduction](#introduction)
- [Setup](#setup)
- [Application Structure](#application-structure)
- [Running the Applications](#running-the-applications)

## Introduction

This project showcases how to implement a basic microservices architecture for an employee-related application. The "Employee" application generates events when employees are created, deleted, and updated and the "Mail Server" application consumes these events to send corresponding email notifications.

## Setup

Before running the applications, ensure you have the following prerequisites:

- Java (17+)
- Apache Kafka (running)
- Gradle (for building)

## Application Structure

The project consists of two separate applications:

1. **Employee Application:**
    - Responsible for employee-related functionality.
    - Generates Kafka events when employees are created.
    - Publishes events to a Kafka topic.
    - Directory Structure:
      ```
      employee-application/
      ├── src/
      │   ├── main/
      │   │   ├── java/
      │   │   │   ├── com.challange.employee/
      │   │   │   │   ├── controller/
      │   │   │   │   ├── service/
      │   │   │   │   └── ...
      │   │   └── resources/
      │   │       ├── application.properties
      │   │       └── ...
      └── ...

2. **Mail Server Application:**
    - Consumes Kafka events from the "Employee" application.
    - Sends email notifications to employees.
    - Directory Structure:
      ```
      mail-server/
      ├── src/
      │   ├── main/
      │   │   ├── java/
      │   │   │   ├── com.challange.mailserver/
      │   │   │   │   ├── config/
      │   │   │   │   ├── service/
      │   │   │   │   └── ...
      │   │   └── resources/
      │   │       ├── application.properties
      │   │       └── ...

## Running the Applications
1. **Clone the repository:**
   ```sh
   git clone https://github.com/Samira1462/employee-mailserver-microservice.git

2. **Build and run the application:**
   ```sh 
   docker-compose down && docker-compose build --no-cache && docker-compose up

3. **Employee Application:**
    - Navigate to the `employee-application` README.md.
   

4. **Mail Server Application:**
    - Navigate to the `mail-server-application` README.md.

