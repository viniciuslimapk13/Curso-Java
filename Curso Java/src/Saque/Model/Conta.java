package Saque.Model;

import java.math.BigDecimal;

public class Conta {
    private BigDecimal numero,saldo,limite;
    private String nome;

    public Conta(BigDecimal numero, BigDecimal saldo, BigDecimal limite, String nome) {
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
        this.nome = nome;
    }

    public BigDecimal getNumero() {
        return numero;
    }

    public void setNumero(BigDecimal numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void deposito(BigDecimal valor){
        this.saldo = this.saldo.add(valor);
    }

    public void saque(BigDecimal valor){
        if(valor.compareTo(this.limite)==1){
            throw new IllegalArgumentException("Limite de saque excedido");
        }
        if (valor.compareTo(this.saldo)==1){
            throw new IllegalArgumentException("Saldo insuficiente!");
        }
        this.saldo = this.saldo.subtract(valor);
    }

    @Override
    public String toString(){
        return "Novo saldo: "+saldo;
    }
}
