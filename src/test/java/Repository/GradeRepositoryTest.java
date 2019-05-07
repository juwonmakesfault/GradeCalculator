package Repository;

import org.junit.Test;
import org.mockito.Spy;

import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class GradeRepositoryTest {
    @Spy
    private GradeRepository gradeRepository;

    @Test
    public void getGradeTest(){
        assertThat(gradeRepository.getGrades(), instanceOf(List.class));
    }

}