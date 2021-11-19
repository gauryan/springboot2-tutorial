package com.tutorial.xyz.dto;

import lombok.Data;

// lombok을 사용해도 FreeMarker에서 admin.userid 가 먹히지 않았다.
// Lombok Annotations Support for VS Code 을 설치해주었더니, 해결되었다.
// 그렇다는 것은... ???
@Data
public class Admin {
  private Long   id;
  private String userid;
  private String password;
  private String nick;
}
