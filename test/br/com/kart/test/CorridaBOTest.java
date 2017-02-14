package br.com.kart.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import br.com.kart.bo.CorridaBO;
import br.com.kart.entidades.Corrida;
import br.com.kart.entidades.Piloto;
import br.com.kart.entidades.PilotoVolta;
import br.com.kart.leitura.LeituraArquivo;

public class CorridaBOTest {

	CorridaBO bo;
	Corrida corrida;
	LeituraArquivo leitura;

	String caminho;
	PilotoVolta pv;

	@Before
	public void init() throws IOException, ParseException {
		bo = new CorridaBO();
		corrida = new Corrida();
		Calendar calen = Calendar.getInstance();
		calen.set(2017, 2, 14, 14, 20, 10);
		corrida.setDuracaoHoras(calen.getTime());
		corrida.setPilotos(new ArrayList<Piloto>());
		corrida.setQtdVoltas(4);
		leitura = new LeituraArquivo();
		LeituraArquivo leitura = new LeituraArquivo();
		caminho = new File("resource/kart").getCanonicalPath();
		leitura.leituraManipulacaoArquivo(caminho);
		corrida = leitura.extraiInformacoes(leitura.leituraManipulacaoArquivo(caminho));
		pv = new PilotoVolta();
	}

	@Test
	public void teste() throws ParseException {
		assertEquals((bo.calculaTempoTotalPorProva(leitura, corrida, 0, 0).size() > 0), true);
		assertEquals(bo.escritaArquivo("resource/saida", pv.sort(bo.calculaTempoTotalPorProva(leitura, corrida, 0, 0))), true);
	}
}
