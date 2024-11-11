package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.visualizar();
		} else {
			System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
		}

	}

	@Override
	public void listarTodos() {
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA Conta número: " + conta.getNumero() + " foi criada com sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {
		var buscarConta = buscarNaCollection(conta.getNumero());

		if (buscarConta != null) {
			listaContas.set(listaContas.indexOf(buscarConta), conta);
			System.out.println("\\nA Conta número: " + conta.getNumero() + " foi atualizada com sucesso!");
		} else {
			System.out.println("\\nA Conta número: " + conta.getNumero() + " não foi encontrada!");
		}
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			if (listaContas.remove(conta) == true) {
				System.out.println("\nA Conta número: " + conta.getNumero() + " foi deletada com sucesso!");
			}
		} else {
			System.out.println("\nA Conta número: " + conta.getNumero() + " não foi encontrada!");
		}

	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {

			conta.sacar(valor);

		} else {
			System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
		}

	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {

			conta.depositar(valor);

		} else {
			System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
		}

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem == null) {
			System.out.println("\nA Conta número: " + numeroOrigem + " não foi encontrada!");
		} else if (contaDestino == null) {
			System.out.println("\nA Conta número: " + numeroDestino + " não foi encontrada!");
		} else if (valor <= contaOrigem.getSaldo()) {
			contaOrigem.sacar(valor);
			contaDestino.depositar(valor);
		}else{
			System.out.println("Saldo Insuficiente!");
		}

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
}