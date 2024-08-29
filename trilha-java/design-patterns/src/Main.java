import builder.Cliente;
import decorator.ServicoPagamento;
import decorator.ServicoPagamentoBase;
import decorator.impl.DescontoPagamentoDecorator;
import decorator.impl.TaxaImportacaoDecorator;
import mediator.Jogador;
import mediator.SalaDePoker;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        useBuilder();
        useDecorator();
        useMediator();
    }

    public static void useBuilder() {
        Cliente cliente = new Cliente.Builder()
                .nome("Frederic")
                .email("frederic@gmail.com")
                .dataNascimento(LocalDate.of(2000, 1, 1))
                .build();
        System.out.println(cliente);
        System.out.println();
    }

    public static void useDecorator() {
        // Serviço de pagamento base
        ServicoPagamento pagamento = new ServicoPagamentoBase();
        double valorCompra = 100.0;
        System.out.printf("Valor base: R$%.2f\n", valorCompra);

        // Caso 1: Pagamento com desconto
        ServicoPagamento pagamentoDesconto = new DescontoPagamentoDecorator(pagamento, 0.1);
        System.out.printf("Valor com desconto: R$%.2f\n", pagamentoDesconto.calcularTotal(valorCompra));

        // Caso 2: Pagamento com taxa de importação
        ServicoPagamento pagamentoTaxa = new TaxaImportacaoDecorator(pagamento);
        System.out.printf("Valor com taxa: R$%.2f\n", pagamentoTaxa.calcularTotal(valorCompra));

        // Caso 3: Pagamento com desconto e taxa de importação
        // Primeiro é calculado o pagamento com desconto
        ServicoPagamento taxaPagamento = new DescontoPagamentoDecorator(pagamento, 0.1);

        // Depois é calculado o pagamento final, calculando a taxa de importação após o desconto
        ServicoPagamento servicoPagamento = new TaxaImportacaoDecorator(taxaPagamento);
        double valorFinal = taxaPagamento.calcularTotal(valorCompra);

        System.out.printf("Valor com desconto e taxa: R$%.2f\n", servicoPagamento.calcularTotal(valorFinal));
        System.out.println();
    }

    public static void useMediator() {
        SalaDePoker salaDePoker = new SalaDePoker();

        Jogador fred = new Jogador("Fred", salaDePoker);
        Jogador samara = new Jogador("Samara", salaDePoker);
        Jogador bartolomeu = new Jogador("Bartolomeu", salaDePoker);

        salaDePoker.registrarJogadores(List.of(fred, samara, bartolomeu));

        fred.enviarMensagem("Vão apostar?");
        System.out.println();

        samara.enviarMensagem("Fui de all-in");
        System.out.println();
    }

}
