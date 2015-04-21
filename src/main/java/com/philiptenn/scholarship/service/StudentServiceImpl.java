package com.philiptenn.scholarship.service;

import com.philiptenn.scholarship.exception.StudentNotFound;
import com.philiptenn.scholarship.repository.StudentRepository;
import com.philiptenn.scholarship.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author <a href="mailto:ptenn@users.noreply.github.com">Philip Tenn</a>
 */
@Component
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Override
    @org.springframework.transaction.annotation.Transactional
    public Student create(Student student) {
        Student createdStudent = student;
        return studentRepository.save(createdStudent);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public Student findById(int id) {
        return studentRepository.findOne(id);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(rollbackFor=StudentNotFound.class)
    public Student delete(int id) throws StudentNotFound {
        Student deletedStudent = studentRepository.findOne(id);

        if (deletedStudent == null)
            throw new StudentNotFound();

        studentRepository.delete(deletedStudent);
        return deletedStudent;
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(rollbackFor=StudentNotFound.class)
    public Student update(Student student) throws StudentNotFound {
        Student updatedStudent = studentRepository.findOne(student.getId());

        if (updatedStudent == null)
            throw new StudentNotFound();

        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setStudentNumber(student.getStudentNumber());
        return updatedStudent;
    }
}
