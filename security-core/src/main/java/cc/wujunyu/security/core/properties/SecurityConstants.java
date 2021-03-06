package cc.wujunyu.security.core.properties;

public interface SecurityConstants {
    /**
     * 默认的用户名密码登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";
    /**
     * 默认的手机验证码登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/authentication/mobile";
    /**
     * 当请求需要身份认证时，默认跳转的url
     *
     * @see SecurityController
     */
    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
    /**
     * 默认登录页面
     *
     * @see SecurityController
     */
    String DEFAULT_LOGIN_PAGE_URL = "/login.html";
    /**
     * 默认注册页面
     */
    String DEFAULT_SIGN_UP_URL = "/sign-up.html";
    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    /**
     * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
    /**
     * session失效默认的跳转地址
     */
    String DEFAULT_SESSION_INVALID_URL = "/default-session-timeout.html";

    /**
     * <pre>默认的openid登录处理的接口地址</pre>
     */
    String DEFAULT_LOGIN_PROCESS_URL_OPENID = "/authentication/openid";
    /**
     * <pre>openId参数名称</pre>
     */
    String DEFAULT_PARAMETER_NAME_OPENID = "openId";

    /**
     * <pre>服务提供商的参数名称</pre>
     */
    String DEFAULT_PARAMETER_NAME_PROVIDERID = "providerId";

    /**
     * <pre>默认的OAuth2的应用Id</pre>
     */
    String DEFAULT_OAUTH_CLIENT_CLIENTID = "wujunyu";

    /**
     * <pre>默认的OAuth2的应用Secret</pre>
     */
    String DEFAULT_OAUTH_CLIENT_CLIENTSECRET = "wujunyusecurity";
}
