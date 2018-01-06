package cc.wujunyu.security.core.validate.code;

import cc.wujunyu.security.core.properties.SecurityProperties;
import cc.wujunyu.security.core.validate.code.images.ImageCode;
import cc.wujunyu.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class ValidateCodeController {



    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;


    @GetMapping("/code/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response,@PathVariable String type)
            throws Exception {
        validateCodeProcessors.get(type+"CodeProcessor").create(new ServletWebRequest(request, response));
    }



}
