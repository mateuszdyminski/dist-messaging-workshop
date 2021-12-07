# Exercise 12

Managing Consumer Groups

## Steps

* We need to have working Kafka cluster. In not - run:

```sh
docker-compose -f ../exercise_1/docker-compose.yml up -d
```

* List consumer groups

```sh
docker exec exercise_1_kafka1_1 kafka-consumer-groups --list --bootstrap-server kafka1:9092
```

* Describe Consumer Group

```sh
docker exec exercise_1_kafka1_1 kafka-consumer-groups --describe --bootstrap-server kafka1:9092 --group ConsumerGroup-1
```

* Reset offsets

```sh
docker exec exercise_1_kafka1_1 kafka-consumer-groups --reset-offsets --bootstrap-server kafka1:9092 --group ConsumerGroup-1 --to-earliest --topic test-transactions-1 --execute
```

* Delete consumer group

```sh
docker exec exercise_1_kafka1_1 kafka-consumer-groups --delete --bootstrap-server kafka1:9092 --group ConsumerGroup-1
```
