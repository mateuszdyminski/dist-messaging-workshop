# Exercise 14

Interact with Zookeeper

## Steps

* We need to have working Kafka cluster. In not - run:

```sh
docker-compose -f ../exercise_1/docker-compose.yml up -d
```

* Enter Zookeeper Shell

```sh
zookeeper-shell.sh localhost:2181
```

* Check cluster id

```sh
get /cluster/id
```

* List brokers

```sh
ls /brokers/ids
```

* Show details of broker

```sh
get /brokers/ids/1
```

* List topics

```sh
ls /brokers/topics
```

* Show details of specific topic

```sh
get /brokers/topics/input-topic
```
