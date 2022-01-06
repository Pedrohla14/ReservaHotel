package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import etities.Reservation;

public class aplication {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		System.out.println("room number:");
		 int number=sc.nextInt();
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		System.out.println("check-in date(dd/MM/yyyy) :");
		Date checkin = formato.parse(sc.next()); 
		System.out.println("check-out  date(dd/MM/yyyy) :");
		Date checkout= formato.parse(sc.next()); 
		
		//verificando se a data de saída é maior que a de entrada 
		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			
			Reservation reservation= new Reservation(number, checkin, checkout);
		System.out.println("reservaton:"+ reservation);
		
		System.out.println();
		System.out.println("Enter data to update the reservation: ");
		
		System.out.println("check-in date(dd/MM/yyyy) :");
		checkin = formato.parse(sc.next()); 
		System.out.println("check-out  date(dd/MM/yyyy) :");
		 checkout= formato.parse(sc.next()); 
		 
		 
		 /*se as dataas atualizadas forem anteriores a data de agora o programa  deve avisar 
		  * ao usuario, umas das maneiras de fazer isso é da forma a seguir, porém não é uma boa prática*/
		 
		 Date date = new Date();
		 if(checkin.before(date)|| checkout.before(date)) {
			 System.out.println("Error in reservation: Reservation dates for update must be future ");
		 }
		 else if (!checkout.after(checkin)) {
			 System.out.println("Error in reservation: Check-out date must be after check-in date");
			 
		 }
		 else {//se nenhum dos erros anteriores surgirem a data vai ser atualizada 
			 //atualizando as datas de entrada e saida 
			 reservation.updateDates(checkin, checkout);
			 //imprimindo as novas datas de entrada e saida
			 System.out.println("reservation:"+ reservation);
			
		 }

		
		
		}
		
		

	
		
		
		sc.close();
}
}