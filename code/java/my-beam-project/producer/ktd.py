# from kafka import KafkaProducer
#
# producer = KafkaProducer(
#     bootstrap_servers='localhost:9092',
#     key_serializer=lambda k: k.encode('utf-8'),
#     value_serializer=lambda v: v.encode('utf-8')
# )
#
# # Format: name,email
# messages = [
#     ("key1", "Alice,alice@example.com"),
#     ("key2", "Bob,bob@example.com"),
#     ("key3", "Charlie,charlie@example.com")
# ]
#
# for key, value in messages:
#     producer.send('my-topic', key=key, value=value)
#
# producer.flush()
# print("Messages sent.")

from kafka import KafkaProducer
from faker import Faker
import random

# Initialize Faker instance
fake = Faker()

# Initialize Kafka producer
producer = KafkaProducer(
    bootstrap_servers='localhost:9092',
    key_serializer=lambda k: k.encode('utf-8'),
    value_serializer=lambda v: v.encode('utf-8')
)

# Number of messages to send (random between 100 to 200)
num_messages = random.randint(100, 200

# Generate and send fake messages
for i in range(num_messages):
    # Generate fake data
    key = f'key{i+1}'  # Creating a unique key for each message
    name = fake.name()
    email = fake.email()
    value = f"{name},{email}"

    # Send the message to Kafka
    producer.send('my-topic', key=key, value=value)

    print(f"Sent: {key} -> {value}")

# Ensure all messages are sent
producer.flush()

print(f"{num_messages} messages sent.")
