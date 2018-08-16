package com.liukai.myspringboot.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

@Data
@Entity
public class Reader implements UserDetails {

  private static final long serialVersionUID = 1L;

  @Id
  private String username;

  private String fullname;

  private String password;

  // UserDetails methods

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // 赋予 READER 权限
    return Arrays.asList(new SimpleGrantedAuthority("READER"));
  }

  @Override
  public boolean isAccountNonExpired() {
    // 不过期
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // 不加锁
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    // 不禁用
    return true;
  }

}
