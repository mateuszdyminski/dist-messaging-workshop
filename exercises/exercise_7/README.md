# Exercise 7

Analyzing in-sync-replicas meaning

## Steps

* We need to have working Kafka cluster. In not - run:

```sh
docker compose -f ../exercise_1/docker-compose.yml up -d
```

* Create Kafka Topic `test-in-sync` from UI [Kafka-UI](http://localhost:8080) - with 3 partitions, replication-factor 3 and in-sync-replicas set to 4

* Run simple producer from `exercise_3`

```sh
KAFKA_BOOTSTRAP_SERVERS="localhost:29092,localhost:39092,localhost:49092" KAFKA_TOPIC="test-in-sync" KAFKA_MSG="test-msg" java -jar target/simple-producer-0.1.jar
```

* Watch the logs : )
