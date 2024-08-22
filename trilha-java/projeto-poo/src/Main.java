import model.Cliente;
import model.conta.Conta;
import model.conta.ContaCorrente;
import model.conta.ContaPoupanca;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Adailton");

        Conta cc = new ContaCorrente("02133-1", cliente);
        Conta cp = new ContaPoupanca("02136-1", cliente);

        cc.depositar(BigDecimal.valueOf(1000));
        cc.transferir(BigDecimal.valueOf(900), cp);

        cc.imprimirExtrato();
        System.out.println();

        cp.imprimirExtrato();
    }
}