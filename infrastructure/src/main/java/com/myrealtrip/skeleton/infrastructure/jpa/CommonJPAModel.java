package com.myrealtrip.skeleton.infrastructure.jpa;

import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * CommonJPAModel
 *
 * @author sarasu
 * @since 2021.10.19
 */
@Accessors(chain = true)
@MappedSuperclass
public abstract class CommonJPAModel implements Serializable {
    @Column(name = "deleted", nullable = false, columnDefinition = "BIT", length = 1)
    private boolean deleted;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;

    @CreatedBy
    @Column(name = "created_by", length = 200, updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "modified_by",
            length = 200)
    private String modifiedBy;
}
