from kafka import KafkaConsumer

# Create a Kafka consumer
consumer = KafkaConsumer(
    'o-topic',                      # Topic name
    bootstrap_servers='localhost:9092',  # Kafka broker address
    auto_offset_reset='earliest',  # Start from the beginning if no offset is committed
    enable_auto_commit=True,       # Automatically commit offsets
    group_id='my-consumer-group',  # Consumer group ID
    value_deserializer=lambda x: x.decode('utf-8')  # Decode bytes to string
)

print("Consuming messages from 'o-topic'...")

# Listen for messages
for message in consumer:
    print(f"Received: {message.value}")
