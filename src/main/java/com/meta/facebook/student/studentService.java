package com.meta.facebook.student;

import com.meta.facebook.student.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class studentService {

    private final studentRepository repository;

    private final studentMapper studentMapper;

    public studentService(studentRepository repository, studentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }
    public studentResponseDto saveStudent (
            studentDto dto
    ){
        var student = com.meta.facebook.student.studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return com.meta.facebook.student.studentMapper.tostudentResponseDto(savedStudent);
    }

    public List<student> findAllStudent() {

        return repository.findAll();

    }

    public student findStudentById(Integer id) {
        return repository.findById(id)
                .orElse(new student());
    }
    public List<student> findStudentByName(String name) {
        return repository.findAllByFirstNameContaining(name);
    }
    public void delete(Integer id){
        repository.deleteById(id);
    }

}
