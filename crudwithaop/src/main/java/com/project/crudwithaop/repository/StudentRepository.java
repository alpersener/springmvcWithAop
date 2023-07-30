package com.project.crudwithaop.repository;
import com.project.crudwithaop.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findAllByOrderByFirstName();
}
