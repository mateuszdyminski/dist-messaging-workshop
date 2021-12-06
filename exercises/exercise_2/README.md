# Exercise 2

Checking Kafka file system

## Steps

* We need to have working Kafka cluster. In not - run:

```sh
docker-compose -f ../exercise_1/docker-compose.yml up -d
```

* Enter Kafka docker image - `docker exec -it exercise_1_kafka1_1 bash`
* Find a place where is Kafka configuration
* Find in configuration files where are stored logs
* Enter that directory and check whats there
* Create new topic in Kafka-UI with replication factor set to 3
* Check again directory structure
