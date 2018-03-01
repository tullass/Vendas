package com.ciadainformatica.vendas.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import com.ciadainformatica.vendas.dao.CrediarioDAO;
import com.ciadainformatica.vendas.domain.Crediario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RelatorioCrediarioBean implements Serializable {

	private List<Crediario> crediarios;
	private Date dataInicio = new Date(System.currentTimeMillis());
	private Date dataFim = new Date(System.currentTimeMillis());

	public List<Crediario> getCrediarios() {
		return crediarios;
	}

	public void setCrediarios(List<Crediario> crediarios) {
		this.crediarios = crediarios;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@PostConstruct
	public void listar() {
		// crediarios = null ;
		try {
			CrediarioDAO crediarioDAO = new CrediarioDAO();
			crediarios = crediarioDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar");
			erro.printStackTrace();
		}

	}

}