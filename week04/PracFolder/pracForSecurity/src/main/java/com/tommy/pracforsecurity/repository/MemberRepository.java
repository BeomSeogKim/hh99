package com.tommy.pracforsecurity.repository;

import com.tommy.pracforsecurity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Email : LoginID

    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);
}
