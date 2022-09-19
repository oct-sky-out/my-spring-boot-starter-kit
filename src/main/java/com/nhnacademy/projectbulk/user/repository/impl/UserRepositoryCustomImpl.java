package com.nhnacademy.projectbulk.user.repository.impl;

import com.nhnacademy.projectbulk.user.entity.User;
import com.nhnacademy.projectbulk.user.repository.UserRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

/**
 * 설명작성란
 *
 * @author 김민수
 * @since 1.0
 */
public class UserRepositoryCustomImpl extends QuerydslRepositorySupport
    implements UserRepositoryCustom {

    public UserRepositoryCustomImpl() {
        super(User.class);
    }
}
