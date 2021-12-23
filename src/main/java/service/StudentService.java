package service;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IStudentRepository;

import java.util.Optional;

public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public Iterable<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        iStudentRepository.deleteById(id);
    }


    @Override
    public Iterable<Student> findAllByOrderByScoreAsc() {
        return iStudentRepository.findAllByOrderByScoreAsc();
    }

    @Override
    public Iterable<Student> findByName(String name) {
        return iStudentRepository.findByName(name);
    }

    @Override
    public Iterable<Student> findAllByScoreGreaterThan(int score) {
        return iStudentRepository.findAllByScoreGreaterThan(8);
    }
}
