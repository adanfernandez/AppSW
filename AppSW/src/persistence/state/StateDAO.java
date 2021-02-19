package persistence.state;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.State;
import persistence.MySQLCon;

public class StateDAO implements StateDataService {

	@Override
	public Connection getConnection() {
		return new MySQLCon().getConnection();
	}

	@Override
	public List<State> getStateListByPanel(long panelId) throws SQLException {
		String query = "Select id, order, name, panel_id FROM state WHERE panel_id = ?;";
		List<State> states = new ArrayList<State>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setLong(1, panelId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				states.add(this.getState(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getConnection().close();
		}
		return states;
	}

	@Override
	public boolean updateState(State uptdatedState, long stateId) throws SQLException {
		String query = "UPDATE state SET order = ?, name = ?, panel_id = ? where id= ?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setInt(1, uptdatedState.getOrder());
			ps.setString(2, uptdatedState.getName());
			ps.setLong(3, uptdatedState.getPanelId());
			ps.setLong(4, stateId);
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
	public boolean saveState(State newState) throws SQLException {
		String query = "INSERT INTO state(order, name, panel_id) VALUES (?, ?, ?);";
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setInt(1, newState.getOrder());
			ps.setString(2, newState.getName());
			ps.setLong(3, newState.getPanelId());

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
	public boolean deleteState(long stateId) throws SQLException {
		String query = "UPDATE state SET deleted=true WHERE id=?;";
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.setLong(1, stateId);
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getConnection().close();
		}
		return false;
	}

	private State getState(ResultSet rs) throws SQLException {
		State newState = new State();

		newState.setId(rs.getLong(1));
		newState.setOrder(rs.getInt(2));
		newState.setName(rs.getString(3));
		newState.setPanelId(rs.getLong(4));
		return newState;
	}

}
