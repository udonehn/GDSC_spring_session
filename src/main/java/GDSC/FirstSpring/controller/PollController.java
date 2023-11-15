package GDSC.FirstSpring.controller;

import GDSC.FirstSpring.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/poll")
@RequiredArgsConstructor
public class PollController {

    private final PollService pollService;

    @GetMapping //사이트 접속
    public String polls() {
        return "poll/poll";
    }

    @PostMapping
    public String addVote(@RequestParam(name = "language") String language) {
        pollService.addVote(language);
        return "poll/poll";
    }

    @GetMapping("/result")
    public String voteResult(Model model) {
        model.addAttribute("c", pollService.getResult("c"));
        model.addAttribute("java", pollService.getResult("java"));
        model.addAttribute("python", pollService.getResult("python"));

        return "poll/poll_result";
    }
}
