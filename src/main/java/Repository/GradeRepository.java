package Repository;

import Domain.Grade;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GradeRepository {
    private List<Grade> grades = new ArrayList<Grade>();

    public void insertGrade(Grade grade){
        grades.add(grade);
    }
}
