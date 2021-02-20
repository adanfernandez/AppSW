package persistence.panel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.Panel;

public interface PanelDataService {

	Connection getConnection();

	public List<Panel> getPanelListByUser(long userId) throws SQLException;

	public boolean savePanel(Panel newPanel) throws SQLException;

	public boolean updatePanel(Panel updatedPanel, long panelId) throws SQLException;

	public boolean deletePanel(long panelId) throws SQLException;

	public boolean isOwner(long panelId, long userId) throws SQLException;
}
