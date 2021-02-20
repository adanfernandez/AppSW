package persistence.state;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.State;
import persistence.MySQLCon;

public class StateDAO implements StateDataService {

	private MySQLCon connection = null;

	@Override
	public MySQLCon getDbConnection() {
		if (connection == null) {
			connection = new MySQLCon();
		}
		return connection;
	}

	@Override
	public List<State> getStateListByPanel(long panelId) throws SQLException {
		String query = "SELECT id, place, name, panel_id, deleted FROM state WHERE panel_id = ?;";
		List<State> states = new ArrayList<State>();
		try {
			PreparedStatement ps = getDbConnection().getConnection().prepareStatement(query);
			ps.setLong(1, panelId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				states.add(this.getState(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getDbConnection().closeConnection();
		}
		return states;
	}

	@Override
	public boolean updateState(State updatedState, long stateId) throws SQLException {
		String query = "UPDATE state SET place = ?, name = ?, panel_id = ?, deleted = ? WHERE id= ?;";
		try {
			PreparedStatement ps = getDbConnection().getConnection().prepareStatement(query);
			ps.setInt(1, updatedState.getPlace());
			ps.setString(2, updatedState.getName());
			ps.setLong(3, updatedState.getPanelId());
			ps.setBoolean(4, updatedState.isDeleted());
			ps.setLong(5, stateId);
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
	public boolean saveState(State newState) throws SQLException {
		String query = "INSERT INTO state(place, name, panel_id) VALUES (?, ?, ?);";
		try {
			PreparedStatement ps = getDbConnection().getConnection().prepareStatement(query);
			ps.setInt(1, newState.getPlace());
			ps.setString(2, newState.getName());
			ps.setLong(3, newState.getPanelId());

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
	public boolean deleteState(long stateId) throws SQLException {
		String query = "UPDATE state SET deleted=true WHERE id=?;";
		try {
			PreparedStatement ps = getDbConnection().getConnection().prepareStatement(query);
			ps.setLong(1, stateId);
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getDbConnection().closeConnection();
		}
		return false;
	}

	private State getState(ResultSet rs) throws SQLException {
		State newState = new State();

		newState.setId(rs.getLong(1));
		newState.setPlace(rs.getInt(2));
		newState.setName(rs.getString(3));
		newState.setPanelId(rs.getLong(4));
		newState.setDeleted(rs.getBoolean(5));
		return newState;
	}

}
