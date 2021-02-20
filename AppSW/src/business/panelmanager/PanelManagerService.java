package business.panelmanager;

import java.util.List;

import model.Panel;

public interface PanelManagerService {
	
	public List<Panel> getPanelsFromUser(Long id);
	
	public boolean deletePanel(Long id);
	
	public boolean updatePanel(Panel updated);
	
	public boolean savePanel(Panel newPanel);
	
}
