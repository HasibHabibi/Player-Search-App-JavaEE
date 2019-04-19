package com.bo;


import com.dao.LoginDAO;
import com.dao.LoginDAOImpl;
import com.exception.BusinessException;
import com.model.User;

public class LoginBOImpl implements LoginBO {
	private LoginDAO loginDAO;
	
	@Override
	public boolean isValidUser(User user) throws BusinessException {
		boolean b = false;
		if(user!=null && user.getId()!=null && user.getPassword()!=null 
				&& user.getId().matches("[a-zA-Z0-9]{10}") 
				&& user.getPassword().matches("[a-zA-Z0-9]{3}@[0-9]{3}")) {
			b=new LoginDAOImpl().isValidUser(user);
		} else {
			throw new BusinessException("Invalid Userid/Password");
		}
		return b;
	}

	@Override
	public User registerUser(User user) throws BusinessException {
		if (user.getId().matches("[Pp]{1}[a-zA-Z]{2}[0-9]{7}")) {
			if (user.getPassword().matches("[a-zA-Z0-9]{3}@[0-9]{3}")) {
				loginDAO = getLoginDAO();
				user = loginDAO.registerUser(user);
			} else
				throw new BusinessException("Entered ID: " + user.getId() + " is invalid");
		} else
			throw new BusinessException("Entered password: " + user.getPassword() + " is invalid");
		return user;
	}
	
	
	private LoginDAO getLoginDAO() {
		if(loginDAO==null) {
			loginDAO= new LoginDAOImpl();
		}
		return loginDAO;
	}

}
