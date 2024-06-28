package com.example.spring_security.dto;

import lombok.Data;

// @Data를 사용하게 되면
// @Getter, @Setter, @Builder 등의 어노테이션을 동시에 사용하는 것과 같은 효과를 얻을 수 있다.
@Data
public class JoinDTO {
    private String username;
    private String password;
}
