package builder;

import java.time.LocalDate;

public class Cliente {

    private String nome;
    private String email;
    private LocalDate dataNascimento;

    private Cliente() {
    }

    public static class Builder {

        private final Cliente cliente = new Cliente();

        public Builder nome(String nome) {
            cliente.nome = nome;
            return this;
        }

        public Builder email(String email) {
            cliente.email = email;
            return this;
        }

        public Builder dataNascimento(LocalDate dataNascimento) {
            cliente.dataNascimento = dataNascimento;
            return this;
        }


        public Cliente build() {
            return cliente;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
