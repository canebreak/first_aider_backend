package com.firstaid.backend.services;

import com.firstaid.backend.Model.Location;
import com.firstaid.backend.Model.User;

import java.util.List;

public interface UserService
{

	//login

	// register via Facebook, Google, Twitter, eamil

	List<User> getUserInRange(Location location, Long range);

	User getUserById(Long id);

}
