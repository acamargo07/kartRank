package br.com.kart.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author andre
 *
 */
public class Corrida {
	
	Date duracaoHoras;
	Integer qtdVoltas;
	List<Piloto> pilotos;
	/**
	 * Construtor padrao
	 */
	public Corrida() {
		setDuracaoHoras(new Date());
		setQtdVoltas(0);
		setPilotos(new ArrayList<>());
	}
	
	public Date getDuracaoHoras() {
		return duracaoHoras;
	}
	public void setDuracaoHoras(Date duracaoHoras) {
		this.duracaoHoras = duracaoHoras;
	}
	public Integer getQtdVoltas() {
		return qtdVoltas;
	}
	public void setQtdVoltas(Integer qtdVoltas) {
		this.qtdVoltas = qtdVoltas;
	}
	public List<Piloto> getPilotos() {
		return pilotos;
	}
	public void setPilotos(List<Piloto> pilotos) {
		this.pilotos = pilotos;
	}
	
} 
