package server; // Correct package declaration

import java.io.*;
import java.net.*;
import java.util.*;

// Chat Server to handle multiple client connections
public class ChatServer {
    private static final int PORT = 12345; // Port number for the server
    private static Set<ClientHandler> clientHandlers = new HashSet<>(); // Set to keep track of connected clients

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) { // Create the server socket
            System.out.println("Chat Server started...");
            while (true) {
                Socket socket = serverSocket.accept(); // Accept new client connection
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandlers.add(clientHandler); // Add client to active list
                new Thread(clientHandler).start(); // Start a new thread to handle the client
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print any errors that occur
        }
    }

    // Inner class to handle client connections
    static class ClientHandler implements Runnable {
        private Socket socket; // Client socket
        private PrintWriter out; // Output stream to send messages to the client
        private BufferedReader in; // Input stream to receive messages from the client
        private String userName; // Username of the connected client

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Read input from client
                out = new PrintWriter(socket.getOutputStream(), true); // Output stream to send messages
                
                // Ask the client for their username
                out.print("Enter your name: "); // Use print to avoid unnecessary newline
                out.flush(); // Ensure message is sent immediately
                userName = in.readLine(); // Read the username from client
                System.out.println(userName + " joined the chat.");
                broadcast(userName + " has joined the chat."); // Notify all clients
                
                // Provide a prompt for the user to start chatting
                out.println("You can now start chatting. Type your message below.");

                
                String message;
                // Read messages from the client and broadcast them
                while ((message = in.readLine()) != null) {
                    broadcast(userName + ": " + message);
                }
            } catch (IOException e) {
                System.out.println(userName + " disconnected.");
            } finally {
                try {
                    socket.close(); // Close the socket when the client disconnects
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clientHandlers.remove(this); // Remove the client from the active list
                broadcast(userName + " has left the chat."); // Notify all clients
            }
        }

        // Method to broadcast messages to all connected clients
        private void broadcast(String message) {
            for (ClientHandler client : clientHandlers) {
                client.out.println(message); // Send message to each client
            }
        }
    }
}
