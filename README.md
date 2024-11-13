# Projeto: Sistema de Conta Bancária

Este projeto implementa um sistema básico de contas bancárias, permitindo a criação, manipulação e consulta de diferentes tipos de contas (como conta corrente e conta poupança). O sistema também oferece um menu interativo para que os usuários possam realizar operações bancárias como depósitos, saques, transferências e consultas de saldo.

## Estrutura do Projeto

O projeto é estruturado em várias classes principais, cada uma responsável por uma parte fundamental do sistema bancário:

### Classes e Arquivos

1. **Conta.java**
   --> Classe base que representa uma conta bancária. Ela possui atributos comuns a todas as contas, como o número da conta, nome do titular, saldo, etc. Essa classe define métodos gerais que serão herdados e especificados nas subclasses de diferentes tipos de contas.
   
2. **ContaCorrente.java**
   --> Subclasse de `Conta` que representa uma conta corrente. Pode conter métodos e atributos específicos para operações e funcionalidades próprias da conta corrente.

3. **ContaPoupanca.java**
   --> Subclasse de `Conta` que representa uma conta poupança. Possui características e métodos próprios para operações relacionadas à conta poupança.

4. **ContaController.java**
   --> Esta classe atua como o controlador principal do sistema. Ela orquestra as operações principais, como criação de contas, consultas e movimentações. O `ContaController` é responsável por aplicar as regras de negócio e gerenciar as transações entre contas.

5. **ContaRepository.java**
   --> Repositório que gerencia o armazenamento das contas criadas. Pode utilizar uma lista ou outra estrutura de dados para armazenar instâncias de `Conta`, permitindo a recuperação e manipulação desses dados.
   
6. **Menu.java**
   --> Classe que implementa o menu interativo do sistema. Esse menu permite ao usuário interagir com o sistema, selecionando opções como criar uma nova conta, realizar saques, depósitos, transferências e consultar saldo.

7. **Cores.java**
   --> Classe utilitária para definir cores que podem ser usadas para formatar a saída no console, melhorando a legibilidade e a experiência do usuário ao utilizar o menu.

## Funcionalidades do Sistema

O sistema de conta bancária implementa as seguintes funcionalidades:

--> **Criação de Conta**: Possibilidade de criar contas correntes e contas poupança com informações do titular.
--> **Depósito**: Permite ao usuário depositar um valor em uma conta específica.
--> **Saque**: Permite ao usuário realizar saques de uma conta, com validação de saldo.
--> **Transferência**: Possibilidade de transferir valores entre contas.
--> **Consulta de Saldo**: Exibe o saldo atual da conta.
--> **Menu Interativo**: Interface em linha de comando que guia o usuário através das opções disponíveis.

## Pré-requisitos

--> **Java**: Certifique-se de que o Java está instalado no sistema (Java 8 ou superior).
--> **Compilador Java**: Um ambiente de desenvolvimento ou compilador que permita compilar e executar programas em Java (por exemplo, o terminal com o comando `javac`).

## Exemplo de Uso

### Criar Conta
O menu solicitará que o usuário insira o tipo de conta (corrente ou poupança) e os dados do titular.

### Realizar Depósito
Escolha a opção de depósito, insira o número da conta e o valor a ser depositado.

### Realizar Saque
Escolha a opção de saque, insira o número da conta e o valor do saque. O sistema verificará o saldo disponível antes de efetuar a transação.

### Transferência entre Contas
Escolha a opção de transferência, insira o número da conta de origem, o número da conta de destino e o valor a ser transferido.

