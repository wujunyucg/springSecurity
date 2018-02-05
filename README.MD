## 使用方法
1.引入依赖(pom.xml)
<dependency>
	<groupId>com.wujunyu.security</groupId>
	<artifactId>wujunyu-security-browser</artifactId>
	<version>1.0.0-SNAPSHOT</version>
</dependency>

2.配置系统(参见 application-example.properties)

3.增加UserDetailsService接口实现

4.如果需要记住我功能，需要创建数据库表(参见 db.sql)

5.如果需要社交登录功能，需要以下额外的步骤
1).配置appId和appSecret
2).创建并配置用户注册页面，并实现注册服务(需要配置访问权限)，注意在服务中要调用ProviderSignInUtils的doPostSignUp方法。
3).添加SocialUserDetailsService接口实现
4).创建社交登录用的表 (参见 db.sql)

## 扩展点
向spring容器注册以下接口的实现，可以替换默认的处理逻辑

1.密码加密解密策略
org.springframework.security.crypto.password.PasswordEncoder

2.表单登录用户信息读取逻辑
org.springframework.security.core.userdetails.UserDetailsService

3.社交登录用户信息读取逻辑
org.springframework.social.security.SocialUserDetailsService

4.Session失效时的处理策略
org.springframework.security.web.session.InvalidSessionStrategy

5.并发登录导致前一个session失效时的处理策略配置
org.springframework.security.web.session.SessionInformationExpiredStrategy

6.退出时的处理逻辑
org.springframework.security.web.authentication.logout.LogoutSuccessHandler

7.短信发送的处理逻辑
com.wujunyu.security.core.validate.code.sms.SmsCodeSender

8.向spring容器注册名为imageValidateCodeGenerator的bean，可以替换默认的图片验证码生成逻辑,bean必须实现以下接口
com.wujunyu.security.core.validate.code.ValidateCodeGenerator

9.如果spring容器中有下面这个接口的实现，则在社交登录无法确认用户时，用此接口的实现自动注册用户，不会跳到注册页面
org.springframework.social.connect.ConnectionSignUp

## 可配置项
```aidl
#浏览器环境配置项，参见BrowserProperties
#wujunyu.security.browser.signInPage = /demo-signIn.html
#wujunyu.security.browser.signInResponseType = REDIRECT
#wujunyu.security.browser.singInSuccessUrl = /manage.html
#wujunyu.security.browser.rememberMeSeconds = 294000
#wujunyu.security.browser.signOutUrl = /demo-logout.html
#wujunyu.security.browser.signUpUrl = /demo-signUp.html

#session管理相关配置，参见SessionProperties
#wujunyu.security.browser.session.maximumSessions = 1
#wujunyu.security.browser.session.maxSessionsPreventsLogin = false
#wujunyu.security.browser.session.sessionInvalidUrl = /wujunyu-session-invalid.html

#图片验证码配置项，参见ImageCodeProperties
#wujunyu.security.code.image.length = 4
#wujunyu.security.code.image.width = 100
#wujunyu.security.code.image.height = 30
#wujunyu.security.code.image.expireIn = 30
#wujunyu.security.code.image.url = /user/*

#短信验证码配置项，参见SmsCodeProperties
#wujunyu.security.code.sms.length = 6
#wujunyu.security.code.sms.expireIn = 60
#wujunyu.security.code.sms.url = /user/*

#社交登录功能拦截的url,参见SocilaProperties
#wujunyu.security.social.filterProcessesUrl = /qqLogin

#QQ登录配置，参见QQProperties
#wujunyu.security.social.qq.app-id = 
#wujunyu.security.social.qq.app-secret = 
#wujunyu.security.social.qq.providerId = callback.do

#微信登录配置，参见WeixinProperties
#wujunyu.security.social.weixin.app-id = wxd99431bbff8305a0
#wujunyu.security.social.weixin.app-secret = 60f78681d063590a469f1b297feff3c4
#wujunyu.security.social.weixin.providerId = weixin

#认证服务器注册的第三方应用配置项，参见OAuth2ClientProperties
#wujunyu.security.oauth2.clients[0].clientId = wujunyu
#wujunyu.security.oauth2.clients[0].clientSecret = wujunyusecret
#wujunyu.security.oauth2.clients[0].accessTokenValidateSeconds = 3600
#wujunyu.security.oauth2.clients[1].clientId = test
#wujunyu.security.oauth2.clients[1].clientSecret = test

#OAuth2认证服务器的tokenStore的类型，可选值为redis和jwt，值为jwt时发出的token为jwt
#wujunyu.security.oauth2.tokenStore = redis
#使用jwt时为token签名的秘钥
#wujunyu.security.oauth2.jwtSigningKey = wujunyu
```
## sql
```aidl
-- 记住我功能用的表
create table persistent_logins (username varchar(64) not null,
								series varchar(64) primary key,
								token varchar(64) not null,
								last_used timestamp not null);
-- 社交登录用的表
create table imooc_UserConnection (userId varchar(255) not null,
	providerId varchar(255) not null,
	providerUserId varchar(255),
	rank int not null,
	displayName varchar(255),
	profileUrl varchar(512),
	imageUrl varchar(512),
	accessToken varchar(512) not null,
	secret varchar(512),
	refreshToken varchar(512),
	expireTime bigint,
	primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on imooc_UserConnection(userId, providerId, rank);

```
