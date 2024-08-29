package decorator;

public class ServicoPagamentoBase implements ServicoPagamento {

    @Override
    public double calcularTotal(double valor) {
        return valor;
    }
}
