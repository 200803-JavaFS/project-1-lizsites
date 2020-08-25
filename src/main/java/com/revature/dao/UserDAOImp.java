package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.ERSUser;
import com.revature.util.ConnectionUtil;

public class UserDAOImp implements UserDAO {

	private static final Logger userLogger = LogManager.getLogger(UserDAOImp.class);
	
	@Override
	public ERSUser getUserByUsername(String username) {
		ERSUser e = new ERSUser();
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ers_users where ers_username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				 e = new ERSUser(rs.getInt("ers_users_id"),rs.getString("ers_username"),rs.getString("ers_password"), rs.getString("user_first_name"),rs.getString("user_last_name"), rs.getString("user_email"),rs.getInt("user_role_id"));
				 return e;
			}
		} catch(SQLException s) {
			s.printStackTrace();
		}
	
		return null;
	}

	@Override
	public ERSUser getUserById(int id) {
		
		return null;
	}

	@Override
	public Set<ERSUser> getAllUsers() {
		Set<ERSUser> allUsers = new TreeSet<>();
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ers_users;";
			Statement stt = conn.createStatement();
			ResultSet rs = stt.executeQuery(sql);
			while (rs.next()) {
			ERSUser e = new ERSUser(rs.getInt("ers_users_id"),rs.getString("ers_username"),rs.getString("ers_password"), rs.getString("user_first_name"),rs.getString("user_last_name"), rs.getString("user_email"),rs.getInt("user_role_id"));
			allUsers.add(e);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
	}

}
