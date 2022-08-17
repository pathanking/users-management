package com.barclays.service;

import java.util.List;

import com.barclays.entities.User;

public interface UserService {

	public List<User> getAllUsers();

	public User getUser(Integer uid);

	public User updateUser(User user, Integer uid);

	public void deleteUser(Integer uid);

	User create(User user);
}
