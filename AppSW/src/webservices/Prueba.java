package webservices;
import infraestructure.FactoryHelper;
import persistence.MySQLCon;

public class Prueba {

	public static void main(String[] args) {
		new MySQLCon().getConnection();
		System.out.println(FactoryHelper.services.getStateManagerService().getStatesByPanel(1L).size());
	}

}
