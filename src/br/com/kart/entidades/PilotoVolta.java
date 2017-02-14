package br.com.kart.entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PilotoVolta implements Comparable<PilotoVolta> {
	
	Integer codigoPiloto;
	Integer numeroVolta;
	TempoMedio tempoVolta;
	String nome;
	Double velocidadeMedia;
	Date tempoTotal;
	Integer qtdVoltas;

	public Integer getCodigoPiloto() {
		return codigoPiloto;
	}

	public void setCodigoPiloto(Integer codigoPiloto) {
		this.codigoPiloto = codigoPiloto;
	}

	public Integer getNumeroVolta() {
		return numeroVolta;
	}

	public void setNumeroVolta(Integer numeroVolta) {
		this.numeroVolta = numeroVolta;
	}

	public TempoMedio getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(TempoMedio tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getVelocidadeMedia() {
		return velocidadeMedia;
	}

	public void setVelocidadeMedia(Double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}

	public Date getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(Date tempoTotal) {
		this.tempoTotal = tempoTotal;
	}

	public Integer getQtdVoltas() {
		return qtdVoltas;
	}

	public void setQtdVoltas(Integer qtdVoltas) {
		this.qtdVoltas = qtdVoltas;
	}

	/**
	 * Faz a ordenacao de pilotos por tempo
	 * @param lista com valores a serem ordenados
	 * @return lista populda e ordenada
	 */
	public List<PilotoVolta> sort(List<PilotoVolta> lista) {
		
		Map<Integer, PilotoVolta> retorno = new HashMap<>();
		
		List<PilotoVolta> listaRetorno = manipulaDadosDePilotoVolta(lista, retorno);
		// lista com os tempos somadoas das quatro voltas
		Collections.sort(listaRetorno);
		return listaRetorno;
	}
	/**
	 * Efetua a soma dos tempos dos pilotos por volta e guarda quantidade de voltas
	 * @param lista
	 * @param retorno
	 */
	private List<PilotoVolta> manipulaDadosDePilotoVolta(List<PilotoVolta> lista, Map<Integer, PilotoVolta> retorno) {
		for (PilotoVolta pv : lista) {
			if (null != pv.getNumeroVolta()) {

				if (retorno.containsKey(pv.getCodigoPiloto())) {
					br.com.kart.util.Utils utils = new br.com.kart.util.Utils();
					PilotoVolta p = retorno.get(pv.getCodigoPiloto());
					p.setTempoTotal(utils.somar(p.getTempoVolta().getTempo(), pv.getTempoVolta().getTempo()));
					p.setQtdVoltas(p.getQtdVoltas() + 1);
				} else {
					pv.setQtdVoltas(1);
					retorno.put(pv.getCodigoPiloto(), pv);
				}
			}
		}
		return  new ArrayList<PilotoVolta>(retorno.values());
	}

	@Override
	public int compareTo(PilotoVolta o) {
		return this.getTempoVolta().compareTo(o.getTempoVolta());
	}

}
