package com.qa.controller;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.model.User;
import com.qa.repository.UserRepository;;

@RestController
@RequestMapping("api/v1/")
public class UserController {

	@RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> list(){
        return userRepository.findAll();
    }

	
	@RequestMapping(value = "users", method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return userRepository.saveAndFlush(user);
    }

	
	@RequestMapping(value = "users/{userId}", method = RequestMethod.GET)
    public User get(@PathVariable Long userId){
        return userRepository.findOne(userId);
    }

	
	@RequestMapping(value = "users/{userId}", method = RequestMethod.PUT)
    public User update(@PathVariable Long userId, @RequestBody User user){
		User existingNote = userRepository.findOne(userId);
        BeanUtils.copyProperties(user, existingNote);
        return userRepository.saveAndFlush(user);
    }

	
	@RequestMapping(value = "users/{userId}", method = RequestMethod.DELETE)
    public User delete(@PathVariable Long userId){
		User existingNote = userRepository.findOne(userId);
		userRepository.delete(existingNote);
        return existingNote;
    }
	
	@Autowired
	private UserRepository userRepository;
}