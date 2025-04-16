Apache Beam is a unified programming model designed for batch and stream processing. Since you've already created a Spring Boot project with dependencies for Apache Beam, the next step is to start implementing a basic pipeline in Java that reads JSON, performs filtering, and processes the data.

### 1. Project Setup

You already have the required dependencies for Apache Beam in your `pom.xml`. Make sure you have the following dependencies:

```xml
<dependency>
    <groupId>org.apache.beam</groupId>
    <artifactId>beam-sdks-java-core</artifactId>
    <version>2.48.0</version>
</dependency>

<dependency>
    <groupId>org.apache.beam</groupId>
    <artifactId>beam-runners-direct-java</artifactId>
    <version>2.48.0</version>
</dependency>

<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.2</version>
</dependency>
```

### 2. Basic Pipeline Example

Let's build a simple Apache Beam pipeline to process JSON data. In this example, we'll:

1. **Read JSON from a file or source** (could be a string, file, etc.).
2. **Filter the data** (based on some condition).
3. **Process the data** (e.g., transforming the data).
4. **Write output** (optional: writing results to a file, console, etc.).

Here’s an example implementation:

#### Step 1: Define a POJO for JSON Mapping

Assume you're dealing with a simple JSON object with a structure like:

```json
{
  "id": 1,
  "name": "John Doe",
  "age": 30
}
```

Define a POJO (Plain Old Java Object) to map this JSON:

```java
public class Person {
    private int id;
    private String name;
    private int age;

    // Getters and Setters

    public Person() {}

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

#### Step 2: Create the Pipeline

The following code defines a simple Apache Beam pipeline that reads JSON data, filters out certain records, and processes the data.

```java

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
				.apply("WriteOutput", TextIO.write().to("output/output").withSuffix(".txt").withoutSharding()); // Adding withoutSharding to avoid unwanted sharding of output files

		// Run the pipeline
		pipeline.run().waitUntilFinish();
	}
}

```

#### Step 3: Explanation of the Code

1. **Reading the JSON Data**: We read the data from a file (`input.json`) using the `TextIO.read()` method. This assumes each line of the file contains a JSON string.

2. **Parsing JSON**: We use Jackson (`ObjectMapper`) to map the JSON string to a `Person` object. This is done using the `MapElements` transform.

3. **Filtering Data**: We apply a simple filter that selects only people who are over 18 years old. The `Filter.by()` method applies a condition to each element of the PCollection (in this case, each `Person` object).

4. **Transformation**: We perform a simple transformation that changes the name of the person by adding a greeting message (`"Hello, " + person.getName() + "!"`).

5. **Writing Output**: The processed output is written to an output file (`output.txt`), though this step is optional and can be modified to write to other destinations (e.g., databases, cloud storage).

#### Step 4: Running the Pipeline

Make sure you have an input file (`input.json`) with the correct JSON data format:

```json
{"id": 1, "name": "John Doe", "age": 25}
{"id": 2, "name": "Jane Smith", "age": 17}
{"id": 3, "name": "Alice Johnson", "age": 30}
```

To run the pipeline, simply execute your Spring Boot application as a Java application. Apache Beam will process the data using the DirectRunner, which executes the pipeline locally.

### 3. Optional Enhancements

- **Batch Processing**: Apache Beam supports both batch and streaming modes. You can configure the pipeline for streaming by switching the runner or adding appropriate windowing/transformation logic.
  
- **Error Handling**: Consider adding better error handling in case parsing the JSON fails or if data is malformed.

- **Logging and Monitoring**: You can add logging to track the progress of the pipeline, especially useful in more complex scenarios.

### 4. Conclusion

This simple example demonstrates the power and flexibility of Apache Beam for processing JSON data in a Spring Boot application. You can easily extend this to more complex pipelines, adding additional transformations, aggregations, or even using different runners (e.g., Google Cloud Dataflow, Flink, etc.) depending on your requirements.







### 1. Code Explanation with Comments

Here’s the full pipeline code with detailed comments explaining each section:

```java
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.Filter;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.TypeDescriptor;
import org.apache.beam.sdk.coders.SerializableCoder;  // Import for Serializable Coder
import org.apache.beam.sdk.values.PCollection;
import com.fasterxml.jackson.databind.ObjectMapper;  // Jackson for JSON parsing

import java.io.IOException;

public class JsonProcessingPipeline {

