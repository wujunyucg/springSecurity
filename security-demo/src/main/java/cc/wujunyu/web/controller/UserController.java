package cc.wujunyu.web.controller;

import cc.wujunyu.dto.User;
import cc.wujunyu.dto.UserQueryCondition;
import cc.wujunyu.security.app.social.AppSignUpUtils;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private AppSignUpUtils appSignUpUtils;

    @GetMapping("/me")
    public Object getCurrentUser(Authentication authentication) {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @PostMapping("/regist")
    public void regist(User user, HttpServletRequest request) {
        String userId = user.getUserName();

        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
        appSignUpUtils.doPostSignUp(new ServletWebRequest(request), userId);
    }

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
    @ApiOperation(value = "用户查询操作")
    public List<User> query(UserQueryCondition userName) {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam(value = "用户id") @PathVariable() String id) {
//        throw new UserNotExistException(id);
        System.out.println("getInfo start");
        User user = new User();
        user.setUserName("tom");
        return user;
    }
}
