package hibernate.interfaces;

import java.util.List;

import hibernate.model.Accident;

public interface AccidentDAO {
		
public Accident insertAccident(Accident ac);
	
	public List<Accident> getAllAccidents();

	public void updateAccident(int accidentId,String accidentType,String date);
	public void removeCustomer(int id);
	public Accident findCustomer(int id);
}
