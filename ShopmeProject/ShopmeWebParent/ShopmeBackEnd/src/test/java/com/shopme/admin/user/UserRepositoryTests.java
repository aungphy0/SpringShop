package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shopme.admin.repositories.UserRepository;
import com.shopme.common.entities.Role;
import com.shopme.common.entities.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        Role roleAdmin = entityManager.find(Role.class, 1);
        User user1 = new User("aphyo2323@gmail.com", "1234", "Aung", "Phyo");
        user1.addRole(roleAdmin);

        User savedUser = repo.save(user1);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateNewUserWithTwoRoles(){
        User userRavi = new User("ravi@gmail.com", "ravi2020", "Ravi", "Kumar");
        Role roleEditor = new Role(3);
        Role roleAssistant = new Role(5);

        userRavi.addRole(roleEditor);
        userRavi.addRole(roleAssistant);

        User savedUser = repo.save(userRavi);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers(){
        Iterable<User> listUsers = repo.findAll();
        listUsers.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserById(){
        User username = repo.findById(1).get();
        System.out.println(username);
        assertThat(username).isNotNull();
    }

    @Test
    public void testUpdateUserRoles(){
        User userRavi = repo.findById(2).get();
        Role roleEditor = new Role(3);
        Role roleSalesperson = new Role(2);

        userRavi.getRoles().remove(roleEditor);
        userRavi.addRole(roleSalesperson);

        repo.save(userRavi);
    }

    @Test
    public void testDeleteUser(){
        Integer userId = 2;
        repo.deleteById(userId);
    }
    
}
