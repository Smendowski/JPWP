import socket
import json

HOST = "172.104.229.108"
PORT = 9001

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))


    username = json.dumps({'username':'Smendowski'})
    all_rooms  = json.dumps({'request': 'ALL_ROOMS'})
    create_room = json.dumps({'request': 'CREATE_ROOM', 'data': 'Custom'})

    s.sendall(str.encode(username))
    response = s.recv(2048).decode()
    response_json = json.loads(response)
    session_id = response_json['session_id']

    print(session_id)

    s.sendall(str.encode(all_rooms))
    response = s.recv(4096).decode()
    response_json = json.loads(response)
    rooms = response_json['data']

    for room in rooms:
        print(room)

    s.sendall(str.encode(create_room))
    response = s.recv(2048).decode()

    print(response)

    s.close()
