from kafka import KafkaProducer

# Create Kafka producer
producer = KafkaProducer(
    bootstrap_servers='localhost:9092',
    value_serializer=lambda v: v.encode('utf-8')
)

# Topic name
topic = "my-topic"

# List of 10 messages
messages = [
    "Message 1: Hello Kafka!",
    "Message 2: Kafka is cool 😎",
    "Message 3: Sending data...",
    "Message 4: Streaming vibes",
    "Message 5: Keep it flowing",
    "Message 6: Another one 🔁",
    "Message 7: Smooth ride",
    "Message 8: Kafka producer here",
    "Message 9: Almost there",
    "Message 10: Done and dusted!"
]

# Send each message
for msg in messages:
    producer.send(topic, msg)
    print(f"Sent: {msg}")

# Ensure all messages are sent
producer.flush()
print("✅ All 10 messages sent successfully!")
