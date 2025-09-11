package com.ygor_h.user_crud.business;

import com.ygor_h.user_crud.infrastructure.entitys.User;
import com.ygor_h.user_crud.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user){
        repository.saveAndFlush(user);
    }

    public User getUserByCpf(String cpf){
        return repository.findByCpf(cpf).orElseThrow(
                () -> new RuntimeException("CPF not found")
        );
    }

    public void deleteUserByCpf(String cpf){
        repository.deleteByCpf(cpf);
    }

    public void updateUserByCpf(String cpf, User user){
        User userEntity = getUserByCpf(cpf);
        User updateUser = User.builder()
                .cpf(cpf)
                .email(user.getEmail() != null ?
                        user.getEmail() : userEntity.getEmail())
                .name(user.getName() != null ?
                        user.getName() : userEntity.getName())
                .id(userEntity.getId())
                .build();

        repository.saveAndFlush(updateUser);
    }
}
