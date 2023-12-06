package model.entities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNuber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

    public Reservation(Integer roomNuber, Date checkin, Date checkout) {
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
