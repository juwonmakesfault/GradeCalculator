package Service;

import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GradeServiceTest {
    @Mock
    Grade grade;
  

    @Test
    public void setGradeTest(){
      grade.setGrade("A0");
      verify(grade,times(1)).setGrade(anyString());
    }
}
