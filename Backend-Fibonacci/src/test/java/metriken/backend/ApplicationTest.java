package metriken.backend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Test
    public void contextLoads() {
    }

    @Test
    public void contextTest() {
        Application.main(new String[]{});
    }
}
