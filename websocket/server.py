import asyncio
import websockets

async def hello(websocket, path):
    name = await websocket.recv()
    print("< {}".format(name))

    greeting = name[::-1]
    await websocket.send(greeting)
    print("> {}".format(greeting))

if __name__ == '__main__':
    start_server = websockets.serve(hello, '10.25.2.143', 9876)

    asyncio.get_event_loop().run_until_complete(start_server)
    asyncio.get_event_loop().run_forever()
