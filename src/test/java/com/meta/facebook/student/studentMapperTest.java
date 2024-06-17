package com.meta.facebook.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class studentMapperTest {

        private studentMapper studentMapper;

         @BeforeEach
         void setUp() {
        studentMapper = new studentMapper();
    }

    @Test
        public void shouldMapStudentDtoToStudent() {
            studentDto dto = new studentDto(
                    "Mary",
                    "Lesley",
                    "maryles@gmail.com",
                    1
            );
            student student = com.meta.facebook.student.studentMapper.toStudent(dto);

        Assertions.assertEquals(dto.firstName(), student.getFirstName());
        Assertions.assertEquals(dto.lastName(), student.getLastName());
        Assertions.assertEquals(dto.email(), student.getEmail());
        Assertions.assertNotNull(student.getSchool());
        Assertions.assertEquals(dto.schoolId(), student.getSchool().getId());
        }

        @Test
        public void shouldThrowNullPointerExceptionWhenStudentDtoIsNull (){
          var exp = Assertions.assertThrows(NullPointerException.class, () -> com.meta.facebook.student.studentMapper.toStudent(null));
          Assertions.assertEquals("The Student Dto should not be null", exp.getMessage());

         }

        @Test
        public void shouldMapStudentToStudentResponseDto(){
             // Given the object
                student student = new student(
                        "Mark",
                        "Zuckerberg",
                        "markz@gmail.com",
                        49
                );
                // when
                studentResponseDto responseDto = com.meta.facebook.student.studentMapper.tostudentResponseDto(student);

                // then
            Assertions.assertEquals(responseDto.firstName(), student.getFirstName());
            Assertions.assertEquals(responseDto.lastName(), student.getLastName());
            Assertions.assertEquals(responseDto.email(), student.getEmail());


        }
}