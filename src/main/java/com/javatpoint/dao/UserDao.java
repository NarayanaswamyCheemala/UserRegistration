/**
 * 
 */
package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import com.javatpoint.dao.exception.UserException;
import com.javatpoint.entity.User;

/**
 * @author naray
 *
 */
@Component
public class UserDao {

@Autowired
 JdbcTemplate jt;
	
	
	
	public void save(User usr) throws UserException {
		System.out.println("Dao layer started  ");
		try {
			String sql="insert into UserDetail(username,password,firstname,lastname) values('"+usr.getUsername()+"','"+usr.getPassword()+"','"+usr.getFirstname()+"','"+usr.getLastname()+"')";  
		     jt.update(sql) ;
		     
		}catch(Exception e) {
			throw new UserException("Unable to update database "+ e.getMessage());
		}
		
		System.out.println("Data added ");
		
	}


/**
 * This method will bring user data 
 */
	public List<User> getUserData() {
		
		String sql = "Select * from UserDetail";
		
		List<User> userlist = jt.query(sql, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {				
				User user =  new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setFirstname(rs.getString(3));
				user.setLastname(rs.getString(4));
				return user;
			}	
			
		});	
		
		System.out.println(userlist);
		
		return userlist;
	}

}
