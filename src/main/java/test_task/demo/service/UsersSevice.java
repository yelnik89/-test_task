package test_task.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import test_task.demo.model.Users;

import java.util.List;

@Service
public class UsersSevice {

    @Autowired
    private UsersRepositor usersRepository;

    public void delete(String id) {
        usersRepository.delete(this.getUsersById(id));
    }

    public Users create(Users user){
        return usersRepository.save(user);
    }

    public Users update(String id, Users newUser){
        Users originalUser = getUsersById(id);
        if (!originalUser.getId().equals(id)){
            throw new IllegalStateException("Mismatch of user id's!");
        }
        newUser.setId(originalUser.getId());
        return usersRepository.save(newUser);
    }

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public Users getUsersById(String id){
        return usersRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
