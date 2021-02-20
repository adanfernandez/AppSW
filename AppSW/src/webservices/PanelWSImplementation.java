package webservices;

import java.util.List;

import javax.jws.WebService;

import business.panelmanager.PanelManagerService;
import infraestructure.FactoryHelper;
import model.Panel;

@WebService(endpointInterface = "webservices.IPanelWS")
public class PanelWSImplementation implements IPanelWS {

	private PanelManagerService manager = null;

	@Override
	public List<Panel> getPanelsFromUser(long userId) {
		return getManager().getPanelsFromUser(userId);
	}

	@Override
	public boolean deletePanel(long id) {
		return getManager().deletePanel(id);
	}

	@Override
	public boolean updatePanel(Panel updated) {
		return getManager().updatePanel(updated);
	}

	@Override
	public boolean savePanel(Panel newPanel) {
		return getManager().savePanel(newPanel);
	}

	private PanelManagerService getManager() {
		if (manager == null) {
			manager = FactoryHelper.services.getPanelManagerService();
		}
		return manager;
	}

}
