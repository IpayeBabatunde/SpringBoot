package com.meta.facebook.student;

import com.meta.facebook.student.student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface studentRepository extends JpaRepository<student, Integer> {

    List<student> findAllByFirstNameContaining(String firstName);

}
