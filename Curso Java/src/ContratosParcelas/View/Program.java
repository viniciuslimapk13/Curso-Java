package ContratosParcelas.View;

import ContratosParcelas.Controller.ContractService;
import ContratosParcelas.Model.Contract;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato:");

        System.out.print("Numero: ");
        BigDecimal number = sc.nextBigDecimal();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), dtf);

        System.out.print("Valor do contrato: ");
        BigDecimal totalValue = sc.nextBigDecimal();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Entre com o numero de parcelas: ");
        Integer months = sc.nextInt();
        ContractService service = new ContractService();
        service.processContract(contract, months);

        System.out.println("Parcelas:");
        System.out.println(contract);


    }
}
