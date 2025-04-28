from kafka import KafkaProducer
import json
import time
import random

KAFKA_BOOTSTRAP_SERVERS = 'localhost:9092'
TOPIC_NAME = 'm-topic'

producer = KafkaProducer(
    bootstrap_servers=KAFKA_BOOTSTRAP_SERVERS,
    value_serializer=lambda v: json.dumps(v).encode('utf-8')
)

names = ["Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hank", "Ivy", "Jack"]

for i in range(100):
    msg = {
        "name": random.choice(names),
        "age": random.randint(20, 60),
        "score": round(random.uniform(0.0, 100.0), 2),
        "active": random.choice([True, False])
    }
    producer.send(TOPIC_NAME, value=msg)
    print(f"[{i+1}] Sent: {msg}")
    time.sleep(0.1)  # Simulate delay

producer.flush()
print("✅ All 100 messages sent to Kafka topic.")
