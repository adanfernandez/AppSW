package business.panelmanager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import infraestructure.FactoryHelper;
import model.Panel;
import persistence.panel.PanelDataService;

public class PanelManager implements PanelManagerService {
	
	private PanelDataService dataService = null;

	@Override
	public List<Panel> getPanelsFromUser(Long userId) {
		List<Panel> panels = new ArrayList<Panel>();
		try {
			panels = getDataService().getPanelListByUser(userId);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			ex.printStackTrace();
		}

		return panels;
	}

	@Override
	public boolean deletePanel(Long id) {
		try {
			return getDataService().deletePanel(id);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePanel(Panel updated) {
		try {
			return getDataService().updatePanel(updated, updated.getId());
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean savePanel(Panel newPanel) {
		try {
			return getDataService().savePanel(newPanel);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			ex.printStackTrace();
		}
		return false;
	}
	
	private PanelDataService getDataService() {
		if (dataService == null) {
			dataService = FactoryHelper.dataServices.getPanelDataService();
		}

		return dataService;
	}

}
