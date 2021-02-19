package persistence.panel;

import model.Panel;

public interface PanelDataService {
		
	public boolean savePanel(Panel panel);

	public boolean updatePanel(Panel panel);
	
	public Panel getPanelById(long panel_id);
	
	public boolean deletePanel(Panel panel);
	
	public boolean isOwner(long panel_id, long user_id);
}
