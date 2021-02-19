package persistence.state;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.State;

public interface StateDataService {
	
	Connection getConnection();
	
	public List<State> getStateListByPanel(long panelId) throws SQLException;
		
	public boolean updateState(State uptdatedState, long stateId) throws SQLException;
	
	public boolean saveState(State newState) throws SQLException;
	
	public boolean deleteState(long stateId) throws SQLException;
	
}
