# python3.6

import random
import pandas as pd
from paho.mqtt import client as mqtt_client


broker = 'broker.emqx.io'
port = 1883
topic = "python/mqtt" 
# generate client ID with pub prefix randomly
client_id = f'python-mqtt-{random.randint(0, 100)}'
username = 'emqx'
password = 'public'


def connect_mqtt() -> mqtt_client:
    def on_connect(client, userdata, flags, rc):
        if rc == 0:
            print("Connected to MQTT Broker!")
        else:
            print("Failed to connect, return code %d\n", rc)

    # client = mqtt_client.Client(client_id)
    client = mqtt_client.Client(mqtt_client.CallbackAPIVersion.VERSION1, client_id)
    client.username_pw_set(username, password)
    client.on_connect = on_connect
    client.connect(broker, port)
    return client


def subscribe(client: mqtt_client):
    def on_message(client, userdata, msg):
        
        print(f"Received `{msg.payload.decode()}` from `{msg.topic}` topic")
        if("masa" in msg.payload.decode()):
            #json_string = '[{"Name": "Nik", "Age": 30, "Active": true}, {"Name": "Kate", "Age": 32, "Active": true}, {"Name": "Evan", "Age": 45, "Active": false}, {"Name": "Kyra", "Age": 43, "Active": true}]'
            json_string = f"{msg.payload.decode()}"
            df = pd.read_json(json_string)
            df.to_csv('grafana/grafana-storage/file.csv', chunksize=10,mode='a', header=False)
        else:
            print(f"Received else `{msg.payload.decode()}` from `{msg.topic}` topic")

    client.subscribe(topic)
    client.on_message = on_message


def run():
    client = connect_mqtt()
    subscribe(client)
    client.loop_forever()
   


if __name__ == '__main__':
    run()