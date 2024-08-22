package models;

import java.util.List;

public class Floor {
    private int floorNum;
    private List<Slot> slots;
    // Total we have n slots
    // 0th index: Truck
    // 1,2 index: Bike
    // rest index: Car

    public Floor(int floorNum, List<Slot> slots) {
        this.floorNum = floorNum;
        this.slots = slots;
    }

    public int getFloorNum() {
        return floorNum;
    }

    // input slotNum
    // 1 to n, slotNum
    // 0 to n-1
    public Slot getSlot(int slotNum) throws IndexOutOfBoundsException {
        return slots.get(slotNum);
    }

    public Slot getFreeSlot(VehicleType vehicleType) {
        int startSlotNum, endSlotNum;
        if (VehicleType.TRUCK == vehicleType) {
            startSlotNum = 0;
            endSlotNum = 0;
        } else if (VehicleType.BIKE == vehicleType) {
            startSlotNum = 1;
            endSlotNum = 2;
        } else {
            startSlotNum = 3;
            endSlotNum = slots.size() - 1;
        }

        for (int slotNum = startSlotNum; slotNum <= endSlotNum; slotNum++) {
            Slot slot = getSlot(slotNum);
            if (slot.isSlotFree())
                return slot;
        }

        return null;
    }

    public List<Slot> getSlots() {
        return this.slots;
    }
}
