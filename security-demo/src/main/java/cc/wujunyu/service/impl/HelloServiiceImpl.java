package cc.wujunyu.service.impl;

import cc.wujunyu.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiiceImpl implements HelloService {
    @Override
    public String greet(String name) {
        System.out.println("greet");
        return "hello, " + name;
    }
}
