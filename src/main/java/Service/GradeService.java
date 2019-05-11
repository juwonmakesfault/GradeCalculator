package Service;

import Domain.Grade;
import Repository.GradeRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GradeService {

    private GradeRepository gradeRepository;

    public double calculateGPA(){
        int totalCredit = 0;
        double cGPA = 0;
        Grade cur_grade;

        Iterator<Grade> Grades = gradeRepository.getGrades().iterator();
        while(Grades.hasNext()) {
            cur_grade = Grades.next();
            totalCredit += cur_grade.getCredit();

            cGPA += cur_grade.getCredit() * alpha2Number(cur_grade);


        }

        return (cGPA/totalCredit);
    }

    public double alpha2Number(Grade cur_grade){
        if(cur_grade.getGrade().equals("A+")){
            return cur_grade.getCredit() * 4.5;
        } else if(cur_grade.getGrade().equals("A0")){
            return cur_grade.getCredit() * 4.0;
        } else if(cur_grade.getGrade().equals("B+")){
            return cur_grade.getCredit() * 3.5;
        } else if(cur_grade.getGrade().equals("B0")){
            return cur_grade.getCredit() * 3.0;
        } else if(cur_grade.getGrade().equals("C+")){
            return cur_grade.getCredit() * 2.5;
        } else if(cur_grade.getGrade().equals("C0")) {
            return cur_grade.getCredit() * 2.0;
        } else if(cur_grade.getGrade().equals("D+")){
            return cur_grade.getCredit() * 1.5;
        } else if(cur_grade.getGrade().equals("D0")){
            return cur_grade.getCredit() * 1.0;
        } else if(cur_grade.getGrade().equals("F")){
            return cur_grade.getCredit() * 0;
        }
        return -1;
    }


    public String FetchSubject(String subject_name){
        Grade cur_grade;

        List<Grade> fetch_grades = new ArrayList<Grade>();

        Iterator<Grade> Grades = gradeRepository.getGrades().iterator();
        while(Grades.hasNext()) {
            cur_grade = Grades.next();
            if(cur_grade.getSubject().equals(subject_name))
                return cur_grade.getGrade();
        }

        return null;
    }

    public List<Grade> FetchGrade(String find){
        Grade cur_grade;

        List<Grade> fetch_grades = new ArrayList<Grade>();

        Iterator<Grade> Grades = gradeRepository.getGrades().iterator();
        while(Grades.hasNext()) {
            cur_grade = Grades.next();
            if(cur_grade.getGrade().equals(find))
                fetch_grades.add(cur_grade);
        }

        return fetch_grades;
    }


}
