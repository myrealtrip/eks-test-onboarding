package com.myrealtrip.skeleton.domain.sample.jpa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myrealtrip.skeleton.infrastructure.jpa.CommonJPAModel;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

/**
 * Organization
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
@Table(name = "organization")
@Where(clause = "deleted = 0")
@SQLDelete(sql = "UPDATE organization set deleted = 1 where id = ?")
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
public class Organization extends CommonJPAModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "organization", orphanRemoval = true)
    @JsonManagedReference
    private List<Member> memberList;
}
