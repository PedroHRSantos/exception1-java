package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Progan {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            System.out.print("Room number: ");
            int number = scan.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkin = sdf.parse(scan.next());
            System.out.print("Chack-out date (dd/MM/yyyy): " );
            Date checkout = sdf.parse(scan.next());
        
            Date now = new Date();
            if (checkin.after(now)|| checkout.after(now)){
                Reservation reservation = new Reservation(number, checkin, checkout);
                System.out.println("Reservation: " + reservation.toString());

                System.out.println();
                System.out.println("Enter data to update the reservation: ");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkin = sdf.parse(scan.next());
                System.out.print("Chack-out date (dd/MM/yyyy): " );
                checkout = sdf.parse(scan.next());

                reservation.updateDates(checkin, checkout);
                System.out.println(reservation);
            }else {
                System.out.println("Date entered is before the current day, invalid date, restart the program and insert the date after the current date");
            }
        }catch(ParseException e){
            System.out.println("Invalid Date Format");
        }catch (DomainException e) {
            System.out.println("Error in reservation: " +  e.getMessage());
        }catch(InputMismatchException e ){
            System.out.println("Restart the program and only enter the code in numerical form.");
        }catch(RuntimeException e ){
            System.out.println("Unexpected error");
        }
        scan.close();
    }
}
