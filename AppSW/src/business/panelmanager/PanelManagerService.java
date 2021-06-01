package business.panelmanager;

import java.util.List;

import business.exceptions.DatabaseErrorException;
import model.Panel;

public interface PanelManagerService {
	
	public List<Panel> getPanelsFromUser(long id) throws DatabaseErrorException;
	
	public boolean deletePanel(long id) throws DatabaseErrorException;
	
	public boolean updatePanel(Panel updated) throws DatabaseErrorException;
	
	public boolean savePanel(Panel newPanel) throws DatabaseErrorException;
	
}
