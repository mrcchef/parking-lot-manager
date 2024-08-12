package models;

import java.util.List;

public class ParkingLot {
    private String id;
    private List<Floor> floors;

    ParkingLot(String id, List<Floor> floors) {
        this.id = id;
        this.floors = floors;
    }

    // Helper functions

    public String getId() {
        return id;
    }

    // Give me floor number 2
    // I have to return 2nd floor's object
    public Floor getFloor(int floor_num) {
        Floor floor = null;
        try {
            floor = floors.get(floor_num - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid Floor Number: " + floor_num + " Current floor size: " + floors.size());
        } catch (Exception e) {
            System.out.println("Unexpected Error" + e);
        }

        return floor;
    }

    public Slot getFreeSlot(VehicleType vehicleType) {

        for (int i = 0; i < floors.size(); i++) {
            Slot slot = floors.get(i).getFreeSlot(vehicleType);
            if (slot != null)
                return slot;
        }

        return null;
    }
}
