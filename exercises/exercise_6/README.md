# Exercise 6

Create consumer with support for switching param: `isolation.level`.

## Steps

* We need to have working Kafka cluster. In not - run:

```sh
docker-compose -f ../exercise_1/docker-compose.yml up -d
```

* Go to `params-consumer` directory
* Edit `exercises/exercise_6/params-consumer/src/main/java/com/kafka/workshop/consumer/KafkaParamsConsumer.java` and add support for new Env Variable `KAFKA_ISOLATION_LEVEL`.
* Build Project

```sh
mvn clean install
```

* Run 2 consumers:

```sh
KAFKA_BOOTSTRAP_SERVERS="localhost:29092,localhost:39092,localhost:49092" KAFKA_TOPIC="test-transactions-1" KAFKA_ISOLATION_LEVEL="read_uncommitted"  java -jar target/params-consumer-0.1.jar
```

and

```sh
KAFKA_BOOTSTRAP_SERVERS="localhost:29092,localhost:39092,localhost:49092" KAFKA_TOPIC="test-transactions-2" KAFKA_ISOLATION_LEVEL="read_committed"  java -jar target/params-consumer-0.1.jar
```

* Modify producer from `exercise_5` and instead of commit throws an exception:

```java
    Thread.sleep(1000);
    throw new KafkaException();

    // producer.commitTransaction(); //commit
```

* Use producer from `exercise_5`:

```sh
KAFKA_BOOTSTRAP_SERVERS="localhost:29092,localhost:39092,localhost:49092" KAFKA_TOPICS="test-transactions-1,test-transactions-2" KAFKA_MSG="test-msg" KAFKA_FALLBACK_TOPIC="deadmsgs"  java -jar target/transactional-producer-0.1.jar
```
