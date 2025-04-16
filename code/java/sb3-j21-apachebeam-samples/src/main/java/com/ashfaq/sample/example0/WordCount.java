package com.ashfaq.sample.example0;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.KV;

public class WordCount {

	public static void main(String[] args) {
		PipelineOptions options = PipelineOptionsFactory.create();

		Pipeline p = Pipeline.create(options);

		p.apply("ReadLines", TextIO.read().from("data/input.txt"))
				.apply("ExtractWords", ParDo.of(new DoFn<String, String>() {
					@ProcessElement
					public void processElement(@Element String element, OutputReceiver<String> out) {
						String[] words = element.split("[^\\p{L}]+");
						for (String word : words) {
							if (!word.isEmpty()) {
								out.output(word.toLowerCase());
							}
						}
					}
				})).apply("CountWords", Count.perElement())
				.apply("FormatResults", ParDo.of(new DoFn<KV<String, Long>, String>() {
					@ProcessElement
					public void processElement(@Element KV<String, Long> wordCount, OutputReceiver<String> out) {
						out.output(wordCount.getKey() + ": " + wordCount.getValue());
					}
				})).apply("WriteCounts", TextIO.write().to("path/to/output"));

		p.run().waitUntilFinish();
	}
}