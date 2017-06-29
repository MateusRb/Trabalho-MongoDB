package br.edu.unoesc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import br.edu.unoesc.dao.ContaDAO;
import br.edu.unoesc.dao.ContaDAOMongo;
import br.edu.unoesc.model.Cliente;
import br.edu.unoesc.model.Conta;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CadastroServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cliente cliente = new Cliente();

		Conta conta = new Conta();

		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setRenda(Double.valueOf(request.getParameter("renda")));
		conta.setNumero(Integer.valueOf(request.getParameter("numeroConta")));
		conta.setCliente(cliente);

		MongoClient mongo = new MongoClient("localhost");
		DB db = mongo.getDB("trabalhomongo");

		ContaDAO contaDAO = new ContaDAOMongo(db);

		contaDAO.inserir(conta);

		mongo.close();

		response.sendRedirect("operacao.jsp");

	}

}
