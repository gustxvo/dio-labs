package model.conta;

import model.Cliente;

import java.math.BigDecimal;
import java.util.Locale;

public abstract class Conta implements IConta {

    private static int SEQUENCIA = 1;

    protected final String agencia;
    protected final int numConta;
    protected final Cliente cliente;
    protected BigDecimal saldo;

    public Conta(String agencia, Cliente cliente) {
        this.agencia = agencia;
        this.numConta = SEQUENCIA++;
        this.cliente = cliente;
        this.saldo = BigDecimal.ZERO;
    }

    @Override
    public void sacar(BigDecimal valor) {
        if (saldoInsuficiente(valor)) {
            throw new RuntimeException("Saldo insuficiente");
        }
        saldo = saldo.subtract(valor);
    }

    @Override
    public void depositar(BigDecimal valor) {
        saldo = saldo.add(valor);
    }

    @Override
    public void transferir(BigDecimal valor, Conta conta) {
        this.sacar(valor);
        conta.depositar(valor);
    }

    private boolean saldoInsuficiente(BigDecimal valor) {
        return saldo.compareTo(valor) < 0;
    }

    protected void imprimirInfosConta() {
        System.out.println("Titular: " + cliente.nome());
        System.out.println("Agência: " + agencia);
        System.out.println("Número da Conta: " + numConta);
        System.out.printf(Locale.of("pt", "BR"), "Saldo: R$%.2f\n", saldo);
    }

}
