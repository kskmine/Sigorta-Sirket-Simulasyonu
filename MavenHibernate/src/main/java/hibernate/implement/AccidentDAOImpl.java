package hibernate.implement;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.interfaces.AccidentDAO;
import hibernate.model.Accident;
import hibernate.utility.HibernateUtility;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;

public class AccidentDAOImpl implements AccidentDAO{

	Session session = HibernateUtility.getSessionFactory().openSession();

	@Override
	public Accident insertAccident (Accident ac) {
		try{
			System.out.println(ac.getAccidentId());
			session.beginTransaction();
			session.persist(ac);
			session.getTransaction().commit();
			}
		    catch (HibernateException e) {
		    	if (session.getTransaction()!=null) session.getTransaction().rollback();
		    	e.printStackTrace(); 
			  }		
			return ac;	
			}

/*	@Override
	public Accident insertAccident(Accident ac) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<Accident> getAllAccidents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAccident(int accidentId, String accidentType, String date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCustomer(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Accident findCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
