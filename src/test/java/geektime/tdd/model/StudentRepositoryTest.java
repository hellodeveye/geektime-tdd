package geektime.tdd.model;

import geektime.tdd.model.Student;
import geektime.tdd.model.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kim.yang
 * @date 2022/11/26 11:47 上午
 */
class StudentRepositoryTest {


    private EntityManagerFactory factory;

    private EntityManager manager;

    private StudentRepository repository;

    private Student john;


    @BeforeEach
    public void before() {
        factory = Persistence.createEntityManagerFactory("student");
        manager = factory.createEntityManager();
        repository = new StudentRepository(manager);
        manager.getTransaction().begin();
        john = repository.save(new Student("john", "smith", "join.smith@email.com"));
        manager.getTransaction().commit();

    }


    @AfterEach
    public void after() {
        manager.clear();
        manager.close();
        factory.close();
    }


    @Test
    public void should_generate_id_for_saved_entity() {
        assertNotEquals(0, john.getId());
    }

    @Test
    public void should_be_able_load_saved_student_by_id() {
        Optional<Student> loaded = repository.findById(john.getId());
        assertTrue(loaded.isPresent());

        assertEquals(john.getFirstName(), loaded.get().getFirstName());
        assertEquals(john.getLastName(), loaded.get().getLastName());
        assertEquals(john.getEmail(), loaded.get().getEmail());
        assertEquals(john.getId(), loaded.get().getId());
    }


    @Test
    public void should_be_able_load_saved_student_by_email() {
        Optional<Student> loaded = repository.findByEmail(john.getEmail());
        assertTrue(loaded.isPresent());

        assertEquals(john.getFirstName(), loaded.get().getFirstName());
        assertEquals(john.getLastName(), loaded.get().getLastName());
        assertEquals(john.getEmail(), loaded.get().getEmail());
        assertEquals(john.getId(), loaded.get().getId());
    }
}