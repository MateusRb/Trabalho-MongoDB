package br.edu.unoesc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import br.edu.unoesc.dao.ContaDAO;
import br.edu.unoesc.dao.ContaDAOMongo;
import br.edu.unoesc.model.Conta;
import br.edu.unoesc.model.Operacoes;
import br.edu.unoesc.model.TipoOperacao;

@WebServlet("/OperacaoServlet")
public class OperacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OperacaoServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String valorusuario = request.getParameter("valor");

		TipoOperacao tipoOperacao = TipoOperacao.valueOf(request.getParameter("tipoOperacao"));

		if (valorusuario != null && tipoOperacao != null) {

			MongoClient mongo = new MongoClient("localhost");

			DB db = mongo.getDB("trabalhomongo");

			ContaDAO contaDAO = new ContaDAOMongo(db);

			Double valor = Double.parseDouble(valorusuario);

			List<Operacoes> operacoes = new ArrayList<>();

			Operacoes operacao = new Operacoes();

			operacao.setTipoOperacao(tipoOperacao);

			operacao.setValor(valor);

			Date data = new Date();

			// String dataFormatada = new SimpleDateFormat("dd/MM/yyyy
			// HH:mm:ss").format(operacao.getData()); caso precise formatar a
			// data

			Jongo jongo = new Jongo(db);

			MongoCollection contas = jongo.getCollection("conta");

			Conta conta = contas.findOne("{numero: " + request.getParameter("numeroConta") + "}").as(Conta.class);

			operacoes.add(operacao);

			conta.setOperacoes(operacoes);

			conta.calculaSaldo();

			contaDAO.alterar(conta);

			response.sendRedirect("cadastro.jsp");

		} else {

			response.sendRedirect("operacao.jsp");
		}

	}

}
