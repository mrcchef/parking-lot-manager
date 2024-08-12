package models;

public class Slot {
    private int slotNum;
    private VehicleType vehicleType;
    private boolean isFree;

    Slot(int slotNum, VehicleType vehicleType) {
        this.slotNum = slotNum;
        this.vehicleType = vehicleType;
        this.isFree = true;
    }

    public int getSlotNum() {
        return slotNum;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isSlotFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

}
