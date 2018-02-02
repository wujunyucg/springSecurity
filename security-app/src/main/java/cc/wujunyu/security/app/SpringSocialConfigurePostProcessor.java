package cc.wujunyu.security.app;

import cc.wujunyu.security.core.social.MySpringSocialConfigure;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SpringSocialConfigurePostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (StringUtils.equals(s, "socialSecurityConfig")) {
            MySpringSocialConfigure configure = (MySpringSocialConfigure) o;
            configure.signupUrl("/social/signup");
            return configure;
        }
        return o;
    }
}
