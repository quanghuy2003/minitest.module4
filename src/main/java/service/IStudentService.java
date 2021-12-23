package service;

import model.Student;

public interface IStudentService extends IGeneralService<Student>{
    Iterable<Student>findAllByOrderByScoreAsc();
    Iterable<Student>findByName(String name);

}
