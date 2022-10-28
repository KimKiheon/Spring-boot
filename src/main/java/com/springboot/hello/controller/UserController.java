package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.dto.UserReqDTO;
import com.springboot.hello.domain.dto.UserResDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserDao userDao;

    public UserController(UserDao userDao) throws SQLException {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String Hello() {
        return "Hello World";
    }

    @PostMapping("")
    public ResponseEntity<Void> add(@RequestBody UserReqDTO dto) {
        userDao.add(dto.toEntity());
        return ResponseEntity.status(201).build(); // Created
    }

    @DeleteMapping("/user")
    public ResponseEntity<Integer> deleteAll() {
        return ResponseEntity.ok().body(userDao.deleteAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResDTO> findById(@PathVariable("id") String id) throws SQLException {
        return ResponseEntity.ok(UserResDTO.form(userDao.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) {
        userDao.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
