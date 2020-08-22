package com.app.exercise.service.user;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.app.exercise.dao.repository.UserRepository;
import com.app.exercise.model.bean.User;
import com.app.exercise.model.generic.BaseResult;
import com.app.exercise.model.generic.UserToken;


public interface UserService 
{
	ResponseEntity<UserToken> loginAuth(UserToken user);
	ResponseEntity<User> addUser(User user);
	ResponseEntity<BaseResult> updateUser(User user);
	ResponseEntity<BaseResult> deleteUser(UUID id);
	ResponseEntity<User> retriveUserById(UUID id);
	ResponseEntity<List<User>> retriveUsers();
	ResponseEntity<List<User>> retriveUsersByName(String name);
	ResponseEntity<BaseResult> deleteAllUsers();
	void setRepository(UserRepository repository);
}
