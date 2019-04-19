package com.bo;

import java.util.Date;
import java.util.List;

import com.exception.BusinessException;
import com.model.User;
import com.model.Team;

public interface SearchBO {

	public User getUserById(String id) throws BusinessException;
	public User getUserByContact(long contact) throws BusinessException;
	public User getUserByEmail(String gender) throws BusinessException;
	public List<User> getUserByGender(String gender) throws BusinessException;
	public List<User> getUserByDOB(Date dob) throws BusinessException;
	public List<User> getUserByName(String name) throws BusinessException;
	public List<User> getUserByTeamName(String teamName) throws BusinessException;
	public User registerUser(User user) throws BusinessException;
	public boolean updateUser(String id, long newContact) throws BusinessException;
	public boolean deleteUser(String id) throws BusinessException;
	public Team registerTeam(Team team) throws BusinessException;
	public List<Team> getAllTeams() throws BusinessException;
	public List<User> getAllUsers() throws BusinessException;
	
}
