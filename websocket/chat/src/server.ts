/// <reference types='node' />
/// <reference types='ws' />

'use strict';

import WebSocket = require('ws');
import models = require('./model');

let port: any = process.env.PORT || 3000;
let WebSocketServer = WebSocket.Server;
let server = new WebSocketServer({ port: port });

server.on('connection', ws => {
    ws.on('message', message => {
        try {
            let userMessage: models.UserMessage = new models.UserMessage(message);
            broadcast(JSON.stringify(userMessage));
        } catch (e) {
            console.error(e.message);
        }
    });
});

function broadcast(data: string): void {
    server.clients.forEach(client => {
        client.send(data);
    });
};

console.log('Server is running on port', port);