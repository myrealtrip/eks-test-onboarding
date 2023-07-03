package com.myrealtrip.skeleton.domain.sample.mybatis.mapper;

import com.myrealtrip.skeleton.core.sample.member.dto.OrganizationDto;
import com.myrealtrip.skeleton.domain.sample.mybatis.query.OrganizationSql;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * OrganizationSqlMapper
 *
 * @author sarasu
 * @since 2021.10.28
 */
public interface OrganizationSqlMapper {
    @Select("SELECT * FROM organization WHERE id = #{id}")
    OrganizationDto getOrganizationById(@Param("id") Long id);

    @Insert(OrganizationSql.insertOrganization)
    void insertOrganization(OrganizationDto organizationDto);
}
