package org.cmu.edthor.capstone.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.cmu.edthor.capstone.model.User;
import org.cmu.edthor.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(path = "/users/register", method = RequestMethod.POST)
	public void addUser(@RequestBody User u) {
		if (u.getId() ==null) {
			u.setId(new ObjectId().toString());
		}
		this.userRepository.save(u);
	}

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@RequestMapping(path = "/users/", method = RequestMethod.GET)
	public User findByUsername(@RequestParam String username){
		return this.userRepository.findByUsername(username);
	}
	
	
}