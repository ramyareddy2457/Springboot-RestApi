package com.example.SpringBootRestApi.Controller;

import com.example.SpringBootRestApi.Dao.UserDao;
import com.example.SpringBootRestApi.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Company")
public class UserController {
    @Autowired
    private UserDao userDao;

    //    Save an Users
    @PostMapping("/User")
    public Users createUser(@Validated @RequestBody Users u) {
        return userDao.save(u);
    }

    @GetMapping("/AllUser")
    public List<Users> getAllUser() {
        return userDao.findAll();
    }

    @GetMapping("/UserById/{id}")
    public ResponseEntity<Users> getUserByID(@PathVariable(value = "id") int id) {
        Users u = userDao.findById(id);
        if (u == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(u);
    }

    @PutMapping("/UpdateUser/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable(value = "id") int id, @Validated @RequestBody Users usersDetails) {
        Users u = userDao.findById(id);
        if (u == null) {
            return ResponseEntity.notFound().build();
        }
        u.setName(usersDetails.getName());
        u.setAge(usersDetails.getAge());
        u.setDepartment(usersDetails.getDepartment());
        u.setYear(usersDetails.getYear());
        Users updateUser = userDao.save(u);
        return ResponseEntity.ok().body(updateUser);

    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Users> delete(@PathVariable(value = "id") int id) {
        Users u = userDao.findById(id);
        if (u == null) {
            return ResponseEntity.notFound().build();
        }
        userDao.delete(u);
        return ResponseEntity.ok().build();
    }

//
}
