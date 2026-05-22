package model;

import java.util.ArrayList;
import java.util.List;

public class Conta {

    private int numero;
    private String titular;
    private String senha;
    private double saldo;

    private List<String> extrato = new ArrayList<>();

    public Conta(int numero, String titular, String senha) {
        this.numero = numero;
        this.titular = titular;
        this.senha = senha;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getExtrato() {
        return extrato;
    }

    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            extrato.add("Depósito: +" + valor);
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            extrato.add("Saque: -" + valor);
            return true;
        }
        return false;
    }

    public void exibir() {
        System.out.println("Conta: " + numero);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$ " + saldo);
    }
}