    public static void main(String[] args) {
        // Step 1: Create a new Apache Beam pipeline
        Pipeline pipeline = Pipeline.create();

        // Step 2: Read JSON input from a file using TextIO
        // "input.json" contains the raw JSON records (one per line)
        PCollection<Person> persons = pipeline.apply("ReadJSON", TextIO.read().from("input.json"))
                // Step 3: Parse each line of the JSON input into a Person object using Jackson's ObjectMapper
                .apply("ParseJSON", MapElements
                        .into(TypeDescriptor.of(Person.class))  // The output type is Person class
                        .via((String jsonString) -> {
                            try {
                                ObjectMapper objectMapper = new ObjectMapper();
                                // Parse the JSON string into a Person object
                                return objectMapper.readValue(jsonString, Person.class);
                            } catch (IOException e) {
                                // In case parsing fails, throw a RuntimeException
                                throw new RuntimeException("Failed to parse JSON", e);
                            }
                        }));

        // Step 4: Explicitly set the Coder for the PCollection of Person objects
        // This is necessary because Beam cannot automatically infer how to serialize Person objects
        persons.setCoder(SerializableCoder.of(Person.class));

        // Step 5: Apply a filter to only include persons whose age is greater than 18
        persons.apply("FilterAdults", Filter.by(person -> person.getAge() > 18))  // Filter based on age
                // Step 6: Transform each Person object into a greeting message
                .apply("TransformNames", MapElements
                        .into(TypeDescriptor.of(String.class))  // The output type is String
                        .via((Person person) -> "Hello, " + person.getName() + "!"))
                // Step 7: Write the resulting greeting strings to a text file
                .apply("WriteOutput", TextIO.write().to("output/output").withSuffix(".txt").withoutSharding());

        // Step 8: Run the pipeline and wait for it to finish processing
        pipeline.run().waitUntilFinish();
    }
}
```

### Code Breakdown:

1. **Pipeline Creation**:
   ```java
   Pipeline pipeline = Pipeline.create();
   ```
   - Initializes a new Apache Beam pipeline. This serves as the entry point for applying transforms (operations) to your data.

2. **Reading JSON Data**:
   ```java
   PCollection<Person> persons = pipeline.apply("ReadJSON", TextIO.read().from("input.json"));
   ```
   - This reads JSON data from a file (`input.json`). Each line in this file is expected to be a JSON string.
   - The output is a `PCollection<String>`, where each element represents a JSON string.

3. **Parsing JSON to Java Objects**:
   ```java
   .apply("ParseJSON", MapElements
           .into(TypeDescriptor.of(Person.class))
           .via((String jsonString) -> {
               try {
                   ObjectMapper objectMapper = new ObjectMapper();
                   return objectMapper.readValue(jsonString, Person.class);
               } catch (IOException e) {
                   throw new RuntimeException("Failed to parse JSON", e);
               }
           }));
   ```
   - This transform converts each JSON string into a `Person` object using Jackson's `ObjectMapper`.
   - The result is a `PCollection<Person>`.

4. **Setting the Coder**:
   ```java
   persons.setCoder(SerializableCoder.of(Person.class));
   ```
   - This line explicitly sets a **Coder** for the `Person` class.
   - A `Coder` is required for serializing and deserializing Java objects in Beam. Since `Person` implements `Serializable`, we use the `SerializableCoder` to handle serialization.

5. **Filtering Data**:
   ```java
   persons.apply("FilterAdults", Filter.by(person -> person.getAge() > 18))
   ```
   - This applies a filter to only include `Person` objects where the `age` is greater than 18. The output is a filtered `PCollection<Person>`.

6. **Transforming Data**:
   ```java
   .apply("TransformNames", MapElements
           .into(TypeDescriptor.of(String.class))
           .via((Person person) -> "Hello, " + person.getName() + "!"));
   ```
   - This applies a transformation to each `Person` object, converting it into a greeting string (`"Hello, Name!"`).

7. **Writing Output**:
   ```java
   .apply("WriteOutput", TextIO.write().to("output/output").withSuffix(".txt").withoutSharding());
   ```
   - This writes the transformed data (greeting strings) to a text file. The output will be a single file named `output-00000-of-00001.txt`, and `withoutSharding()` ensures that the result is written to a single file rather than multiple sharded files.

8. **Running the Pipeline**:
   ```java
   pipeline.run().waitUntilFinish();
   ```
   - Finally, the pipeline is executed. The program will wait until the pipeline finishes processing all data.

---

### 2. Error Explanation and Fix

#### Error You Encountered:

```
java.lang.IllegalStateException: Unable to return a default Coder for ParseJSON/Map/ParMultiDo(Anonymous).output [PCollection@616412281]. Correct one of the following root causes:
  No Coder has been manually specified;  you may do so using .setCoder().
  Inferring a Coder from the CoderRegistry failed: Unable to provide a Coder for com.ashfaq.sample.default_runner.controller.Person.
  Building a Coder using a registered CoderProvider failed.
```

#### Why Did This Error Happen?

1. **No Coder for `Person`**:
   - Apache Beam requires a **Coder** to handle the serialization and deserialization of data between transforms. By default, Beam can automatically infer a Coder for primitive types like `String`, `Integer`, etc. However, for custom Java objects like `Person`, Beam doesn't know how to serialize them unless explicitly told.
   
2. **Beam Tries to Infer the Coder**:
   - Beam attempted to infer the appropriate Coder for the `Person` class. Since the `Person` class is not a primitive type and Beam has no built-in logic to handle it, this inference failed.
   
3. **Error Message**:
   - The error message explicitly states that Beam was unable to infer a Coder for `Person`. This is why the pipeline throws an exception and halts.

#### Fix:

To resolve this, we manually specify a **Coder** for the `Person` class. This allows Beam to correctly handle serialization and deserialization of `Person` objects.

```java
persons.setCoder(SerializableCoder.of(Person.class));
```

- **Serializable Coder**: We used `SerializableCoder.of(Person.class)`, which works because the `Person` class implements `Serializable`. This tells Beam how to serialize `Person` objects when they're passed between different stages of the pipeline.

- **Why this works**:
   - **Serializable**: The `Person` class implements `Serializable`, which is a simple interface indicating that instances of the class can be serialized into a stream of bytes. `SerializableCoder` is a built-in Beam coder that can handle objects implementing this interface.

### In Summary:

- The **error** was caused by Beam's inability to automatically determine how to serialize your custom `Person` class.
- The **solution** was to manually specify the Coder using `SerializableCoder`, which allows Beam to serialize and deserialize `Person` objects correctly.
