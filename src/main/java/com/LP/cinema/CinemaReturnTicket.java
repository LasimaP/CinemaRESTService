package com.LP.cinema;

public class CinemaReturnTicket {

    private CinemaSeat returnedTicket;

    public CinemaReturnTicket(CinemaSeat ticket) {
        this.returnedTicket = ticket;
        returnedTicket.setBooked(false);
    }

    public CinemaReturnTicket() {}

    public CinemaSeat getReturnedTicket() {
        return returnedTicket;
    }

    public void setReturnedTicket(CinemaSeat returnedTicket) {
        this.returnedTicket = returnedTicket;
    }
}
