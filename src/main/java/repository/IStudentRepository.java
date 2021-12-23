package repository;

import model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.jar.JarEntry;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
        Iterable<Student>findAllByOrderByScoreAsc();
        Iterable<Student>findByName(String name);

}
