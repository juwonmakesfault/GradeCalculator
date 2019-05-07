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

           if(cur_grade.getGrade().equals("A+")){
               cGPA += cur_grade.getCredit() * 4.5;
           } else if(cur_grade.getGrade().equals("A0")){
               cGPA += cur_grade.getCredit() * 4.0;
           } else if(cur_grade.getGrade().equals("B+")){
               cGPA += cur_grade.getCredit() * 3.5;
           } else if(cur_grade.getGrade().equals("B0")){
               cGPA += cur_grade.getCredit() * 3.0;
           } else if(cur_grade.getGrade().equals("C+")){
               cGPA += cur_grade.getCredit() * 2.5;
           } else if(cur_grade.getGrade().equals("C0")) {
               cGPA += cur_grade.getCredit() * 2.0;
           } else if(cur_grade.getGrade().equals("D+")){
               cGPA += cur_grade.getCredit() * 1.5;
           } else if(cur_grade.getGrade().equals("D0")){
               cGPA += cur_grade.getCredit() * 1.0;
           } else if(cur_grade.getGrade().equals("F")){
               cGPA += cur_grade.getCredit() * 0;
           }
       }

       return (cGPA/totalCredit);
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


}
