package net.acercade.adventcode2017.inversecaptcha;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by golcinab on 02/12/2017.
 */
public class CaptchaInversorTest {

	CaptchaInversor inversor;

	@Before
	public void setUp(){ inversor = new CaptchaInversor(); }

	@Test
	public void texto_con_solo_un_numero_devuelve_cero(){
		assertThat(inversor.sumCaptcha("1"), is(0));
	}

	@Test
	public void texto_con_sucesivos_devuelve_suma(){
		assertThat(inversor.sumCaptcha("112"), is(1));
	}

	@Test
	public void texto_con_multiples_sucesivos_devuelve_suma_sucesivos(){
		assertThat(inversor.sumCaptcha("1122"), is(3));
	}

	@Test
	public void todos_diferentes_devuelve_cero(){
		assertThat(inversor.sumCaptcha("1234"), is(0));
	}

	@Test
	public void todos_iguales_suma_todos(){
		assertThat(inversor.sumCaptcha("1111"), is(4));
	}

	@Test
	public void principio_fin_iguales_suma_valor(){
		assertThat(inversor.sumCaptcha("91212129"), is(9));
	}
}
