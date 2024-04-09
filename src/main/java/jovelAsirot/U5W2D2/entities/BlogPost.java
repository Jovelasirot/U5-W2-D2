package jovelAsirot.U5W2D2.entities;

import jovelAsirot.U5W2D2.enums.Category;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogPost {

    private long id;

    private Category category;

    private String cover;

    private String content;
    
    private int readingTime;
}
