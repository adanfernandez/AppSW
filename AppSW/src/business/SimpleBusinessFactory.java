package business;

import business.panelmanager.PanelManager;
import business.panelmanager.PanelManagerService;
import business.statemanager.StateManager;
import business.statemanager.StateManagerService;
import business.taskmanager.TaskManager;
import business.taskmanager.TaskManagerService;

public class SimpleBusinessFactory implements BusinessFactory {

	@Override
	public StateManagerService getStateManagerService() {
		return new StateManager();
	}

	@Override
	public TaskManagerService getTaskManagerService() {
		return new TaskManager();
	}

	@Override
	public PanelManagerService getPanelManagerService() {
		return new PanelManager();
	}

}
