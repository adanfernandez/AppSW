package persistence.task;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import model.Task;
import persistence.MySQLCon;

public class TaskDAO implements TaskDataService {

	private MySQLCon connection = null;

	@Override
	public MySQLCon getDbConnection() {
		if (connection == null) {
			connection = new MySQLCon();
		}
		return connection;
	}

	@Override
	public List<Task> getTaskListByState(long stateId) throws SQLException {
		String query = "Select id, title, location, description, expirationDate, state_id, deleted FROM task WHERE state_id = ? AND deleted <> 1;";
		List<Task> tasks = new ArrayList<Task>();
		try {
			PreparedStatement ps = getDbConnection().getConnection().prepareStatement(query);
			ps.setLong(1, stateId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tasks.add(this.getTask(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getDbConnection().closeConnection();
		}
		return tasks;
	}

	@Override
	public boolean updateTask(Task updatedTask, long taskId) throws SQLException {
		String query = "UPDATE task SET title = ?, location = ?, expirationDate = ?, description = ?, state_id = ?, deleted = ? where id= ?;";
		try {
			PreparedStatement ps = getDbConnection().getConnection().prepareStatement(query);
			ps.setString(1, updatedTask.getTitle());
			ps.setString(2, updatedTask.getLocation());
			ps.setTimestamp(3, updatedTask.getExpirationDate() == null ? null : new Timestamp(updatedTask.getExpirationDate().toGregorianCalendar().getTimeInMillis()));
			ps.setString(4, updatedTask.getDescription());
			ps.setLong(5, updatedTask.getStateId());
			ps.setBoolean(6, updatedTask.isDeleted());
			ps.setLong(7, taskId);
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getDbConnection().closeConnection();
		}
		return false;
	}

	@Override
	public boolean saveTask(Task newTask) throws SQLException {
		String query = "INSERT INTO task(title, location, expirationDate, description, state_id) VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement ps = getDbConnection().getConnection().prepareStatement(query);
			ps.setString(1, newTask.getTitle());
			ps.setString(2, newTask.getLocation());
			ps.setTimestamp(3, null);
			ps.setString(4, newTask.getDescription());
			ps.setLong(5, newTask.getStateId());
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getDbConnection().closeConnection();
		}
		return false;
	}

	@Override
	public boolean deleteTask(long taskId) throws SQLException {
		String query = "UPDATE task SET deleted=true WHERE id=?;";
		try {
			PreparedStatement ps = getDbConnection().getConnection().prepareStatement(query);
			ps.setLong(1, taskId);
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getDbConnection().closeConnection();
		}
		return false;
	}

	private Task getTask(ResultSet rs) throws SQLException {
		Task newTask = new Task();
		newTask.setId(rs.getLong(1));
		newTask.setTitle(rs.getString(2));
		newTask.setLocation(rs.getString(3));
		newTask.setDescription(rs.getString(4));
		newTask.setExpirationDate(convertTimestampToXmlGregorianCalendar(rs.getTimestamp(5)));
		newTask.setStateId(rs.getLong(6));
		newTask.setDeleted(rs.getBoolean(7));

		return newTask;
	}

	private XMLGregorianCalendar convertTimestampToXmlGregorianCalendar(Timestamp ts) {

		if (ts == null)
			return null;

		XMLGregorianCalendar cal;
		try {
			cal = DatatypeFactory.newInstance().newXMLGregorianCalendar();
			LocalDateTime ldt = ts.toLocalDateTime();

			cal.setYear(ldt.getYear());
			cal.setMonth(ldt.getMonthValue());
			cal.setDay(ldt.getDayOfMonth());
			cal.setHour(ldt.getHour());
			cal.setMinute(ldt.getMinute());
			cal.setSecond(ldt.getSecond());
			cal.setFractionalSecond(new BigDecimal("0." + ldt.getNano()));

			return cal;
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
