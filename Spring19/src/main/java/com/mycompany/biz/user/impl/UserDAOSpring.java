package com.mycompany.biz.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mycompany.biz.user.UserVO;

@Repository
public class UserDAOSpring implements UserService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String USER_GET="select * from users where ID=? and PASSWORD=?";
	private final String USER_INSERT="insert into users values (?,?,?,?);";
	private final String USER_UPDATE="update users set PASSWORD=?,NAME=?,ROLE=? where ID=?";
	private final String USER_DELETE="delete from users where ID=?";
	private final String USER_LIST=" select * from users order by ID desc";
	
	
	public void insertUser(UserVO vo) {
		
		Object[] args = {vo.getId(),vo.getPassword(),vo.getName(),vo.getRole()};
		jdbcTemplate.update(USER_INSERT,args);
	}
	
	public void updateUser(UserVO vo) {
		
		Object[] args = {vo.getPassword(),vo.getName(),vo.getRole(),vo.getId()};
		jdbcTemplate.update(USER_UPDATE,args);
	}
	
	public void deleteUser(UserVO vo) {
		jdbcTemplate.update(USER_DELETE,vo.getId());
	}
	
	public UserVO getUser(UserVO vo) {
		Object[] args = {vo.getId(),vo.getPassword()};
		
		return jdbcTemplate.queryForObject(USER_GET,args,new UserRowMapper());
	}
	
	class UserRowMapper implements RowMapper<UserVO>{

		@Override
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			UserVO user = new UserVO();
			user.setId(rs.getString("ID"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setName(rs.getString("NAME"));
			user.setRole(rs.getString("ROLE"));
			
			return user;
		}
		
	}
	
	public List<UserVO> getUserList(){
		return jdbcTemplate.query(USER_LIST, new UserRowMapper());
	}
}
