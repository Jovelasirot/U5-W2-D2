package jovelAsirot.U5W2D2.entities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogAuthor {

    private long id;

    private String name;

    private String surname;

    private String email;

    private LocalDate birthDate;

    private String avatar;
}
