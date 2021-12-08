package com.kafka.workshop.producer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class KafkaSimpleProducer {

	private final Logger logger = LoggerFactory.getLogger(KafkaSimpleProducer.class);
	private final String topic;
    private final int count;
	private final Properties props;

	public KafkaSimpleProducer(String bootstrapServers, String topic, int count) {
		this.topic = topic;
		this.count = count;

		String serializer = StringSerializer.class.getName();
		props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put("key.serializer", serializer);
		props.put("value.serializer", serializer);
	}

	public void produce(String msg) {
		Producer<String, String> producer = new KafkaProducer<>(props);
		int key = 1;
		ProducerRecord<String, String> record = new ProducerRecord(topic, String.valueOf(key), msg);

		for (int i = 0; i < count; i++) {
			producer.send(record);
		}

		producer.close();
	}

	public static void main(String[] args) {
		String bootstrapServers = System.getenv("KAFKA_BOOTSTRAP_SERVERS");
		String topic = System.getenv("KAFKA_TOPIC");
		String message = System.getenv("KAFKA_MSG");
		String count = System.getenv("KAFKA_MSG_COUNT");
		int countInt = Integer.parseInt(count);

		KafkaSimpleProducer c = new KafkaSimpleProducer(bootstrapServers, topic, countInt);
		c.produce(message);
	}
}