package br.edu.unoesc.dao;

import java.util.List;

import br.edu.unoesc.model.Conta;

public interface ContaDAO {

	void inserir(Conta conta);

	void alterar(Conta conta);

	void deletar(Conta conta);

	List<Conta> todos();

	Conta porNumero(Integer numero);
}
