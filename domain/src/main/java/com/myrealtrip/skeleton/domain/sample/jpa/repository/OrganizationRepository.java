package com.myrealtrip.skeleton.domain.sample.jpa.repository;

import com.myrealtrip.skeleton.domain.sample.jpa.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * OrganizationRepository
 *
 * @author sarasu
 * @since 2021.10.19
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
