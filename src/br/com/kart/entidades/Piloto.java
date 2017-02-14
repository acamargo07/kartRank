package br.com.kart.entidades;

import java.util.ArrayList;
import java.util.List;

public class Piloto implements Comparable<Piloto>{
	
	String nome;
	Integer codigo;
	List<Double> velocidadeMedia;
	List<Integer> numeroVoltas;
	List<TempoMedio> tempoVolta;
	
	public Piloto() {
		setCodigo(0);
		setNome("");
		setVelocidadeMedia(new ArrayList<>());
		setNumeroVoltas(new ArrayList<Integer>());
		setTempoVolta(new ArrayList<TempoMedio>());
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public List<Double> getVelocidadeMedia() {
		return velocidadeMedia;
	}
	public void setVelocidadeMedia(List<Double> velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
	public List<Integer> getNumeroVoltas() {
		return numeroVoltas;
	}
	public void setNumeroVoltas(List<Integer> numeroVoltas) {
		this.numeroVoltas = numeroVoltas;
	}
	public List<TempoMedio> getTempoVolta() {
		return tempoVolta;
	}
	public void setTempoVolta(List<TempoMedio> tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Piloto other = (Piloto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public int compareTo(Piloto o) {
		return 0;
	}
	
}
