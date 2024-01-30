package com.gcu.model;

public class SearchedUserModel {

	private int id; 
    private String firstName;
    private String lastName;
    private String username;

	public String searchValue;
	
	public boolean friends;
    
    
    public SearchedUserModel(int id, String firstName, String lastName, String username, boolean friends) {
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.username = lastName;
    	this.friends = friends;
    }
    
    public SearchedUserModel() {
    	this.id = 0;
    	this.firstName = "N/A";
    	this.lastName = "N/A";
    	this.username = "N/A";
    	this.friends = false;
    }
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}    
	
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
}
