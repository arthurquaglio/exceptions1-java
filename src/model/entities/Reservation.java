package model.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Reservation {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Integer roomNumber;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Reservation(Integer roomNumber, LocalDateTime checkin, LocalDateTime checkout) {
        this.roomNumber = roomNumber;
        this.checkIn = checkin;
        this.checkOut = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public long duration(){
        Duration duration = Duration.between(checkIn, checkOut);
        return duration.toDays();
    }

    public String updateDates(LocalDateTime checkIn, LocalDateTime checkOut){
        LocalDateTime now = LocalDateTime.now();
        if (checkIn.isBefore(now) || checkOut.isBefore(now) ) {
            return "Reservation dates for updates must be future dates";
        }
        if (!checkOut.isAfter(checkIn)) {
            return "Check-out date must be after check-in date";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + checkIn.format(formatter)
                + ", check-out: "
                + checkOut.format(formatter)
                + ", "
                + duration()
                + " nights";
    }
}
