package com.pathfinder.service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.google.common.hash.Hashing;
import com.pathfinder.common.viewmodels.UserViewModel;
import com.pathfinder.data.IUserRepository;
import com.pathfinder.data.entities.User;
import com.pathfinder.service.interfaces.IUserService;
import com.pathfinder.service.models.UserCredentials;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepo;

	
	private final String salt = "pathfinder-i-hardly-know-her";

	@Override
	public UserViewModel registerNewUser(UserCredentials credentials) {
		var hashedPassword = Hashing.sha256().hashString(credentials.password + salt, StandardCharsets.UTF_8)
				.toString();
		var user = new User(credentials.nickname, credentials.email, hashedPassword);
		userRepo.save(user);

		return new UserViewModel(user);
	}

	@Override
	public List<UserViewModel> search(String param) {
		var users = userRepo.findByNicknameLikeAndIsDeletedFalseOrEmailAndIsDeletedFalse("%" + param + "%", param);

		return users.stream().map(u -> new UserViewModel(u)).collect(Collectors.toList());
	}

	@Override
	public UserViewModel login(UserCredentials credentials) throws ResponseStatusException {
		var hashedPassword = Hashing.sha256().hashString(credentials.password + salt, StandardCharsets.UTF_8)
				.toString();
		var user = userRepo.findByEmailAndPasswordHashAndIsDeletedFalse(credentials.email, hashedPassword);

		if (!user.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No account found for given email and password.");
		}

		return new UserViewModel(user.get());

	}

	@Override
	public void deactivateUser(Integer id) {
		var userOpt = userRepo.findById(id);
		
		if(!userOpt.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No account found for given id.");
		}

		var user = userOpt.get();
		user.setIsDeleted(true);
		userRepo.save(user);
	}
}
