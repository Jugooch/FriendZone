package com.gcu.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.sql.RowSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.business.SecurityBusinessService;
import com.gcu.model.SearchedUserModel;
import com.gcu.model.UserModel;

@Service
public class SearchDAOService {

	@Autowired
	@SuppressWarnings("unused")
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	public static List<SearchedUserModel> users;
	
	@Autowired
	private SecurityBusinessService securityService;
	
	// Constructor
	public SearchDAOService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 *  Get all existing Users values from Users table that match the search value.
	 * @return 
	 */
	public List<SearchedUserModel> getAllUsers(String searchValue)
	{		
		try{
		
			String sql = "SELECT ID, Username, FirstName, LastName FROM users WHERE Username LIKE ? OR FirstName LIKE ? OR LastName LIKE ?";
			
			users = this.jdbcTemplateObject.query(sql,
			        new RowMapper<SearchedUserModel>() {
			            @Override
			            public SearchedUserModel mapRow(ResultSet pResultSet, int pRowNumber) throws SQLException {
			                final SearchedUserModel user = new SearchedUserModel();
			                user.setId(pResultSet.getInt("ID"));
			                user.setFirstName(pResultSet.getString("FirstName"));
			                user.setLastName(pResultSet.getString("LastName"));
			                user.setUsername(pResultSet.getString("Username"));
			                if(isFriends(user)) {
			                	user.friends = true;
			                }
			                return user;
			                }
			        }, "%"+searchValue+"%", "%"+searchValue+"%", "%"+searchValue+"%");
			
		}
		catch (Exception e){ 
			e.printStackTrace();
		}		
		return users; 
	}
	
	public boolean isFriends(SearchedUserModel user) {
		try 
		{
		String sql = "SELECT FriendID FROM relationships WHERE UserID = ?";
		List<Integer> relationships = this.jdbcTemplateObject.query(sql,
		        new RowMapper<Integer>() 
				{
					public Integer mapRow(ResultSet pResultSet, int pRowNumber) throws SQLException {
		                final SearchedUserModel user2 = new SearchedUserModel();
		                user2.setId(pResultSet.getInt("FriendID"));
		                return user2.getId();
	                }
				}, securityService.getCurrentlyLoggedIn().getId());
		
			for(int i= 0; i < relationships.size(); i++) {
				if(relationships.get(i) == user.getId()) {
					return true;
				}
			}
		}
		catch(Exception e) {
		
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean addFriend(UserModel user) {
		String sql = "INSERT INTO relationships (UserID, FriendID) VALUES (?, ?)";
		try
		{
			int rows = jdbcTemplateObject.update(
				sql,
				securityService.getCurrentlyLoggedIn().getId(),
				user.getId()			
			);
			return rows == 1 ? true: false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false; 
	}
}
