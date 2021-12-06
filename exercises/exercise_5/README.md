# Exercise 5

Create transactional producer which sends messages to the multiple Kafka Topics in one transaction.

## Steps

* Read the javadoc of [KafkaProducer](https://kafka.apache.org/30/javadoc/org/apache/kafka/clients/producer/KafkaProducer.html) to know how to use the Transactions in Producer API
* We need to have working Kafka cluster. In not - run:

```sh
docker compose -f ../exercise_1/docker-compose.yml up -d
```

* Go to `transactional-producer` directory
* Edit `exercises/exercise_5/transactional-producer/src/main/java/com/kafka/workshop/transactions/TransactionsProducer.java` and send message to all topics passed in `KAFKA_TOPICS` Env Variable.
* Add extra functionality which sends record to `KAFKA_FALLBACK_TOPIC` if transaction fails.
* Build Project

```sh
mvn clean install
```

* Run producer:

```sh
KAFKA_BOOTSTRAP_SERVERS="localhost:29092,localhost:39092,localhost:49092" KAFKA_TOPICS="test-transactions-1,test-transactions-2" KAFKA_MSG="test-msg" KAFKA_FALLBACK_TOPIC="deadmsgs"  java -jar target/transactional-producer-0.1.jar
```

* Open Kafka-UI [Kafka-UI](http://localhost:8080) to see the records
