import java.math.BigDecimal;

public class ContaPessoal {

    private final String nome;
    private final String agencia;
    private final int numConta;
    private final BigDecimal saldo;

    public ContaPessoal(String nome, String agencia, int numConta, BigDecimal saldo) {
        this.nome = nome;
        this.agencia = agencia;
        this.numConta = numConta;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public String getAgencia() {
        return agencia;
    }

    public int getNumConta() {
        return numConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
