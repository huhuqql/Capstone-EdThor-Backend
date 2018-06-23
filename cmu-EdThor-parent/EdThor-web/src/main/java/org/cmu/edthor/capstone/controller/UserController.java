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
	public Integer addUser(@RequestBody User u) {
		User temp_user = this.userRepository.findByUsername(u.getUsername());
		if(temp_user != null) {
			return -1;
		}
		else {
			if (u.getId() ==null) {
				u.setId(new ObjectId().toString());
			}
			this.userRepository.save(u);
			return 1;
		}
	}

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@RequestMapping(path = "/users/", method = RequestMethod.GET)
	public Integer findByUsername(@RequestParam String username, String password){
		User u = new User();
		u = this.userRepository.findByUsername(username);
		String temp_password = u.getPassword();
		if(temp_password == password) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	
}