package com.meta.facebook.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import com.meta.facebook.student.studentService;
import com.meta.facebook.student.studentRepository;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest;
import com.meta.facebook.student.studentMapper;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class studentServiceTest {

    // which service we want to test

    @InjectMocks
    private studentService studentService;

    //declare the dependencies

    @Mock
    private studentRepository repository;

    @Mock
    private studentMapper studentMapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void shouldSuccessfullySaveAStudent(){
        // Given
        studentDto studentDto = new studentDto(
                "Ryan",
                "Scott",
                "Ryanst@gmail.com",
                1
        );
        student student = new student(
                "Ryan",
                "Scott",
                "Ryanst@gmail.com",
                23
        );
        student savedStudent = new student(
                "Ryan",
                "Scott",
                "Ryanst@gmail.com",
                23
        );
        savedStudent.setId(1);
        // Mock the calls
        when(com.meta.facebook.student.studentMapper.toStudent(studentDto)).thenReturn(student);
        when(repository.save(student))
                .thenReturn(savedStudent);
        when(com.meta.facebook.student.studentMapper.tostudentResponseDto(savedStudent))
                .thenReturn(new studentResponseDto(
                        "Ryan",
                        "Scott",
                        "Ryanst@gmail.com"));
        // when

          studentResponseDto responseDto = studentService.saveStudent(studentDto);

        // Then
        Assertions.assertEquals(studentDto.firstName(), responseDto.firstName());
        Assertions.assertEquals(studentDto.lastName(), responseDto.email());
        Assertions.assertEquals(studentDto.email(), responseDto.email());

    }
}