package decorator.impl;

import decorator.ServicoPagamento;

public class DescontoPagamentoDecorator extends ServicoPagamentoDecorator {

    private final double porcentagemDesconto;

    public DescontoPagamentoDecorator(ServicoPagamento servicoPagamento, double porcentagemDesconto) {
        super(servicoPagamento);
        this.porcentagemDesconto = porcentagemDesconto;
    }

    @Override
    public double calcularTotal(double valor) {
        double valorDeconto = (1 - porcentagemDesconto);

        return super.calcularTotal(valor) * valorDeconto;
    }
}
