# Exercise 3

Create simple producer which sends messages to the Kafka Topic

## Steps

* Read the javadoc of [KafkaProducer](https://kafka.apache.org/30/javadoc/org/apache/kafka/clients/producer/KafkaProducer.html) to know how to use the Producer API (to send messages to Kafka)
* We need to have working Kafka cluster. In not - run:

```sh
docker-compose -f ../exercise_1/docker-compose.yml up -d
```

* Create Kafka Topic `test` with 3 partitions and replication factor set to 3:

```sh
docker exec exercise_1_kafka1_1 kafka-topics --create --topic test --bootstrap-server kafka1:9092 --partitions 3 --replication-factor 3
```

* Or create Kafka Topic `test` from UI [Kafka-UI](http://localhost:8080) - with 3 partitions and replication-factor 3
* Go to `simple-producer` directory
* Edit `simple-producer/src/main/java/com/kafka/workshop/producer/com.kafka.workshop.transactions.KafkaSimpleProducer.java` file to Produce 1 record to partition 1.
* Don't forget to close the producer.
* Build Project

```sh
mvn clean install
```

* Run producer:

```sh
KAFKA_BOOTSTRAP_SERVERS="localhost:29092,localhost:39092,localhost:49092" KAFKA_TOPIC="test" KAFKA_MSG="test-msg" java -jar target/simple-producer-0.1.jar
```

* Open Kafka-UI [Kafka-UI](http://localhost:8080) to see the record
* Edit `simple-producer/src/main/java/com/kafka/workshop/producer/com.kafka.workshop.transactions.KafkaSimpleProducer.java` file to Produce N records where N will be configured via Environment Variable `KAFKA_MSG_COUNT`.
* Build Project

```sh
mvn clean install
```

* Run producer:

```sh
KAFKA_BOOTSTRAP_SERVERS="localhost:29092,localhost:39092,localhost:49092" KAFKA_TOPIC="test" KAFKA_MSG="test-msg" KAFKA_MSG_COUNT="100000" java -jar target/simple-producer-0.1.jar
```

* Check if number of records in [Kafka-UI](http://localhost:8080) equals number of sent records
