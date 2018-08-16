package com.liukai.myspringboot.common.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自定义的spring条件类
 *
 * @author liukai
 */
public class MySpringCondition implements Condition {

  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    try {
      // TODO: 2018/7/22 在此加载想要加载的类
      context.getClassLoader().loadClass("org.springframework.jdbc.core.JdbcTemplate");
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }
}
