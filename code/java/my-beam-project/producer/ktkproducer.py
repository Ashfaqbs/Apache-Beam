from kafka import KafkaProducer
import json
import random
import time

producer = KafkaProducer(
    bootstrap_servers='localhost:9092',  # Use 'kafka:9093' if running in Docker with Beam
    value_serializer=lambda v: json.dumps(v).encode('utf-8')
)

brands = ['ABC Corp']
categories = ['Electronics']
statuses = ['active', 'inactive']
names = ['Smartphone', 'Tablet', 'Monitor', 'Camera', 'Speaker']

def generate_product():
    return {
        "productId": f"P{random.randint(1000, 9999)}",
        "productName": random.choice(names),
        "category": random.choice(categories),
        "brand": random.choice(brands),
        "price": round(random.uniform(50, 500), 2),
        "discount": random.randint(0, 30),
        "availableStock": random.randint(1, 100),
        "rating": round(random.uniform(1, 5), 1),
        "reviewCount": random.randint(0, 500),
        "currency": "USD",
        "warehouse": "WH-A1",
        "color": random.choice(["Red", "Blue", "Black"]),
        "dimensions": "10x5x3",
        "status": random.choice(statuses),
        "releaseDate": "2023-10-01",
        "updatedAt": "2025-04-29"
    }

# Produce 20 messages
for _ in range(20):
    product = generate_product()
    print("Producing:", product)
    producer.send("i-topic", value=product)
    time.sleep(0.5)

producer.flush()
producer.close()
