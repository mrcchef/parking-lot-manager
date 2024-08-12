package models;

import java.security.Timestamp;

public class Ticket {
    private String id;
    private int startTimestamp;

    Ticket(String id,int startTimestamp)
    {
        this.id=id;
        this.startTimestamp=startTimestamp;
    }

}
