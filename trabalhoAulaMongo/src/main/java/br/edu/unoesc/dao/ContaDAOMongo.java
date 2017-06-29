package br.edu.unoesc.dao;

import java.util.ArrayList;
import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.DB;

import br.edu.unoesc.model.Conta;

public class ContaDAOMongo implements ContaDAO {

	private final DB db;

	public ContaDAOMongo(DB db) {
		this.db = db;
	}

	public MongoCollection conta() {

		Jongo jongo = new Jongo(db);
		return jongo.getCollection("conta");
	}

	@Override
	public List<Conta> todos() {

		MongoCursor<Conta> cursorConta = conta().find().as(Conta.class);

		List<Conta> contasList = new ArrayList<>();
		cursorConta.forEach(conta -> contasList.add(conta));

		return contasList;
	}

	@Override
	public void inserir(Conta conta) {

		conta().save(conta);
	}

	@Override
	public void alterar(Conta conta) {

		conta().update("{numero: #}", conta.getNumero()).with(conta);

	}

	@Override
	public void deletar(Conta conta) {

		conta().remove("{numero: #}", conta.getNumero());
	}

	@Override
	public Conta porNumero(Integer numero) {

		return conta().findOne("{numero: #}", numero).as(Conta.class);
	}

}
