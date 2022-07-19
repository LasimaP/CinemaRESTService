package com.LP.cinema;

import com.LP.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

@RestController
public class CinemaController {

    private final Cinema cinema = new Cinema();
    private final ConcurrentHashMap<String, CinemaTicket> bookedSeats = new ConcurrentHashMap<>();
    private final CinemaManager cinemaManager = new CinemaManager();
    private final ApiRequestException cinemaException = new ApiRequestException();

    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseTicket(@RequestBody CinemaSeat requestedSeat) {
        var seat = cinema.findSeat(requestedSeat);
        if (seat != null) {
            if (!seat.isBooked()) {
                var soldTicket = new CinemaTicket(seat);
                bookedSeats.put(soldTicket.getToken(), soldTicket);
                cinemaManager.update(seat);
                return new ResponseEntity<>(soldTicket, HttpStatus.OK);
            } else {
                return cinemaException.seatAlreadySoldException();
            }
        } else {
            return cinemaException.seatOutOfBoundsException();
        }
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody CinemaToken ticketToken) {
        String requestedToken = ticketToken.getToken();

        if (!bookedSeats.containsKey(requestedToken)) {
            return cinemaException.wrongTokenException();
        }

        var ticketToReturn = new CinemaReturnTicket(bookedSeats.get(requestedToken).getTicket());
        bookedSeats.remove(requestedToken);
        cinemaManager.update(ticketToReturn.getReturnedTicket());
        return new ResponseEntity<>(ticketToReturn, HttpStatus.OK);
    }

    @PostMapping("/stats")
    public ResponseEntity<?> checkStats(@RequestParam(defaultValue = "password", required = false) String password) {
        if (password.equals("super_secret")) {
            return new ResponseEntity<>(cinemaManager, HttpStatus.OK);
        }
        return cinemaException.wrongPasswordException();
    }

}
