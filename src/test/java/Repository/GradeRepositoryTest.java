package Repository;

import Domain.Grade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class GradeRepositoryTest {
    @Spy
    private GradeRepository gradeRepository;
    @Mock
    private Grade grade;

    @Test
    public void getGradeTest(){
        assertThat(gradeRepository.getGrades(), instanceOf(List.class));
    }

    @Test
    public void insertTest(){
        grade.setGrade("A0");
        gradeRepository.insertGrade(grade);
        List<Grade> grades =  gradeRepository.getGrades();
        assertThat(grades.size(),is(1));
    }
}