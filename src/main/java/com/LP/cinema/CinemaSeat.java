package com.LP.cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class CinemaSeat {
    private int row;
    private int column;
    private int price;

    private boolean booked;

    public CinemaSeat(int row, int column) {
        this.row = row;
        this.column = column;
        this.booked = false;
        setPrice();
    }

    public CinemaSeat() {}

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice() {
        price = (row <= 4) ? 10 : 8;
    }

    @JsonIgnore
    public boolean isBooked() {
        return this.booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CinemaSeat that = (CinemaSeat) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}

