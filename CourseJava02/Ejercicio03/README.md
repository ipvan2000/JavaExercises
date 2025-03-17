# Java Chat Application

## Overview

This is a simple multi-user chat application implemented in Java using socket programming. It allows multiple clients to connect to a central server, send messages, and receive messages from other users in real time.

## Features

- **Multi-client support**: Multiple users can connect to the server simultaneously.
- **Real-time messaging**: Clients can send and receive messages instantly.
- **User notifications**: Notifies all users when someone joins or leaves the chat.
- **Simple text-based interface**: Easy to use and interact with.
- **Threaded client handling**: Each client connection runs on a separate thread, ensuring smooth communication.
- **Scalability**: The server can handle multiple users without conflicts or message loss.

## Requirements

- Java 8 or later
- Terminal/Command Prompt
- Optional: Any IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)

## File Structure

```
ChatApplication/
│── src/
│   ├── server/
│   │   ├── ChatServer.java  # Server-side implementation
│   ├── client/
│   │   ├── ChatClient.java  # Client-side implementation
│── README.md                # Instructions and documentation
```

## Java Class Explanations

### `ChatServer.java`

This class is responsible for handling the server-side operations. It listens for incoming client connections and manages message broadcasting.

- **Main Server**:
  - Starts a `ServerSocket` on port `12345`.
  - Continuously accepts incoming client connections.
  - Creates a `ClientHandler` thread for each new client.
  - Manages a list of connected clients to facilitate message broadcasting.

- **ClientHandler (Inner Class)**:
  - Each connected client runs on a separate thread, allowing multiple users to chat simultaneously.
  - Reads input from a connected client and sends messages to all other connected clients.
  - Notifies users when a client joins or leaves.
  - Cleans up resources when a client disconnects.

### `ChatClient.java`

This class represents the client-side implementation, allowing users to connect to the chat server and send/receive messages.

- **Client Connection**:
  - Establishes a socket connection to `localhost:12345`.
  - Uses input and output streams for sending and receiving messages.

- **User Interaction**:
  - Asks for a username upon connection.
  - Listens for incoming messages from the server using a separate thread.
  - Reads user input and sends messages to the server.
  - Displays real-time chat messages from other users.

- **Threaded Message Listening**:
  - A background thread continuously listens for incoming messages.
  - Prevents blocking of user input while messages are being received.

## How to Run the Chat Application

### 1. Start the Server

First, navigate to the server directory and compile `ChatServer.java`:

```sh
javac -d out/ src/server/ChatServer.java
```

Run the server:

```sh
java -cp out/ server.ChatServer
```

The server will start and listen for incoming client connections.

### 2. Start the Client

In a new terminal, navigate to the client directory and compile `ChatClient.java`:

```sh
javac -d out/ src/client/ChatClient.java
```

Run the client:

```sh
java -cp out/ client.ChatClient
```

You can start multiple clients to join the chat.

## Example Chat Session

```
Enter your name: John
You can now start chatting. Type your message below.
John: Hello everyone!
Alice has joined the chat.
Alice: Hi John!
```

## Troubleshooting

- **Client does not connect to the server**:

  - Ensure the server is running before starting a client.
  - Check that the client is connecting to the correct IP and port (`localhost:12345`).

- **Messages are not being received**:

  - Verify that messages are being broadcasted in `ChatServer.java`.
  - Ensure the client is continuously reading messages.

- **Port already in use error**:

  - If you see an error like `Address already in use: JVM_Bind`, ensure no other process is using port `12345`.
  - Try changing the port in `ChatServer.java` and `ChatClient.java`.

- **Console messages appear with delays**:
  - Ensure `flush()` is called on the `PrintWriter` output stream to force messages to be sent immediately.

## Screenshots

Include screenshots of the server running and multiple clients chatting.

## License

This project is free to use for educational purposes.

---

This guide provides everything needed to run and troubleshoot the Java chat application. Let me know if you need any modifications! 🚀
