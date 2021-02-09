package com.pathfinder.service.interfaces;

import java.util.List;

import org.springframework.web.server.ResponseStatusException;

import com.pathfinder.common.viewmodels.UserViewModel;
import com.pathfinder.service.models.UserCredentials;

public interface IUserService {
	UserViewModel registerNewUser(UserCredentials credentials);

	List<UserViewModel> search(String param);

	UserViewModel login(UserCredentials credentials) throws ResponseStatusException;

	void deactivateUser(Integer id);

}
