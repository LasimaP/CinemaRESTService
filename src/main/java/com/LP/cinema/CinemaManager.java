package com.LP.cinema;

public class CinemaManager {
    private int currentIncome;
    private int numberOfAvailableSeats;
    private int numberOfPurchasedTickets;


    public CinemaManager() {
        this.currentIncome = 0;
        this.numberOfAvailableSeats = 81;
        this.numberOfPurchasedTickets = 0;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }


    public void update(CinemaSeat seat) {
        if (seat == null) {
            return;
        }

        if (seat.isBooked()) {
            currentIncome += seat.getPrice();
            numberOfAvailableSeats -= 1;
            numberOfPurchasedTickets += 1;
        } else {
            currentIncome -= seat.getPrice();
            numberOfAvailableSeats += 1;
            numberOfPurchasedTickets -= 1;
        }
    }

}

