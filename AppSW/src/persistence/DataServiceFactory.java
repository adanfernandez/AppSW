package persistence;

import persistence.panel.PanelDataService;
import persistence.state.StateDataService;
import persistence.task.TaskDataService;
import persistence.user.UserDataService;

public interface DataServiceFactory {
	
	public PanelDataService getPanelDataService();
	
	public StateDataService getStateDataService();
	
	public TaskDataService getTaskDataService();
	
	public UserDataService getUserDataService();
	
}
