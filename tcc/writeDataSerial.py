import serial
import time

ser = serial.Serial(port='COM7',
        baudrate = 9600,
        parity = serial.PARITY_NONE,      
        stopbits=serial.STOPBITS_ONE,
        bytesize=serial.EIGHTBITS,
        timeout=1)
x = (str.encode("%s"%('1')))

while True:
        ser.write(x)
        time.sleep(1)