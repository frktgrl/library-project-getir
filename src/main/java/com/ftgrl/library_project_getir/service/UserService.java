package com.ftgrl.library_project_getir.service;


import com.ftgrl.library_project_getir.dto.UpdateUserRequest;
import com.ftgrl.library_project_getir.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UpdateUserRequest request);
    void deleteUser(Long id);
}
