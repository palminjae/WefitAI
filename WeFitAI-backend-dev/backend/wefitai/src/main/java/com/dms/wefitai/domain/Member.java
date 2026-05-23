package com.dms.wefitai.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member {
    // 시나리오 1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    // 시나리오 2
    @Column
    private Double height;

    @Column
    private Double weight;

    @Column
    private Double bodyFatPercentage;

    @Column
    private Double waistCircumference;

    @Column
    private Double gripStrength;

    @Builder
    public Member(String userId, String password, Authority authority, LocalDate birthdate, Gender gender) {
        this.userId = userId;
        this.password = password;
        this.authority = authority;
        this.birthdate = birthdate;
        this.gender = gender;
    }
    public void updateBodyInfo(Double height, Double weight, Double bodyFatPercentage, Double waistCircumference, Double gripStrength) {
        this.height = height;
        this.weight = weight;
        this.bodyFatPercentage = bodyFatPercentage;
        this.waistCircumference = waistCircumference;
        this.gripStrength = gripStrength;
    }
}