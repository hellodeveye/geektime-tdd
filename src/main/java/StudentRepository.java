
import jakarta.persistence.EntityManager;

import java.util.Optional;

/**
 * @author kim.yang
 * @date 2022/11/26 10:01 上午
 */
public class StudentRepository {
    private EntityManager manager;

    public StudentRepository(EntityManager manager) {
        this.manager = manager;
    }


    public Student save(Student student){
        manager.persist(student);
        return student;
    }

    public Optional<Student> findById(long id){
        return Optional.ofNullable(manager.find(Student.class,id));
    }
}
