import java.util.List;
import java.util.Map;

public class TestWuzzufJobs {

    public static void  test() {
        ReadingCSV R = new ReadingCSV();

        List<JobDetails> jobs = R.ReadCSVFile("D:\\ITI-- -AI-PRO\\JAVA & UML PROGRAMMING\\Day 4\\home work\\Wuzzuf_Jobs.csv");
        JobsDataService j = new JobsDataService();
        Map jobsByCountry = j.FilterJobsByCountry(jobs);
        Map jobsByLevel = j.FilterJobsByLevel(jobs);
        Map jobsByTitle = j.FilterJobsByTitle(jobs);
        Map jobsByYears = j.FilterJobsByYears(jobs);
        System.out.println("jobsByCountry : " + jobsByCountry);
        System.out.println("jobsByLevel : " + jobsByLevel);
        System.out.println("jobsByTitle : " + jobsByTitle);
        System.out.println("jobsByYears : " + jobsByYears);
}
}

