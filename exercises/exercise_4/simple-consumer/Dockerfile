FROM openjdk:17.0.1-slim-buster

RUN mkdir /usr/share/kafka

# Add the jar file
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/kafka/${JAR_FILE}

# Consumer configuration
ENV KAFKA_BOOTSTRAP_SERVERS="kafka-cluster-kafka-bootstrap.kafka:9092"
ENV KAFKA_TOPIC="kafka-topic-1"
ENV EXECUTABLE_JAR=/usr/share/kafka/${JAR_FILE}

# Start Simple Kafka Consumer
ENTRYPOINT java -jar $EXECUTABLE_JAR