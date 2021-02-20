package business.statemanager;

import java.util.List;

import model.State;

public interface StateManagerService {
	
	public List<State> getStatesByPanel(long panelId);
	
	public boolean deleteState(long id);
	
	public boolean updateState(State updated);
	
	public boolean saveState(State newState);

}
