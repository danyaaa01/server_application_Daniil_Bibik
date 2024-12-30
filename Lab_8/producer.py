from kafka import KafkaProducer
import json
import random
import time

producer = KafkaProducer(bootstrap_servers='localhost:9092',
                         value_serializer=lambda v: json.dumps(v).encode('utf-8'))

topic_name = 'test-topic'

for i in range(10):
    data = {'number': i, 'value': random.random()}
    producer.send(topic_name, value=data)
    time.sleep(1)

producer.close()
