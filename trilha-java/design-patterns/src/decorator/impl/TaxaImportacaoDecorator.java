package decorator.impl;

import decorator.ServicoPagamento;

public class TaxaImportacaoDecorator extends ServicoPagamentoDecorator {

    private static final double TAXA = 0.15;

    public TaxaImportacaoDecorator(ServicoPagamento servicoPagamento) {
        super(servicoPagamento);
    }

    @Override
    public double calcularTotal(double valor) {
        double valorFinal = super.calcularTotal(valor) * (1 + TAXA);
        return Math.round(valorFinal);
    }
}
