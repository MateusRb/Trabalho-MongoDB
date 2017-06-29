package br.edu.unoesc.model;

public enum TipoOperacao {

	CREDITO(true, false), DEBITO(false, true);

	private TipoOperacao(boolean credito, boolean debito) {
		this.credito = credito;
		this.debito = debito;
	}

	private boolean credito;
	private boolean debito;

	public boolean isCredito() {
		return credito;
	}

	public void setCredito(boolean credito) {
		this.credito = credito;
	}

	public boolean isDebito() {
		return debito;
	}

	public void setDebito(boolean debito) {
		this.debito = debito;
	}

}