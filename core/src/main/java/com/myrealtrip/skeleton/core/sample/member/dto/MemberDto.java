package com.myrealtrip.skeleton.core.sample.member.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

/**
 * MemberDto
 *
 * @author sarasu
 * @since 2021.10.19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto implements Serializable {
    private Long id;
    private String userId;
    private String password;

    @JsonProperty("organization")
    private OrganizationDto organizationDto;
}
