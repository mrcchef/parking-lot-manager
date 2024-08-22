package models;


public class Vehicle {

    private VehicleType vehicleType;
    private String color;
    private String registrationNum;

    public Vehicle(VehicleType vehicleType, String color, String registrationNum) {
        this.vehicleType = vehicleType;
        this.color = color;
        this.registrationNum = registrationNum;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

}

// 3 class
// Car, Bike, Truck
// Extends Vehicle
