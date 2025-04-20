package com.weather;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * WeatherAPI class handles the integration with the OpenWeatherMap API.
 * It fetches real-time weather data for a given location.
 */
public class WeatherAPI {
    // API key for accessing the OpenWeatherMap API
    private static final String API_KEY = "";

    // Base URL for the OpenWeatherMap API
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    /**
     * Fetches weather data for a specific location.
     *
     * @param location The name of the city or location to fetch weather data for.
     * @return A JsonObject containing the weather data.
     * @throws IOException If there is an issue with the API request or response.
     */
    public static JsonObject getWeather(String location) throws IOException {
        // Construct the full URL for the API request
        String urlString = BASE_URL + "?q=" + location + "&appid=" + API_KEY + "&units=metric";
        URL url = new URL(urlString);

        // Open a connection to the API
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); // Set the request method to GET

        // Check if the response code is not 200 (OK)
        if (conn.getResponseCode() != 200) {
            throw new IOException("Error fetching data from the API: " + conn.getResponseCode());
        }

        // Read the response from the API
        Scanner scanner = new Scanner(url.openStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close(); // Close the scanner

        // Print the URL for debugging purposes
        System.out.println("URL: " + urlString);

        // Parse the response string into a JsonObject and return it
        return JsonParser.parseString(response.toString()).getAsJsonObject();
    }
}
