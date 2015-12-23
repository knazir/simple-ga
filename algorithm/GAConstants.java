package algorithm;

public interface GAConstants {
	
	/* GUI CONSTANTS */
	public static final int APPLICATION_WIDTH = 1024;
	public static final int APPLICATION_HEIGHT = 768;
	
	/* SOLUTION CONSTANTS */
	public static final int POPULATION_SIZE = 100;
	public static final int[] SOLUTION_SEQUENCE =
		{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 9;
	public static final int GENE_LENGTH = SOLUTION_SEQUENCE.length;
	
	
	/* ALGORITHM BEHAVIOR CONSTANTS */
	public static final double UNIFORM_RATE = 0.5;
	public static final double MUTATION_RATE = 0.15;
	public static final int TOURNAMENT_SIZE = 5;
	public static final int MAX_FITNESS = GENE_LENGTH;

}