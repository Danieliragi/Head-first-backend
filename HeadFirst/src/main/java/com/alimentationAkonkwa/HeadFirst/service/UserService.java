package com.alimentationAkonkwa.HeadFirst.service;


import com.alimentationAkonkwa.HeadFirst.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllClients();
    User createClient(User user);
    User getClientById(Long id);
    Boolean deleteClientById(Long id);
    Boolean updateClientById(Long id, User user);
}
