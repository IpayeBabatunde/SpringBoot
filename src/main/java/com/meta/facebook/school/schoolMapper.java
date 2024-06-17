package com.meta.facebook.school;

import org.springframework.stereotype.Service;

@Service
public class schoolMapper {
        public school toSchool (schoolDto dto) {

            return new school(dto.name());
        }
        public schoolDto toSchoolDto (school school){

            return new schoolDto(school.getName());
        }
}
