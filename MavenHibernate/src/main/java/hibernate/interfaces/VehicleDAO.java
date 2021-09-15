package hibernate.interfaces;
import java.util.List;

import hibernate.model.Vehicle;

public interface VehicleDAO {
	
	public Vehicle insertVehicle(Vehicle ac) ;
		
		public List<Vehicle> getAllVehicles();
		public void updateVehicle(int vehicleId,String model,String licencePlate,String brand) ;
		public void removeVehicle(int id) ;
		public Vehicle findcountVehicle(int id) ;

		void addCustomer(int id, int customerid);
}
