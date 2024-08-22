import java.time.Instant;
import java.util.List;

import models.Floor;
import models.ParkingLot;
import models.Slot;
import models.Ticket;
import models.Vehicle;
import models.VehicleType;

public class ParkingLotManager {
    private ParkingLot parkingLot;

    ParkingLotManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    // 1) park: Given a input vehicle, I want to park

    Ticket park(Vehicle vehicle) {
        Ticket ticket = null;
        // step 1) Find the free slot for the vehicle
        System.out.println("Finding free slot for vehicle Type: " + vehicle.getVehicleType());
        Slot freeSlot = parkingLot.getFreeSlot(vehicle.getVehicleType());
        if (freeSlot != null) {
            System.out.println("Occupying the free slot where Floor num: " + freeSlot.getFloorNum() + " and Slot num: "
                    + freeSlot.getSlotNum());
            // step 2) occpuy that slot
            freeSlot.setIsFree(false);

            // step 3) Generate a ticket
            StringBuilder ticketId = new StringBuilder();
            // Format: <parking_lot_id>_<floor_no>_<slot_no>
            ticketId.append(parkingLot.getId()).append("_").append(freeSlot.getFloorNum()).append("_")
                    .append(freeSlot.getSlotNum());
            ticket = new Ticket(ticketId.toString(), Instant.now(), freeSlot.getSlotNum(),
                    freeSlot.getFloorNum());

            System.out.println("Created ticket with ticket id: " + ticket.getId());
        }

        return ticket;
    }

    boolean unpark(Ticket ticket) {
        System.out.println("Unparking the ticket: " + ticket.getId());
        // step 1) I want that slot....
        Floor floor = parkingLot.getFloor(ticket.getFloorNum());
        Slot slot = floor.getSlot(ticket.getSlotNum());
        System.out.println(
                "Found occupied slot with floor Num: " + floor.getFloorNum() + " slot num: " + slot.getSlotNum());
        // step 2) I will free that slot
        slot.setIsFree(true);
        // step 3) calculate amount (out of scope)

        System.out.println("Unparked the vehicle");
        return true;
    }

    void displayFloorWiseFreeSlotsCnt(VehicleType vehicleType) {
        List<Floor> floors = this.parkingLot.getFloors();
        for (int i = 0; i < floors.size(); i++) {
            System.out.println("Floor Number: " + i);
            List<Slot> slots = floors.get(i).getSlots();

            int truckFreeSlotsCnt = 0;
            int carFreeSlotsCnt = 0;
            int bikeFreeSlotsCnt = 0;

            for (int j = 0; j < slots.size(); j++) {
                if (!slots.get(j).isSlotFree())
                    continue;

                if (slots.get(j).getVehicleType() == VehicleType.TRUCK)
                    truckFreeSlotsCnt++;
                else if (slots.get(j).getVehicleType() == VehicleType.CAR)
                    carFreeSlotsCnt++;
                else if (slots.get(j).getVehicleType() == VehicleType.BIKE)
                    bikeFreeSlotsCnt++;

            }

            System.out.println("Floor Cnt: " + i);
            System.out.println("Free Truck Slots cnt: " + truckFreeSlotsCnt);
            System.out.println("Free Car Slots cnt: " + carFreeSlotsCnt);
            System.out.println("Free Bike Slots cnt: " + bikeFreeSlotsCnt);
        }
    }

    void displayFloorWiseOccupiedSlot(VehicleType vehicleType) {
        List<Floor> floors = this.parkingLot.getFloors();
        for (int i = 0; i < floors.size(); i++) {
            System.out.println("Floor Number: " + i);
            List<Slot> slots = floors.get(i).getSlots();
            int freeSlotsCnt = 0;
            for (int j = 0; j < slots.size(); j++) {
                if (!slots.get(j).isSlotFree())
                    continue;

                freeSlotsCnt += 1;
            }

            System.out.println("Free Slots cnt: " + freeSlotsCnt);

        }
    }

}
