package test_task.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test_task.demo.model.Users;

@Repository
public interface UsersRepositor extends JpaRepository<Users, String> {
}
