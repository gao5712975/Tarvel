package com.tarvel.shiro.realm;

import com.tarvel.business.admin.user.po.UserEntity;
import com.tarvel.shiro.authz.UsernamePasswordCaptchaToken;
import com.tarvel.shiro.service.ShiroService;
import com.tarvel.shiro.session.LoginUser;
import com.tarvel.util.MD5.MD5Util;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * 验证登录用户
 * @author liujiegang
 */
public class ShiroDataBaseRealm extends AuthorizingRealm {

    @Resource
    private ShiroService shiroService;
    
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if(principals == null){
			throw new AuthorizationException("Principals对象不能为空");
		}
		LoginUser loginUser = (LoginUser) principals.fromRealm(getName()).iterator().next();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.addRoles(shiroService.getPurviews(loginUser.getUserId()));
		return info;
	}
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordCaptchaToken usernamePasswordToken = (UsernamePasswordCaptchaToken) token;

        String validationCode = (String) SecurityUtils.getSubject().getSession().getAttribute("validationCode");
        if(usernamePasswordToken.getCaptcha() == null ||
                !usernamePasswordToken.getCaptcha().equalsIgnoreCase(validationCode)){
//            throw new CaptchaException("验证码错误");
        }

		String password = new String(usernamePasswordToken.getPassword());
        usernamePasswordToken.setPassword(MD5Util.getPasswordWithMD5(password).toCharArray());
		String username = usernamePasswordToken.getUsername();
		UserEntity user = shiroService.findUserByName(username);
		if(user == null){
			throw new AccountException("用户不可用");
		}
		LoginUser loginUser = new LoginUser();
		try {
            PropertyUtils.copyProperties(loginUser, user);
        } catch (Exception e) {
            throw new AuthenticationException("系统错误");
        }
		return new SimpleAuthenticationInfo(loginUser, user.getUserPassword(), getName());
	}

}
