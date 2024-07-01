#!/usr/bin/env python
import time
import serial

ser = serial.Serial(
        port='/dev/ttyS0',
        baudrate = 9600,
        parity = serial.PARITY_NONE,      
        stopbits=serial.STOPBITS_ONE,
        bytesize=serial.EIGHTBITS,
        timeout=1
)

while 1:
        byte_val=ser.read()
        print(byte_val)
        if(byte_val):
            int_val = int.from_bytes(byte_val, "big")
        #print(int_val)
            print(int_val)
        #print(type(int_val))


