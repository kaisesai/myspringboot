package com.liukai.myspringboot;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class)
// @SpringBootTest
public class MyspringbootApplicationTests {

  @Test
  public void contextLoads() {
  }

  @Test
  public void testRandom() {
    // 随机抽奖
    for (int i = 0; i < 100; i++) {
      int winnerIndex = RandomUtils.nextInt(0, 100);
      System.out.println("winner: " + winnerIndex);
    }
  }

}
