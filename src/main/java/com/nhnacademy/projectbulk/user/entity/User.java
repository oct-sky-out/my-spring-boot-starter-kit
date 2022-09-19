package com.nhnacademy.projectbulk.user.entity;

import com.nhnacademy.projectbulk.auditing.entity.BaseTimeAuditingEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

/**
 * 설명작성란
 *
 * @author 김민수
 * @since 1.0
 */
@Entity
@Table(indexes = @Index(name = "userId_index", columnList = "userId", unique = true))
public class User extends BaseTimeAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userNo;

    @NotBlank
    private String userId;

    @NotBlank
    private String password;
}
