package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Progan {
    public static void main(String[] args) throws ParseException{
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Room number: ");
        int number = scan.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(scan.next());
        System.out.print("Chack-out date (dd/MM/yyyy): " );
        Date checkout = sdf.parse(scan.next());
        Date now = new Date();
        if(checkin.before(now) || checkout.before(now)){
            System.out.println("error in reservation: Reservation dates fur update must be future dates. ");
        }
        else if (!checkout.after(checkin)){
            System.out.print("error in reservation: check out dat must be after chack-in date");
        }else{
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation.toString());

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(scan.next());
            System.out.print("Chack-out date (dd/MM/yyyy): " );
            checkout = sdf.parse(scan.next());

            now = new Date();
            if (checkin.before(now) || checkout.before(now)){
                System.out.println("error in reservation: Reservation dates fur update must be future dates. ");
            }else if(!checkout.after(checkin)){
                 System.out.print("error in reservation: check out dat must be after chack-in date");
            }else{
                reservation.updateDates(checkin, checkout);
                System.out.println("Reservation: " + reservation.toString());
            }
        }
        scan.close();
    }
}

// aula 175 
// verificar como foi criado a class Reservation