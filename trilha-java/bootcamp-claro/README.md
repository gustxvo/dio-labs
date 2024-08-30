# Desafio Bootcamp Claro - Java API

API RESTful do Bootcamp da Claro em Java com Spring Boot.

Essa é uma API simplificada de um processo de contratação de dados móveis.

## Principais Tecnologias

- Java 21: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
- Spring Boot 3.3.3: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
- Spring Data JPA: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
- OpenAPI (Swagger): Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
- Railway: facilita o deploy e monitoramento de nossas soluções na nuvem, além de oferecer diversos bancos de dados como serviço e pipelines de CI/CD.

```mermaid
classDiagram
    class Client {
        -UUID id
        -String name
        -Address address
        -String cpf
    }

    class Address {
        -String street
        -String number
        -String complement
    }

    class Account {
        -String number
        -Client client
        -AccountPlan accountPlan
        -Number availableDataInMb
        -Number price
        -Date renewalDate
    }

    class AccountPlan {
        <<Enumeration>>
        PRE_PAID
        POST_PAID
        CONTROL
        FLEX
    }

    Client "1" *-- "1" Address
    Client "1" -- "N" Account
    Account "1" *-- "1" AccountPlan

```