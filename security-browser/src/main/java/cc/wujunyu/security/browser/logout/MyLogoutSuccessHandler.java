package cc.wujunyu.security.browser.logout;

import cc.wujunyu.security.core.support.SimpleResponse;
import cc.wujunyu.security.core.properties.SecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private SecurityProperties securityProperties;

    private ObjectMapper objectMapper = new ObjectMapper();

    public MyLogoutSuccessHandler(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse
            , Authentication authentication) throws IOException, ServletException {
        logger.info("退出成功");
        String signOutUrl = securityProperties.getBrowser().getSignOutUrl();
        if(StringUtils.isBlank(signOutUrl)) {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse("退出成功")));
        } else {
            httpServletResponse.sendRedirect(signOutUrl);
        }
    }
}
