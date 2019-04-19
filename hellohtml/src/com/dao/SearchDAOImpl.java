package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dbutil.OracleDbConnection;
import com.exception.BusinessException;
import com.model.User;
import com.model.Team;

public class SearchDAOImpl implements SearchDAO{

	@Override
	public User getUserById(String id) throws BusinessException {
		User user = null;
		try (Connection connection = OracleDbConnection.getConnection()){
			String sql = "select p.id,p.name,p.dob,p.email,"
					+ "p.gender,p.contact,t.teamName "
					+ "from Player p join teams t "
					+ "on p.team_id=t.team_id"
					+ " where p.id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id.toUpperCase());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = new User();
				user.setId(id);
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setTeamName(resultSet.getString("teamName"));
				user.setGender(resultSet.getString("gender"));
				user.setContact(resultSet.getLong("contact"));
				user.setDob(resultSet.getDate("dob"));
				
			} else {
				throw new BusinessException("User id "+id+" not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured kindly contact SYSADMIN"+e);
		}
		return user;
	}

	@Override
	public User getUserByContact(long contact) throws BusinessException {
		User user = null;
		try (Connection connection = OracleDbConnection.getConnection()){
			String sql = "select p.id,p.name,p.dob,p.email,"
					+ "p.gender,p.contact,t.teamName "
					+ "from Player p join teams t "
					+ "on p.team_id=t.team_id"
					+ " where p.contact=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, contact);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getString("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setTeamName(resultSet.getString("teamName"));
				user.setGender(resultSet.getString("gender"));
				user.setContact(contact);
				user.setDob(resultSet.getDate("dob"));
				
			} else {
				throw new BusinessException("User contact "+contact+" not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured kindly contact SYSADMIN"+e);
		}
		return user;
	}

	@Override
	public User getUserByEmail(String email) throws BusinessException {
		User user = null;
		try (Connection connection = OracleDbConnection.getConnection()){
			String sql = "select p.id,p.name,p.dob,p.gender,"
					+ "p.contact,t.teamName "
					+ "from Player p join teams t "
					+ "on p.team_id=t.team_id"
					+ " where p.email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getString("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(email);
				user.setTeamName(resultSet.getString("teamName"));
				user.setGender(resultSet.getString("gender"));
				user.setContact(resultSet.getLong("contact"));
				user.setDob(resultSet.getDate("dob"));
				
			} else {
				throw new BusinessException("User contact "+email+" not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured kindly contact SYSADMIN"+e);
		}
		return user;
	}

	@Override
	public List<User> getUserByGender(String gender) throws BusinessException {
		List<User> userList = new ArrayList<>();
		try (Connection connection = OracleDbConnection.getConnection()){
			String sql = "select p.id,p.name,p.dob,p.email,"
					+ "p.contact,t.teamName "
					+ "from Player p join teams t "
					+ "on p.team_id=t.team_id"
					+ " where p.gender=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, gender);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getString("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setTeamName(resultSet.getString("teamName"));
				user.setGender(gender);
				user.setContact(resultSet.getLong("contact"));
				user.setDob(resultSet.getDate("dob"));
				userList.add(user);
				
			} 
			if(userList.size()==0)
			{
				throw new BusinessException("User gender - "+gender+" not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured kindly contact SYSADMIN"+e);
		}
		return userList;
	}

