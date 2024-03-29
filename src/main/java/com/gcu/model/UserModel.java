package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

public class UserModel 
{ 
	private int id; 
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String username;
    private String password;    
    private String profilePic;
    private boolean privacy; 
    
    private List<PostModel> Posts = new ArrayList<PostModel>();
    
    /**
     * full Constructor
     * 
     * @param firstName
     * @param lastName
     * @param email
     * @param username
     * @param phone
     * @param password
     */
    public UserModel(int id, String firstName, String lastName, String email, String phone, String username, String password, String profilePic, boolean privacy)
    {
    	this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.profilePic = profilePic;
		this.privacy = privacy;
	}
    
    /**
     * minimal UserModel
     * 
     * @param username
     * @param password
     */
    public UserModel(String username, String password)
    {
    	this.username = username;
    	this.password = password;
    }
    
    /**
     * default constructor
     */
    public UserModel(){}
    
    
	// getters and setters for member variables of user model
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public List<PostModel> getPosts() { return Posts; }
    public void setPosts(List<PostModel> posts) { this.Posts = posts; }
    public void addPost(PostModel postModel) { getPosts().add(0, postModel); }

	public String getProfilePic() { return profilePic; }
	public void setProfilePic(String profilePic) { this.profilePic = profilePic; }

	public boolean getPrivacy() { return privacy; }
	public void setPrivacy(boolean privacy) { this.privacy = privacy; }
}