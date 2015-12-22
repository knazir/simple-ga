/* This class represents an individual in our population with its
 * own "chromosome" composed of exactly the same number of genes
 * as the solution sequence. The individual has a fitness score
 * that is calculated by comparing the number of in-common, in-place
 * "genes" in the chromosome compared to the solution.
 * 
 * Each individual is originally generated with a random chromosome
 * of values between the minimum and maximum value of any element in
 * the solution.
 */

package algorithm;

import java.util.Random;

public class Individual implements GAConstants {
	
	/** Current sequence of GENE_LENGTH integers, which is exactlythe solution size */
	private int[] genes;
	
	/** Current fitness score (of the genes array) */
	private int fitness = 0;
	
	/** Random generator for "mutations" in sequence */
	private Random randomGenerator;
	
	public Individual() {
		this.genes = new int[GENE_LENGTH];	// initializes an "empty" chromosome
		this.randomGenerator = new Random();
	}
	
	/** Creates a randomly generated chromosome */
	public void generateIndividual() {
		for (int i = 0; i < GENE_LENGTH; i++) {
			int gene = randomGenerator.nextInt(MAX_VALUE + 1);
			genes[i] = gene;
		}
	}
	
	/** Calculates the individual's current fitness score */
	public int getFitness() {
		if (this.fitness == 0)
			for (int i = 0; i < GENE_LENGTH ; i++) 
				if (genes[i] == SOLUTION_SEQUENCE[i]) 
					this.fitness++;
		return fitness;
	}
	
	/** Sets a specific gene to a value and resets individual's fitness */
	public void setGene(int index, int value) {
		this.genes[index] = value;
		this.fitness = 0;
	}
	
	@Override
	public String toString() {
		String chromosome = "";
		for (int i = 0; i < GENE_LENGTH; i++)
			chromosome += genes[i];
		return chromosome;
	}
}
