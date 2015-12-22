package algorithm;

import java.util.Random;

public class Individual implements GAConstants {
	
	private int[] genes;
	private int fitness = 0;
	private Random randomGenerator;
	
	public Individual() {
		this.genes = new int[GENE_LENGTH];
		this.randomGenerator = new Random();
	}
	
	public void generateIndividual() {
		for (int i = 0; i < GENE_LENGTH; i++) {
			int gene = randomGenerator.nextInt(MAX_VALUE + 1);
			genes[i] = gene;
		}
	}
}
