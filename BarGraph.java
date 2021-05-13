
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class BarGraph extends Application{
    private static double[] digitFrequencyPercent;

    @Override public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample");
        final CategoryAxis DigitAxis = new CategoryAxis();
        final NumberAxis percentAxis = new NumberAxis();
        final BarChart<String,Number> barGraph = new BarChart<String,Number>(DigitAxis,percentAxis);
        barGraph.setTitle("Benford's Law Bar Graph");
        DigitAxis.setLabel("Digit");
        percentAxis.setLabel("Percent");
 
        XYChart.Series series = new XYChart.Series();  
        series.getData().add(new XYChart.Data("1", digitFrequencyPercent[0]));
        series.getData().add(new XYChart.Data("2", digitFrequencyPercent[1]));
        series.getData().add(new XYChart.Data("3", digitFrequencyPercent[2]));
        series.getData().add(new XYChart.Data("4", digitFrequencyPercent[3]));
        series.getData().add(new XYChart.Data("5", digitFrequencyPercent[4]));
        series.getData().add(new XYChart.Data("6", digitFrequencyPercent[5]));
        series.getData().add(new XYChart.Data("7", digitFrequencyPercent[6]));
        series.getData().add(new XYChart.Data("8", digitFrequencyPercent[7]));
        series.getData().add(new XYChart.Data("9", digitFrequencyPercent[8]));
        
        Scene scene = new Scene(barGraph,800,600);
        barGraph.getData().addAll(series);
        stage.setScene(scene);
        stage.show();
    }

    public void newGraph(int[] frequency) {
        digitFrequencyPercent = new double[9];

        int total = frequency[0] + frequency[1] + frequency[2] + frequency[3] + frequency[4] + frequency[5] + frequency[6] + frequency[7] + frequency[8];
        for (int i = 0; i < 9; i++) {
            digitFrequencyPercent[i] = (frequency[i] / Double.valueOf(total)) * 100.0;

        }

        if (digitFrequencyPercent[0] > 29 && digitFrequencyPercent[0] < 32) {
            System.out.println("Fraud likely did not occur");
        }

        launch();
    }
}
