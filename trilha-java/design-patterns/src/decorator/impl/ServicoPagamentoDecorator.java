package decorator.impl;

import decorator.ServicoPagamento;

public class ServicoPagamentoDecorator implements ServicoPagamento {

    protected ServicoPagamento servicoPagamento;

    public ServicoPagamentoDecorator(ServicoPagamento servicoPagamento) {
        this.servicoPagamento = servicoPagamento;
    }

    @Override
    public double calcularTotal(double valor) {
        return valor;
    }
}
