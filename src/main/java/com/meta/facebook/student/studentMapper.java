package com.meta.facebook.student;

import com.meta.facebook.school.school;
import org.springframework.stereotype.Service;

@Service
public class studentMapper {

    public static student toStudent(studentDto studentDto) {
        if (studentDto == null) {
            throw new NullPointerException("The Student Dto should not be null");
        }
        var student = new student();
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());

        var school = new school();
        school.setId(studentDto.schoolId());
        student.setSchool(school);

        return student;

    }
    public static studentResponseDto tostudentResponseDto(student student) {
        return new studentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
