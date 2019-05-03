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

import com.qa.model.ToDo;
import com.qa.repository.To_doRepository;;

@RestController
@RequestMapping("api/v1/")
public class To_DoController {

	@RequestMapping(value = "todo", method = RequestMethod.GET)
    public List<ToDo> list(){
        return to_doRepository.findAll();
    }

	
	@RequestMapping(value = "todo", method = RequestMethod.POST)
    public ToDo create(@RequestBody ToDo to_do){
        return to_doRepository.saveAndFlush(to_do);
    }

	
	@RequestMapping(value = "todo/{id}", method = RequestMethod.GET)
    public ToDo get(@PathVariable Long id){
        return to_doRepository.findOne(id);
    }

	
	@RequestMapping(value = "todo/{id}", method = RequestMethod.PUT)
    public ToDo update(@PathVariable Long id, @RequestBody ToDo to_do){
		ToDo existingNote = to_doRepository.findOne(id);
        BeanUtils.copyProperties(to_do, existingNote);
        //return existingNote;
        return to_doRepository.saveAndFlush(to_do);
    }

	
	@RequestMapping(value = "todo/{id}", method = RequestMethod.DELETE)
    public ToDo delete(@PathVariable Long id){
		ToDo existingNote = to_doRepository.findOne(id);
        to_doRepository.delete(existingNote);
        return existingNote;
    }

	
	@Autowired
	private To_doRepository to_doRepository;
}
