package com.kafka.workshop.producer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class KafkaSimpleProducer {

	private final Logger logger = LoggerFactory.getLogger(KafkaSimpleProducer.class);
	private final String topic;
	private final Properties props;

	public KafkaSimpleProducer(String bootstrapServers, String topic) {
		this.topic = topic;

		String serializer = StringSerializer.class.getName();
		props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put("key.serializer", serializer);
		props.put("value.serializer", serializer);
	}

	public void produce(String msg) {
		Producer<String, String> producer = new KafkaProducer<>(props);
		int key = 0;

		ProducerRecord<String, String> record = new ProducerRecord(topic, Integer.toString(key), msg);
		producer.send(record);

		producer.close();

		// create the message
		// use producer.send
		// close producer after all
	}

	public static void main(String[] args) {
		String bootstrapServers = System.getenv("KAFKA_BOOTSTRAP_SERVERS");
		String topic = System.getenv("KAFKA_TOPIC");
		String message = System.getenv("KAFKA_MSG");

		KafkaSimpleProducer c = new KafkaSimpleProducer(bootstrapServers, topic);
		c.produce(message);
	}
}