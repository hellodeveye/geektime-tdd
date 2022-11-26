import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Optional;

/**
 * @author kim.yang
 * @date 2022/11/26 10:03 上午
 */
public class TestApplication {


    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("student");

        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        StudentRepository studentRepository = new StudentRepository(entityManager);

        Student john = new Student("john", "smith", "john.smith@email.com");

        studentRepository.save(john);

        entityManager.getTransaction().commit();

        System.out.println(john.getId());

        Optional<Student> loaded = studentRepository.findById(john.getId());

        System.out.println(loaded);
    }
}
