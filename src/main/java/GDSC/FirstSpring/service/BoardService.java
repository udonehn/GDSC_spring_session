package GDSC.FirstSpring.service;

import GDSC.FirstSpring.DTO.PostDTO;
import GDSC.FirstSpring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void write(PostDTO post) {
        boardRepository.save(post);
    }

    public List<PostDTO> getPosts(boolean new_first){
        List<PostDTO> posts = boardRepository.getPosts();
        if (new_first){
            Collections.reverse(posts);
        }
        return posts;
    }

    public PostDTO postDetail(Integer idx){
        return boardRepository.detail(idx);
    }

    public void deletePost(Integer idx) {
        boardRepository.delete(idx);
    }
}
