package com.myrealtrip.skeleton.domain.sample.mybatis.mapper;

import com.myrealtrip.skeleton.core.sample.member.dto.MemberDto;
import com.myrealtrip.skeleton.domain.sample.mybatis.query.MemberSql;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * MemberMapper
 *
 * @author sarasu
 * @since 2021.10.28
 */
public interface MemberSqlMapper {
    @Select("SELECT * FROM member WHERE id = #{id}")
    MemberDto getMemberById(@Param("id") Long id);

    @SelectProvider(type = MemberSql.class, method = "findByMemberDto")
    public List<MemberDto> findMemberByMemberDto(MemberDto memberDto);

    @Insert(MemberSql.memberInsert)
    void insertMember(MemberDto memberDto);
}
