import random
import time
import serial
import codecs
from paho.mqtt import client as mqtt_client


broker = 'broker.emqx.io'
port = 1883
topic = "python/mqtt"
# generate client ID with pub prefix randomly
client_id = f'python-mqtt-{random.randint(0, 1000)}'
username = 'emqx'
password = 'public'

def connect_mqtt():
    def on_connect(client, userdata, flags, rc):
        if rc == 0:
            print("Connected to MQTT Broker!")
        else:
            print("Failed to connect, return code %d\n", rc)

    client = mqtt_client.Client(client_id)
    client.username_pw_set(username, password)
    client.on_connect = on_connect
    client.connect(broker, port)
    return client


def publish(client):
    print("teste")
    msg_count = 0
    while True:
        #msg = recebeMensagemSerial()
        
        ser = serial.Serial(port = '/dev/ttyS0',
            baudrate = 115200,
            parity = serial.PARITY_NONE,      
            stopbits=serial.STOPBITS_ONE,
            bytesize=serial.EIGHTBITS,
            timeout=1)
        time.sleep(3)
        
        comandoLido = ser.read()
        msg = int.from_bytes(comandoLido,'big')
        #msg = comandoLido
        while (ser.in_waiting >1):
            print('deu boa',msg)
            print(': ', comandoLido)
            
           # print('::: ', ord(comandoLido))
            
            
            time.sleep(1)
            #msg = f"messages: {msg_count}"
            result = client.publish(topic, msg)
            # result: [0, 1]
            status = result[0]
            if status == 0:
                print(f"Send `{msg}` to topic `{topic}`")
            else:
                print(f"Failed to send message to topic {topic}")
        msg_count += 1



def run():
    
    client = connect_mqtt()
    client.loop_start()
    publish(client)


if __name__ == '__main__':
    run()
