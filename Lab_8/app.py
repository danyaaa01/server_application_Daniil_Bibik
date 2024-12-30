from flask import Flask, request, jsonify
from kafka import KafkaProducer
import json

app = Flask(__name__)
producer = KafkaProducer(bootstrap_servers='localhost:9092',
                         value_serializer=lambda v: json.dumps(v).encode('utf-8'))

@app.route('/send', methods=['POST'])
def send_message():
    data = request.json
    producer.send('test-topic', value=data)
    return jsonify({'status': 'success'})

if __name__ == '__main__':
    app.run(port=5000)
    