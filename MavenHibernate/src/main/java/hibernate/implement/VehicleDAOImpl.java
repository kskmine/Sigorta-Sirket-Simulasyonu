package hibernate.implement;

import java.util.List;

import javax.persistence.Query;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;

import hibernate.interfaces.VehicleDAO;
import hibernate.model.Customer;
import hibernate.model.Vehicle;
import hibernate.utility.HibernateUtility;


public class VehicleDAOImpl implements VehicleDAO{
	
	Session session = HibernateUtility.getSessionFactory().openSession();

	@Override
	public Vehicle insertVehicle(Vehicle v) {
		
		try {
			session.beginTransaction();
			session.persist(v);

			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			if (session.getTransaction()!=null) session.getTransaction().rollback();
	    	e.printStackTrace(); 
		  }		
		return v;
		
	}

	@Override
	public List<Vehicle> getAllVehicles() {
         List<Vehicle> vehicles =null;
     
         try {
        	 session.beginTransaction();
	          vehicles = session.createQuery("FROM u vehicle").list(); }
	         
	          catch (HibernateException e) {
			if (session.getTransaction()!=null) session.getTransaction().rollback();
	    	  e.printStackTrace(); 
		  }
	   return vehicles;
	}

	@Override
	public void addCustomer(int id, int customerid) {
		try{
	         session.beginTransaction();
	         Vehicle vehicle = session.get(Vehicle.class, id); 
	         Customer customer=session.get(Customer.class, customerid);
	         customer.getVehicles().add(vehicle);
	         vehicle.setCustomer(customer);
	         session.update(vehicle); 
			 session.getTransaction().commit();
	    }
		catch (HibernateException e) {
	         if (session.getTransaction()!=null) session.getTransaction().rollback();
	         e.printStackTrace(); 
	    }
		
	}

	@Override
	public void removeVehicle(int id) {
		Transaction tx = null;
		try{
	         Vehicle vehicle = session.get(Vehicle.class, id); 
	         session.delete(vehicle); 
	         tx = session.beginTransaction();
	         // do something
	         tx.commit();
	     } catch (Exception exp) {
	         tx.rollback();
	         // close session
	     }
	}

	@Override
	public Vehicle findcountVehicle(int id) {
		
		Vehicle vehicle=session.get(Vehicle.class, id);
		Customer customer=session.get(Customer.class, id);
		
		
		Query query = session.createQuery("select count(v) from Vehicle v where v.customer.customerId = :customer_customerid  ");
		query.setParameter("customer_customerid", id);

		//List result=query.getResultList();
		Long result =(Long)query.getSingleResult();


		System.out.println(customer.getCustomerId()+" id no'lu mÃ¼ÅŸterinin "+result +" tane aracÄ± vardÄ±r.");
		return null;
	}

	@Override
	public void updateVehicle(int vehicleId, String model, String licencePlate, String brand) {
		// TODO Auto-generated method stub
		
	}

}
