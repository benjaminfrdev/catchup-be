package com.project.be.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDTO {

    private String uuid;
    private String phoneNumber;
    private String name;
    private String avatar;
    private String status;


}

