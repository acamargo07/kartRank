package br.com.kart.bo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.kart.entidades.Corrida;
import br.com.kart.entidades.Piloto;
import br.com.kart.entidades.PilotoVolta;
import br.com.kart.leitura.LeituraArquivo;
import br.com.kart.util.Utils;

/**
 * @author andre
 *
 */
public class CorridaBO {
	
	private Utils utils;
	/**
	 * Construtor padrao
	 */
	public CorridaBO() {
		utils  = new Utils();
	}

	/**
	 * Metodo responsavel por organizar os pilotos por ordem de tempo por volta
	 * 
	 * @param leitura 
	 * @param corrida
	 * @param controladorPiloto
	 * @param controlador
	 * @retur Lista preenchida
	 * @throws ParseException
	 */
	public List<PilotoVolta> calculaTempoTotalPorProva(LeituraArquivo leitura, Corrida corrida, Integer controladorPiloto,
			Integer controlador) throws ParseException {
		List<PilotoVolta> lista = new ArrayList<>();
		while (controladorPiloto < corrida.getPilotos().size()) {

			Piloto p = corrida.getPilotos().get(controladorPiloto);
			PilotoVolta pVolta = new PilotoVolta();
			pVolta.setCodigoPiloto(p.getCodigo());
			pVolta.setNome(p.getNome());

			if (p.getNumeroVoltas().size() > controlador) {
				pVolta.setNumeroVolta(p.getNumeroVoltas().get(controlador));
			}
			if (p.getTempoVolta().size() > controlador) {
				pVolta.setTempoVolta(p.getTempoVolta().get(controlador));
			}
			if (p.getVelocidadeMedia().size() > controlador) {
				pVolta.setVelocidadeMedia(p.getVelocidadeMedia().get(controlador));
			}

			lista.add(pVolta);
			controlador++;
			if (controlador.equals(4)) {
				controladorPiloto++;
				controlador = 0;
			}
		}
		return lista;
	}
	/**
	 * Gera o arquivo de saida
	 * @param caminho
	 * @param lista
	 * @return boolean 
	 */
	public boolean escritaArquivo(String caminho, List<PilotoVolta> lista) {
		try {
		File file = new File(caminho);
		
		if(null != file && file.exists()) {
			file.delete();
		}
		file.createNewFile();
		
		int colocacao = 1;
		FileWriter arq = new FileWriter(file);
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.println("Ranking Corrida");
		gravarArq.println("Pilotos");
		for(PilotoVolta pv : lista) {
			gravarArq.println(pv.getCodigoPiloto()+" "+pv.getNome());
			gravarArq.println("Colocação: "+ colocacao+"°");
			gravarArq.println("Voltas Completadas: "+ pv.getQtdVoltas());
			gravarArq.println("Tempo total da prova"+ utils.tratarTempoVolta(pv.getTempoTotal()));
			colocacao++;
		}

		arq.close();
		} catch (ParseException p) {
			p.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
