// Main program to interact with the user and display vehicle details
import java.util.Scanner;

public class VehicleInformationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message and menu options
        System.out.println("Welcome to the Vehicle Information System");
        System.out.println("Choose vehicle type: 1. Car  2. Motorcycle  3. Truck");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                // Input and creation of Car object
                System.out.println("Enter Car Make:");
                String carMake = scanner.nextLine();
                System.out.println("Enter Car Model:");
                String carModel = scanner.nextLine();
                System.out.println("Enter Car Year:");
                int carYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter Number of Doors:");
                int carDoors = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter Fuel Type (petrol/diesel/electric):");
                String fuelType = scanner.nextLine();

                Car car = new Car(carMake, carModel, carYear);
                car.setNumDoors(carDoors);
                car.setFuelType(fuelType);

                // Display Car details
                displayCarDetails(car);
                break;

            case 2:
                // Input and creation of Motorcycle object
                System.out.println("Enter Motorcycle Make:");
                String motoMake = scanner.nextLine();
                System.out.println("Enter Motorcycle Model:");
                String motoModel = scanner.nextLine();
                System.out.println("Enter Motorcycle Year:");
                int motoYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter Number of Wheels:");
                int motoWheels = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter Motorcycle Type (sport/cruiser/off-road):");
                String motoType = scanner.nextLine();

                Motorcycle motorcycle = new Motorcycle(motoMake, motoModel, motoYear);
                motorcycle.setNumWheels(motoWheels);
                motorcycle.setMotorcycleType(motoType);

                // Display Motorcycle details
                displayMotorcycleDetails(motorcycle);
                break;

            case 3:
                // Input and creation of Truck object
                System.out.println("Enter Truck Make:");
                String truckMake = scanner.nextLine();
                System.out.println("Enter Truck Model:");
                String truckModel = scanner.nextLine();
                System.out.println("Enter Truck Year:");
                int truckYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter Cargo Capacity (in tons):");
                double cargoCapacity = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter Transmission Type (manual/automatic):");
                String transmissionType = scanner.nextLine();

                Truck truck = new Truck(truckMake, truckModel, truckYear);
                truck.setCargoCapacity(cargoCapacity);
                truck.setTransmissionType(transmissionType);

                // Display Truck details
                displayTruckDetails(truck);
                break;

            default:
                System.out.println("Invalid choice!");
                break;
        }

        scanner.close();
    }

    // Method to display Car details
    public static void displayCarDetails(Car car) {
        System.out.println("Car Details:");
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Number of Doors: " + car.getNumDoors());
        System.out.println("Fuel Type: " + car.getFuelType());
    }

    // Method to display Motorcycle details
    public static void displayMotorcycleDetails(Motorcycle motorcycle) {
        System.out.println("Motorcycle Details:");
        System.out.println("Make: " + motorcycle.getMake());
        System.out.println("Model: " + motorcycle.getModel());
        System.out.println("Year: " + motorcycle.getYear());
        System.out.println("Number of Wheels: " + motorcycle.getNumWheels());
        System.out.println("Type: " + motorcycle.getMotorcycleType());
    }

    // Method to display Truck details
    public static void displayTruckDetails(Truck truck) {
        System.out.println("Truck Details:");
        System.out.println("Make: " + truck.getMake());
        System.out.println("Model: " + truck.getModel());
        System.out.println("Year: " + truck.getYear());
        System.out.println("Cargo Capacity: " + truck.getCargoCapacity() + " tons");
        System.out.println("Transmission Type: " + truck.getTransmissionType());
    }
}