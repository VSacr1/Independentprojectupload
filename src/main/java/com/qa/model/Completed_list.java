package com.qa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import antlr.collections.List;

@Entity
public class Completed_list{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long complete_id; 
	
	private float dateCompleted;
	
	public Completed_list()
	{
		
	}
	public Completed_list(String item, /*boolean isComplete,*/ float dateSet, float dateCompleted)
	{
		
	}

	public Long getComplete_id() {
		return complete_id;
	}

	public void setComplete_id(Long complete_id) {
		this.complete_id = complete_id;
	}

	public float getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(float dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	
//	public void ifCompleted()
//	{
//		//This is where i need to write the if completed boolean to move it from one list to another
//		//else no movement required. 
//		
//		if(isComplete() == true)
//		{
//			
//		}
//		else 
//		{
//			
//		}
//	}
	

}
