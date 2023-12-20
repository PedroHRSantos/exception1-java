package model.entities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
    private Integer roomNuber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

    public Reservation(Integer roomNuber, Date checkin, Date checkout) {
        if(!checkout.after(checkin)){
            throw new DomainException("error in reservation: Reservation dates fur update must be future dates.");
        }
        this.roomNuber = roomNuber;
        this.checkin = checkin;
        this.checkout = checkout;
        
    }

    public Reservation(){}

    public Integer getRoomNuber() {
        return roomNuber;
    }

    public void setRoomNuber(Integer roomNuber) {
        this.roomNuber = roomNuber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Long duration(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates (Date checkin, Date checkout){

        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)){
            throw new DomainException( "error in reservation: Reservation dates fur update must be future dates. ");
        } if(!checkout.after(checkin)){
            throw new DomainException( "error in reservation: check out dat must be after chack-in date");
        }
        this.checkin = checkin;
        this.checkout = checkout;
       
        

    } 

    @Override
    public String toString(){
        return "reservation: " +  roomNuber + ", check-in "
        + sdf.format(checkin) +
        ", check-out" + sdf.format(checkout)
        +", " + duration() + " nights";
    }
}
