package com.meta.facebook.student;


import jakarta.validation.constraints.NotEmpty;

public record studentDto(
                         @NotEmpty (message = "firstName should not be empty" )
                         String firstName,
                         @NotEmpty   (message = "lastName should not be empty" )
                         String lastName,
                         String email,
                         Integer schoolId)
{


}
