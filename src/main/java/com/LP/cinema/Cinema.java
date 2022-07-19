package com.LP.cinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private int totalRows;
    private int totalColumns;
    private List<CinemaSeat> availableSeats;


    public Cinema() {
        this.totalRows = 9;
        this.totalColumns = 9;
        this.availableSeats = new ArrayList<>();
        populateSeats();
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<CinemaSeat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<CinemaSeat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    private void populateSeats() {
        for(int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                var seat = new CinemaSeat(i + 1, j + 1);
                availableSeats.add(seat);
            }
        }
    }

    public CinemaSeat findSeat(CinemaSeat seat) {
        if (availableSeats.contains(seat)) {
            return availableSeats.get(availableSeats.indexOf(seat));
        }
        return null;
    }
}

