package com.barclays.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.entities.User;
import com.barclays.exception.UserNotFoundException;
import com.barclays.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Integer uid) {
		return userRepository.findById(uid)
				.orElseThrow(() -> new UserNotFoundException("User Not Found With UID : " + uid));
	}

	@Override
	@Transactional
	public User updateUser(User user, Integer uid) {
		User fetchedUser = userRepository.findById(uid)
				.orElseThrow(() -> new UserNotFoundException("User Not Found With UID : " + uid));

		fetchedUser.setAddress(user.getAddress());
		fetchedUser.setEmail(user.getEmail());
		fetchedUser.setFirstName(user.getFirstName());
		fetchedUser.setLastName(user.getLastName());
		return fetchedUser;
	}

	@Override
	public void deleteUser(Integer uid) {
		User fetchedUser = userRepository.findById(uid)
				.orElseThrow(() -> new UserNotFoundException("User Not Found With UID : " + uid));
		userRepository.delete(fetchedUser);
	}

}
