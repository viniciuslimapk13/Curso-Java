package Reserva.View;

import Reserva.Model.Reserva;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate checkin,checkout;

        try {
            System.out.print("Room number: ");
            BigDecimal numero = sc.nextBigDecimal();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = LocalDate.parse(sc.next(), format);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = LocalDate.parse(sc.next(), format);
            Reserva reserva = new Reserva(numero, checkin, checkout);
            System.out.println(reserva + "\n");

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = LocalDate.parse(sc.next(), format);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = LocalDate.parse(sc.next(), format);
            reserva.updateData(checkin, checkout);
            System.out.println(reserva);
        }catch (IllegalArgumentException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }

        sc.close();
    }
}
