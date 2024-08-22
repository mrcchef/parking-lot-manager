
import java.util.ArrayList;
import java.util.List;

import models.Floor;
import models.ParkingLot;
import models.Slot;
import models.Ticket;
import models.Vehicle;
import models.VehicleType;

public class Start {
    public static void main(String[] args) {
        // 1) Park a Vehicle
        List<Floor> floors = new ArrayList<Floor>();
        int floorCnt = 5;
        for (int i = 0; i < floorCnt; i++) {
            int slotNum = 10;
            List<Slot> slots = new ArrayList<Slot>();
            for (int j = 0; j < slotNum; j++) {
                VehicleType vechileType;
                if (j == 0)
                    vechileType = VehicleType.TRUCK;
                else if (j <= 2)
                    vechileType = VehicleType.BIKE;
                else
                    vechileType = VehicleType.CAR;
                slots.add(new Slot(j, vechileType, i));
            }
            Floor floor = new Floor(i, slots);
            floors.add(floor);
        }

        ParkingLot parkingLot = new ParkingLot("PARK1", floors);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot);

        Vehicle v1 = new Vehicle(VehicleType.TRUCK, "red", "123");

        Ticket t1 = parkingLotManager.park(v1);
        // parkingLotManager.displayFloorWiseFreeSlotsCnt(v1.getVehicleType());
        parkingLotManager.displayFloorWiseOccupiedSlot(v1.getVehicleType());
        parkingLotManager.unpark(t1);
        parkingLotManager.displayFloorWiseOccupiedSlot(v1.getVehicleType());

    }
}
