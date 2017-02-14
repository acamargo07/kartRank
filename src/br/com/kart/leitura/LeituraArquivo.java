package br.com.kart.leitura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.kart.entidades.Corrida;
import br.com.kart.entidades.Piloto;
import br.com.kart.entidades.TempoMedio;
import br.com.kart.util.Utils;

public class LeituraArquivo {
	
	private Utils utils;
	
	public LeituraArquivo() {
		this.utils = new Utils();
	}
	/**
	 * 
	 * @param caminho
	 * @return lista preenchida
	 * @throws IOException
	 */
	public List<String> leituraManipulacaoArquivo(String caminho) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(caminho));
		br.readLine();
		List<String> listaInformacoes = new ArrayList<String>();
		while (br.ready()) {
			String linha = br.readLine();
			String[] partes = linha.split(" ");
			for (int i = 0; i < partes.length; i++) {
				if (!partes[i].isEmpty() && !partes[i].trim().equalsIgnoreCase("–")) {
					listaInformacoes.add(partes[i]);
				}
			}
		}
		br.close();
		return listaInformacoes;
	}
	/**
	 *  Extrai as informacoes para o objeto corrida
	 * @param informacoes
	 * @return Objeto Corrida preenchido
	 * @throws ParseException
	 */
	public Corrida extraiInformacoes(List<String> informacoes) throws ParseException {
		int indiceControle = 0;
		Piloto piloto = new Piloto();
		Corrida corrida = new Corrida();

		for (int i = 0; i <= informacoes.size(); i++) {
			if (indiceControle == 6) {
				if (corrida.getPilotos().isEmpty()) {
					corrida.getPilotos().add(piloto);
				} else {
					if (!corrida.getPilotos().contains(piloto)) {
						corrida.getPilotos().add(piloto);
					} else {
						for (Piloto p : corrida.getPilotos()) {
							if (p.getCodigo().equals(piloto.getCodigo())) {
								p.getNumeroVoltas().addAll(piloto.getNumeroVoltas());
								p.getTempoVolta().addAll(piloto.getTempoVolta());
								p.getVelocidadeMedia().addAll(piloto.getVelocidadeMedia());
							}
						}
					}
				}
				indiceControle = 0;
				piloto = new Piloto();
			}

			piloto = popular(informacoes, indiceControle, piloto, i);
			indiceControle++;
		}
		return corrida;
	}
	/**
	 * Preenche o objeto Piloto
	 * @param informacoes
	 * @param indiceControle
	 * @param piloto
	 * @param i
	 * @return Piloto preenchido
	 * @throws ParseException
	 */
	private Piloto popular(List<String> informacoes, int indiceControle, Piloto piloto, int i) throws ParseException {
		// codigo
		if (indiceControle == 1) {
			piloto.setCodigo(Integer.valueOf(informacoes.get(i)));
			// Nome
		} else if (indiceControle == 2) {
			piloto.setNome(informacoes.get(i));
			// numero de voltas
		} else if (indiceControle == 3) {
			piloto.getNumeroVoltas().add(Integer.valueOf(informacoes.get(i)));
			// tempo da volta
		} else if (indiceControle == 4) {
			TempoMedio tempo = new TempoMedio();
			tempo.setTempo(utils.tratarTempoVolta(informacoes.get(i)));
			piloto.getTempoVolta().add(tempo);
			// velocidade media
		} else if (indiceControle == 5) {
			piloto.getVelocidadeMedia().add(utils.parseVelocidadeMedia(informacoes.get(i)));
		}
		return piloto;
	}

}
