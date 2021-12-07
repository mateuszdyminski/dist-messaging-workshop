# Exercise 13

Expanding cluster

## Steps

* We need to have working Kafka cluster. In not - run:

```sh
docker-compose -f ../exercise_1/docker-compose.yml up -d
```

* Create Kafka Topic `new-topic` with 100 partitions:

```sh
docker exec exercise_1_kafka1_1 kafka-topics --create --topic new-topic --bootstrap-server kafka1:9092 --partitions 10 --replication-factor 1
```

* Go to directory from exercise_1
* Edit `docker-compose.yml` file and add new 4 broker

```yml
  kafka4:
    image: confluentinc/cp-kafka:latest
    depends_on:
      - zookeeper
    ports:
      - 59092:59092
    environment:
      KAFKA_BROKER_ID: 4
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka4:9092,PLAINTEXT_HOST://localhost:59092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
```

* Run

```sh
docker-compose up -d
```

* Check with `docker ps` is image is up and running
* Run

```sh
docker exec exercise_1_kafka1_1 kafka-broker-api-versions --bootstrap-server kafka1:9092
```

* And check if on the list is `kafka4`
* It should appear in UI tool in couple of seconds
* Problem: new node has no partitions
* Go to `exercise_13` directory and analyze file `topics_to_move.json`
* Go to container:

```sh
kafka-reassign-partitions.sh --bootstrap-server localhost:29092 --topics-to-move-json-file topics_to_move.json --broker-list "4" --generate
```

* Copy content of proposition to file `config.json`
* Configure new partitions setup:

```sh
kafka-reassign-partitions.sh --bootstrap-server localhost:29092 --reassignment-json-file config.json --execute
```

* Open UI tool and check where are the partitions
