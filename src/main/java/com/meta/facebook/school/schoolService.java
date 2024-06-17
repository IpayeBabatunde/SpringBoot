package com.meta.facebook.school;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class schoolService {

    private final schoolMapper schoolMapper;
    private final schoolRepository schoolRepository;
    public schoolService(com.meta.facebook.school.schoolMapper schoolMapper, com.meta.facebook.school.schoolRepository schoolRepository) {
        this.schoolMapper=schoolMapper;
        this.schoolRepository=schoolRepository;
    }

    public schoolDto create(
            schoolDto dto
    ) {
        var school = schoolMapper.toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }
    public List<schoolDto> findAll() {

        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }
}
