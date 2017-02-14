package br.com.kart.mains;

import java.io.File;
import java.util.List;

import br.com.kart.bo.CorridaBO;
import br.com.kart.entidades.Corrida;
import br.com.kart.entidades.PilotoVolta;
import br.com.kart.leitura.LeituraArquivo;
import br.com.kart.util.Utils;

public class Principal {
	public static void main(String args[]) {
		try {
		CorridaBO bo = new CorridaBO();
		Utils utils =  new Utils();
		String caminho = new File("resource/kart").getCanonicalPath();
		String caminhoSainda = "resource/saida";
		
		LeituraArquivo leitura = new LeituraArquivo();
		
		leitura.leituraManipulacaoArquivo(caminho);
		
		Corrida corrida = leitura.extraiInformacoes(leitura.leituraManipulacaoArquivo(caminho));
		
		corrida = utils.ordearListas(corrida);
		
		Integer controladorPiloto = 0;
		Integer controlador = 0;
		List<PilotoVolta> listaPv = bo.calculaTempoTotalPorProva(leitura, corrida, controladorPiloto, controlador);
		PilotoVolta pv = new PilotoVolta();
		listaPv = pv.sort(listaPv);
		bo.escritaArquivo(caminhoSainda, listaPv);
		
		System.out.println("Resultado da Corrida gerado co sucesso na pasta (Kart -> Resource -> saida.txt)");
		}catch (Exception e ) {
			e.getMessage();
			System.err.println("Ocorreu um erro inesperado");
		}

	}
}
