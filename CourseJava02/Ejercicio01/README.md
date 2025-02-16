## Source Code Overview

The `src` folder contains the source code for the project. Below is an overview of the main components and their functionalities:

### Main.java

This is the entry point of the application. It contains the `main` method which is executed when the program runs. The `main` method performs the following tasks:
- Creates an instance of the `Clock` class.
- Starts the clock by calling the `startClock` method, which begins updating and displaying the current time.
- Runs the clock for 10 seconds by putting the main thread to sleep.
- Stops the clock by calling the `stopClock` method, which stops the time update and display threads.
- Prints a message indicating that the clock has stopped.

### Clock.java

This class represents a clock. It includes methods to start and stop the clock. The `Clock` class performs the following tasks:
- Maintains a flag (`running`) to control the execution of the clock. This flag is used to start and stop the clock.
- Stores the current time in a string (`currentTime`), which is updated every second.
- Uses two separate threads to handle time updates and display:
  - The update thread continuously updates the current time every second using the `SimpleDateFormat` class to format the date and time.
  - The display thread prints the most recently updated time to the console every second.
- Provides a method (`startClock`) to start the clock by initializing and starting the update and display threads. The update thread is given a lower priority to ensure that the display thread can run more frequently.
- Provides a method (`stopClock`) to stop the clock by setting the `running` flag to false, which causes both the update and display threads to stop executing.

The `Clock` class ensures that the time is updated and displayed in a synchronized manner, providing a real-time clock functionality within the application.

#### Detailed Explanation of Clock.java

- **Attributes:**
  - `running`: A boolean flag that controls the execution of the clock. When set to `false`, it stops the clock.
  - `currentTime`: A string that stores the current time, which is updated every second.

- **Methods:**
  - `startClock()`: This method starts the clock by creating and starting two threads:
    - **Update Thread:** This thread updates the `currentTime` every second using the `SimpleDateFormat` class to format the date and time. It runs in a loop as long as the `running` flag is `true`.
    - **Display Thread:** This thread prints the `currentTime` to the console every second. It also runs in a loop as long as the `running` flag is `true`.
    - The update thread is given a lower priority to ensure that the display thread can run more frequently and provide real-time updates.
  - `stopClock()`: This method stops the clock by setting the `running` flag to `false`, which causes both the update and display threads to stop executing.

The `Clock` class uses multithreading to ensure that the time is updated and displayed in real-time. The update thread continuously updates the time, while the display thread prints the updated time to the console. This design allows the clock to provide accurate and synchronized time updates.