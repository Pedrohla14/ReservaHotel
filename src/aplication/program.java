package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model_etities.Reservation;
import model_exeptions.DomainExeption;

public class program{

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		
		
		try {
		
			System.out.println("room number:");
			 int number=sc.nextInt();
			 
			System.out.println("check-in date(dd/MM/yyyy) :");
			Date checkin = formato.parse(sc.next()); 
			System.out.println("check-out  date(dd/MM/yyyy) :");
			Date checkout= formato.parse(sc.next()); 
			
			//intanciando o objeto
			

			Reservation reservation= new Reservation(number, checkin, checkout);
			System.out.println("reservaton:"+ reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.println("check-in date(dd/MM/yyyy) :");
			checkin = formato.parse(sc.next()); 
			System.out.println("check-out  date(dd/MM/yyyy) :");
			 checkout= formato.parse(sc.next()); 
			
			//atualizando a reserva
			reservation.updateDates(checkin, checkout);
			
			 //imprimindo as novas datas de entrada e saida
			 System.out.println("reservation:"+ reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format ");
		}
		catch(DomainExeption e) {
			System.out.println("error in  reserservation: "+ e.getMessage());
		}
		catch (RuntimeException e) {//erros comuns, serve pra não quebrar o programa
			System.out.println("error,algo deu errado,tente novamente");
		}
		
		

		
		

	
		
		
		sc.close();
}
}