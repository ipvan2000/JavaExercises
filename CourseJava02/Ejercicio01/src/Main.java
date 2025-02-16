public class Main {
    public static void main(String[] args) {
        Clock clock = new Clock(); // Create a Clock instance
        clock.startClock(); // Start the clock

        // Run the clock for 10 seconds, then stop it
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
            Thread.currentThread().interrupt();
        }
        
        clock.stopClock(); // Stop the clock
        System.out.println("Clock stopped.");
    }
}
