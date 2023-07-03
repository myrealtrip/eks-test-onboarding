package com.myrealtrip.skeleton.domain.sample.jpa.repository;

import com.myrealtrip.skeleton.domain.sample.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MemberRepository
 *
 * @author sarasu
 * @since 2021.10.19
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
