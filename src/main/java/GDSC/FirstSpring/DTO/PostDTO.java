package GDSC.FirstSpring.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostDTO {
    private Integer idx;
    private String title;
    private String context;
}
