package org.example;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * * 요구사항
 * - 비밀번호는 최소 8자 이상 12자 이하
 * - 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외 발생시킴
 * - 경계조건에 대해 테스트 코드를 작성해야함
 */
public class PasswordValidatorTest {

  @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.") // 테스트 코드의 의도를 나타냄
  @Test
  void validatePasswordTest() {
    assertThatCode(() -> PasswordValidator.validate("serverwizard"))
        .doesNotThrowAnyException(); // assertThatCode 안에 있는 부분이 실행되었을 때, 예외가 발생하지 않음을 확인
  }

  @DisplayName("비밀번호가 8자 미만, 12자 초과하는 경우 IlligalArgumentException 예외가 발생한다")
  @ParameterizedTest // 경계조건 어노테이션. 이 어노테이션 사용시 여러 ValueSource 사용할 수 있다.
  @ValueSource(strings = {"aaabccc", "aabbccddeeffgg"})
  void validatePasswordTest2(String password){

    assertThatCode(() -> PasswordValidator.validate(password))
        .isInstanceOf(IllegalArgumentException.class) // 해당 메소드가 실행되면, 이런 exception이 발생하는데, exception type은 IllegalArgumentException이고,
        .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다."); // exception의 message는 ("") 다.
  }
}
