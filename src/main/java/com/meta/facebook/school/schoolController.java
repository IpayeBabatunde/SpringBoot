package com.meta.facebook.school;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class schoolController {

    private final schoolService schoolService;

    public schoolController(schoolService schoolService) {
        this.schoolService=schoolService;

    }

    @PostMapping("/schools")
    public schoolDto create(
            @RequestBody schoolDto dto
    ) {

        return schoolService.create(dto);
    }



    @GetMapping("/schools")
    public List<schoolDto> findAll() {

      return schoolService.findAll();
    }
}
