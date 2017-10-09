import asyncio
import websockets

async def hello():
    async with websockets.connect('ws://10.24.12.122:9876/') as websocket:
        name = input("What's your name? ")
        await websocket.send(name)
        print("> {}".format(name))

        greeting = await websocket.recv()
        print("< {}".format(greeting))

if __name__ == '__main__':
    asyncio.get_event_loop().run_until_complete(hello())
