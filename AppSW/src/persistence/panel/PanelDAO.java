package persistence.panel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Panel;
import persistence.MySQLCon;

public class PanelDAO implements PanelDataService {

	private MySQLCon connection = null;

	@Override
	public MySQLCon getDbConnection() {
		if (connection == null) {
			connection = new MySQLCon();
		}
		return connection;
	}

	@Override
	public List<Panel> getPanelListByUser(long userId) throws SQLException {
		String query = "SELECT id, name, user_id, deleted FROM panel WHERE user_id = ?;";
		List<Panel> panels = new ArrayList<Panel>();
		try {
			PreparedStatement ps = getDbConnection().getConnection().prepareStatement(query);
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				panels.add(this.getPanel(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getDbConnection().closeConnection();
		}
		return panels;
	}

	@Override
	public boolean savePanel(Panel newPanel) throws SQLException {
		String query = "INSERT INTO panel(name, user_id) VALUES (?, ?);";
		try {
			PreparedStatement ps = getDbConnection().getConnection().prepareStatement(query);
			ps.setString(1, newPanel.getName());
			ps.setLong(2, newPanel.getUserId());

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
	public boolean updatePanel(Panel updatedPanel, long panelId) throws SQLException {
		String query = "UPDATE panel SET name = ?, user_id = ?, deleted = ? WHERE id= ?;";
		try {
			PreparedStatement ps = getDbConnection().getConnection().prepareStatement(query);
			ps.setString(1, updatedPanel.getName());
			ps.setLong(2, updatedPanel.getUserId());
			ps.setBoolean(3, updatedPanel.isDeleted());
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
	public boolean deletePanel(long panelId) throws SQLException {
		String query = "UPDATE panel SET deleted=true WHERE id=?;";
		try {
			PreparedStatement ps = getDbConnection().getConnection().prepareStatement(query);
			ps.setLong(1, panelId);
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
	public boolean isOwner(long panelId, long userId) throws SQLException {
		String query = "SELECT id FROM panel WHERE id = ? AND  user_id = ?";
		try {
			PreparedStatement ps = getDbConnection().getConnection().prepareStatement(query);
			ps.setLong(1, panelId);
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			getDbConnection().closeConnection();
		}
		return false;
	}

	private Panel getPanel(ResultSet rs) throws SQLException {
		Panel newPanel = new Panel();

		newPanel.setId(rs.getLong(1));
		newPanel.setName(rs.getString(2));
		newPanel.setUserId(rs.getLong(3));
		newPanel.setDeleted(rs.getBoolean(4));
		return newPanel;
	}

}
