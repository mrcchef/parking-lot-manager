package models;

public class Slot {
    private int slotNum;
    private VehicleType vehicleType;
    private boolean isFree;
    private int floorNum;

    Slot(int slotNum, VehicleType vehicleType,int floorNum) {
        this.slotNum = slotNum;
        this.vehicleType = vehicleType;
        this.isFree = true;
        this.floorNum=floorNum;
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

    public int getFloorNum(){
        return floorNum;
    }

}
