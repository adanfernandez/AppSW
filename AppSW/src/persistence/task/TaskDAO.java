package persistence.task;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Task;
import persistence.MySQLCon;

public class TaskDAO implements TaskDataService {

	@Override
	public Connection getConnection() {
		return new MySQLCon().getConnection();
	}

	@Override
	public List<Task> getTaskListByState(long stateId) throws SQLException {
		String query = "Select id, title, location, description, expirationDate, state_id FROM task WHERE state_id = ?;";
		List<Task> tasks = new ArrayList<Task>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setLong(1, stateId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				tasks.add(this.getTask(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getConnection().close();
		}
		return tasks;
	}

	@Override
	public boolean updateTask(Task uptdateTask, long taskId) throws SQLException {
		String query = "UPDATE task SET title = ?, location = ?, expirationDate = ?, description = ?, id_state = ? where id= ?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setString(1, uptdateTask.getTitle());
			ps.setString(2, uptdateTask.getLocation());
			ps.setDate(3, (Date) uptdateTask.getExpirationDate());
			ps.setString(4, uptdateTask.getDescription());
			ps.setLong(5, uptdateTask.getStateId());
			ps.setLong(6, taskId);
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getConnection().close();
		}
		return false;
	}

	@Override
	public boolean saveTask(Task newTask) throws SQLException {
		String query = "INSERT INTO task(title, location, expirationDate, description, id_state) VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setString(1, newTask.getTitle());
			ps.setString(2, newTask.getLocation());
			ps.setDate(3, (Date) newTask.getExpirationDate());
			ps.setString(4, newTask.getDescription());
			ps.setLong(5, newTask.getStateId());
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getConnection().close();
		}
		return false;
	}

	@Override
	public boolean deleteTask(long taskId) throws SQLException {
		String query = "UPDATE task SET deleted=true WHERE id=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setLong(1, taskId);
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getConnection().close();
		}
		return false;
	}


	private Task getTask(ResultSet rs) throws SQLException {
		Task newTask = new Task();
		newTask.setId(rs.getLong(1));
		
		return newTask;
	}

}
