package cc.wujunyu.web.controller;

import cc.wujunyu.dto.User;
import cc.wujunyu.dto.UserQueryCondition;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition userName, Pageable pageable) {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @RequestMapping(value = "user/{id:\\d+}", method = RequestMethod.GET)
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable() String id) {
        User user = new User();
        user.setUserName("tom");
        return user;
    }
}
