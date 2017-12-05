package net.acercade.adventcode2017.checksum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by golcinab on 02/12/2017.
 */
public class ChecksumCalculator {

	public int getChecksum(String[][] input) {
		int checksum = 0;
		for (int i = 0; i < input.length; i++) {
			checksum += getChecksum(input[i]);
		}
		return checksum;
	}

	public int getChecksumDivisible(String[][] input) {
		int checksum = 0;
		for (int i = 0; i < input.length; i++) {
			checksum += getChecksumDivisible(input[i]);
		}
		return checksum;
	}

	public int getChecksum(String[] input){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for( int i = 0; i < input.length; i++){
			if( input[i] == null ) break;
			max = Integer.max(getIntFromString(input[i]), max);
			min = Integer.min(getIntFromString(input[i]), min);
		}
		return max - min;
	}

	private int getIntFromString(String s) {
		return Integer.parseInt(s);
	}

	public int getChecksumDivisible(String[] input){
		int result = 0;

		for( int i = 0; i < input.length; i++){
			int divisor = getIntFromString(input[i]);
			for( int j = 0; j < input.length; j++){
				int denominator = getIntFromString(input[j]);

				if (divisor % denominator == 0 && i != j) {
					result = (divisor / denominator);
				}
			}
		}

		return result;
	}

	public static void main(String[] args){
		ChecksumCalculator checksum = new ChecksumCalculator();
		String[][] input = new String[16][16];

		try {
			File file = checksum.getFile("ChecksumInput.txt");
			BufferedReader bfile = new BufferedReader(new FileReader(file));

			String s;
			int j = 0;

			while ((s = bfile.readLine()) != null) {
				String[] tmp = s.split("\\s+");

				for( int i = 0; i < tmp.length; i++){
					input[j][i] = tmp[i];
				}
				j++;
			}
			bfile.close();
		} catch (IOException e) {
		}


		System.out.println("Checksum Normal: " + new ChecksumCalculator().getChecksum(input));
		System.out.println("Checksum Divisible: " + new ChecksumCalculator().getChecksumDivisible(input));
	}

	private File getFile(String filename){
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(filename).getFile());

		return file;
	}
}
