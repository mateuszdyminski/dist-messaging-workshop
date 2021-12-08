# Distributed Messaging with Apache Kafka

Distributed Messaging with Apache Kafka - Workshop Materials

## Presentation

Presentations could be find here:

* [Apache_Kafka_Part_1](slides/Apache_Kafka_Part_1.pptx)
* [Apache_Kafka_Part_2](slides/Apache_Kafka_Part_2.pptx)

## Agenda

* Overview of Distributed Messaging Systems
  * What's Apache Kafka
  * When it's worth to use Apache Kafka
  * Use Cases
  * Alternatives to Kafka
* Kafka Design
  * Motivation
  * Persistence
  * Performance
  * The Producer
  * The Consumer
  * Message Delivery Semantics
  * Replication
  * Log Compaction
* Kafka API
  * Producer API
  * Consumer API
  * Kafka Streams
  * Kafka Connect
* Kafka Operations
  * Adding, Modifying and removing topics
  * Checking consumer position
  * Expanding your cluster
  * Decommissioning brokers
  * Geo Replication
  * Broker configuration tuning
  * Producer configuration tuning
  * Consumer configuration tuning
  * Java
  * Hardware and OS
  * Monitoring
* Other
  * How many topics can I have
  * How to choose number of partitions

## Exercises

List of exercises run during the workshop:

* [Excercise 1](exercises/exercise_1) - Running cluster
* [Excercise 2](exercises/exercise_2) - Check Kafka filesystem
* [Excercise 3](exercises/exercise_3) - Write Simple Producer in Java
* [Excercise 4](exercises/exercise_4) - Write Simple Consumer in Java
* [Excercise 5](exercises/exercise_5) - Write Transaction Producer
* [Excercise 6](exercises/exercise_6) - Write Consumer with different isolation level
* [Excercise 7](exercises/exercise_7) - Replication
* [Excercise 8](exercises/exercise_8) - Log compaction
* [Excercise 9](exercises/exercise_9) - Streams API
* [Excercise 10](exercises/exercise_10) - Connector API
* [Excercise 11](exercises/exercise_11) - Create, Modify and Delete topic
* [Excercise 12](exercises/exercise_12) - Managing Consumer Groups
* [Excercise 13](exercises/exercise_13) - Expanding cluster
* [Excercise 14](exercises/exercise_14) - Interacting with Zookeeper

## Credits

This workshop wan't be possible without:

* [https://kafka.apache.org/documentation/](https://kafka.apache.org/documentation/)
* [https://www.confluent.io/blog/kafka-fastest-messaging-system/](https://www.confluent.io/blog/kafka-fastest-messaging-system/)
* [https://www.amazon.com/Designing-Data-Intensive-Applications-Reliable-Maintainable/dp/1449373321](https://www.amazon.com/Designing-Data-Intensive-Applications-Reliable-Maintainable/dp/1449373321)
* [https://debezium.io/](https://debezium.io/)
* [https://softwaremill.com/mqperf/#summary-of-features](https://softwaremill.com/mqperf/#summary-of-features)
* [https://www.confluent.io/hub/mmolimar/kafka-connect-fs/](https://www.confluent.io/hub/mmolimar/kafka-connect-fs/)
* [https://www.youtube.com/watch?v=8BUoY8jbRoQ](https://www.youtube.com/watch?v=8BUoY8jbRoQ)
* [https://medium.com/@TimvanBaarsen/apache-kafka-cli-commands-cheat-sheet-a6f06eac01b#b94e](https://medium.com/@TimvanBaarsen/apache-kafka-cli-commands-cheat-sheet-a6f06eac01b#b94e)
* [https://docs.confluent.io/platform/current/kafka/monitoring.html#broker-metrics](https://docs.confluent.io/platform/current/kafka/monitoring.html#broker-metrics)
* [https://towardsdatascience.com/overview-of-ui-tools-for-monitoring-and-management-of-apache-kafka-clusters-8c383f897e80](https://towardsdatascience.com/overview-of-ui-tools-for-monitoring-and-management-of-apache-kafka-clusters-8c383f897e80)
* [https://sematext.com/blog/kafka-metrics-to-monitor/](https://sematext.com/blog/kafka-metrics-to-monitor/)
* [https://logz.io/blog/monitoring-kafka-in-production/](https://logz.io/blog/monitoring-kafka-in-production/)
* [https://github.com/jvm-profiling-tools/perf-map-agent](https://github.com/jvm-profiling-tools/perf-map-agent)
* [https://github.com/brendangregg/FlameGraph](https://github.com/brendangregg/FlameGraph)
* [https://strimzi.io/blog/2021/06/08/broker-tuning/](https://strimzi.io/blog/2021/06/08/broker-tuning/)
* [https://speakerdeck.com/gunnarmorling/practical-change-data-streaming-use-cases-with-apache-kafka-and-debezium-qcon-san-francisco-2019](https://speakerdeck.com/gunnarmorling/practical-change-data-streaming-use-cases-with-apache-kafka-and-debezium-qcon-san-francisco-2019)