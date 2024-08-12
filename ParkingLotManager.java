import models.ParkingLot;
import models.Slot;
import models.Vehicle;

public class ParkingLotManager {
    private ParkingLot parkingLot;
    

    ParkingLotManager(ParkingLot parkingLot)
    {
        this.parkingLot=parkingLot;
    }

    // 1) park: Given a input vehicle, I want to park 

    Ticket park(Vehicle vehicle)
    {
        // step 1) Find the free slot for the vehicle 
        Slot freeSlot=parkingLot.getFreeSlot(vehicle.getVehicleType());
        if(freeSlot==null)
        {
            return false;
        }
        else
        {
            // step 2) occpuy that slot 
            freeSlot.setIsFree(false); 

            // step 3) Generate a ticket
            return true;
        }
        
        
        
    }
    

}
