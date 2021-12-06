# Exercise 10

Run Kafka Connect connector

## Steps

* We need to have working Kafka cluster. In not - run:

```sh
docker-compose -f ../exercise_1/docker-compose.yml up -d
```

* Download Kafka Connect component from [https://www.confluent.io/hub](https://www.confluent.io/hub)
* Let's use [https://www.confluent.io/hub/mmolimar/kafka-connect-fs](https://www.confluent.io/hub/mmolimar/kafka-connect-fs)
* Extract Connector from archive
* Create `connectors` directory in home
* Move diretory with connector to `/home/<USER>/connectors`
* Edit connector configuration file

```conf
name=FsSourceConnector
connector.class=com.github.mmolimar.kafka.connect.fs.FsSourceConnector
tasks.max=1
fs.uris=file:///home/<USER>/data
topic=mytopic
policy.class=com.github.mmolimar.kafka.connect.fs.policy.SimplePolicy
policy.recursive=true
policy.regexp=.
policy.batch_size=0
policy.cleanup=none
file_reader.class=com.github.mmolimar.kafka.connect.fs.file.reader.TextFileReader
file_reader.batch_size=0
```

* Edit Kafka configuration `$KAFKA_HOME/config/connect-standalone.properties` file to point the connectors to `/home/<USER>/connectors`

```conf
plugin.path=/home/<User>/connectors
```

* Create directory with files

```sh
/home/<USER>/data
```

* Create dummy file with text there
* Run Connector

```sh
connect-standalone.sh $KAFKA_HOME/config/connect-standalone.properties etc/kafka-connect-fs.properties
```

* Check Kafka Connector API [http://localhost:8083](http://localhost:8083)
* Add new file and restart task

```sh
curl -X POST http://localhost:8083/connectors/FsSourceConnector/tasks/0/restart | jq .
```
