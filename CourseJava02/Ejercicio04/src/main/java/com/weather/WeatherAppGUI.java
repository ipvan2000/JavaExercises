package com.weather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import com.google.gson.JsonObject;

public class WeatherAppGUI {
    public static void main(String[] args) {
        // Create the main application frame
        JFrame frame = new JFrame("Weather Information App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Main panel with BorderLayout to organize components
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Text area to display weather information
        JTextArea resultArea = new JTextArea("Weather information will appear here...");
        resultArea.setEditable(false); // Make the text area read-only
        resultArea.setFont(new Font("Arial", Font.BOLD, 16)); // Set font style and size
        resultArea.setForeground(Color.BLUE); // Set text color
        resultArea.setBackground(Color.LIGHT_GRAY); // Set background color
        resultArea.setLineWrap(true); // Enable line wrapping
        resultArea.setWrapStyleWord(true); // Wrap lines at word boundaries
        resultArea.setMargin(new Insets(10, 10, 10, 10)); // Add padding around the text
        mainPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER); // Add the text area to the center of the panel

        // Input panel at the bottom for user input
        JPanel inputPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JLabel locationLabel = new JLabel("Enter Location (e.g., London, New York):"); // Label for the input field
        JTextField locationField = new JTextField(); // Text field for user to enter location
        JButton fetchButton = new JButton("Get Weather"); // Button to fetch weather information

        // Add placeholder text to the location field
        locationField.setText("Enter city name...");
        locationField.setForeground(Color.GRAY); // Set placeholder text color

        // Add focus listener to handle placeholder text behavior
        locationField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Clear placeholder text when the field gains focus
                if (locationField.getText().equals("Enter city name...")) {
                    locationField.setText("");
                    locationField.setForeground(Color.BLACK); // Set text color to black
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Restore placeholder text if the field is empty when it loses focus
                if (locationField.getText().isEmpty()) {
                    locationField.setText("Enter city name...");
                    locationField.setForeground(Color.GRAY); // Set placeholder text color
                }
            }
        });

        // Add components to the input panel
        inputPanel.add(locationLabel);
        inputPanel.add(locationField);
        inputPanel.add(fetchButton);

        // Add the input panel to the bottom of the main panel
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // Add action listener to the fetch button
        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the location entered by the user
                String location = locationField.getText().trim();
                if (location.isEmpty() || location.equals("Enter city name...")) {
                    // Display an error message if the input is invalid
                    resultArea.setText("Error: Please enter a valid location.");
                    return;
                }
                try {
                    // Fetch weather data from the API
                    JsonObject weatherData = WeatherAPI.getWeather(location);
                    // Extract and format weather information
                    String weatherInfo = "Location: " + location + "\n"
                            + "Temperature: " + weatherData.getAsJsonObject("main").get("temp").getAsString() + "°C\n"
                            + "Humidity: " + weatherData.getAsJsonObject("main").get("humidity").getAsString() + "%\n"
                            + "Condition: " + weatherData.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
                    // Display the weather information in the result area
                    resultArea.setText(weatherInfo);
                } catch (Exception ex) {
                    // Display an error message if the API request fails
                    resultArea.setText("Error: " + ex.getMessage());
                }
            }
        });

        // Add the main panel to the frame
        frame.add(mainPanel);
        frame.setVisible(true); // Make the frame visible
    }
}