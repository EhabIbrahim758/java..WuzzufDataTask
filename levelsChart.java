import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Pie Chart with 4 Slices
 *
 * <p>Demonstrates the following:
 *
 * <ul>
 *   <li>Pie Chart
 *   <li>ChartBuilderPie
 *   <li>Setting Non-circular to match container aspect ratio
 *   <li>Legend outside south, with Horizontal Legend Layout
 */
public class levelsChart implements ExampleChart<PieChart> {

  public static void main(String[] args) {

    ExampleChart<PieChart> exampleChart = new levelsChart();
    PieChart chart = exampleChart.getChart();
    new SwingWrapper<>(chart).displayChart();
  }

  @Override
  public PieChart getChart() {
    ReadingCSV input = new ReadingCSV();
    List<JobDetails> jobs = input.ReadCSVFile("D:\\ITI-- -AI-PRO\\JAVA & UML PROGRAMMING\\Day 4\\home work\\Wuzzuf_Jobs.csv");
    JobsDataService service = new JobsDataService();
    HashMap levels = (HashMap) service.FilterJobsByLevel(jobs);
    List levelsTypes = new ArrayList<>(levels.keySet());
    List levelNumbers = new ArrayList<Double>(levels.values());

    // Create Chart
    PieChart chart =
        new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();

    // Customize Chart
    chart.getStyler().setCircular(false);
    chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideS);
    chart.getStyler().setLegendLayout(Styler.LegendLayout.Horizontal);

    // Series
    for (int i=0;i<levelNumbers.size();i++){
      chart.addSeries(String.valueOf(levelsTypes.get(i)), (Number) levelNumbers.get(i));
    }


    return chart;
  }

  @Override
  public String getExampleChartName() {

    return getClass().getSimpleName() + " - Pie Chart with 4 Slices";
  }
}
