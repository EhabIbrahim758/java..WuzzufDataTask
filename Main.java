
import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.selection.Selection;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import java.util.*;


public class Main {


    public static void main(String[] args) {

        TestWuzzufJobs.test();
        ReadingCSV R = new ReadingCSV();
        List<JobDetails> jobs = R.ReadCSVFile("D:\\ITI-- -AI-PRO\\JAVA & UML PROGRAMMING\\Day 4\\home work\\Wuzzuf_Jobs.csv");
        // printing Data as a Table
        int i = 0;
        List<Integer> Number = new ArrayList<>();
        List<String> title = new ArrayList<>();
        List<String> company = new ArrayList<>();
        List<String> location = new ArrayList<>();
        List<String> type = new ArrayList<>();
        List<String> level = new ArrayList<>();
        List<String> yearsExp = new ArrayList<>();
        List<String> country = new ArrayList<>();
        List<String> skills = new ArrayList<>();

        for(JobDetails j : jobs ){
            Number.add(i++);
            title.add(j.Title);
            company.add(j.Company);
            location.add(j.Location);
            type.add(j.Type);
            level.add(j.Level);
            yearsExp.add(j.YearExp);
            country.add(j.Country);
            skills.add(j.Skills);
        }

        Table JobsTable =
                Table.create("JobsTable")
                        .addColumns(
                                DoubleColumn.create("num", Number),
                                StringColumn.create("title", title),
                                StringColumn.create("company", company),
                                StringColumn.create("location", location),
                                StringColumn.create("type", type),
                                StringColumn.create("level", level),
                                StringColumn.create("yearsExp", yearsExp),
                                StringColumn.create("country", country),
                                StringColumn.create("skills", skills));

        System.out.println(JobsTable.print());



    // showing some charts
    }

}
