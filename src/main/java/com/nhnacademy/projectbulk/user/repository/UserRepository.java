package com.nhnacademy.projectbulk.user.repository;

import com.nhnacademy.projectbulk.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 설명작성란
 *
 * @author 김민수
 * @since 1.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
