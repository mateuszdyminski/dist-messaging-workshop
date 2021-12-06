package com.kafka.workshop.streams;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;

public class WordCount {

	private final Properties props;
	private final String inputTopic;
	private final String outputTopic;

	public WordCount(String bootstrapServers, String inputTopic, String outputTopic) {
		this.inputTopic = inputTopic;
		this.outputTopic = outputTopic;

		props = new Properties();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-example");
		props.put(StreamsConfig.CLIENT_ID_CONFIG, "wordcount-example-client");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 10 * 1000);
		props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
	}

	public void count() {
		// Define the processing topology of the Streams application.
		final StreamsBuilder builder = new StreamsBuilder();
		createWordCountStream(builder);
		final KafkaStreams streams = new KafkaStreams(builder.build(), props);
		
		streams.cleanUp();

		// Now run the processing topology via `start()` to begin processing its input data.
		streams.start();

		// Add shutdown hook to respond to SIGTERM and gracefully close the Streams application.
		Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
	}

	private void createWordCountStream(final StreamsBuilder builder) {
		// put implementation here
	}

	public static void main(String[] args) {
		String bootstrapServers = System.getenv("KAFKA_BOOTSTRAP_SERVERS");
		String inputTopic = System.getenv("KAFKA_INPUT_TOPIC");
		String outputTopic = System.getenv("KAFKA_OUTPUT_TOPIC");

		WordCount c = new WordCount(bootstrapServers, inputTopic, outputTopic);
		c.count();
	}
}