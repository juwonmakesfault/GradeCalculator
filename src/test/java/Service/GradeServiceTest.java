package Service;

import Domain.Grade;
import Repository.GradeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {
    
    @Mock
    Grade grade;

    @Spy
    GradeRepository gradeRepository;

    @InjectMocks
    GradeService gradeService;
  
    @Test
    public void setGradeTest(){
        grade.setGrade("A0");
        verify(grade,times(1)).setGrade(anyString());
    }
    
    @Test
    public void setCreditTest(){
        Grade grade1 = new Grade(null, null, 0);
        grade1.setCredit(3);
        assertTrue(grade1.getCredit()>=0);
    }

    @Test
    public void upperCaseTest() {
        Grade grade = new Grade("a+", null, 0);
        assertTrue(Character.isUpperCase(grade.getGrade().charAt(0)));
    }

    @Test
    public void isGradeTest(){
        Grade grade = new Grade("E0", null, 0);
        assertThat( grade.getGrade().charAt(0) , anyOf(is('A'), is('B'), is('C'), is('D'), is('F') ));
    }
  
    @Test
    public void isAddOn(){
        Grade grade = new Grade("A+", null, 0);
        assertThat( grade.getGrade().charAt(1) , anyOf(is('+'), is('0')));
    }
  
    @Test
    public void calculateCurrentGPA(){
        gradeRepository.insertGrade(new Grade("A+", "sub1", 3));
        gradeRepository.insertGrade(new Grade("A+", "sub2", 3));
        assertThat(gradeService.calculateGPA(), is(4.5));
    }

    @Test
    public void FetchRealCodingGrade(){
        gradeRepository.insertGrade(new Grade("A+", "실전코딩", 2));
        assertThat(gradeService.FetchSubject("실전코딩"), is("A+"));
    }
    
    @Test
    public void FetchGradesTest(){
        gradeRepository.insertGrade(new Grade("A+", "실전코딩", 2));
        gradeRepository.insertGrade(new Grade("B0", "IT영어", 1));
        gradeRepository.insertGrade(new Grade("A+", "데이터통신", 3));
        gradeRepository.insertGrade(new Grade("A+", "운영체제및실습", 3));
        gradeRepository.insertGrade(new Grade("B+", "웹프로그래밍", 3));

        assertThat(gradeService.FetchGrade("A+").size(), is(3));
    }    
}
