package mediator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SalaDePoker implements Mediator {

    private final Set<Jogador> jogadores = new HashSet<>();

    @Override
    public void enviarMensagem(String mensagem, Jogador remetente) {
        for (Jogador jogador : jogadores) {
            if (!jogador.equals(remetente)) {
                jogador.receberMensagem(mensagem, remetente);
            }
        }
    }

    public void registrarJogadores(List<Jogador> jogadores) {
        this.jogadores.addAll(jogadores);
    }
}
