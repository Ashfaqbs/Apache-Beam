package com.ashfaq.sample.example1;

import java.io.IOException;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.Filter;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.values.TypeDescriptor;

import com.ashfaq.sample.models.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonProcessingPipeline {

	public static void main(String[] args) {
		Pipeline pipeline = Pipeline.create();

		// Read JSON from a file or other source
		pipeline.apply("ReadJSON", TextIO.read().from("data/input.json"))
				.apply("ParseJSON", MapElements.into(TypeDescriptor.of(Person.class)).via((String jsonString) -> {
					try {
						ObjectMapper objectMapper = new ObjectMapper();
						return objectMapper.readValue(jsonString, Person.class);
					} catch (IOException e) {
						throw new RuntimeException("Failed to parse JSON", e);
					}
				})).apply("FilterAdults", Filter.by(person -> person.getAge() > 18)) // Filter based on age
				.apply("TransformNames",
						MapElements.into(TypeDescriptor.of(String.class))
								.via((Person person) -> "Hello, " + person.getName() + "!"))
				// Writing the result
				.apply("WriteOutput", TextIO.write().to("output/output").withSuffix(".txt").withoutSharding()); // Adding
																												// withoutSharding
																												// to
																												// avoid
																												// unwanted
																												// sharding
																												// of
																												// output
																												// files

		// Run the pipeline
		pipeline.run().waitUntilFinish();
	}
}
