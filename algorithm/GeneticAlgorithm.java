package algorithm;

import java.util.Random;

public class GeneticAlgorithm implements GAConstants {

	private Random randomGenerator;

	public GeneticAlgorithm() {
		this.randomGenerator = new Random();
	}
	
	
	/** Iterates through the current population and chooses two individuals
	 *  at random to "mate" (cross over genes) and insert that new individual
	 *  into the population. Then iterates through the new population and
	 *  adds random mutations to each individual's genes.
	 */
	public Population evolvePopulation(Population population) {
		Population newPopulation = new Population(population.size());

		for (int i = 0; i < population.size(); i++) {
			Individual firstIndividual = randomSelection(population);
			Individual secondIndividual = randomSelection(population);
			Individual newIndividual = crossOver(firstIndividual, secondIndividual);
			newPopulation.saveIndividual(i, newIndividual);
		}

		for (int i = 0; i < newPopulation.size(); i++)
			mutate(newPopulation.getIndividual(i));

		return newPopulation;
	}

	/** Randomly selects an individual from a population by simulating a
	 *  "survival tournament" from which the fittest individual is taken
	 *  and returned.
	 */
	private Individual randomSelection(Population population) {
		Population newPopulation = new Population(TOURNAMENT_SIZE);

		for (int i = 0; i < TOURNAMENT_SIZE; i++) {
			int randomIndex = (int) (Math.random() * population.size());
			newPopulation.saveIndividual(i, population.getIndividual(randomIndex));
		}

		Individual fittestIndividual = newPopulation.getFittest();
		return fittestIndividual;
	}

	/** Takes two individuals and iterates through their chromosome, randomly
	 *  swapping individual genes. The newly created individual is returned.
	 */
	private Individual crossOver(Individual firstIndividual, Individual secondIndividual) {
		Individual newSolution = new Individual();
		
		for (int i = 0; i < GENE_LENGTH; i++) {
			if (Math.random() <= UNIFORM_RATE)
				newSolution.setGene(i, firstIndividual.getGene(i));
			else
				newSolution.setGene(i, secondIndividual.getGene(i));
		}
		return newSolution;
	}
	
	/** Iterates through an individual's chromosome and randomly mutates genes */
	private void mutate(Individual individual) {
		for (int i = 0; i < GENE_LENGTH; i++) {
			if (Math.random() <= MUTATION_RATE) {
				int gene = randomGenerator.nextInt(MAX_VALUE + 1);
				individual.setGene(i, gene);
			}
		}
	}
}
