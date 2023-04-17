package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

  @DisplayName("패스워드 초기화한다.")
  @Test
  void passwordTest() {
    // given
    User user = new User();  // user객체가 주어졌고,

    // when
    user.initPassword(() -> "abcdefgf");   // 이 메소드로 호출했을 때

    // then
    assertThat(user.getPassword()).isNotNull();  // 패스워드가 셋팅이 되면 성공.
  }

  @DisplayName("패스워드가 요구사항에 부합되지 않아 초기화가 되지 않는다.")
  @Test
  void passwordTest2() {
    // given
    User user = new User();  // user객체가 주어졌고,

    // when
    user.initPassword(() -> "Ab");   // 이 메소드로 호출했을 때

    // then
    assertThat(user.getPassword()).isNull();  // 패스워드가 NUll이 되면 성공.
  }
}