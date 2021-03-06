package com.ruge.shiro.helloword;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author 爱丽丝、如歌
 * @Description: TODO
 * @date 2017/12/29 12:48
 */
public class JdbcRealm {
    public static void main(String[] args) {
        /**
         * 读取配置文件，初始化 SecurityManager 工厂
         */
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:JdbcRealm.ini");
        /**
         * 获取 SecurityManager 实例
         */
        SecurityManager securityManager =  factory.getInstance();
        /**
         * 把 securityManager 实例 绑定到 SecurityUtils
         */
        SecurityUtils.setSecurityManager(securityManager);
        /**
         * 得到当前执行的用户
         */
        Subject subject = SecurityUtils.getSubject();
        /**
         * 创建 token 令牌
         */
        UsernamePasswordToken token = new UsernamePasswordToken("1","1");

        try{
        /**
         * 身份认证
         */
        subject.login(token);
        System.out.println("登录成功");
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("登录失败");
        }
        /**
         * 退出
         */
        subject.logout();



    }
}