	@Override
	public List<User> getUserByDOB(Date dob) throws BusinessException {
		List<User> userList = new ArrayList<>();
		try (Connection connection = OracleDbConnection.getConnection()){
			String sql = "select p.id,p.name,p.email,"
					+ "p.gender,p.contact,t.teamName "
					+ "from Player p join teams t "
					+ "on p.team_id=t.team_id"
					+ " where p.dob=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, new java.sql.Date(dob.getTime()));
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getString("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setTeamName(resultSet.getString("teamName"));
				user.setGender(resultSet.getString("gender"));
				user.setContact(resultSet.getLong("contact"));
				user.setDob(dob);
				userList.add(user);
				
			} 
			if(userList.size()==0)
			{
				throw new BusinessException("User DOB - "+dob+" not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured kindly contact SYSADMIN"+e);
		}
		return userList;
	}

	@Override
	public List<User> getUserByName(String name) throws BusinessException {
		List<User> userList = new ArrayList<>();
		try (Connection connection = OracleDbConnection.getConnection()){
			String sql = "select p.id,p.dob,p.email,"
					+ "p.gender,p.contact,t.teamName "
					+ "from Player p join teams t "
					+ "on p.team_id=t.team_id"
					+ " where p.name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getString("id"));
				user.setName(name);
				user.setEmail(resultSet.getString("email"));
				user.setTeamName(resultSet.getString("teamName"));
				user.setGender(resultSet.getString("gender"));
				user.setContact(resultSet.getLong("contact"));
				user.setDob(resultSet.getDate("dob"));
				userList.add(user);
				
			} 
			if(userList.size()==0)
			{
				throw new BusinessException("User name - "+name+" not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured kindly contact SYSADMIN"+e);
		}
		return userList;
	}

	@Override
	public List<User> getUserByTeamName(String teamName) throws BusinessException {
		List<User> userList = new ArrayList<>();
		try (Connection connection = OracleDbConnection.getConnection()){
			String sql = "select p.id,p.name,p.dob,p.email,"
					+ "p.gender,p.contact "
					+ "from Player p join teams t "
					+ "on p.team_id=t.team_id"
					+ " where t.teamName=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teamName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getString("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setTeamName(teamName);
				user.setGender(resultSet.getString("gender"));
				user.setContact(resultSet.getLong("contact"));
				user.setDob(resultSet.getDate("dob"));
				userList.add(user);
				
			} 
			if(userList.size()==0)
			{
				throw new BusinessException("User with teamname - "+teamName+" not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error occured kindly contact SYSADMIN"+e);
		}
		return userList;
	}

	@Override
	public User registerUser(User user) throws BusinessException {
		try (Connection connection = OracleDbConnection.getConnection()){
			String sql = "{call REGISTERPlayer(?,?,?,?,?,?,?,?)}"; //if function then {call ?=REGISTERUser(?,?,?,?,?,?,?)}
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);
			callableStatement.setString(2, user.getName());
			callableStatement.setDate(3, new java.sql.Date(user.getDob().getTime()) );
			callableStatement.setString(4, user.getEmail());
			callableStatement.setString(5, user.getGender());
			callableStatement.setString(6, user.getTeamName());
			callableStatement.setLong(7, user.getContact());
			callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
			
			callableStatement.execute();
			System.out.println(callableStatement.getString(1));
			if(callableStatement.getString(8) == null) {
				user.setId(callableStatement.getString(1));
				System.out.println("Registered");
			} else {
				throw new SQLException(callableStatement.getString(8));
			}
			user.setId(callableStatement.getString(1));
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal error occured kindly contact SYSADMIN"+e);
		}
		
		
		return user;
	}

	@Override
	public boolean updateUser(String id, long newContact) throws BusinessException {
		boolean b = false;
		try (Connection connection = OracleDbConnection.getConnection()){
			String sql = "UPDATE player SET contact = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(2, id);
			preparedStatement.setLong(1, newContact);
			
			b = preparedStatement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal error occured kindly contact SYSADMIN"+e);
		}
		
		return b;
	}

	@Override
	public boolean deleteUser(String id) throws BusinessException {
		boolean b = false;
		try (Connection connection = OracleDbConnection.getConnection()){
			String sql = "delete from player_login where id = ?";
			String sql2 = "delete from player where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			b = preparedStatement.execute();
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setString(1, id);
			b = preparedStatement2.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal error occured kindly contact SYSADMIN"+e);
		}
		return b;
	}

	@Override
	public Team registerTeam(Team team) throws BusinessException {
		try (Connection connection = OracleDbConnection.getConnection()){
			String sql = "{call REGISTERTEAM(?,?,?,?)}";
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.setString(2, team.getTeamName());
			callableStatement.setString(3, team.getCoachName());
			callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
			
			callableStatement.execute();

			team.setTeam_id(callableStatement.getInt(1));
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal error occured kindly contact SYSADMIN"+e);
		}
		return team;
	}

	@Override
	public List<Team> getAllTeams() throws BusinessException {
		List<Team> teamList = new ArrayList<>();
		try (Connection connection = OracleDbConnection.getConnection()){
			String sql = "select team_id, teamname, coachname "
					+ "from teams";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Team team = new Team();
				team.setTeam_id(resultSet.getInt("team_id"));
				team.setTeamName(resultSet.getString("teamname"));
				team.setCoachName(resultSet.getString("coachname"));
				
				teamList.add(team);
			}
			if(teamList.size()==0)
			{
				throw new BusinessException("No Teams found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal error occured kindly contact SYSADMIN"+e);
		}
		return teamList;
	}

	@Override
	public List<User> getAllUsers() throws BusinessException {
		List<User> userList = new ArrayList<>();
		try (Connection connection = OracleDbConnection.getConnection()){
			String sql = "select p.id, p.name, p.dob, p.email, p.gender, p.contact, teamname "
					+ "from Player p join teams t on p.team_id = t.team_id";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getString("id"));
				user.setName(resultSet.getString("name"));
				user.setDob(resultSet.getDate("dob")); 
				user.setEmail(resultSet.getString("email"));
				user.setGender(resultSet.getString("gender"));
				user.setContact(resultSet.getLong("contact"));
				user.setTeamName(resultSet.getString("teamname"));
				userList.add(user);
			}
			if(userList.size()==0)
			{
				throw new BusinessException("No Users found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal error occured kindly contact SYSADMIN"+e);
		}
		return userList;
	}

}
