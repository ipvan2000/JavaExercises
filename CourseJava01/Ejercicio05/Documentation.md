# Documentation and Steps to Run the Vehicle Information System
## Overview
This Java program is designed for a car rental agency to manage different types of vehicles (cars, motorcycles, and trucks). The application utilizes interfaces to enforce common behavior and consistency across vehicle types. The main program allows users to create objects of different vehicle types, input relevant information, and display the details of each vehicle.

## Components
1. Interfaces:

- Vehicle: Defines methods for retrieving the make, model, and year of a vehicle.
- CarVehicle: Extends Vehicle with methods for setting and getting the number of doors and fuel type.
- MotorVehicle: Extends Vehicle with methods for setting and getting the number of wheels and motorcycle type.
- TruckVehicle: Extends Vehicle with methods for setting and getting the cargo capacity and transmission type.

2. Classes:
- Car: Implements Vehicle and CarVehicle interfaces.
- Motorcycle: Implements Vehicle and MotorVehicle interfaces.
- Truck: Implements Vehicle and TruckVehicle interfaces.

3. Main Program:
- VehicleInformationSystem: Main class to interact with the user, create vehicle objects, and display their details.

# Steps to Run the Code

1. Run the Main Program:
- Locate the VehicleInformationSystem class, which contains the main method.
- Run the VehicleInformationSystem class. This will launch the interactive console application.

2. Interact with the Program:
- Follow the prompts in the console to input details for different vehicle types.
- The program will display the details of the vehicle you entered.