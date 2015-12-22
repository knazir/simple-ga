/* This class represents a population of individuals at some stage
 * in the algorithm. Each population instance stores an internal
 * array of individuals representing the current generation.
 * 
 * From the population, the fittest individual can be determined.
 */

package algorithm;

public class Population {
	
	/** Internal array of current generation */
	private Individual[] individuals;
	
	public Population(int populationSize) {
		individuals = new Individual[populationSize];
	}
	
	/** Initializes the generation with randomly generated individuals */
	public void initialize() {
		for (int i = 0; i < size(); i++) {
			Individual newIndividual = new Individual();
			newIndividual.generateIndividual();
			saveIndividual(i, newIndividual);
		}
	}
	
	/** Returns a given individual */
	public Individual getIndividual(int index) {
		return individuals[index];
	}
	
	/** Returns the fittest individual in the generation */
	public Individual getFittest() {
		Individual fittestIndividual = individuals[0];
		
		for (int i = 0; i < size(); i++)
			if (fittestIndividual.getFitness() <= getIndividual(i).getFitness())
				fittestIndividual = getIndividual(i);
		return fittestIndividual;
	}
	
	/** Returns the size of the current generation */
	public int size() {
		return this.individuals.length;
	}
	
	/** Saves an individual to the current generation at a specific index */
	public void saveIndividual(int index, Individual individual) {
		this.individuals[index] = individual;
	}
	
}
