package br.com.kart.entidades;

import java.util.Date;

/**
 * @author andre
 *
 */
public class TempoMedio  implements Comparable<TempoMedio>{
	private Date tempo;

	public Date getTempo() {
		return tempo;
	}

	public void setTempo(Date tempo) {
		this.tempo = tempo;
	}

	
	
	@Override
	public int compareTo(TempoMedio param) {
		
		
		return this.tempo.compareTo(param.getTempo());
	}
	
}
