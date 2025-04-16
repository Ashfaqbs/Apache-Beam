import apache_beam as beam
import json

def run_json_processing():
    with beam.Pipeline() as pipeline:
        # Read JSON strings from a file
        persons = (pipeline 
                   | 'ReadJson' >> beam.io.ReadFromText('path/to/input.json')
                   | 'ParseJson' >> beam.Map(json.loads))
        
        # Increment age by one for each person
        def age_increment(person):
            person['age'] += 1
            return person

        aged_persons = (persons 
                        | 'IncrementAge' >> beam.Map(age_increment))
        
        # Format the result back to JSON strings
        formatted = (aged_persons 
                     | 'FormatJson' >> beam.Map(json.dumps))
        
        # Write the processed data back to a file
        formatted | 'Write' >> beam.io.WriteToText('path/to/output.json')

if __name__ == '__main__':
    run_json_processing()