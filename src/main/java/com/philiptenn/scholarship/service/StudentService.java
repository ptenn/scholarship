package com.philiptenn.scholarship.service;

import com.philiptenn.scholarship.exception.StudentNotFound;
import com.philiptenn.scholarship.model.Student;

import java.util.List;

/**
 * @author <a href="mailto:ptenn@users.noreply.github.com">Philip Tenn</a>
 */
public interface StudentService {

    public Student create(Student shop);
    public Student delete(int id) throws StudentNotFound;
    public List<Student> findAll();
    public Student update(Student shop) throws StudentNotFound;
    public Student findById(int id);
}
