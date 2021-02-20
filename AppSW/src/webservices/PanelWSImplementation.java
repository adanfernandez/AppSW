package webservices;

import java.util.List;

import javax.jws.WebService;

import model.Panel;

@WebService(endpointInterface = "webservices.IpanelWS")
public class PanelWSImplementation implements IPanelWS {

	@Override
	public List<Panel> getPanelsFromUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePanel(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePanel(Panel updated) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean savePanel(Panel newPanel) {
		// TODO Auto-generated method stub
		return false;
	}

}
