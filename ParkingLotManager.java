import java.time.Instant;

import models.Floor;
import models.ParkingLot;
import models.Slot;
import models.Ticket;
import models.Vehicle;

public class ParkingLotManager {
    private ParkingLot parkingLot;

    ParkingLotManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    // 1) park: Given a input vehicle, I want to park

    Ticket park(Vehicle vehicle) {
        Ticket ticket = null;
        // step 1) Find the free slot for the vehicle
        System.out.println("Finding free slot for vehicle Type" + vehicle.getVehicleType());
        Slot freeSlot = parkingLot.getFreeSlot(vehicle.getVehicleType());
        if (freeSlot != null) {
            System.out.println("Occupying the free slot: " + freeSlot.getSlotNum());
            // step 2) occpuy that slot
            freeSlot.setIsFree(false);

            // step 3) Generate a ticket
            StringBuilder ticketId = new StringBuilder();
            // Format: <parking_lot_id>_<floor_no>_<slot_no>
            ticketId.append(parkingLot.getId()).append("_").append(freeSlot.getFloorNum()).append("_")
                    .append(freeSlot.getSlotNum());
            ticket = new Ticket(ticketId.toString(), Instant.now(), freeSlot.getSlotNum(), freeSlot.getFloorNum());

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

}
