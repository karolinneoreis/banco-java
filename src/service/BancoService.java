package service;

import model.Conta;
import java.util.ArrayList;
import java.util.List;

public class BancoService {

    private List<Conta> contas = new ArrayList<>();

    public Conta criarConta(String titular, String senha) {
        int numero = contas.size() + 1;
        Conta conta = new Conta(numero, titular, senha);
        contas.add(conta);
        return conta;
    }

    public Conta buscarConta(int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    public Conta login(int numero, String senha) {
        Conta conta = buscarConta(numero);
        if (conta != null && conta.validarSenha(senha)) {
            return conta;
        }
        return null;
    }

    public void listarContas() {
        for (Conta c : contas) {
            c.exibir();
            System.out.println("----------------");
        }
    }

    public boolean transferir(int origemNum, int destinoNum, double valor) {

        Conta origem = buscarConta(origemNum);
        Conta destino = buscarConta(destinoNum);

        if (origem == null || destino == null) {
            return false;
        }

        if (origem.sacar(valor)) {
            destino.depositar(valor);

            origem.getExtrato().add("Transferência enviada: -" + valor);
            destino.getExtrato().add("Transferência recebida: +" + valor);

            return true;
        }

        return false;
    }
}