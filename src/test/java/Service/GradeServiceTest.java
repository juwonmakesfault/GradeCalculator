package Service;

import Domain.Grade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {
    
    @Mock
    Grade grade;

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
