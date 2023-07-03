package com.myrealtrip.skeleton.domain.sample.jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.myrealtrip.skeleton.infrastructure.jpa.CommonJPAModel;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Member
 *
 * @author sarasu
 * @since 2021.10.19
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
@Where(clause = "deleted = 0")
@SQLDelete(sql = "UPDATE member set deleted = 1 where id = ?")
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
public class Member extends CommonJPAModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organization_id")
    @JsonBackReference
    private Organization organization;
}
