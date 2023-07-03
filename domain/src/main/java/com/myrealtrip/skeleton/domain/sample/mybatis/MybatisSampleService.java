package com.myrealtrip.skeleton.domain.sample.mybatis;

import com.myrealtrip.skeleton.core.sample.member.dto.MemberDto;
import com.myrealtrip.skeleton.core.sample.member.dto.OrganizationDto;
//import com.myrealtrip.skeleton.domain.sample.mybatis.mapper.MemberSqlMapper;
//import com.myrealtrip.skeleton.domain.sample.mybatis.mapper.OrganizationSqlMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * MybatisSampleService
 *
 * @author sarasu
 * @since 2021.10.28
 */
//@AllArgsConstructor
//@Service
//public class MybatisSampleService {
//    private MemberSqlMapper memberSqlMapper;
//    private OrganizationSqlMapper organizationSqlMapper;
//
//    public MemberDto getMember(Long id) {
//        return memberSqlMapper.getMemberById(id);
//    }
//
//    public List<MemberDto> findMember(MemberDto memberDto) {
//        return memberSqlMapper.findMemberByMemberDto(memberDto);
//    }
//
//    public OrganizationDto getOrganization(Long id) {
//        return organizationSqlMapper.getOrganizationById(id);
//    }
//
//    @Transactional
//    public void saveMemberAndOrganization(MemberDto member, OrganizationDto organization) {
//        organizationSqlMapper.insertOrganization(organization);
//        memberSqlMapper.insertMember(member);
//    }
//}
