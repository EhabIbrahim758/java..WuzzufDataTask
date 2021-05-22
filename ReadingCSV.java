import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingCSV {
    public List<JobDetails> ReadCSVFile(String filename){
        List<JobDetails> jobs = new ArrayList<>();

        try( BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line = br.readLine();
            if (line != null){
                line = br.readLine();
            }
            while(line != null){
                String[] Attributes = line.split(",");
                JobDetails job = CreateJob(Attributes);
                jobs.add(job);
                line = br.readLine();

            }

        }catch(IOException e){
            System.out.println(e);
        }


        return jobs;
    }
    public JobDetails CreateJob(String[] attributes){
        String title = attributes[0];
        String company = attributes[1];
        String location = attributes[2];
        String type = attributes[3];
        String level = attributes[4];
        String yearexp = attributes[5];
        String country = attributes[5];
        String skills = attributes[7];

        return new JobDetails(title, company, location, type,
                level, yearexp, country, skills);


    }
}
