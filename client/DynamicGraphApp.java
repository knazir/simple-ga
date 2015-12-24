package client;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.DynamicTimeSeriesCollection;
import org.jfree.data.time.Second;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import algorithm.GAConstants;
import algorithm.GeneticAlgorithm;
import algorithm.Population;

/** @see http://stackoverflow.com/questions/5048852 */
public class DynamicGraphApp extends ApplicationFrame implements GAConstants {
	
	private static Timer timer;
	private static GeneticAlgorithm algorithm = new GeneticAlgorithm();
	private static Population population = new Population(POPULATION_SIZE);
	private static int generation = 0;

	public DynamicGraphApp(final String title) {
		super(title);
		population.initialize();

		final DynamicTimeSeriesCollection dataset =
				new DynamicTimeSeriesCollection(1, COUNT, new Second());
		dataset.setTimeBase(new Second(0, 0, 0, 1, 1, 2011));
		dataset.addSeries(noData(), 0, "Population");
		JFreeChart chart = createChart(dataset);
		

		final JLabel generationLabel = new JLabel("Current Generation: " + generation);
		final JButton run = new JButton(STOP);
		run.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if (STOP.equals(cmd)) {
					timer.stop();
					run.setText(START);
				} else {
					timer.start();
					run.setText(STOP);
				}
			}
		});

		final JComboBox combo = new JComboBox();
		combo.addItem("Fast");
		combo.addItem("Faster");
		combo.addItem("Slow");
		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ("Faster".equals(combo.getSelectedItem())) {
					timer.setDelay(FASTER);
				} else if ("Fast".equals(combo.getSelectedItem())) {
					timer.setDelay(FAST);
				} else {
					timer.setDelay(SLOW);
				}
			}
		});

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize( new java.awt.Dimension(APPLICATION_WIDTH , APPLICATION_HEIGHT));
		this.add(chartPanel, BorderLayout.CENTER);
		JPanel btnPanel = new JPanel(new FlowLayout());
		btnPanel.add(generationLabel);
		btnPanel.add(run);
		btnPanel.add(combo);
		this.add(btnPanel, BorderLayout.SOUTH);

		timer = new Timer(FAST, new ActionListener() {

			float[] newData = new float[1];

			@Override
			public void actionPerformed(ActionEvent e) {
				generation++;
				float dataPoint = population.getFittest().getFitness();
				population = algorithm.evolvePopulation(population);
				
				generationLabel.setText("Current Generation: " + generation);
				
				if (dataPoint == MAX_FITNESS) {
					generation = 0;
					population.initialize();
					timer.stop();
					run.setText(RESTART);
				}
				
				newData[0] = dataPoint;
				dataset.advanceTime();
				dataset.appendData(newData);
			}
		});
	}

	private float[] noData() {
		float[] a = new float[COUNT];
		for (int i = 0; i < a.length; i++) {
			a[i] = 0;
		}
		return a;
	}

	private JFreeChart createChart(final XYDataset dataset) {
		final JFreeChart result = ChartFactory.createTimeSeriesChart(
				GRAPH_TITLE, "Generation", "Fitness", dataset, true, true, false);
		final XYPlot plot = result.getXYPlot();
		ValueAxis domain = plot.getDomainAxis();
		domain.setAutoRange(true);
		ValueAxis range = plot.getRangeAxis();
		range.setRange(0, MAX_FITNESS + GRAPH_Y_AXIS_BUFFER);
		return result;
	}

	public void start() {
		timer.start();
	}

	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				DynamicGraphApp demo = new DynamicGraphApp(GRAPH_TITLE);
				demo.pack();
				RefineryUtilities.centerFrameOnScreen(demo);
				demo.setVisible(true);
				demo.start();
			}
		});
	}
}