package cc.wujunyu.security.core.properties;

public class BrowserProperties {
    private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;
    private LoginType loginType = LoginType.JSON;
    private int rememberMeSeconds = 3600;
    private String signUpUrl = SecurityConstants.DEFAULT_SIGN_UP_URL;


    private String signOutUrl;
    private SessionProperties session = new SessionProperties();

    public String getSignOutUrl() {
        return signOutUrl;
    }

    public void setSignOutUrl(String signOutUrl) {
        this.signOutUrl = signOutUrl;
    }

    public SessionProperties getSession() {
        return session;
    }

    public void setSession(SessionProperties session) {
        this.session = session;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }
}
