package br.com.controlecef.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the documento database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d") })
public class Documento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer iddocumento;

	private String tipoAcompanhamento;

	private String grauDependencia;

	private String anotacao;
	

	public Documento() {
	}


	public String getTipoAcompanhamento() {
		return tipoAcompanhamento;
	}

	public void setTipoAcompanhamento(String tipoAcompanhamento) {
		this.tipoAcompanhamento = tipoAcompanhamento;
	}

	public String getGrauDependencia() {
		return grauDependencia;
	}

	public void setGrauDependencia(String grauDependencia) {
		this.grauDependencia = grauDependencia;
	}

	public String getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}


	public Integer getIddocumento() {
		return iddocumento;
	}


	public void setIddocumento(Integer iddocumento) {
		this.iddocumento = iddocumento;
	}

}