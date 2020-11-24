# Socket Utils

![Apollo CI](https://github.com/ApolloCEC/socketUtils/workflows/Apollo%20CI/badge.svg)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/be4852fb525748748947104a7c57e815)](https://www.codacy.com/gh/ApolloCEC/socketUtils/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=AFCLPlatform/socketUtils&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/be4852fb525748748947104a7c57e815)](https://www.codacy.com/gh/ApolloCEC/socketUtils/dashboard?utm_source=github.com&utm_medium=referral&utm_content=AFCLPlatform/socketUtils&utm_campaign=Badge_Coverage)




## Purpose

The aim of this project is to simplify the connection between the sockets of the various modules of the AFCL platform.

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
