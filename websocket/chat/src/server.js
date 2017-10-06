/// <reference path='../declarations/node.d.ts' />
/// <reference path='../declarations/ws.d.ts' />
'use strict';
exports.__esModule = true;
var WebSocket = require("ws");
var models = require("./model");
var port = process.env.PORT || 3000;
var WebSocketServer = WebSocket.Server;
var server = new WebSocketServer({ port: port });
server.on('connection', function (ws) {
    ws.on('message', function (message) {
        try {
            var userMessage = new models.UserMessage(message);
            broadcast(JSON.stringify(userMessage));
        }
        catch (e) {
            console.error(e.message);
        }
    });
});
function broadcast(data) {
    server.clients.forEach(function (client) {
        client.send(data);
    });
}
;
console.log('Server is running on port', port);
