package com.liukai.myspringboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liukai
 */
@NoArgsConstructor
@Data
public class User {

  private String name;

  private String gender;

  private int age;

  private String height;
}
