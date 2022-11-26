package geektime.tdd.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
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


    public Student save(Student student) {
        manager.persist(student);
        return student;
    }

    public Optional<Student> findById(long id) {
        return Optional.ofNullable(manager.find(Student.class, id));
    }


    public Optional<Student> findByEmail(String email) {
        TypedQuery<Student> query = manager.createQuery("SELECT s from Student s where s.email = :email", Student.class);
        List<Student> students = query.setParameter("email", email).getResultList();
        return students.stream().findFirst();
    }

    public List<Student> all() {
        TypedQuery<Student> q = manager.createQuery("SELECT s from Student s", Student.class);
        return q.getResultList();
    }
}
