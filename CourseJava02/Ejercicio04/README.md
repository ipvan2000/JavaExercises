# Weather Information Application

This project is a Java-based Weather Information Application that provides real-time weather updates using a graphical user interface (GUI). The application integrates with a weather API to fetch and display weather data for a specific location.

---

## **Project Structure**

The project follows the standard Maven structure:

```
Ejercicio04/
├── pom.xml                          # Maven configuration file
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── weather/
│   │   │           ├── App.java          # Entry point of the application
│   │   │           ├── WeatherAppGUI.java # GUI implementation
│   │   │           └── WeatherAPI.java   # API 
```

---

## **Class Documentation**

### **1. App.java**
- **Location:** `src/main/java/com/weather/App.java`
- **Description:** 
  - This is the entry point of the application.
  - It initializes and launches the graphical user interface (GUI) by calling the `main` method of the `WeatherAppGUI` class.

### **2. WeatherAppGUI.java**
- **Location:** `src/main/java/com/weather/WeatherAppGUI.java`
- **Description:** 
  - Implements the graphical user interface (GUI) for the application.
  - Allows users to input a location (e.g., city name) and fetch weather data.
  - Displays weather information such as temperature, humidity, and conditions.
  - Handles user input validation and error messages.

### **3. WeatherAPI.java**
- **Location:** `src/main/java/com/weather/WeatherAPI.java`
- **Description:** 
  - Handles integration with the OpenWeatherMap API.
  - Fetches real-time weather data for a given location.
  - Parses the API response into a JSON object for use in the application.

---

## **Setup and Execution**

### **Prerequisites**
1. **Java Development Kit (JDK):**
   - Ensure you have JDK 17 or later installed.
   - Verify the installation by running:
     ```sh
     java -version
     ```
2. **Maven:**
   - Ensure Maven is installed and configured.
   - Verify the installation by running:
     ```sh
     mvn -v
     ```

### **Steps to Run the Project**
1. **Clone the Repository:**
   - Clone the project to your local machine:
     ```sh
     git clone <repository-url>
     ```
   - Replace `<repository-url>` with the URL of your Git repository.

2. **Navigate to the Project Directory:**
   ```sh
   cd JavaExercises/CourseJava02/Ejercicio04
   ```

3. **Add Your API Key:**
   - Open the `WeatherAPI.java` file located in `src/main/java/com/weather/`.
   - Replace the placeholder `YOUR_API_KEY` with your actual OpenWeatherMap API key:
     ```java
     private static final String API_KEY = "YOUR_API_KEY";
     ```

4. **Build the Project:**
   - Clean and compile the project using Maven:
     ```sh
     mvn clean compile
     ```

5. **Run the Application:**
   - Execute the application by running the `App` class:
     ```sh
     mvn exec:java -Dexec.mainClass="com.weather.App"
     ```

---

## **Features**
- **Real-Time Weather Updates:**
  - Fetches weather data such as temperature, humidity, and conditions for a specific location.
- **Graphical User Interface (GUI):**
  - User-friendly interface for inputting location and displaying weather data.
- **Error Handling:**
  - Displays error messages for invalid input or failed API requests.

---

## **Dependencies**
The project uses the following dependencies:
1. **Gson:**
   - For parsing JSON responses from the weather API.
   - Included in the `pom.xml`:
     ```xml
     <dependency>
         <groupId>com.google.code.gson</groupId>
         <artifactId>gson</artifactId>
         <version>2.10.1</version>
     </dependency>
     ```

---

## **Troubleshooting**
1. **Error: Could not find or load main class `com.weather.App`:**
   - Ensure the project is compiled using Maven:
     ```sh
     mvn clean compile
     ```

2. **Error: API key is invalid:**
   - Verify that you have replaced `YOUR_API_KEY` in `WeatherAPI.java` with a valid OpenWeatherMap API key.

3. **Error: `WeatherAppGUI` import cannot be resolved:**
   - Ensure the file `WeatherAppGUI.java` is located in `src/main/java/com/weather/`.
   - Verify the package declaration in `WeatherAppGUI.java`:
     ```java
     package com.weather;
     ```

---

## **License**
This project is licensed under the MIT License. Feel free to use and modify it as needed.