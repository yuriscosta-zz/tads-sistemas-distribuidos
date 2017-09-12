from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler

class RequestHandler(SimpleXMLRPCRequestHandler):
    rpc_paths = ('/RPC2',)

server =  SimpleXMLRPCServer(("localhost", 8000),
                             requestHandler=RequestHandler)
server.register_introspection_functions()

server.register_function(pow)

def adder_function(x, y):
    return x + y
server.register_function(adder_function, 'add')

class MyFuncs:
    def mul(self, x, y):
        return x * y
server.register_instance(MyFuncs())

server.serve_forever()
