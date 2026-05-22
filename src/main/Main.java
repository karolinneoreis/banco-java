package main;

import model.Conta;
import service.BancoService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BancoService banco = new BancoService();

        Conta logado = null;

        while (true) {

            System.out.println("\n=== BANCO JAVA ===");

            if (logado == null) {
                System.out.println("1 - Criar conta");
                System.out.println("2 - Login");
                System.out.println("0 - Sair");

                int opcao = sc.nextInt();

                switch (opcao) {

                    case 1:
                        sc.nextLine();

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Senha: ");
                        String senha = sc.nextLine();

                        Conta nova = banco.criarConta(nome, senha);
                        System.out.println("Conta criada! Número: " + nova.getNumero());
                        break;

                    case 2:
                        System.out.print("Número da conta: ");
                        int num = sc.nextInt();

                        sc.nextLine();
                        System.out.print("Senha: ");
                        String s = sc.nextLine();

                        logado = banco.login(num, s);

                        if (logado != null) {
                            System.out.println("Login realizado!");
                        } else {
                            System.out.println("Login inválido!");
                        }
                        break;

                    case 0:
                        return;
                }

            } else {

                System.out.println("Bem-vindo " + logado.getTitular());
                System.out.println("1 - Depositar");
                System.out.println("2 - Sacar");
                System.out.println("3 - Transferir");
                System.out.println("4 - Extrato");
                System.out.println("5 - Logout");

                int opcao = sc.nextInt();

                switch (opcao) {

                    case 1:
                        System.out.print("Valor: ");
                        logado.depositar(sc.nextDouble());
                        System.out.println("OK");
                        break;

                    case 2:
                        System.out.print("Valor: ");
                        double valor = sc.nextDouble();

                        if (logado.sacar(valor)) {
                            System.out.println("OK");
                        } else {
                            System.out.println("Saldo insuficiente!");
                        }
                        break;

                    case 3:
                        System.out.print("Conta destino: ");
                        int destino = sc.nextInt();

                        System.out.print("Valor: ");
                        double v = sc.nextDouble();

                        if (banco.transferir(logado.getNumero(), destino, v)) {
                            System.out.println("Transferência OK");
                        } else {
                            System.out.println("Erro");
                        }
                        break;

                    case 4:
                        for (String e : logado.getExtrato()) {
                            System.out.println(e);
                        }
                        break;

                    case 5:
                        logado = null;
                        System.out.println("Logout feito");
                        break;
                }
            }
        }
    }
}