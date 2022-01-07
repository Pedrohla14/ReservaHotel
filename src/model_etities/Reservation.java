package model_etities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model_exeptions.DomainExeption;

public class Reservation {
	private Integer roomNumber;
	private Date  checkin;
	private Date  checkout;
	
	
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
	
	

	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainExeption {
		tratamentoDeErro(checkin,checkout);
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
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

	public long duration() {
		

        long diff = checkout.getTime() - checkin.getTime();

        TimeUnit time = TimeUnit.DAYS; 
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        return diffrence;
	}
	
	public void updateDates(Date checkin, Date checkout) throws DomainExeption {
		tratamentoDeErro(checkin,checkout);
		
		this.checkin=checkin;
		this.checkout=checkout;
		
	}
	
	public void tratamentoDeErro(Date checkin, Date checkout) throws DomainExeption {
		 Date date = new Date();
		 if(checkin.before(date)|| checkout.before(date)) {//uso esse trtamento IllegalArgumentException() quando os argumentos são ínvalidos 
			throw new DomainExeption("Error in reservation: Reservation dates for update must be future ") ;
		 }
		if  (!checkout.after(checkin)) {
			throw new DomainExeption( "Error in reservation: Check-out date must be after check-in date");
			 
		 }
	}

	@Override
	public String toString() {
		return "roomNumber=" + 
	roomNumber 
	+ ", checkin="
	+ formato.format(checkin)
	+ ", checkout="
	+ formato.format(checkout)
	+" ,"
	+ duration()
	+" nights";
	}
	
	
}
