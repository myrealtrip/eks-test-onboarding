package com.myrealtrip.skeleton.domain.sample.mybatis.query;

import com.myrealtrip.skeleton.core.sample.member.dto.MemberDto;

//public class MemberSql {
//    public static final String memberInsert = """
//            INSERT
//              INTO member (
//                       id,
//                       user_id,
//                       password,
//                       organization_id,
//                       deleted,
//                       created_at,
//                       modified_at,
//                       created_by,
//                       modified_by
//                   )
//            VALUES (
//                   '#{id}',
//                   '#{userId}',
//                   '#{password}',
//                   '#{organization.id}',
//                   0,
//                   NOW(),
//                   NOW(),
//                   '',
//                   ''
//                   )
//            """;
//
//    public String findByMemberDto(MemberDto memberDto) {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("""
//                SELECT *
//                  FROM member
//                 WHERE 1=1
//                """);
//
//        if (memberDto.getUserId() != null) {
//            sb.append("""
//                    AND user_id = '${userId}'
//                    """);
//        }
//        if (memberDto.getOrganizationDto() != null && memberDto.getOrganizationDto().getId() != null) {
//            sb.append("""
//                    AND organization_id = '#{organization.id}'
//                    """);
//        }
//
//        return sb.toString();
//    }
//
//}
