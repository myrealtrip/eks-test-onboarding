package com.myrealtrip.skeleton.core.sample.member.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * OrganizationDto
 *
 * @author sarasu
 * @since 2021.10.19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto implements Serializable {
    private Long id;
    private String name;
    private String description;

    @JsonProperty("memberList")
    private List<MemberDto> memberDtoList = new ArrayList<>();
}