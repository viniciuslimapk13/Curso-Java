package Saque.View;

import Saque.Model.Conta;

import java.math.BigDecimal;
import java.util.Scanner;

public class ContaView {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        try{
            System.out.print("Enter account data \nNumber: ");
            BigDecimal numero = sc.nextBigDecimal();
            System.out.print("Holder: ");
            String nome = sc.next();
            System.out.print("Saldo inicial: ");
            BigDecimal saldo = sc.nextBigDecimal();
            System.out.print("Limite de saque: ");
            BigDecimal limite = sc.nextBigDecimal();
            Conta conta = new Conta(numero, saldo, limite, nome);

            System.out.print("\nValor de saque: ");
            BigDecimal saque = sc.nextBigDecimal();
            conta.saque(saque);
            System.out.println(conta.toString());

        }catch(IllegalArgumentException e){
            System.out.println("Erro de saque: " + e.getMessage());
        }
        sc.close();
    }
}
