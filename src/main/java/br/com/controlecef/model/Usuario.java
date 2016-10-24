package br.com.controlecef.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Transient;


@Entity
@NamedNativeQueries({ 
@NamedNativeQuery(name="Usuario.findAll", query="SELECT * FROM Usuario ",resultClass = Usuario.class)})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigoUsuario;										

	
	private String codigoCategoria;

	
	private String codigoUsuarioAtualizador;

	
	private Date dataAtualizacao;
	
	
	private String cpf;

	
	private String descricaoEnderecoEmail;

	
	private String descricaoLembrancaSenha;

	
	private String descricaoLogin;

	
	private Date dataExpiracaoSenha;

	
	private Date datanascimento;

	
	private Date dataUltimaVisita;

	
	private String identificadorAcessoSimultaneo;

	
	private String identificadorGerente;

	
	private String identificadorPrimeiroAcesso;

	
	private String identificadorStatus;

	
	private String nomeUsuario;

	
	private String numeroCelular;

	
	@Transient
	private String cpfCnpjFormatado;


	private Integer numeroMatricula;


	private String numeroTelefone;

	
	private String senha;
	

	private String identificadorExpiracaoSenha;
	
	
	private Integer cdAgn;
	
	
	private String dsFuncao;
	
	
	private Integer qtTentAcesso = 0;

	public Usuario() {
	}

	public boolean isAdmin(){
		return "S".equals(identificadorGerente);
	}

	public String getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(String codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getCodigoUsuarioAtualizador() {
		return codigoUsuarioAtualizador;
	}

	public void setCodigoUsuarioAtualizador(String codigoUsuarioAtualizador) {
		this.codigoUsuarioAtualizador = codigoUsuarioAtualizador;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getDescricaoEnderecoEmail() {
		return descricaoEnderecoEmail;
	}

	public void setDescricaoEnderecoEmail(String descricaoEnderecoEmail) {
		this.descricaoEnderecoEmail = descricaoEnderecoEmail;
	}

	public String getDescricaoLembrancaSenha() {
		return descricaoLembrancaSenha;
	}

	public void setDescricaoLembrancaSenha(String descricaoLembrancaSenha) {
		this.descricaoLembrancaSenha = descricaoLembrancaSenha;
	}

	public String getDescricaoLogin() {
		return descricaoLogin;
	}

	public void setDescricaoLogin(String descricaoLogin) {
		this.descricaoLogin = descricaoLogin;
	}

	public Date getDataExpiracaoSenha() {
		return dataExpiracaoSenha;
	}

	public void setDataExpiracaoSenha(Date dataExpiracaoSenha) {
		this.dataExpiracaoSenha = dataExpiracaoSenha;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public Date getDataUltimaVisita() {
		return dataUltimaVisita;
	}

	public void setDataUltimaVisita(Date dataUltimaVisita) {
		this.dataUltimaVisita = dataUltimaVisita;
	}

	public String getIdentificadorAcessoSimultaneo() {
		return identificadorAcessoSimultaneo;
	}

	public void setIdentificadorAcessoSimultaneo(
			String identificadorAcessoSimultaneo) {
		this.identificadorAcessoSimultaneo = identificadorAcessoSimultaneo;
	}

	public String getIdentificadorGerente() {
		return identificadorGerente;
	}

	public void setIdentificadorGerente(String identificadorGerente) {
		this.identificadorGerente = identificadorGerente;
	}

	public String getIdentificadorPrimeiroAcesso() {
		return identificadorPrimeiroAcesso;
	}

	public void setIdentificadorPrimeiroAcesso(
			String identificadorPrimeiroAcesso) {
		this.identificadorPrimeiroAcesso = identificadorPrimeiroAcesso;
	}

	public String getIdentificadorStatus() {
		return identificadorStatus;
	}

	public void setIdentificadorStatus(String identificadorStatus) {
		this.identificadorStatus = identificadorStatus;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	
	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	

	public String getIdentificadorExpiracaoSenha() {
		return identificadorExpiracaoSenha;
	}

	public void setIdentificadorExpiracaoSenha(
			String identificadorExpiracaoSenha) {
		this.identificadorExpiracaoSenha = identificadorExpiracaoSenha;
	}

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	

	public Integer getCdAgn() {
		return cdAgn;
	}

	public void setCdAgn(Integer cdAgn) {
		this.cdAgn = cdAgn;
	}

	public String getDsFuncao() {
		return dsFuncao;
	}

	public void setDsFuncao(String dsFuncao) {
		this.dsFuncao = dsFuncao;
	}

	public Integer getQtTentAcesso() {
		return qtTentAcesso;
	}

	public void setQtTentAcesso(Integer qtTentAcesso) {
		this.qtTentAcesso = qtTentAcesso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoUsuario == null) ? 0 : codigoUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigoUsuario == null) {
			if (other.codigoUsuario != null)
				return false;
		} else if (!codigoUsuario.equals(other.codigoUsuario))
			return false;
		return true;
	}

	public String getCpfCnpjFormatado() {
		return cpfCnpjFormatado;
	}

	public void setCpfCnpjFormatado(String cpfCnpjFormatado) {
		this.cpfCnpjFormatado = cpfCnpjFormatado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(Integer numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}
}