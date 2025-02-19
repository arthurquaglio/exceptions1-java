package application;

import model.entities.Reservation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.print("Room Number: ");
        int roomNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Check-in (dd/MM/yyyy): ");
        LocalDateTime checkIn = LocalDateTime.parse(sc.nextLine()+" 00:00:00", formatter);
        System.out.print("Check-out (dd/MM/yyyy): ");
        LocalDateTime checkOut = LocalDateTime.parse(sc.nextLine()+" 00:00:00", formatter);

        if (!checkOut.isAfter(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else{
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: "+reservation);

            System.out.println("\nEnter data to update the reservation");
            System.out.print("Check-in (dd/MM/yyyy): ");
            checkIn = LocalDateTime.parse(sc.nextLine()+" 00:00:00", formatter);
            System.out.print("Check-out (dd/MM/yyyy): ");
            checkOut = LocalDateTime.parse(sc.nextLine()+" 00:00:00", formatter);

            String error =  reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Error in reservation: "+error);
            }
            else {
                System.out.println("Reservation: " + reservation);
            }
        }
        sc.close();
    }
}
