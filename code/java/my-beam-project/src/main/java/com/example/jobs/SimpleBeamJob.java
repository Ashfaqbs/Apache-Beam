package com.example.jobs;


import org.apache.beam.runners.flink.FlinkRunner;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.TypeDescriptors;

public class SimpleBeamJob {
    public static void main(String[] args) {
        // Define pipeline options
        PipelineOptions options = PipelineOptionsFactory.create();
        options.setRunner(FlinkRunner.class);

        // Create the pipeline
        Pipeline pipeline = Pipeline.create(options);

        // Define the pipeline steps
        pipeline.apply("CreateInput", Create.of("Hello", "Beam", "with", "Flink"))
                .apply("ToUpperCase", MapElements.into(TypeDescriptors.strings())
                        .via((String word) -> word.toUpperCase()))
                .apply("PrintOutput", MapElements.via(new SimpleFunction<String, Void>() {
                    @Override
                    public Void apply(String input) {
                        System.out.println(input);
                        return null;
                    }
                }));

        // Run the pipeline
        pipeline.run().waitUntilFinish();
    }
}
