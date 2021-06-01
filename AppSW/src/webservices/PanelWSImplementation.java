package webservices;

import java.util.List;

import javax.jws.WebService;

import business.exceptions.DatabaseErrorException;
import business.panelmanager.PanelManagerService;
import infraestructure.FactoryHelper;
import model.Panel;

@WebService(endpointInterface = "webservices.IPanelWS")
public class PanelWSImplementation implements IPanelWS {

	private PanelManagerService manager = null;

	@Override
	public List<Panel> getPanelsFromUser(long userId) throws DatabaseErrorException {
		return getManager().getPanelsFromUser(userId);
	}

	@Override
	public boolean deletePanel(long id) throws DatabaseErrorException {
		return getManager().deletePanel(id);
	}

	@Override
	public boolean updatePanel(Panel updated) throws DatabaseErrorException {
		return getManager().updatePanel(updated);
	}

	@Override
	public boolean savePanel(Panel newPanel) throws DatabaseErrorException {
		return getManager().savePanel(newPanel);
	}

	private PanelManagerService getManager() {
		if (manager == null) {
			manager = FactoryHelper.services.getPanelManagerService();
		}
		return manager;
	}

}
