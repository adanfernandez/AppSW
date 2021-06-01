package business.statemanager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.exceptions.DatabaseErrorException;
import infraestructure.FactoryHelper;
import model.State;
import persistence.state.StateDataService;

public class StateManager implements StateManagerService {

	private StateDataService dataService = null;

	@Override
	public List<State> getStatesByPanel(long panelId) throws DatabaseErrorException {
		List<State> states = new ArrayList<State>();
		try {
			states = getDataService().getStateListByPanel(panelId);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			throw new DatabaseErrorException();
		}

		return states;
	}

	@Override
	public boolean deleteState(long id) throws DatabaseErrorException {
		try {
			return getDataService().deleteState(id);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			throw new DatabaseErrorException();
		}
	}

	@Override
	public boolean updateState(State updated) throws DatabaseErrorException {
		try {
			return getDataService().updateState(updated, updated.getId());
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			throw new DatabaseErrorException();
		}
	}

	@Override
	public boolean saveState(State newState) throws DatabaseErrorException {
		try {
			return getDataService().saveState(newState);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			throw new DatabaseErrorException();
		}
	}

	private StateDataService getDataService() {
		if (dataService == null) {
			dataService = FactoryHelper.dataServices.getStateDataService();
		}

		return dataService;
	}

}
