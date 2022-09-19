package com.nhnacademy.projectbulk.auditing.entity;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 설명작성란
 *
 * @author 김민수
 * @since 1.0
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeAuditingEntity {
    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @PrePersist
    public void doPersistBeforeCreationTime(){
        this.createTime = LocalDateTime.now();
    }

    @PreUpdate
    public void doUpdateBeforeUpdateTime(){
        this.updateTime = LocalDateTime.now();
    }
}
