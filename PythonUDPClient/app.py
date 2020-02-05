#!/usr/bin/env python3

import socket

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# msg = input()
# sock.sendto(msg.encode('utf-8'), ('127.0.0.1', 1234))
# answer, address = sock.recvfrom(1024)
# answer = answer.decode('utf-8')
# print(answer)

while True:
    msg = input()
    sock.sendto(msg.encode('utf-8'), ('127.0.0.1', 1234))
    answer, address = sock.recvfrom(1024)
    answer = answer.decode('utf-8')
    print(answer);
