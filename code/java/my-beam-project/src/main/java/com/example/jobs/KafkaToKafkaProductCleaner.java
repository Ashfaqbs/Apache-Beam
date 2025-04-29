package com.example.jobs;


import com.example.dto.CleanProduct;
import com.example.dto.ProductFlat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.kafka.KafkaIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.options.StreamingOptions;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.TypeDescriptor;
import org.apache.beam.sdk.values.TypeDescriptors;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaToKafkaProductCleaner {
    public static void main(String[] args) {
        StreamingOptions options = PipelineOptionsFactory.fromArgs(args)
                .withValidation()
                .as(StreamingOptions.class);
        options.setStreaming(true);

        Pipeline p = Pipeline.create(options);
        ObjectMapper mapper = new ObjectMapper();

        // Step 1: Read from Kafka i-topic
        p.apply("ReadKafka", KafkaIO.<String, String>read()
                        .withBootstrapServers("kafka:9093")
                        .withTopic("i-topic")
                        .withKeyDeserializer(StringDeserializer.class)
                        .withValueDeserializer(StringDeserializer.class)
                        .withoutMetadata())
                .apply("ExtractValues", MapElements.into(TypeDescriptors.strings())
                        .via(KV::getValue))

                // Step 2: Parse JSON to ProductFlat
                .apply("ParseJson", MapElements.into(TypeDescriptor.of(ProductFlat.class))
                        .via(json -> {
                            try {
                                return mapper.readValue(json, ProductFlat.class);
                            } catch (JsonProcessingException e) {
                                throw new RuntimeException(e);
                            }
                        }))

                // Step 3: Filter on multiple fields
                .apply("FilterValidProducts", Filter.by(product ->
                        "ABC Corp".equals(product.getBrand()) &&
                                "Electronics".equals(product.getCategory()) &&
                                "active".equals(product.getStatus()) &&
                                product.getAvailableStock() > 0))

                // Step 4: Transform to CleanProduct
                .apply("TransformProduct", MapElements.into(TypeDescriptor.of(CleanProduct.class))
                        .via(product -> {
                            double finalPrice = product.getPrice() - (product.getPrice() * product.getDiscount() / 100);
                            return new CleanProduct(
                                    product.getProductId(),
                                    product.getProductName(),
                                    product.getBrand(),
                                    finalPrice,
                                    product.getAvailableStock()
                            );
                        }))

                // Step 5: Convert to JSON string
                .apply("SerializeJson", MapElements.into(TypeDescriptors.strings())
                        .via(cleanProduct -> {
                            try {
                                return mapper.writeValueAsString(cleanProduct);
                            } catch (JsonProcessingException e) {
                                throw new RuntimeException(e);
                            }
                        }))

                // Step 6: Write to Kafka o-topic
                .apply("WriteKafka", KafkaIO.<Void, String>write()
                        .withBootstrapServers("kafka:9093")
                        .withTopic("o-topic")
                        .withValueSerializer(StringSerializer.class)
                        .withKeySerializer(org.apache.kafka.common.serialization.VoidSerializer.class)
                        .values());

        p.run().waitUntilFinish();
    }
}
