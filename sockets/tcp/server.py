# coding: utf-8

import socket

HOST = ''
PORT = 5000

tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
origin = (HOST, PORT)

tcp.bind(origin)
tcp.listen(1)

while True:
    connection, client = tcp.accept()
    print("Conectador por: {0}".format(client))
    while True:
        message = connection.recv(1024).decode()
        if not message: 
            break
        print ("{0}: {1}".format(client, message))
    print("Finalizando conexão com: {0}".format(client))
    connection.close()
