package com.njtech.blogadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author chenxin
 * @date 2021/8/31 13:07
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 配置加密算法
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //配置拦截器,那些需要拦截  那些需要放行，
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()    //开启登录认证
                .antMatchers("/css/**").permitAll()     //静态资源放行
                .antMatchers("/img/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/plugins/**").permitAll()
//                .antMatchers("/admin/**").authenticated()
                .antMatchers("/admin/**").access("@authService.auth(request,authentication)") //自定义service，自定义权限认证 来去实现实时的权限认证
                .antMatchers("/pages/**").authenticated()   //需要登录认证
                .and().formLogin()
                .loginPage("/login.html")   //自定义的登录页面
                .loginProcessingUrl("/login")   //登录请求
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/pages/main.html")  //默认登录成功之后的跳转
                .failureUrl("/login.html")  //，默认登录失败之后的跳转
                .permitAll()        //登录相关接口放行
                .and().logout()
                .logoutUrl("/logout")   //退出登录接口
                .logoutSuccessUrl("/login.html")    //退出登录成功的跳转页面
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()   //csrf关闭 如果自定义登录 需要关闭,判断是否本机浏览器访问
                .headers().frameOptions().sameOrigin();
    }

    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("123456");
        System.out.println(encode);
    }
}
