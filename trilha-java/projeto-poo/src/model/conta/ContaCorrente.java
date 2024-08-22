package model.conta;

import model.Cliente;

public class ContaCorrente extends Conta {

    public ContaCorrente(String agencia, Cliente cliente) {
        super(agencia, cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato da Conta Corrente");
        super.imprimirInfosConta();
    }
}
