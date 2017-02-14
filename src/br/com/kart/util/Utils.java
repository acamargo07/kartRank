package br.com.kart.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.TimeZone;

import br.com.kart.entidades.Corrida;
import br.com.kart.entidades.Piloto;

public class Utils {
	
	
	public Date tratarTempoVolta(String tempo) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("m:ss.SSS");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.parse(tempo);
	}

	public String tratarTempoVolta(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("m:ss.SSS");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.format(date);
	}

	public Double parseVelocidadeMedia(String valor) {
		return Double.parseDouble(valor.replace(",", "."));
	}

	public Corrida ordearListas(Corrida corrida) throws ParseException {
		// organiza os pilotos por melhor tempo
		for (Piloto p : corrida.getPilotos()) {
			Collections.sort(p.getTempoVolta());
		}
		return corrida;
	}
	
	public Date somar(Date date, Date date2) {
		return new Date(date.getTime() + date2.getTime());		
	}
	
	
}
