package Service;

import Domain.Grade;
import Repository.GradeRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GradeService {

    private GradeRepository gradeRepository;

    public double calculateGPA(){
        int totalCredit = 0;
        double cGPA = 0;
        Grade cur_grade;

        Iterator<Grade> Grades = gradeRepository.getGrades().iterator();

        List gradeList = Arrays.asList(new String[] {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"});

        while(Grades.hasNext()) {
            cur_grade = Grades.next();
            totalCredit += cur_grade.getCredit();
            String grade = cur_grade.getGrade();

            if(gradeList.contains(grade))
                cGPA += cur_grade.getCredit() * alpha2Number(gradeList.indexOf(grade));
        }

        return (cGPA/totalCredit);
    }

    public double alpha2Number(int gradeNum){
        if (gradeNum == 9) return 0;
        return (9-gradeNum) * 0.5;
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
