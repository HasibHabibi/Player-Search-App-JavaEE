package com.bo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dao.SearchDAO;
import com.dao.SearchDAOImpl;
import com.exception.BusinessException;
import com.model.User;
import com.model.Team;

public class SearchBOImpl implements SearchBO{
	private SearchDAO searchDAO;

	@Override
	public User getUserById(String id) throws BusinessException {
		User user = null;
		if(id.matches("[Pp]{1}[a-zA-Z]{2}[0-9]{7}")) {
			//code here for DAO
			searchDAO = getSearchDAO();
			user = searchDAO.getUserById(id);
		} else {
			throw new BusinessException("Entered User id "+id+" is invalid");
		}
		return user;
	}

	@Override
	public User getUserByContact(long contact) throws BusinessException {
		User user = null;
		if(Long.toString(contact).length()==10) {
			searchDAO = getSearchDAO();
			user = searchDAO.getUserByContact(contact);
		} else {
			throw new BusinessException("Entered contact "+contact+" is invalid");
		}
		return user;
	}

	@Override
	public User getUserByEmail(String email) throws BusinessException {
		User user = null;
		if(email.matches("^(.+)@(.+)$")) {
			//code here for DAO
			searchDAO = getSearchDAO();
			user = searchDAO.getUserByEmail(email);
		} else {
			throw new BusinessException("Entered User email "+email+" is invalid");
		}
		return user;
	}

	@Override
	public List<User> getUserByGender(String gender) throws BusinessException {
		List<User> userList = null;
		if(gender.matches("[MF]{1}")) {
			searchDAO = getSearchDAO();
			userList = searchDAO.getUserByGender(gender);
		} else {
			throw new BusinessException("Gender entered: "+gender+" was invalid");
		}
		return userList;
	}

	@Override
	public List<User> getUserByDOB(Date dob) throws BusinessException {
		List<User> userList = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		  if(sdf.format(dob).matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
			  searchDAO =getSearchDAO(); 
			  userList = searchDAO.getUserByDOB(dob);
		  }
		 
		
		return userList;
	}

	@Override
	public List<User> getUserByName(String name) throws BusinessException {
		List<User> userList = null;
		if(name.matches("[a-zA-Z]{2,20}")) {
			searchDAO = getSearchDAO();
			userList = searchDAO.getUserByName(name);
		} else {
			throw new BusinessException("Name Entered: "+name+" is invalid");	
		}
		return userList;
	}

	@Override
	public List<User> getUserByTeamName(String teamName) throws BusinessException {
		List<User> userList = null;
		if(teamName.matches("[a-zA-Z ]{3,15}")) {
			searchDAO = getSearchDAO();
			userList = searchDAO.getUserByTeamName(teamName);
		} else {
			throw new BusinessException("Entered Team name "+teamName+" is invalid");
		}
		return userList;
	}


	
	
	
	
	
	
	
	@Override
	public User registerUser(User user) throws BusinessException {
			if(user.getName().matches("[a-zA-Z ]{2,20}")) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				if(sdf.format(user.getDob()).matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
					if(user.getEmail().matches("^(.+)@(.+)$")) {
						if(user.getGender().matches("[mMfF]{1}")) {
							if(Long.toString(user.getContact()).length()==10) {
								if(user.getTeamName().matches("[a-zA-Z ]{3,15}")) {
									searchDAO = getSearchDAO();
									user = searchDAO.registerUser(user);
								}
								else
									throw new BusinessException("Entered Team Name: "+user.getTeamName()+" is invalid");
							}
							else
								throw new BusinessException("Entered contact: "+user.getContact()+" is invalid");
						}
						else
							throw new BusinessException("Entered Gender: "+user.getGender()+" is invalid");
					}
					else
						throw new BusinessException("Entered Email: "+user.getEmail()+" is invalid");
				}
				else
					throw new BusinessException("Entered DOB: "+user.getDob()+" is invalid");
			}
		return user;
	}
	
	
	
	
	
	
	
	
	@Override
	public boolean updateUser(String id, long newContact) throws BusinessException {
		boolean b1 = true;
		boolean[] b = {false, false};
		if(id.matches("[Pp]{1}[a-zA-Z]{2}[0-9]{7}")) {
			b[0] = true;
		}
		if(Long.toString(newContact).length()==10) {
			b[1] = true;
		}
		for (boolean c : b) {
			if(!c) {
				b1 = false;
			}
			searchDAO = getSearchDAO();
			searchDAO.updateUser(id, newContact);
		}
		return b1;
	}

	@Override
	public boolean deleteUser(String id) throws BusinessException {
		boolean b = false;
		if(id.matches("[Pp]{1}[a-zA-Z]{2}[0-9]{7}")) {
			b = true;
			searchDAO = getSearchDAO();
			searchDAO.deleteUser(id);
		}
		return b;
	}
	
	
	
	
	
	

	@Override
	public Team registerTeam(Team team) throws BusinessException {
		
		searchDAO = getSearchDAO();
		team = searchDAO.registerTeam(team);
		return team;
	}
	
	
	
	
	
	
	
	

	@Override
	public List<Team> getAllTeams() throws BusinessException {
		List<Team> teamList = null;
		searchDAO = getSearchDAO();
		teamList = searchDAO.getAllTeams();
		return teamList;
	}

	@Override
	public List<User> getAllUsers() throws BusinessException {
		List<User> userList = null;
		searchDAO = getSearchDAO();
		userList = searchDAO.getAllUsers();
		return userList;
	}
	

	private SearchDAO getSearchDAO() {
		if(searchDAO==null) {
			searchDAO=new SearchDAOImpl();
		}
		return searchDAO;
	}

}
