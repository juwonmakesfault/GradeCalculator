package Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Grade {

    private String grade;
    private String subject;
    private int credit;

}
