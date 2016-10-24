package br.com.controlecef.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;



@Entity
@NamedQuery(name="Funcionalidades.findAll", query="SELECT f FROM Funcionalidades f")

public class Funcionalidades implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)

	private Integer cdFun;

	
	private String dsArqApl;

	
	private String idAgr;

	
	private String nmFun;

	
	private Integer cdMod;

	
	private Integer cdFunPai;
	 

	private Integer cdMen;

	
	private String idStat;

	
	private Integer nrOrd;

	
	private String dsUrl;
	
	
	private String nmIcone;

	

	public Funcionalidades() {
		cdFunPai = null;
	}

	public String goToUrl() {
		return dsUrl
				+ (dsUrl.contains("?") ? "&faces-redirect=true"
						: "?faces-redirect=true");
	}

	public Integer getCdFun() {
		return this.cdFun;
	}

	public void setCdFun(Integer cdFun) {
		this.cdFun = cdFun;
	}

	public String getDsArqApl() {
		return this.dsArqApl;
	}

	public void setDsArqApl(String dsArqApl) {
		this.dsArqApl = dsArqApl;
	}

	public String getIdAgr() {
		return this.idAgr;
	}

	public void setIdAgr(String idAgr) {
		this.idAgr = idAgr;
	}

	public String getNmFun() {
		return this.nmFun;
	}

	public void setNmFun(String nmFun) {
		this.nmFun = nmFun;
	}

	public Integer getCdFunPai() {
		return cdFunPai;
	}

	public void setCdFunPai(Integer cdFunPai) {
		this.cdFunPai = cdFunPai;
	}

	public Integer getCdMen() {
		return cdMen;
	}

	public void setCdMen(Integer cdMen) {
		this.cdMen = cdMen;
	}

	public String getIdStat() {
		return idStat;
	}

	public void setIdStat(String idStat) {
		this.idStat = idStat;
	}

	public Integer getNrOrd() {
		return nrOrd;
	}

	public void setNrOrd(Integer nrOrd) {
		this.nrOrd = nrOrd;
	}

	public Integer getCdMod() {
		return cdMod;
	}

	public void setCdMod(Integer cdMod) {
		this.cdMod = cdMod;
	}

	public String getDsUrl() {
		return dsUrl;
	}

	public void setDsUrl(String dsUrl) {
		this.dsUrl = dsUrl;
	}

	public String getNmIcone() {
		return nmIcone;
	}

	public void setNmIcone(String nmIcone) {
		this.nmIcone = nmIcone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdFun == null) ? 0 : cdFun.hashCode());
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
		Funcionalidades other = (Funcionalidades) obj;
		if (cdFun == null) {
			if (other.cdFun != null)
				return false;
		} else if (!cdFun.equals(other.cdFun))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionalidades [cdFun=" + cdFun + ", dsArqApl=" + dsArqApl
				+ ", nmFun=" + nmFun + ", cdMod=" + cdMod + "]";
	}

}