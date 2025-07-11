package Contratos.View;

import Contratos.Model.Contract;
import Contratos.Model.Departament;
import Contratos.Model.Worker;
import Contratos.Model.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WorkerView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter department's name: " );
        String departament = sc.next();

        System.out.println("\u001B[1mEnter worker data:\u001B[0m");

        System.out.print("Name: ");
        String name = sc.next();

        System.out.print("Level: ");
        String level = sc.next();

        System.out.print("Base Salary: ");
        Worker worker = new Worker(new Departament(departament), name, WorkerLevel.valueOf(level), sc.nextDouble());

        System.out.print("How many contracts to this worker? ");
        Integer qtd = sc.nextInt();

        for (int i = 0; i < qtd; i++){
            System.out.printf("\u001B[1mEnter contract #%d data:\u001B[0m\n", i+1);

            System.out.print("Date (DD/MM/YYYY): ");
            LocalDate date = LocalDate.parse(sc.next(), format);

            System.out.print("Value per hour: ");
            Double value = sc.nextDouble();

            System.out.print("Duration (hours): ");
            Contract contract = new Contract(date, value, sc.nextInt());
            worker.addContract(contract);

        }

        System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
        String periodo = sc.next();
        String[] parts = periodo.split("/");
        Integer year = Integer.parseInt(parts[1]);
        Integer month = Integer.parseInt(parts[0]);
        Double income = worker.income(year, month);

        System.out.println("Name: "+worker.getName());
        System.out.println("Departament: "+worker.getDepartament().getName());
        System.out.printf("Income for %d/%d: %.2f%n", month, year, income);








    }
}
