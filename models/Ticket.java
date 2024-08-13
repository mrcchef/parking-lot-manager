package models;

import java.time.Instant;

public class Ticket {
    private String id;
    private Instant startTimestamp;
    private int slotNum;
    private int floorNum;

    public Ticket(String id, Instant startTimestamp, int slotNum, int floorNum) {
        this.id = id;
        this.startTimestamp = startTimestamp;
        this.slotNum = slotNum;
        this.floorNum = floorNum;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public int getSlotNum() {
        return slotNum;
    }

    public String getId() {
        return id;
    }

}
