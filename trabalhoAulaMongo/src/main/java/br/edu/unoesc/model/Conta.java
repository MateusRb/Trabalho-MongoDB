package br.edu.unoesc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conta {

	private Integer numero;
	private Cliente cliente;
	List<Operacoes> operacoes;
	private Double saldo = 0.0;

	public Conta() {
		super();
	}

	public Conta(Integer numero, Cliente cliente, List<Operacoes> operacoes, Double saldo) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.operacoes = operacoes;
		this.saldo = saldo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Operacoes> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<Operacoes> operacoes) {
		this.operacoes = operacoes;
	}

	public Double calculaSaldo() {
		for (Operacoes op : operacoes) {
			if (TipoOperacao.CREDITO.equals(op.getTipoOperacao())) {
				saldo += op.getValor();
			} else {
				saldo -= op.getValor();
			}
		}
		return saldo;
	}

	public void depositar(Double valor) {
		addOperacao(new Operacoes(valor, new Date(), TipoOperacao.CREDITO));
	}

	public void sacar(Double valor) {
		addOperacao(new Operacoes(valor, new Date(), TipoOperacao.DEBITO));
	}

	public void addOperacao(Operacoes operacao) {
		if (operacoes == null) {
			operacoes = new ArrayList<>();
		}
		operacoes.add(operacao);
	}
}
