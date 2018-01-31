package cc.wujunyu.security.core.properties;

public class WeixinProperties extends SocialProperties {
    private String providerId = "weixin";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
