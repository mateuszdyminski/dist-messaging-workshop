package com.kafka.workshop.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class KafkaParamsConsumer {

	private final Logger logger = LoggerFactory.getLogger(KafkaParamsConsumer.class);
	private final String topic;
	private final Properties props;

	public KafkaParamsConsumer(String bootstrapServers, String topic) {
		this.topic = topic;

		String deserializer = StringDeserializer.class.getName();
		props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "ConsumerGroup-1");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, deserializer);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
	}

	public void consume() {
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(topic));

		try {
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
				records.forEach(record ->
					logger.info("{} [{}] offset={}, key={}, value=\"{}\"",
							record.topic(), record.partition(),
							record.offset(), record.key(), record.value())
				);
	
				consumer.commitSync();
			}
		} finally {
			consumer.close();
		}
	}

	public static void main(String[] args) {
		String bootstrapServers = System.getenv("KAFKA_BOOTSTRAP_SERVERS");
		String topic = System.getenv("KAFKA_TOPIC");

		KafkaParamsConsumer c = new KafkaParamsConsumer(bootstrapServers, topic);
		c.consume();
	}
}