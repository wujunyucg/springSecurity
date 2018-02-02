package cc.wujunyu.security.core.properties;

public class OAuth2Properties {

    private OAuth2ClientProperties[] clients = {};

    private String jwtSigningKey = "wujunyu";

    public String getJwtSigningKey() {
        return jwtSigningKey;
    }

    public void setJwtSigningKey(String jwtSigningKey) {
        this.jwtSigningKey = jwtSigningKey;
    }

    public OAuth2ClientProperties[] getClients() {
        return clients;
    }

    public void setClients(OAuth2ClientProperties[] clients) {
        this.clients = clients;
    }
}
