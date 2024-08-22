package model.conta;

import model.Cliente;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String agencia, Cliente cliente) {
        super(agencia, cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato da Conta Poupança");
        super.imprimirInfosConta();
    }
}
