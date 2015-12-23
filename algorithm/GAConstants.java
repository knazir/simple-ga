
package algorithm;

public interface GAConstants {
	
	/* GUI CONSTANTS */
	public static final int APPLICATION_WIDTH = 1024;
	public static final int APPLICATION_HEIGHT = 768;
	
	/* SOLUTION CONSTANTS */
	public static final int POPULATION_SIZE = 100;
	public static final int MIN_VALUE = 10;
	public static final int MAX_VALUE = 99;
	public static final int GENE_LENGTH = 50;
	public static final int[] SOLUTION_SEQUENCE = 
		{52, 14, 19, 79, 99, 87, 69, 99, 56, 61, 67, 71, 99, 94, 25, 77, 
		 69, 57, 65, 53, 42, 67, 38, 79, 62, 41, 81, 59, 20, 12, 68, 67, 
		 26, 49, 35, 87, 15, 70, 53, 15, 78, 10, 60, 29, 30, 78, 65, 16, 98, 39};
	
	/* ALGORITHM BEHAVIOR CONSTANTS */
	public static final double UNIFORM_RATE = 0.5;
	public static final double MUTATION_RATE = 0.15;
	public static final int TOURNAMENT_SIZE = 5;
	public static final int MAX_FITNESS = GENE_LENGTH;

}