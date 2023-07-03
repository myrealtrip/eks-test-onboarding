package com.myrealtrip.skeleton.domain.sample.jpa.mapper;

import com.myrealtrip.skeleton.core.sample.member.dto.MemberDto;
import com.myrealtrip.skeleton.domain.sample.jpa.entity.Member;
import com.myrealtrip.skeleton.infrastructure.mapstruct.EntityMapperBase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * MemberMapper
 *
 * @author sarasu
 * @since 2021.10.19
 */
@Mapper(componentModel = "spring")
public interface MemberMapper extends EntityMapperBase<Member, MemberDto> {
    @Override
    @Mapping(source = "organization", target = "organizationDto")
    MemberDto toDto(Member member);

    @Override
    @Mapping(source = "organizationDto", target = "organization")
    Member toEntity(MemberDto memberDto);
}
