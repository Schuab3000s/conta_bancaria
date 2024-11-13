package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner entrada = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = entrada.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				entrada.nextLine();
				opcao = 0;
			}

			switch (opcao) {
			case 9:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				entrada.close();
				System.exit(0);
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");

				System.out.println("Digite o Número da Agência: ");
				agencia = entrada.nextInt();
				System.out.println("Digite o Nome do Tirular: ");
				entrada.skip("\\R?");
				titular = entrada.nextLine();

				do {
					System.out.println("Digite o Tipo de Conta: ");
					System.out.println("1 - Conta Corrente \n2 - Conta Poupança");
					tipo = entrada.nextInt();
				} while (tipo != 1 && tipo != 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = entrada.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito: ");
					limite = entrada.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversário da Conta: ");
					aniversario = entrada.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
				contas.listarTodos();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");

				System.out.println("Digite o número da conta: ");
				numero = entrada.nextInt();

				contas.procurarNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = entrada.nextInt();

				var buscarConta = contas.buscarNaCollection(numero);

				if (buscarConta != null) {

					tipo = buscarConta.getTipo();

					System.out.println("Digite o Número da Agência: ");
					agencia = entrada.nextInt();
					System.out.println("Digite o Nome do Tirular: ");
					entrada.skip("\\R?");
					titular = entrada.nextLine();
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = entrada.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito: ");
						limite = entrada.nextFloat();
						contas.cadastrar(
								new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversário da Conta: ");
						aniversario = entrada.nextInt();
						contas.cadastrar(
								new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
					default -> System.out.println("Tipo de conta inválido");
					}
				} else {
					System.out.println("A conta não foi encontrada.");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = entrada.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");

				System.out.println("Digite o número da conta: ");
				numero = entrada.nextInt();

				do {
					System.out.println("Digite o valor para sacar (R$): ");
					valor = entrada.nextFloat();
				} while (valor <= 0);

				contas.sacar(numero, valor);
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");

				System.out.println("Digite o número da conta: ");
				numero = entrada.nextInt();

				do {
					System.out.println("Digite o valor para depositar (R$): ");
					valor = entrada.nextFloat();
				} while (valor <= 0);

				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");

				System.out.println("Digite o número da conta de origem: ");
				int numeroOrigem = entrada.nextInt();

				System.out.println("Digite o número da conta de destino: ");
				numeroDestino = entrada.nextInt();

				do {
					System.out.println("Digite o valor para transferir: ");
					valor = entrada.nextFloat();
				} while (valor <= 0);

				contas.transferir(numeroOrigem, numeroDestino, valor);

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Kevin Schuab - kevinschuab@gmail.com");
		System.out.println("github.com/Schuab3000s");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}