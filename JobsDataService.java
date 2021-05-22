import java.util.*;

public class JobsDataService {
    public Map<String, Integer> FilterJobsByTitle (List<JobDetails> jobs){
        Map<String, Integer> titleJobs = new HashMap<>();
        Set<String> titles_set = new HashSet<>();
        List<String> titles_list = new ArrayList<>();

        for (JobDetails j : jobs){
            titles_list.add(j.Title);
            titles_set.add(j.Title);
        }
        int i = 0;
        for(String s : titles_set){
          int c = Collections.frequency(titles_list, s);
          titleJobs.put(s, c);
          i++;
        }

        return titleJobs;

    }

    public Map<String, Integer> FilterJobsByCountry (List<JobDetails> jobs){
        HashMap<String, Integer> JobsByCounty = new HashMap<>();
        Set<String> County_set = new HashSet<>();
        List<String> County_list = new ArrayList<>();

        for (JobDetails j : jobs){
            County_list.add(j.Country);
            County_set.add(j.Country);
        }
        int i = 0;
        for(String s : County_set){
            int c = Collections.frequency(County_list, s);
            JobsByCounty.put(s, c);
            i++;
        }

        return JobsByCounty;

    }


    public Map<String, Integer> FilterJobsByLevel (List<JobDetails> jobs){
        HashMap<String, Integer> JobsByLevel = new HashMap<>();
        Set<String> Level_set = new HashSet<>();
        List<String> Level_list = new ArrayList<>();

        for (JobDetails j : jobs){
            Level_list.add(j.Level);
            Level_set.add(j.Level);
        }
        int i = 0;
        for(String s : Level_set){
            int c = Collections.frequency(Level_list, s);
            JobsByLevel.put(s, c);
            i++;
        }

        return JobsByLevel;

    }




    public Map<String, Integer> FilterJobsByYears (List<JobDetails> jobs){
        HashMap<String, Integer> JobsByYears = new HashMap<>();
        Set<String> Years_set = new HashSet<>();
        List<String> Years_list = new ArrayList<>();

        for (JobDetails j : jobs){
            Years_list.add(j.YearExp);
            Years_set.add(j.YearExp);
        }
        int i = 0;
        for(String s : Years_set){
            int c = Collections.frequency(Years_list, s);
            JobsByYears.put(s, c);
            i++;
        }

        return JobsByYears;

    }


}


