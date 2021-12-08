package com.kafka.workshop.transactions;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.AuthorizationException;
import org.apache.kafka.common.errors.OutOfOrderSequenceException;
import org.apache.kafka.common.errors.ProducerFencedException;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class TransactionsProducer {

	private final Logger logger = LoggerFactory.getLogger(TransactionsProducer.class);
	private final String[] topics;
	private final String fallbackTopic;
	private final Properties props;

	public TransactionsProducer(String bootstrapServers, String topics, String fallbackTopic) {
		this.topics = topics.split(",");
		this.fallbackTopic = fallbackTopic;

		String serializer = StringSerializer.class.getName();
		props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put("transactional.id", "transactional-producer-1");
		props.put("key.serializer", serializer);
		props.put("value.serializer", serializer);
	}

	public void produce(String msg) throws InterruptedException {
		Producer<String, String> producer = new KafkaProducer<>(props);

		producer.initTransactions(); //initiate transactions
		try {
			producer.beginTransaction(); //begin transactions

			Arrays.stream(topics).forEach(
				topic -> producer.send(new ProducerRecord<>(topic, msg))
			);

			producer.commitTransaction(); //commit

            // uncomment for exercise 6
            // Thread.sleep(1000);
            // throw new KafkaException();
		} catch (ProducerFencedException | OutOfOrderSequenceException | AuthorizationException e) {
			// We can't recover from these exceptions, so our only option is to close the producer and exit.
			producer.close();

			sendFallbackMessage(msg);
		} catch (KafkaException e) {
			// For all other exceptions, just abort the transaction
			producer.abortTransaction();
		}

		producer.close();
	}

	public void sendFallbackMessage(String message) {
		Producer producer = new KafkaProducer<>(props);
		logger.info("Sending message to fallback topic!");
        producer.send(new ProducerRecord<>(fallbackTopic, message));
        producer.close();
	}

	public static void main(String[] args) throws InterruptedException {
		String bootstrapServers = System.getenv("KAFKA_BOOTSTRAP_SERVERS");
		String topics = System.getenv("KAFKA_TOPICS");
		String fallbackTopic = System.getenv("KAFKA_FALLBACK_TOPIC");
		String message = System.getenv("KAFKA_MSG");

		TransactionsProducer c = new TransactionsProducer(bootstrapServers, topics, fallbackTopic);
		c.produce(message);
	}
}