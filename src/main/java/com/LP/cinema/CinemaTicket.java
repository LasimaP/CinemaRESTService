package com.LP.cinema;

public class CinemaTicket {
    private String token;
    private CinemaSeat ticket;

    public CinemaTicket(CinemaSeat ticket) {
        this.ticket = ticket;
        this.ticket.setBooked(true);
        token = new CinemaToken().getToken();
    }

    public CinemaTicket() {}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public CinemaSeat getTicket() {
        return ticket;
    }

    public void setTicket(CinemaSeat ticket) {
        this.ticket = ticket;
    }

}