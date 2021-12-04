# Exercise: Create Simple Consumer

## Procedure

* Read the javadoc of [KafkaConsumer](https://kafka.apache.org/30/javadoc/org/apache/kafka/clients/consumer/KafkaConsumer.html) to know how to use the Consumer API (to consume msg from Kafka)
* Go to `simple-consumer` directory
* Create kafka cluster with at least 3 brokers

```sh
docker compose -f ../../cluster/docker-compose.yml up -d 
```

* Create Kafka Topic with 3 partitions and replication factor set to 3

```sh
docker exec cluster_kafka1_1 kafka-topics --create --topic test --bootstrap-server kafka1:9092 --partitions 3 --replication-factor 3
```

* Edit `simple-consumer/src/main/java/com/kafka/workshop/consumer/KafkaSimpleConsumer.java` file to Consumer only 1 record instead of consuming them in loop.
* Don't forget to close the consumer.
* Build Project `mvn clean install`

* Run consumer:

```sh
KAFKA_BOOTSTRAP_SERVERS="localhost:29092,localhost:39092,localhost:49092" KAFKA_TOPIC="test" java -jar target/simple-consumer-0.1.jar
```

* In new terminal open `exercise_1` with `simple-producer` and produce test message

* Run new terminal and run another consumer:

```sh
KAFKA_BOOTSTRAP_SERVERS="localhost:29092,localhost:39092,localhost:49092" KAFKA_TOPIC="test" java -jar target/simple-consumer-0.1.jar
```

* See what happen in logs
* In new terminal open `exercise_1` with `simple-producer` and produce another test message
* Which consumer gets the message?
* Change implementation of Producer and try to implement Round Robin algorithm to balance messages across consumers.
