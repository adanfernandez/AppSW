package business;

import business.panelmanager.PanelManagerService;
import business.statemanager.StateManagerService;
import business.taskmanager.TaskManagerService;

public interface BusinessFactory {
		
	public StateManagerService getStateManagerService();
	
	public TaskManagerService getTaskManagerService();
	
	public PanelManagerService getPanelManagerService();
}
