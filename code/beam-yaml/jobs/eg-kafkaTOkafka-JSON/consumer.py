from kafka import KafkaConsumer
import json

KAFKA_BOOTSTRAP_SERVERS = 'localhost:9092'
TOPIC_NAME = 'n-topic'

consumer = KafkaConsumer(
    TOPIC_NAME,
    bootstrap_servers=KAFKA_BOOTSTRAP_SERVERS,
    auto_offset_reset='earliest',  
    enable_auto_commit=True,
    group_id='my-consumer-group',
    value_deserializer=lambda m: json.loads(m.decode('utf-8'))
)

print(f"Listening to messages on topic '{TOPIC_NAME}'...\n")

for message in consumer:
    print(f"Received: {message.value}")
