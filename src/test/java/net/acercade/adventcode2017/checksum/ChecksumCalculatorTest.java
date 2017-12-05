package net.acercade.adventcode2017.checksum;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by golcinab on 02/12/2017.
 */
public class ChecksumCalculatorTest {


	private ChecksumCalculator checksumCalculator;

	@Before
	public void setUp() throws Exception {
		checksumCalculator = new ChecksumCalculator();
	}

	@Test
	public void vector_con_una_posicion_tiene_checskum_cero(){
		String[] input = new String[1];
		input[0] = "12";

		assertThat(checksumCalculator.getChecksum(input), is(0));
	}

	@Test
	public void vector_con_tres_posiciones_devuelve_el_diferencia_entre_max_y_min(){
		String[] input = new String[3];
		input[0] = "7"; input[1]= "5"; input[2] = "3";

		assertThat(checksumCalculator.getChecksum(input), is(4));
	}

	@Test
	public void array_con_una_fila_devuelve_checksum_de_vector(){
		String[][] input = new String[1][3];
		input[0][0] = "7"; input[0][1] = "5"; input[0][2] = "3";

		assertThat(checksumCalculator.getChecksum(input), is(4));
	}

	@Test
	public void	array_con_tres_filas_devuelve_suma_checksum_de_vectores(){
		String[][] input = new String[3][4];
		input[0][0] = "5"; input[0][1] = "1"; input[0][2] = "9"; input[0][3] = "5";
		input[1][0] = "7"; input[1][1] = "5"; input[1][2] = "3";
		input[2][0] = "2"; input[2][1] = "4"; input[2][2] = "6"; input[2][3] = "8";

		assertThat(checksumCalculator.getChecksum(input), is(18));

	}

	@Test
	public void calcular_checksum_divisible_de_array(){
		String[] input = new String[4];
		input[0] = "5"; input[1] = "9"; input[2] = "2"; input[3] = "8";

		assertThat(checksumCalculator.getChecksumDivisible(input), is(4));
	}

	@Test
	public void calcular_checksum_divisible_de_vector(){
		String[][] input = new String[3][4];
		input[0][0] = "5"; input[0][1] = "9"; input[0][2] = "2"; input[0][3] = "8";
		input[1][0] = "9"; input[1][1] = "4"; input[1][2] = "7"; input[1][3] = "3";
		input[2][0] = "3"; input[2][1] = "8"; input[2][2] = "6"; input[2][3] = "5";

		assertThat(checksumCalculator.getChecksumDivisible(input), is(9));
	}
}
