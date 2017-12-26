
import com.webtest.springboot.SpringBootRestApiApp;
import com.webtest.springboot.model.User;
import com.webtest.springboot.repository.UserRepository;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = {SpringBootRestApiApp.class})
public class RestControllerTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void testPersist() {
        User user1 = new User("fn1", "ln1", "un1", "pass1");
        user1.setId("id1");
        User user2 = new User("fn2", "ln2", "un2", "pass2");
        user2.setId("id2");
        
        entityManager.persist(user1);
        entityManager.flush();
        entityManager.persist(user2);
        entityManager.flush();
        
        List<User> findByLastName = userRepository.findAll();
        assertThat(findByLastName.size()).isEqualTo(2);
        
        User found = findByLastName.get(0);
        assertThat(found.getFirstName()).isEqualTo(user1.getFirstName());
    }
}
