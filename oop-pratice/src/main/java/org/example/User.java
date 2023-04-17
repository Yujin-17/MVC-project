package org.example;

public class User {

  private String password;

  public void initPassword(PasswordGenerator passwordGenerator){
    String password = passwordGenerator.generatePassword();
    /**
     * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
     */
    if(password.length() >= 8 && password.length() <= 12){
      this.password = password; // 랜덤으로 패스워드를 만들어서 이 조건에 만족할때만, 패스워드가 셋팅.
    }

  }

  public String getPassword() {
    return password;
  }
}
