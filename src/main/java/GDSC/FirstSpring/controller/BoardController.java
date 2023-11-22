package GDSC.FirstSpring.controller;

import GDSC.FirstSpring.DTO.PostDTO;
import GDSC.FirstSpring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public String board(@RequestParam(defaultValue = "true") Boolean new_first, Model model){
        List<PostDTO> posts = boardService.getPosts(new_first);
        model.addAttribute("posts", posts);
        return "board/board";
    }

    @GetMapping("/write")
    public String writePage() {
        return "board/write";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute PostDTO post){
        boardService.write(post);
        return "redirect:/board";
    }

    @GetMapping("/post/{idx}")
    public String postDetail(@PathVariable("idx") Integer idx, Model model){
        PostDTO post = boardService.postDetail(idx);
        model.addAttribute("post", post);
        return "board/post_detail";
    }

    @DeleteMapping("/post/{idx}")
    public String deletePost(@PathVariable("idx") Integer idx){
        boardService.deletePost(idx);
        return "redirect:/board";
    }

}
