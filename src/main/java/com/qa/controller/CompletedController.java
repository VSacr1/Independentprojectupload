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

import com.qa.model.Completed_list;
import com.qa.repository.Completed_listRepository;

@RestController
@RequestMapping("api/v1/")
public class CompletedController {

	@RequestMapping(value = "completed", method = RequestMethod.GET)
    public List<Completed_list> list(){
        return completed_listRepository.findAll();
    }

	
	@RequestMapping(value = "completed", method = RequestMethod.POST)
    public Completed_list create(@RequestBody Completed_list completed_list){
        return completed_listRepository.saveAndFlush(completed_list);
    }

	
	@RequestMapping(value = "completed/{complete_id}", method = RequestMethod.GET)
    public Completed_list get(@PathVariable Long complete_id){
        return completed_listRepository.findOne(complete_id);
    }

	
	@RequestMapping(value = "completed/{complete_id}", method = RequestMethod.PUT)
    public Completed_list update(@PathVariable Long complete_id, @RequestBody Completed_list completed_list){
		Completed_list existingNote = completed_listRepository.findOne(complete_id);
        BeanUtils.copyProperties(completed_listRepository, existingNote);
        return completed_listRepository.saveAndFlush(completed_list);
    }

	
	@RequestMapping(value = "completed/{complete_id}", method = RequestMethod.DELETE)
    public Completed_list delete(@PathVariable Long complete_id){
		Completed_list existingNote = completed_listRepository.findOne(complete_id);
		completed_listRepository.delete(existingNote);
        return existingNote;
    }

	
	@Autowired
	private Completed_listRepository completed_listRepository;
}
