package persistence;

import persistence.panel.PanelDataService;
import persistence.state.StateDataService;
import persistence.task.TaskDataService;


public interface DataServiceFactory {
	
	public PanelDataService getPanelDataService();
	
	public StateDataService getStateDataService();
	
	public TaskDataService getTaskDataService();
		
}
