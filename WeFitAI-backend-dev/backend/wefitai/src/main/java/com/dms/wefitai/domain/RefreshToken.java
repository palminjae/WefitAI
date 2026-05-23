package com.dms.wefitai.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class RefreshToken {

    @Id
    @Column(name = "rt_key")
    private String key;

    @Column(name = "rt_value")
    private String Value;

    @Builder
    public RefreshToken(String key, String value) {
        this.key = key;
        this.Value = value;
    }

    public RefreshToken updateValue(String token) {
        this.Value = token;
        return this;
    }
}
