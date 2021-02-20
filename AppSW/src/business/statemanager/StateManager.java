package business.statemanager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infraestructure.FactoryHelper;
import model.State;
import persistence.state.StateDataService;

public class StateManager implements StateManagerService {

	private StateDataService dataService = null;

	@Override
	public List<State> getStatesByPanel(long panelId) {
		List<State> states = new ArrayList<State>();
		try {
			states = getDataService().getStateListByPanel(panelId);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			ex.printStackTrace();
		}

		return states;
	}

	@Override
	public boolean deleteState(long id) {
		try {
			return getDataService().deleteState(id);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateState(State updated) {
		try {
			return getDataService().updateState(updated, updated.getId());
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveState(State newState) {
		try {
			return getDataService().saveState(newState);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			ex.printStackTrace();
		}
		return false;
	}

	private StateDataService getDataService() {
		if (dataService == null) {
			dataService = FactoryHelper.dataServices.getStateDataService();
		}

		return dataService;
	}

}
