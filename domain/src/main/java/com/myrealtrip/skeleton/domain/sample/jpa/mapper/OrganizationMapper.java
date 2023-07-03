package com.myrealtrip.skeleton.domain.sample.jpa.mapper;

import com.myrealtrip.skeleton.core.sample.member.dto.OrganizationDto;
import com.myrealtrip.skeleton.domain.sample.jpa.entity.Organization;
import com.myrealtrip.skeleton.infrastructure.mapstruct.EntityMapperBase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * OrganizationMapper
 *
 * @author sarasu
 * @since 2021.10.19
 */
@Mapper(componentModel = "spring")
public interface OrganizationMapper extends EntityMapperBase<Organization, OrganizationDto> {
    @Override
    @Mapping(source = "memberList", target = "memberDtoList")
    OrganizationDto toDto(Organization organization);

    @Override
    @Mapping(source ="memberDtoList", target = "memberList")
    Organization toEntity(OrganizationDto organizationDto);
}
