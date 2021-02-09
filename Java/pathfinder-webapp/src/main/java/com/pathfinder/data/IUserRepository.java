package com.pathfinder.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pathfinder.data.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	List<User> findByNicknameLikeAndIsDeletedFalseOrEmailAndIsDeletedFalse(String nickname, String email);

	Optional<User> findByEmailAndPasswordHashAndIsDeletedFalse(String email, String passwordHash);
}
