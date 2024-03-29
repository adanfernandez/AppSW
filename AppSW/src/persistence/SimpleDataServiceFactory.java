package persistence;

import persistence.panel.PanelDAO;
import persistence.panel.PanelDataService;
import persistence.state.StateDAO;
import persistence.state.StateDataService;
import persistence.task.TaskDAO;
import persistence.task.TaskDataService;

public class SimpleDataServiceFactory implements DataServiceFactory {

	@Override
	public PanelDataService getPanelDataService() {
		return new PanelDAO();
	}

	@Override
	public StateDataService getStateDataService() {
		return new StateDAO();
	}

	@Override
	public TaskDataService getTaskDataService() {
		return new TaskDAO();
	}

}
