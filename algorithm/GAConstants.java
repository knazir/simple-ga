package algorithm;

public interface GAConstants {

	/* SOLUTION CONSTANTS */
	//	public static final int[] SOLUTION_SEQUENCE =
	//		{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	//	public static final int[] SOLUTION_SEQUENCE =
	//		{0, 1, 6, 1, 6, 8, 2, 8, 4, 2, 7, 8, 4, 2, 7, 8, 4, 4, 6, 0,
	//		 2, 5, 7, 8, 4, 3, 5, 8, 9, 9, 5, 1, 2, 4, 5, 6, 4, 3 ,2, 1};

	//	public static final int[] SOLUTION_SEQUENCE = 
	//		{52, 14, 19, 79, 99, 87, 69, 99, 56, 61, 67, 71, 99, 94, 25, 77, 
	//		 69, 57, 65, 53, 42, 67, 38, 79, 62, 41, 81, 59, 20, 12, 68, 67, 
	//		 26, 49, 35, 87, 15, 70, 53, 15, 78, 10, 60, 29, 30, 78, 65, 16, 98, 39};

	public static final int[] SOLUTION_SEQUENCE = 
		{71, 65, 45, 51, 64, 87, 63, 68, 54, 38, 44, 80, 22, 97, 30, 99, 40, 73, 44, 88, 
		11, 35, 71, 52, 95, 85, 28, 46, 74, 12, 92, 79, 93, 89, 47, 95, 98, 12, 85, 78, 
		59, 51, 47, 89, 45, 51, 29, 34, 75, 48, 54, 33, 46, 27, 55, 97, 12, 47, 30, 24, 
		19, 24, 20, 22, 33, 51, 77, 26, 42, 88, 74, 80, 13, 65, 89, 19, 86, 91, 57, 75, 
		19, 18, 30, 46, 31, 28, 68, 72, 45, 20, 98, 65, 42, 62, 13, 22, 21, 90, 21, 94,
		};

	//	public static final int[] SOLUTION_SEQUENCE = 
	//		{71, 65, 45, 51, 64, 87, 63, 68, 54, 38, 44, 80, 22, 97, 30, 99, 40, 73, 44, 88, 
	//		 11, 35, 71, 52, 95, 85, 28, 46, 74, 12, 92, 79, 93, 89, 47, 95, 98, 12, 85, 78, 
	//		 59, 51, 47, 89, 45, 51, 29, 34, 75, 48, 54, 33, 46, 27, 55, 97, 12, 47, 30, 24, 
	//		 19, 24, 20, 22, 33, 51, 77, 26, 42, 88, 74, 80, 13, 65, 89, 19, 86, 91, 57, 75, 
	//		 19, 18, 30, 46, 31, 28, 68, 72, 45, 20, 98, 65, 42, 62, 13, 22, 21, 90, 21, 94,
	//		 71, 65, 45, 51, 64, 87, 63, 68, 54, 38, 44, 80, 22, 97, 30, 99, 40, 73, 44, 88, 
	//		 11, 35, 71, 52, 95, 85, 28, 46, 74, 12, 92, 79, 93, 89, 47, 95, 98, 12, 85, 78, 
	//		 59, 51, 47, 89, 45, 51, 29, 34, 75, 48, 54, 33, 46, 27, 55, 97, 12, 47, 30, 24, 
	//		 19, 24, 20, 22, 33, 51, 77, 26, 42, 88, 74, 80, 13, 65, 89, 19, 86, 91, 57, 75, 
	//		 19, 18, 30, 46, 31, 28, 68, 72, 45, 20, 98, 65, 42, 62, 13, 22, 21, 90, 21, 94};

	public static final int POPULATION_SIZE = 100;
	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 99;
	public static final int GENE_LENGTH = SOLUTION_SEQUENCE.length;


	/* ALGORITHM BEHAVIOR CONSTANTS */
	public static final double UNIFORM_RATE = 0.5;
	public static final double MUTATION_RATE = 0.025;
	public static final int TOURNAMENT_SIZE = 5;
	public static final int MAX_FITNESS = GENE_LENGTH;


	/* DYNAMIC GRAPHING APP CONSTANTS */
	public static final int GRAPH_Y_AXIS_BUFFER = 5;
	public static final String START = "Start";
	public static final String STOP = "Stop";
	public static final String RESTART = "Restart";
	public static final int COUNT = 2 * 60;
	public static final int FASTER = 10;
	public static final int FAST = FASTER * 5;
	public static final int SLOW = FAST * 5;

	/* GUI CONSTANTS */
	public static final String GRAPH_TITLE = "Fitness by Generation | Population: " 
			+ POPULATION_SIZE + " | Target Fitness: " + MAX_FITNESS;
	public static final int APPLICATION_WIDTH = 1024;
	public static final int APPLICATION_HEIGHT = 768;

}