# Mail Sender Application

Welcome to the Mail Sender Application , This repository contains a Spring Boot application that demonstrates the use of Apache Kafka to send emails based on events triggered by incoming messages. The application listens to Kafka messages containing information about employee actions and sends corresponding emails using the provided JavaMailSender.

## Table of Contents

- Requirements
- Technologies Used
- Installation and Setup

## In

The Email Sender App is built to showcase the integration of Apache Kafka with Spring Boot to send automated emails based on events. The application utilizes Kafka's publish-subscribe model to receive employee-related messages, processes these messages, and sends emails accordingly.


## Technologies Used

- Programming Language: Java 17
- Web Framework: Spring Boot 3,Spring Mail , Lombok
- Message Broker: Kafka
- Build tools: gradle 7

## Installation and Setup

1. Go to the root of the application where build.gradle and Run execute the below command

   ```sh  
   ./gradlew bootRun


