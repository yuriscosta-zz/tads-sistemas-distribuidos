# coding: utf-8

import socket

HOST = '127.0.0.1'
PORT = 5000

udp = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
target = (HOST, PORT)

message = input("Digite uma mensagem (para sair digite ctrl + x): ")

while message != '\x18':
    udp.sendto(message.encode(), target)
    message = input("Digite uma mensagem (para sair digite ctrl + x): ")

udp.close()
