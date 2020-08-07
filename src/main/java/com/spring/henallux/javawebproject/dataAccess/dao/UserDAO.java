package com.spring.henallux.javawebproject.dataAccess.dao;

import com.spring.henallux.javawebproject.dataAccess.entity.UserEntity;
import com.spring.henallux.javawebproject.dataAccess.repository.UserRepository;
import com.spring.henallux.javawebproject.exceptions.EmailAlreadyUse;
import com.spring.henallux.javawebproject.exceptions.UserAlreadyExist;
import com.spring.henallux.javawebproject.exceptions.UserNotFound;
import com.spring.henallux.javawebproject.model.User;
import com.spring.henallux.javawebproject.utility.Constants;
import com.spring.henallux.javawebproject.utility.ProviderConverter;
import com.spring.henallux.javawebproject.utility.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserDAO {
	private final UserRepository dataAccess;
	private final ProviderConverter mapper;
	private final TestModel<User> testUser;

	@Autowired
	public UserDAO(UserRepository dataAccess, ProviderConverter mapper, TestModel<User> testUser) {
		this.dataAccess = dataAccess;
		this.mapper = mapper;
		this.testUser = testUser;
	}

	public Collection<User> findAllUsers() {
		return dataAccess.findAll().stream().map(mapper::userEntityToUserModel).collect(Collectors.toList());
	}

	public User findUser(String username) throws UserNotFound {
		Optional<UserEntity> userEntity = dataAccess.findByUsername(username);

		if (!userEntity.isPresent()) throw new UserNotFound();
		return mapper.userEntityToUserModel(userEntity.get());
	}

	public User saveUser(User user) throws Exception {
		testUser.setObjectToTest(user);
		if (testUser.hasError()) throw new Exception(); //TODO
		if (dataAccess.existsByUsername(user.getUsername())) throw new UserAlreadyExist();
		if (dataAccess.existsByEmail(user.getEmail())) throw new EmailAlreadyUse();

		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		UserEntity userEntity = mapper.userModelToEntity(user);
		userEntity.setAccountNonExpired(true);
		userEntity.setAccountNonLocked(true);
		userEntity.setEnable(true);
		userEntity.setAuthorities(Constants.USER);
		userEntity.setCredentialsNonExpired(true);
		dataAccess.save(userEntity);
		return user;
	}

	public User deleteUser(User user) {
		dataAccess.delete(mapper.userModelToEntity(user));
		return user;
	}

	public void deleteUser(String username) {
		dataAccess.deleteUserByUsername(username);
	}
}
