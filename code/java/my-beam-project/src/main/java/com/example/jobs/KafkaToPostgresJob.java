package com.example.jobs;

import com.example.dto.User;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.extensions.avro.coders.AvroCoder;
import org.apache.beam.sdk.io.jdbc.JdbcIO;
import org.apache.beam.sdk.io.kafka.KafkaIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.options.StreamingOptions;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.kafka.common.serialization.StringDeserializer;


public class KafkaToPostgresJob {
    public static void main(String[] args) {

        StreamingOptions options = PipelineOptionsFactory.fromArgs(args)
                .withValidation()
                .as(StreamingOptions.class);
        options.setStreaming(true);

        Pipeline p = Pipeline.create(options);

        // Step 1: Read from Kafka
        PCollection<User> users =   p.apply(KafkaIO.<String, String>read()
                        .withBootstrapServers("kafka:9093")
                        .withTopic("my-topic")
                        .withKeyDeserializer(StringDeserializer.class)
                        .withValueDeserializer(StringDeserializer.class)
                        .withoutMetadata())

                // Step 2: Convert KafkaRecord to KV<String, String>
//                .apply("ExtractKV", MapElements.into(
//                                TypeDescriptors.kvs(TypeDescriptors.strings(), TypeDescriptors.strings()))
//                        .via((KafkaRecord<String, String> record) -> record.getKV()))

                // Step 3: Convert KV<String, String> to User object
                .apply("MapToUser", MapElements.via(new SimpleFunction<KV<String, String>, User>() {
                    public User apply(KV<String, String> record) {
                        String[] parts = record.getValue().split(",");
                        return new User(parts[0], parts[1]);
                    }
                }))
                .setCoder(AvroCoder.of(User.class));

                // Step 4: Write User to Postgres
        users .apply("WriteToPostgres", JdbcIO.<User>write()
                        .withDataSourceConfiguration(JdbcIO.DataSourceConfiguration.create(
                                        "org.postgresql.Driver", "jdbc:postgresql://postgres:5432/mainschema")
                                .withUsername("postgres")
                                .withPassword("admin"))
                        .withStatement("INSERT INTO users(name, email) VALUES(?, ?)")
                        .withPreparedStatementSetter((user, ps) -> {
                            ps.setString(1, user.getName());
                            ps.setString(2, user.getEmail());
                        }));

        p.run().waitUntilFinish();
    }


}
