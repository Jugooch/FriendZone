package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationModel 
{
	// VARIABLES 
	
    private String FirstName;
    private String LastName;
    private String Email;
    private String Phone;
    
    @NotNull(message="Username is a required field")
    @Size(min=2, max=32, message="Username must be between 2 and 32 characters")
    private String Username;

    @NotNull(message="Password is a required field")
    @Size(min=8, max=32, message="Password must be between 8 and 32 characters")
    private String Password;
    
    
    // CONSTRUCTORS
    
    public RegistrationModel(String firstName, String lastName, String email, String username, String phone, String password)
    {
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Email = email;
		this.Phone = phone;
		this.Username = username;
		this.Password = password;
	}
    
    public RegistrationModel(String username, String password)
    {
    	this.Username = username;
    	this.Password = password;
    }
        
    
    // GETTERS/SETTERS
    
    public RegistrationModel() {
    }

    // FirstName
    public String getFirstName() { return FirstName; }
    public void setFirstName(String firstName) { this.FirstName = firstName; }
    
    // LastName
    public String getLastName() { return LastName; }
    public void setLastName(String lastName) { this.LastName = lastName; }
    
    // Email
    public String getEmail() { return Email; }
    public void setEmail(String email) { this.Email = email; }
    
    // Phone
    public String getPhone() { return Phone; }
    public void setPhone(String phone) { this.Phone = phone; }
    
    // Username
    public String getUsername() { return Username; }
    public void setUsername(String username) { this.Username = username; }
    
    // Password
    public String getPassword() { return Password; }
    public void setPassword(String password) { this.Password = password; }
}