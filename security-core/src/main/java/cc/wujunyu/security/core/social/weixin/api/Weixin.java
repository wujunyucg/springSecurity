package cc.wujunyu.security.core.social.weixin.api;

public interface Weixin {

    WeixinUserInfo getUserInfo(String openId);
}
