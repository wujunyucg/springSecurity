package cc.wujunyu.security.core.validate.code;

import cc.wujunyu.security.core.validate.code.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
