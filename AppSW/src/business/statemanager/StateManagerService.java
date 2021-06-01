package business.statemanager;

import java.util.List;

import business.exceptions.DatabaseErrorException;
import model.State;

public interface StateManagerService {
	
	public List<State> getStatesByPanel(long panelId) throws DatabaseErrorException;
	
	public boolean deleteState(long id) throws DatabaseErrorException;
	
	public boolean updateState(State updated) throws DatabaseErrorException;
	
	public boolean saveState(State newState) throws DatabaseErrorException;

}
