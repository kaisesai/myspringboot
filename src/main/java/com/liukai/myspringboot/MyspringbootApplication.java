package com.liukai.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.util.StringUtils;

/**
 * @author liukai
 * <p>
 * 开启组件扫描和自动配置
 * @SpringBootConfiguration
 * @EnableAutoConfiguration
 * @ComponentScan
 */
@SpringBootApplication
public class MyspringbootApplication {

  public static void main(String[] args) {
    // 负责启动引导应用程序
    SpringApplication.run(MyspringbootApplication.class, args);
  }
}
