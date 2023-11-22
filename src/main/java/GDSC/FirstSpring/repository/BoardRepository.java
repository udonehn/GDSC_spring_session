package GDSC.FirstSpring.repository;

import GDSC.FirstSpring.DTO.PostDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    public Map<Integer, PostDTO> mapRepository = new HashMap<>();
    public Integer index = 0;
    public void save(PostDTO post) {
        index += 1;
        post.setIdx(index);
        mapRepository.put(index, post);
    }

    public List<PostDTO> getPosts(){
        return new ArrayList<>(mapRepository.values());
    }

    public PostDTO detail(Integer idx){
        return mapRepository.get(idx);
    }

    public void delete(Integer idx) {
        mapRepository.remove(idx);
    }
}
