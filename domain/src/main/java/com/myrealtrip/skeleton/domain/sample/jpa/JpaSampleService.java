package com.myrealtrip.skeleton.domain.sample.jpa;

import com.myrealtrip.skeleton.core.sample.member.dto.MemberDto;
import com.myrealtrip.skeleton.core.sample.member.dto.OrganizationDto;
import com.myrealtrip.skeleton.core.sample.member.exception.OrganizationNotFoundException;
import com.myrealtrip.skeleton.domain.sample.jpa.entity.Member;
import com.myrealtrip.skeleton.domain.sample.jpa.entity.Organization;
import com.myrealtrip.skeleton.domain.sample.jpa.mapper.MemberMapper;
import com.myrealtrip.skeleton.domain.sample.jpa.mapper.OrganizationMapper;
import com.myrealtrip.skeleton.domain.sample.jpa.repository.MemberRepository;
import com.myrealtrip.skeleton.domain.sample.jpa.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

/**
 * JpaSampleService
 *
 * @author sarasu
 * @since 2021.10.19
 */
@Slf4j
@AllArgsConstructor
@Service
@Transactional(transactionManager = "transactionManager", readOnly = true)
public class JpaSampleService {
    private OrganizationRepository organizationRepository;
    private MemberRepository memberRepository;

    private final MemberMapper memberMapper = Mappers.getMapper(MemberMapper.class);
    private final OrganizationMapper organizationMapper = Mappers.getMapper(OrganizationMapper.class);

    public OrganizationDto getOrganization(Long id) {
        Organization organization = organizationRepository.findById(id).orElse(Organization.builder().build());
        Hibernate.initialize(organization.getMemberList());

        return organizationMapper.toDto(organization);
    }

    public MemberDto getMember(Long id) {
        Member member = memberRepository.findById(id).orElse(Member.builder().build());
        Hibernate.initialize(member.getOrganization());

        return memberMapper.toDto(member);
    }

    @Transactional(transactionManager = "transactionManager", readOnly = false)
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        return organizationMapper.toDto(organizationRepository.save(organizationMapper.toEntity(organizationDto)));
    }

    @Transactional(transactionManager = "transactionManager", readOnly = false)
    public MemberDto saveMember(MemberDto memberDto) {
        Member member = memberMapper.toEntity(memberDto);
        member.setOrganization(organizationRepository.getById(memberDto.getOrganizationDto().getId()));

        try {
            return memberMapper.toDto(memberRepository.save(member));
        } catch (EntityNotFoundException ex) {
            throw new OrganizationNotFoundException();
        }
    }
}
