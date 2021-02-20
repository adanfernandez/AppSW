package business.panelmanager;

import java.util.List;

import model.Panel;

public interface PanelManagerService {
	
	public List<Panel> getPanelsFromUser(long id);
	
	public boolean deletePanel(long id);
	
	public boolean updatePanel(Panel updated);
	
	public boolean savePanel(Panel newPanel);
	
}
