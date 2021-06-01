package webservices;

import java.util.List;

import javax.jws.WebService;

import business.exceptions.DatabaseErrorException;
import business.statemanager.StateManagerService;
import infraestructure.FactoryHelper;
import model.State;

@WebService(endpointInterface = "webservices.IStateWS")
public class StateWSImplementation implements IStateWS {

	private StateManagerService manager = null;

	@Override
	public List<State> getStatesFromPanel(long panelId) throws DatabaseErrorException {
		return getManager().getStatesByPanel(panelId);
	}

	@Override
	public boolean deleteState(long id) throws DatabaseErrorException {
		return getManager().deleteState(id);
	}

	@Override
	public boolean updateState(State updated) throws DatabaseErrorException {
		return getManager().updateState(updated);
	}

	@Override
	public boolean saveState(State newState) throws DatabaseErrorException {
		return getManager().saveState(newState);
	}

	private StateManagerService getManager() {
		if (manager == null) {
			manager = FactoryHelper.services.getStateManagerService();
		}
		return manager;
	}

}
