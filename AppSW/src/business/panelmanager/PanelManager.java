package business.panelmanager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.exceptions.DatabaseErrorException;
import infraestructure.FactoryHelper;
import model.Panel;
import persistence.panel.PanelDataService;

public class PanelManager implements PanelManagerService {
	
	private PanelDataService dataService = null;

	@Override
	public List<Panel> getPanelsFromUser(long userId) throws DatabaseErrorException {
		List<Panel> panels = new ArrayList<Panel>();
		try {
			panels = getDataService().getPanelListByUser(userId);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			throw new DatabaseErrorException();
		}

		return panels;
	}

	@Override
	public boolean deletePanel(long id) throws DatabaseErrorException {
		try {
			return getDataService().deletePanel(id);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			throw new DatabaseErrorException();
		}
	}

	@Override
	public boolean updatePanel(Panel updated) throws DatabaseErrorException {
		try {
			return getDataService().updatePanel(updated, updated.getId());
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			
			throw new DatabaseErrorException();
		}
	}

	@Override
	public boolean savePanel(Panel newPanel) throws DatabaseErrorException {
		try {
			return getDataService().savePanel(newPanel);
		} catch (SQLException ex) {
			// TODO : VER COMO MEJORAR ESTA PARTE.
			throw new DatabaseErrorException();
		}
	}
	
	private PanelDataService getDataService() {
		if (dataService == null) {
			dataService = FactoryHelper.dataServices.getPanelDataService();
		}

		return dataService;
	}

}
