package com.example.randomthought;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Thought {
	
	  @Id
	  private String id;
	  private String thought;

	  public String getId() {
	  return id;
	  }

	  public void setId(String idIn) {
	    this.id = idIn;
	  }

	  public String getThought() {
		    return thought;
		  }
	  
	  public void setThought(String thought) {
	    this.thought = thought;
	  }

}