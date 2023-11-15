package GDSC.FirstSpring.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class PollService {
    public final HashMap<String, Integer> votes = new HashMap<>();

    public PollService(){
        votes.put("c", 0);
        votes.put("java", 0);
        votes.put("python", 0);
    }

    public void addVote(String language){
        votes.put(language, votes.get(language) + 1);
    }

    public Integer getResult(String language){
        return votes.get(language);
    }
}
