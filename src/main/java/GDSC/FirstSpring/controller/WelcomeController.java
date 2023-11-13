package GDSC.FirstSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public String welcome() {
        return "welcome/welcome";
    }

    @GetMapping("/name")
    public String welcomeName(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "welcome/welcome_name";

    }
}
