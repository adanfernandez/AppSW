package business;

import business.panelmanager.PanelManagerService;
import business.statemanager.StateManagerService;
import business.taskmanager.TaskManagerService;
import business.usermanager.UserManagerService;

public interface BusinessFactory {
	
	public UserManagerService getUserManagerService();
	
	public StateManagerService getStateManagerService();
	
	public TaskManagerService getTaskManagerService();
	
	public PanelManagerService getPanelManagerService();
}
