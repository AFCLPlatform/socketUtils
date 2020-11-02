# Socket Utils

## Purpose

The aim of this project is used to simplify the connection between sockets.

## Pre-Requisites
- Gradle

## Installation
```bash
gradle shadowJar 
```

## Usage
Include the generated `.jar` file in your project dependencies.

## Example(s)
 
### Send
````java
// Connect to server
Socket socket = new Socket("HOST", PORT);

// Create json object
JsonObject object = createSomeJsonObject();

// Send as json string
SocketUtils.sendJsonString(socket, object.toString());

// Send as json object (by gson)
SocketUtils.sendJsonObject(socket, object);

// Send generic json type
SocketUtils.sendJsonObject(socket, new User("Stefan", "Pedratscher"));
````

### Recv

````java
// Start the server socket and accept a client connection
ServerSocket serverSocket = new ServerSocket(PORT);
Socket clientSocket = serverSocket.accept();

// Wait for json string from the client
String string = SocketUtils.receiveJsonString(clientSocket);

// Wait for json object (from gson) from the client
JsonObject jsonObject = SocketUtils.receiveJsonObject(clientSocket);

// Wait for generic json from the client
User customUserObject = SocketUtils.receiveJsonObject(socket, User.class);
````

### User class

````java
public class User {
    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
````