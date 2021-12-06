# Exercise 1

Running local docker cluster

## Steps

* Run cluster with `docker compose up -d`
* Check status of containers - `docker ps`
* Enter Kafka docker image - `docker exec -it exercise_1_kafka1_1 bash`
* Find `log.segment.bytes` value in server configuration
* Open docker-compose file
* Uncomment `kafka-ui` and `kafka-ui2` visualizations tool
* Run `docker compose up -d`
* Open [http://locahost:8080](http://locahost:8080) and check what's there
* Open [http://locahost:8090](http://locahost:8090) and check what's there
* Create Topic `test` from [Kafka-UI](http://locahost:8080)
