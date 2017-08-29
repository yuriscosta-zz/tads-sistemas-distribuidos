# coding: utf-8

import socket

HOST = '127.0.0.1'
PORT = 5000

tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
target = (HOST, PORT)

tcp.connect(target)

message = input("Digite uma mensagem (para sair digite ctrl + x): ")

while message != '\x18':
    tcp.send(message.encode())
    message = input("Digite uma mensagem (para sair digite ctrl + x): ")

tcp.close()
