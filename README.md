# Socket Utils

## Purpose

The aim of this project is used to simplify the connection between sockets.

## Pre-Requisites
- Gradle

## Installation
```
gradle shadowJar 
```

## Usage
Include the generated `.jar` file in your project dependencies.


## Example
#### Send
````
// Connect so server
Socket socket = new Socket("HOST", PORT);

// Create json object
JsonObject object = createSomeJsonObject();

// Send as json string or json object
SocketUtils.sendJsonString(socket, object.toString());
SocketUtils.sendJsonObject(socket, object);
````

#### Recv

````
// Start the server socket and accept client connection
ServerSocket serverSocket = new ServerSocket(PORT);
Socket clientSocket = serverSocket.accept();

// Wait for json from the client
String string = SocketUtils.receiveJsonString(clientSocket);
JsonObject jsonObject = SocketUtils.receiveJsonObject(clientSocket);
````