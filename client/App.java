package client;

import algorithm.GAConstants;
import algorithm.GeneticAlgorithm;
import algorithm.Population;

public class App implements GAConstants {

	private static final int POPULATION_SIZE = 100;
	
	public static void main(String[] args) {
		GeneticAlgorithm algorithm = new GeneticAlgorithm();
		Population population = new Population(POPULATION_SIZE);
		population.initialize();
		
		int generation = 0;
		
		while (population.getFittest().getFitness() != MAX_FITNESS) {
			generation++;
			System.out.print("Generation: " + generation + " ");
			System.out.println("Fittest: " + population.getFittest().getFitness());
			System.out.println(population.getFittest() + "\n");
			population = algorithm.evolvePopulation(population);
		}
		
		System.out.println("Solution found: ");
		System.out.println(population.getFittest());
	}
}
