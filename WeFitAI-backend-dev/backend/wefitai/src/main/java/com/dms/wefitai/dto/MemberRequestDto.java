package com.dms.wefitai.dto;

import com.dms.wefitai.domain.Authority;
import com.dms.wefitai.domain.Gender; // Gender를 import 합니다.
import com.dms.wefitai.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate; // LocalDate를 import 합니다.

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {
    private String userId;
    private String password;
    private LocalDate birthDate; // 필드 추가
    private Gender gender;       // 필드 추가

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .userId(userId)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .birthdate(birthDate) // 빌더에 추가
                .gender(gender)       // 빌더에 추가
                .build();
    }

    // login 메서드는 userId, password만 사용하므로 그대로 둡니다.
    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(userId, password);
    }
}