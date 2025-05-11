package com.ftgrl.library_project_getir.dto;

import com.ftgrl.library_project_getir.entity.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private Role role;
}


