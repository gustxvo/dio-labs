package mediator;

public class Jogador {

    private final String nome;
    private final Mediator mediator;

    public Jogador(String nome, Mediator mediator) {
        this.nome = nome;
        this.mediator = mediator;
    }

    public void enviarMensagem(String mensagem) {
        mediator.enviarMensagem(mensagem, this);
    }

    public void receberMensagem(String mensagem, Jogador remetente) {
        System.out.printf("%s recebeu a mensagem de %s: %s\n", this.nome, remetente.nome, mensagem);
    }

}
