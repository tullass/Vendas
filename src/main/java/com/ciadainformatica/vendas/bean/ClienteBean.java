package com.ciadainformatica.vendas.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.ciadainformatica.vendas.dao.ClienteDAO;
import com.ciadainformatica.vendas.dao.PessoaDAO;
import com.ciadainformatica.vendas.domain.Cliente;
import com.ciadainformatica.vendas.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {
	private Cliente cliente;
	private List<Cliente> clientes;
	private List<Pessoa> pessoas;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@PostConstruct
	public void listar() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os estados");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			cliente = new Cliente();
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao gerar nova pessoa");
			erro.printStackTrace();
		}

	}

	public void salvar() {

		try {
			for (Cliente a : clientes) {
				if (a.getCodigo() == clientes.size()) {
					Messages.addGlobalInfo(a.getPessoa().getNome() + "" + "" + "Ja existe como Cliente!");

					return;
				}
			}
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.merge(cliente);

			Messages.addGlobalInfo("salvo com sucesso!");

			novo();

			clientes = clienteDAO.listar();

		} catch (Exception erro) {
			Messages.addGlobalError("Ouve um erro na hora de salvar o cliente");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");
			Messages.addGlobalError(cliente.getPessoa().getNome() + " exlcuido com sucesso!");

			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.excluir(cliente);

			novo();
			clientes = clienteDAO.listar();
		} catch (Exception erro) {
			Messages.addGlobalError("Ouve um erro na hora de apagar o cliente");
			erro.printStackTrace();
		}

	}
}
