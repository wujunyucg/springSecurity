package cc.wujunyu.web.controller;

import cc.wujunyu.dto.User;
import cc.wujunyu.dto.UserQueryCondition;
import cc.wujunyu.exception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                System.out.println(error.getDefaultMessage());
            });
        }
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public User delete(@PathVariable String id) {
        return null;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user) {
//        if (errors.hasErrors()) {
//            errors.getAllErrors().stream().forEach(error ->
//                    System.out.println(error.getDefaultMessage()));
//        }
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition userName, Pageable pageable) {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable() String id) {
        throw new UserNotExistException(id);
//        User user = new User();
//        user.setUserName("tom");
//        return user;
    }
}
