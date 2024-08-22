import feature.AparelhoTelefonico;
import feature.NavegadorInternet;
import feature.ReprodutorMusical;

public class Main {

    public static void main(String[] args) {
        IPhone iPhone = new IPhone();

        usarTelefonia(iPhone);
        System.out.println();

        iniciarMusica(iPhone);
        System.out.println();

        navegar(iPhone);
        System.out.println();
    }

    private static void usarTelefonia(AparelhoTelefonico aparelho) {
        aparelho.atender();
        aparelho.ligar("4002-8922");
        aparelho.iniciarCorreioVoz();
    }

    private static void iniciarMusica(ReprodutorMusical reprodutor) {
        reprodutor.selecionarMusica("Imagine Dragons - Believer");
        reprodutor.tocar();
        reprodutor.pausar();
    }

    private static void navegar(NavegadorInternet navegador) {
        navegador.adicionarNovaAba();
        navegador.exibirPagina("https://wwww.google.com");
        navegador.atualizarPagina();
    }

}