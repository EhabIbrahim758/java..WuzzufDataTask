import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
//import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class titlesChart implements ExampleChart<PieChart> {

  public static void main(String[] args) {

    ExampleChart<PieChart> exampleChart = new titlesChart();
    PieChart chart = exampleChart.getChart();
    new SwingWrapper<>(chart).displayChart();
  }

  @Override
  public PieChart getChart() {
    ReadingCSV input = new ReadingCSV();
    List<JobDetails> jobs = input.ReadCSVFile("D:\\ITI-- -AI-PRO\\JAVA & UML PROGRAMMING\\Day 4\\home work\\Wuzzuf_Jobs.csv");
    JobsDataService service = new JobsDataService();
    Map titles = service.FilterJobsByTitle(jobs);
    List titlesNames = new ArrayList<>(titles.keySet());
    List titlesNumbers = new ArrayList<Double>(titles.values());

    // Create Chart
    PieChart chart =
        new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();

    // Customize Chart
    chart.getStyler().setCircular(false);
    chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideS);
    chart.getStyler().setLegendLayout(Styler.LegendLayout.Horizontal);

    // Series
    for (int i=titlesNumbers.size()-20;i<titlesNumbers.size();i++){
      chart.addSeries(String.valueOf(titlesNames.get(i)), (Number) titlesNumbers.get(i));
    }


    return chart;
  }

  @Override
  public String getExampleChartName() {

    return getClass().getSimpleName() + " - Pie Chart with 4 Slices";
  }
}
