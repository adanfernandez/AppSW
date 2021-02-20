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

	private Connection connection = null;

	@Override
	public Connection getConnection() {
		if (connection == null) {
			connection = new MySQLCon().getConnection();
		}
		return connection;
	}

	@Override
	public List<Task> getTaskListByState(long stateId) throws SQLException {
		String query = "Select id, title, location, description, expirationDate, state_id, deleted FROM task WHERE state_id = ?;";
		List<Task> tasks = new ArrayList<Task>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setLong(1, stateId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
	public boolean updateTask(Task updatedTask, long taskId) throws SQLException {
		String query = "UPDATE task SET title = ?, location = ?, expirationDate = ?, description = ?, id_state = ?, deleted = ? where id= ?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setString(1, updatedTask.getTitle());
			ps.setString(2, updatedTask.getLocation());
			ps.setDate(3, (Date) updatedTask.getExpirationDate());
			ps.setString(4, updatedTask.getDescription());
			ps.setLong(5, updatedTask.getStateId());
			ps.setBoolean(6, updatedTask.isDeleted());
			ps.setLong(7, taskId);
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
		newTask.setTitle(rs.getString(2));
		newTask.setLocation(rs.getString(3));
		newTask.setDescription(rs.getString(4));
		newTask.setExpirationDate(rs.getDate(5));
		newTask.setStateId(rs.getLong(6));
		newTask.setDeleted(rs.getBoolean(7));

		return newTask;
	}

}
