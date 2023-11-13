package GDSC.FirstSpring.service;

import org.springframework.stereotype.Service;

@Service
public class AgeService {

    public int calculateAge(int age, boolean isBirthdayPassed) {
        if (isBirthdayPassed){
            return age-1;
        }
        else{
            return age-2;
        }

    }
}
