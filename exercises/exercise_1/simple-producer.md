# Exercise: Create Simple Producer

## Procedure

* Read the javadoc of [KafkaProducer](https://kafka.apache.org/30/javadoc/org/apache/kafka/clients/producer/KafkaProducer.html) to know how to use the Producer API (to send messages to Kafka)
* Go to `simple-producer` directory
* Create kafka cluster with at least 3 brokers

```sh
docker compose -f ../../cluster/docker-compose.yml up -d 
```

* Create Kafka Topic `test` with 3 partitions and replication factor set to 3:

```sh
docker exec cluster_kafka1_1 kafka-topics --create --topic test --bootstrap-server kafka1:9092 --partitions 3 --replication-factor 3
```

* Edit `simple-producer/src/main/java/com/kafka/workshop/producer/com.kafka.workshop.transactions.KafkaSimpleProducer.java` file to Produce only 1 record instead of producing them in loop.

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
