# Exercise 11

Altering topics

## Steps

* We need to have working Kafka cluster. In not - run:

```sh
docker-compose -f ../exercise_1/docker-compose.yml up -d
```

* Create new topic

```sh
docker exec exercise_1_kafka1_1 kafka-topics --create --topic kafka-topics-tool-test --bootstrap-server kafka1:9092 --partitions 1 --replication-factor 1
```

* Get details of topic

```sh
docker exec exercise_1_kafka1_1 kafka-topics --describe --topic kafka-topics-tool-test --bootstrap-server kafka1:9092
```

* Add new partitions

```sh
docker exec exercise_1_kafka1_1 kafka-topics --alter --topic kafka-topics-tool-test --bootstrap-server kafka1:9092 --partitions 5
```

* Try to reduce number of partitons

```sh
docker exec exercise_1_kafka1_1 kafka-topics --alter --topic kafka-topics-tool-test --bootstrap-server kafka1:9092 --partitions 1
```

* Set config `min.insync.replicas` to 3
