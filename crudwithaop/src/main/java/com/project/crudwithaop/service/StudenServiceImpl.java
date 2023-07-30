package com.project.crudwithaop.service;
import com.project.crudwithaop.dto.StudentDTO;
import com.project.crudwithaop.entity.Student;
import com.project.crudwithaop.mapper.ModelMapperService;
import com.project.crudwithaop.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudenServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<StudentDTO> findAll() {
        List<Student> students=studentRepository.findAllByOrderByFirstName();
        List<StudentDTO> studentDTOS=students.stream()
                .map(student -> this.modelMapperService.getModelMapper()
                        .map(student,StudentDTO.class))
                .collect(Collectors.toList());
        return studentDTOS;

    }

    @Override
    public StudentDTO findById(Long id) {
    Student student=this.studentRepository.findById(id).orElseThrow();
    StudentDTO studentDTO=this.modelMapperService.getModelMapper()
            .map(student,StudentDTO.class);
    return studentDTO;


    }

    @Override
    public void save(StudentDTO studentDTO) {
        Student student=modelMapperService.getModelMapper().map(studentDTO,Student.class);
        studentRepository.saveAndFlush(student);

    }

    @Override
    public void deleteById(Long id) {
        this.studentRepository.deleteById(id);

    }





}
