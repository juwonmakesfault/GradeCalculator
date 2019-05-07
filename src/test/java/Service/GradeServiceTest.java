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
    
}
