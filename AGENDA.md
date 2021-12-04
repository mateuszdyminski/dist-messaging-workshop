# Agenda

## Overview of Distributed Messaging Systems

* What's Apache Kafka
* When it's worth to use Apache Kafka
* Use Cases:
  * Messaging
  * Streaming
  * Asynchronous communication
  * Real-Time processing
  * Metrics / Log aggregation
  * CQRS / Event Sourcing
  * Change Data Capture
  * Geo-replication
* Alternatives to Kafka
  * As Queue
    * RabbitMQ
    * AtiveMQ
    * NATS
    * Redis
    * Amazon SQS / Azure Service Bus / GCE Pub/Sub
  * As Messaging Platform
    * Apache Spark
    * Apache Storm
    * Apache Flume

## Design

* Motivation
* Persistence
* Performance
* The Producer
* The Consumer
* Message Delivery Semantics
* Replication

## Kafka API

* Producer API
* Simple Consumer API
* Kafka Streams
* Kafka Connect

## Configuration

* New Producer
* Broker
* Consumer and Producer Configuration

## Implementation

* API Design
* Network Layer
* Messages
* Message format
* Log
* Distribution

## Basic Kafka Operations

* Adding and removing topics
* Modifying topics
* Graceful shutdown
* Balancing leadership
* Checking consumer position
* Mirroring data between clusters
* Expanding your cluster
* Decommissioning brokers
* Increasing replication factor

## Other

* Datacenters
* Important Server Configs
* Important Client Configs
* Production Server Configs
* Monitoring
* ZooKeeper
