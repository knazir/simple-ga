package algorithm;

import java.util.Random;

public class GeneticAlgorithm implements GAConstants {
	
	private Random randomGenerator;
	
	public GeneticAlgorithm() {
		this.randomGenerator = new Random();
	}
	
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
	
	

}
