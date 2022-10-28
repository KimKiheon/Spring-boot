package jdbc.userdao.controller;

import jdbc.userdao.dao.UserDao;
import jdbc.userdao.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserDao userDao = null;

    public UserController(UserDao userDao) throws SQLException {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String Hello() {
        return "Hello World";
    }

    @GetMapping("/user")
    public User addAndGet() throws SQLException {
        userDao.add(new User("2", "kiheon", "3333"));
        return userDao.findByID("2");
    }
    @DeleteMapping("/user")
    public ResponseEntity<Integer> deleteAll(){
        return ResponseEntity.ok().body(userDao.deleteAll());
    }
}
