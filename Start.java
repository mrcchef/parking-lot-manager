
package par;

import java.util.ArrayList;
import java.util.List;

import models.Floor;
import models.ParkingLot;
import models.Slot;



public class Start {
    public static void Main(String[] args) {
        // 1) Park a Vehicle 
        List<Floor> floors=new ArrayList<Floor>();
        int floorCnt=5;
        for(int i=0;i<floorCnt;i++)
        {   
            int slotNum=10;
            List<Slot> slots=new ArrayList<Slot>();
            for(int j=0;j<slotNum;j++)
            {
                VehicleType vechileType;
                if(j==0)
                    vechileType=
                slots.add(new Slot(j,vechileType,i));
            }
            Floor floor=new Floor(i,);
        }


        ParkingLot parkingLot=new ParkingLot("PARK1", null);
        ParkingLotManager parkingLotManager=new ParkingLotManager(parkingLot);
    }
}
