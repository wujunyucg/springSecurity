package cc.wujunyu.security.core.validate.code.images;

import cc.wujunyu.security.core.validate.code.ValidateCode;
import cc.wujunyu.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import cc.wujunyu.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

@Component("imageCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    /**
     * 验证码发送器
     */
    @Autowired
    private SmsCodeSender smsCodeSender;


    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        ImageIO.write(((ImageCode) validateCode).getImage(), "JPEG", request.getResponse().getOutputStream());
    }

}
