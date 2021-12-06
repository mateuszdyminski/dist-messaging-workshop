# Exercise 9

Word Count with Record Stream with KStream

Develop a standalone Kafka Streams application that reads records in from a source and writes it out to a sink.

1. Use the high-level [Streams DSL](http://kafka.apache.org/30/documentation/streams/developer-guide/dsl-api.html)
2. Use [StreamsBuilder.stream](http://kafka.apache.org/30/javadoc/org/apache/kafka/streams/StreamsBuilder.html) to create a [KStream](http://kafka.apache.org/30/javadoc/org/apache/kafka/streams/kstream/KStream.html) to read records in
3. Use [KStream.to](http://kafka.apache.org/22/javadoc/org/apache/kafka/streams/kstream/KStream.html) to write records out

## Steps

* We need to have working Kafka cluster. In not - run:

```sh
docker-compose -f ../exercise_1/docker-compose.yml up -d
```

* Go to `streams` directory
* Edit `exercises/exercise_9/streams/src/main/java/com/kafka/workshop/streams/WordCount.java` and add business logic to calculate word count.
* For each record from `inputTopic` we should split it into words, group them by value and emit the K,V pair where K is word and V is number of its occurence.
* Build Project

```sh
mvn clean install
```

* Run streams application:

```sh
KAFKA_BOOTSTRAP_SERVERS="localhost:29092,localhost:39092,localhost:49092" KAFKA_INPUT_TOPIC="input-topic" KAFKA_OUTPUT_TOPIC="output-topic" java -jar target/streams-1.0.jar
```

* Use producer from `exercise_3`:

```sh
KAFKA_BOOTSTRAP_SERVERS="localhost:29092,localhost:39092,localhost:49092" KAFKA_TOPIC="input-topic" KAFKA_MSG="Ala ma kota Ala ma Ala" java -jar target/treams-1.0.jar
```

* Open Kafka-UI [http://localhost:8080](http://localhost:8080) and check `output-topic`
