package com.philiptenn.scholarship.repository;

import com.philiptenn.scholarship.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:ptenn@users.noreply.github.com">Philip Tenn</a>
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}