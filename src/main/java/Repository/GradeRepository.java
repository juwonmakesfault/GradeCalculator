package Repository;

import Domain.Grade;

import java.util.ArrayList;
import java.util.List;

public class GradeRepository {
    List<Grade> grades = new ArrayList<Grade>();

    public void insertGrade(Grade grade){
        grades.add(grade);
    }

    public List<Grade> getGrades(){
        return grades;
    }
}
