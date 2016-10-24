package br.com.controlecef.dao.util;

public class Parametros<V> {

	private String nome;
	private V valor;

	public Parametros() {

	}

	public Parametros(String nome, V valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public V getValor() {
		return valor;
	}

	public void setValor(V valor) {
		this.valor = valor;
	}

}
