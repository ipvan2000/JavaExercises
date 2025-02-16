import java.text.SimpleDateFormat;
import java.util.Date;
class Clock {
  private boolean running = true; // Control flag for clock execution
  private String currentTime = ""; // Store the latest time for display

  /**
   * Starts the clock with separate threads for updating and displaying the time.
   */
  public void startClock() {
      // Thread to continuously update the current time
      Thread updateThread = new Thread(() -> {
          SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
          while (running) {
              currentTime = formatter.format(new Date()); // Update time
              try {
                  Thread.sleep(1000); // Sleep for 1 second before updating again
              } catch (InterruptedException e) {
                  System.out.println("Time update interrupted.");
                  Thread.currentThread().interrupt();
              }
          }
      });

      // Thread to display the updated time
      Thread displayThread = new Thread(() -> {
          while (running) {
              System.out.println(currentTime); // Print the most recently updated time
              try {
                  Thread.sleep(1000); // Sleep for 1 second before printing again
              } catch (InterruptedException e) {
                  System.out.println("Clock display interrupted.");
                  Thread.currentThread().interrupt();
              }
          }
      });

      // Assign thread priorities
      updateThread.setPriority(Thread.MIN_PRIORITY);  // Lower priority for updating time
      displayThread.setPriority(Thread.MAX_PRIORITY); // Higher priority for displaying time

      // Start both threads
      updateThread.start();
      displayThread.start();
  }

  /**
   * Stops the clock execution.
   */
  public void stopClock() {
      running = false; // Stop both threads
  }
}