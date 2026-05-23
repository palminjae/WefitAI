package com.dms.wefitai.repository;

import com.dms.wefitai.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUserId(String userId);
    boolean existsByUserId(String userId);
}