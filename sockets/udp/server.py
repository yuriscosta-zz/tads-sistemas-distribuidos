# codging: utf-8

import socket
import time

HOST = ''
PORT = 5000

udp = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
origin = (HOST, PORT)

udp.bind(origin)

while True:
    message, client = udp.recvfrom(1024)
    print("Cliente: {0}\nMensagem: {1}".format(client, message))

udp.close()    
