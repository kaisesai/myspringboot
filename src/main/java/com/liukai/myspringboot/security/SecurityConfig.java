package com.liukai.myspringboot.security;

import com.liukai.myspringboot.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * spring security自定义配置
 *
 * @author liukai
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private ReaderRepository readerRepository;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // 要求登陆者有 READER 权限,设置登录表单的路径
    // http.authorizeRequests().antMatchers("/").access("hasRole('READER')").antMatchers("/**")
    //     .permitAll().and().formLogin().loginPage("/login").failureUrl("/login?error=true");
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // super.configure(web);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    // auth.userDetailsService(new UserDetailsService() {
    //   @Override
    //   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     return readerRepository.findById(username).get();
    //   }
    // });
  }

}

