package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model_entities.Reservation;

public class Main {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();

		System.out.println("Enter the reservation date:");
		System.out.println("Room Number");
		int roomNumber = sc.nextInt();
		System.out.println("Check-in: (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-Out: (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next());

		if (checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Error in reservation: Reservation dates for update must be future dates");

		} else if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out Date must be after check-in Date ");

		} else {

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println("");
			System.out.println("Enter the reservation update date:");
			System.out.println("Check-in: (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out: (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: ");
			} else {
				System.out.println("Reservation: " + reservation);
			}
		}
		sc.close();
	}

}
