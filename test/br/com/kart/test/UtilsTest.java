package br.com.kart.test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.kart.entidades.Corrida;
import br.com.kart.entidades.Piloto;
import br.com.kart.util.Utils;

public class UtilsTest {
	
	Utils utils = new Utils();
	Corrida corrida;
	Date primeiraData;
	Date segundaData;
	Date terceiraData;
	
	@Before
	public void pupularInfo() {
		corrida = new Corrida();
		corrida.setDuracaoHoras(new Date());
		corrida.setPilotos(new ArrayList<Piloto>());
		corrida.setQtdVoltas(4);
		Calendar calen = Calendar.getInstance();
		calen.setTime(new Date());
		calen.set(2017, 2, 14, 14, 20, 10);
		calen.set(calen.MILLISECOND, 0);
		primeiraData = calen.getTime();
		segundaData = calen.getTime();
		calen.set(2017, 2, 14, 14, 40, 20);
		calen.set(calen.MILLISECOND, 0);
		terceiraData = calen.getTime();
		
	}
	@Test
	public void test() throws ParseException {
		assertEquals(utils.ordearListas(corrida), corrida);
		assertEquals((Object)utils.parseVelocidadeMedia("2.23"),(Object) Double.parseDouble("2.23"));
		assertEquals(utils.tratarTempoVolta(utils.somar(primeiraData, segundaData)),utils.tratarTempoVolta(terceiraData));
	}

}
