# Exercise 8

Analyzing log compaction.

## Steps

* We need to have working Kafka cluster. In not - run:

```sh
docker compose -f ../exercise_1/docker-compose.yml up -d
```

* Create Kafka Topic `compacted-topic` from UI [Kafka-UI](http://localhost:8080) - with `Cleanup policy` = `Compact` and `Time to retain data (in ms)` = `100`

* Run simple producer from `exercise_3` - be sure that the keys are the same.

```sh
KAFKA_BOOTSTRAP_SERVERS="localhost:29092,localhost:39092,localhost:49092" KAFKA_TOPIC="compacted-topic" KAFKA_MSG="test-msg" java -jar target/simple-producer-0.1.jar
```

* Run it multiple times
* After some time - messages should dissapear from Topic.
