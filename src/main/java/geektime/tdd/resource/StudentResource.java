package geektime.tdd.resource;

import geektime.tdd.model.Student;
import geektime.tdd.model.StudentRepository;
import jakarta.inject.Inject;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

/**
 * @author kim.yang
 * @date 2022/11/26 12:06 下午
 */
@Path("/students")
public class StudentResource {

    private StudentRepository repository;

    public StudentResource() {
        var factory = Persistence.createEntityManagerFactory("student");
        var manager = factory.createEntityManager();
        repository = new StudentRepository(manager);
        ;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> all() {
        return repository.all();
    }
}
