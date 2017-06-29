package br.edu.unoesc.model;

import java.util.Date;

public class Operacoes {

	private Double valor;
	private Date data;
	private TipoOperacao tipoOperacao;

	public Operacoes() {
		super();
	}

	public Operacoes(Double valor, Date data, TipoOperacao tipoOperacao) {
		super();
		this.valor = valor;
		this.data = data;
		this.tipoOperacao = tipoOperacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

}
