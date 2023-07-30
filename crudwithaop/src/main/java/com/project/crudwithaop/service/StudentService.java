package com.project.crudwithaop.service;

import com.project.crudwithaop.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    public List<StudentDTO> findAll();

    StudentDTO findById(Long id);

    void save(StudentDTO studentDTO);

    void deleteById(Long id);
}
