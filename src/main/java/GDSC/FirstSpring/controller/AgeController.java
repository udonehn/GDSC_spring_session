package GDSC.FirstSpring.controller;

import lombok.RequiredArgsConstructor;
import GDSC.FirstSpring.service.AgeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/age")
@RequiredArgsConstructor
public class AgeController {
    private final AgeService ageService;

    @GetMapping
    public String age(){
        return "age/age";
    }

    @GetMapping("/result")
    public String ageResult(@RequestParam(name = "age") int age,
                            @RequestParam(name = "isBirthdayPassed") boolean isBirthdayPassed,
                            Model model) {

        int resultAge = ageService.calculateAge(age, isBirthdayPassed);
        model.addAttribute("resultAge",resultAge);

        return "age/age_result";
    }

}
