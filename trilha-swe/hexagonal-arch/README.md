# Padrões de Arquitetura de Software

Aqui está a revisão sugerida:

Os padrões de arquitetura de software são diretrizes usadas no processo de concepção e design de sistemas, os quais visam
centralizar e isolar as regras de negócio do domínio das camadas de aplicação e suas dependências externas,
reduzindo o acoplamento entre os componentes do sistema. 

Embora compartilhem esse objetivo comum, cada padrão pode
utilizar terminologias e apresentar detalhes de implementação ligeiramente diferentes.

## Arquitetura Hexagonal (Ports and Adapters)

A **Arquitetura Hexagonal**, também conhecida como **Ports and Adapters**, foi introduzida por Alistair Cockburn visando
criar sistemas mais flexíveis e independentes de suas interfaces externas, como bancos de dados e
frameworks. A ideia central é separar as regras de negócio do sistema das tecnologias externas, permitindo maior
facilidade de manutenção e mudanças.

## Arquitetura em Camadas (Onion Architecture)

A **Arquitetura em Camadas** foi proposta por Jeffrey Palermo em 2008, desenvolvida para projetar sistemas com altas
complexidades na camada de negócio. Bem como a arquitetura hexagonal, garante o princípio de responsabilidade única
entre a camada de aplicação e tecnologias, mas define uma "Camada de Negócio Central" (Core Business Layer)
independente, com as camadas externas em volta.

## Arquitetura Limpa (Clean Architecture)

A **Arquitetura Limpa**, proposta por Robert C. Martin (Uncle Bob) em 2012, possui conceitos centrais são semelhantes à
Arquitetura em Camadas, mas utiliza uma terminologia diferente. O modelo de domínio é chamado de “entidade”, que contém
regras e lógica específicas de negócio, enquanto a lógica específica de operações da aplicação reside
nos casos de uso. Casos de uso, ou serviços, manipulam as entidades, direcionando-as a executar suas regras de
negócio.

## Utilização no Projeto

Seguindo o exemplo da live coding da DIO sobre design arquitetural, presente no
repositório https://github.com/General-Studies/dio-avengers-api, este projeto aplica o padrão de Arquitetura Hexagonal.

## Referências

- [Demystifying software architecture patterns](https://www.thoughtworks.com/insights/blog/architecture/demystify-software-architecture-patterns)
- [Hexagonal architecture (software)](https://en.wikipedia.org/wiki/Hexagonal_architecture_(software))
