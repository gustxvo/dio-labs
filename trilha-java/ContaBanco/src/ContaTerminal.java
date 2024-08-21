import java.math.BigDecimal;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaPessoal conta = cadastrarConta(scanner);

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, " +
                        "conta %d e seu saldo R$%.2f já está disponível para saque.",
                conta.getNome(), conta.getAgencia(), conta.getNumConta(), conta.getSaldo());
    }

    public static ContaPessoal cadastrarConta(Scanner scanner) {
        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();

        System.out.print("Agência: ");
        String agencia = scanner.next();

        System.out.print("Número da conta: ");
        int numConta = scanner.nextInt();

        System.out.print("Saldo da conta: ");
        BigDecimal saldo = scanner.nextBigDecimal();

        return new ContaPessoal(nome, agencia, numConta, saldo);
    }

}