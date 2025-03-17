package client; // Correct package declaration

import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost"; // Server address (localhost for local testing)
    private static final int SERVER_PORT = 12345; // Port number to connect to the server

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT); // Connect to the server
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Read messages from server
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true); // Send messages to server
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) { // Read user input

            System.out.println("Connected to chat server.");
            
            // Read the server's prompt for the username
            System.out.print("Enter your name: "); // Display prompt without newline
            String userName = consoleInput.readLine(); // Read user input for username
            output.println(userName); // Send username to the server

            // Create a separate thread to listen for messages from the server
            Thread receiveThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = input.readLine()) != null) { // Read messages from server
                        System.out.println(serverMessage); // Print received messages
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server."); // Handle server disconnection
                }
            });

            receiveThread.start(); // Start the message listening thread

            // Read user input and send messages to the server
            String userMessage;
            while ((userMessage = consoleInput.readLine()) != null) {
                output.println(userMessage); // Send user message to the server
            }

        } catch (IOException e) {
            System.out.println("Error connecting to the server: " + e.getMessage()); // Handle connection errors
        }
    }
}
