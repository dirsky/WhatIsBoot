package com.frank.boot.config.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过class类来实现对shiro的配置，其本质如同直接在ini文件内进行配置
 * @author GuoZhong Xu
 * @date 2019/05/13 11:59
 * @version 1.0
 */
@Configuration
public class MyShiroConfig {

    /**
     * 凭证匹配器（由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了）
     * @return 返回HashedCredentialsMatcher并注入bean直接生效
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //散列的次数，比如散列两次，相当于 md5(md5(""));
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }

    /**
     * 将自定义ShiroRealm配置给shiro的ShiroRealm
     * ？疑惑：为啥要注入bean，不是在getSecurityManager引用了吗？
     * @return 自定义ShiroRealm
     */
    @Bean
    public ShiroRealm getShiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return shiroRealm;
    }

    /**
     * 将ShiroRealm配置给shiro的SecurityManager
     * @return SecurityManager
     */
    @Bean
    public SecurityManager getSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getShiroRealm());
        return securityManager;
    }
}
