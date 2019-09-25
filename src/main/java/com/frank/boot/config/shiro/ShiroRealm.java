package com.frank.boot.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 实现自定义的ShiroRealm，其实叫ShiroRealm不合适，例如：UserRealm这样不错。
 * @author GuoZhong Xu
 * @date 2019/05/13 11:54
 * @version 1.0
 */
public class ShiroRealm extends AuthorizingRealm {
    /**
     * 赋权
     * 获取用户角色和权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String userName = (String) token.getPrincipal();
        String password = (String) token.getCredentials();


        return null;
    }
}
