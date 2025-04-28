from kafka import KafkaConsumer

# Create a Kafka consumer
consumer = KafkaConsumer(
    'n-topic',
    bootstrap_servers=['localhost:9092'],  # Use your Kafka broker address
    auto_offset_reset='earliest',
    group_id='n-topic-consumer-group',
    enable_auto_commit=True
)

print("Listening for messages on 'n-topic'...")

# Continuously listen for messages
for message in consumer:
    print(f"Received: {message.value.decode('utf-8')}")
