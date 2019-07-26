package com.team.medico.dao;


import java.util.Date;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import com.team.medico.model.Admin;
import com.team.medico.model.Doctor;
import com.team.medico.model.History;
import com.team.medico.model.Patient;
import com.team.medico.model.PreferredLanguage;
import com.team.medico.model.Timeslot;
import com.team.medico.model.User;




@Repository
public class MedicoDaoImple implements MedicoDao {

	@Autowired
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	

	@SuppressWarnings("unchecked")
	@Override
	public boolean validateUser(User user) {
		
		System.out.println(user.getPassword());
		Session session = this.sessionFactory.openSession();
		User user1 = (User)session.get(User.class,user.getEmailId());
		session.close();
		
		if (BCrypt.checkpw(user.getPassword(), user1.getPassword())) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public User getUserByEmailId(String emailId) {
		Session session = this.sessionFactory.openSession();
		User user = (User)session.get(User.class,emailId);
		session.close();
		return user;
	}
	
	@Override
	public void savePatient(final Patient patient) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(patient);
		tx.commit();
		session.close();
	}
	
	@Override
	public void saveUser(final User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

	@Scheduled(fixedRate = 155000)
	public void demoServiceMethod()
    {
        long millis=System.currentTimeMillis();  //current date 
        
		List<Doctor> docList = getApprovedDoctor();//fetching all approved doctor
		if (docList != null) {
			for (Doctor doc : docList) {

				String strTime = doc.getPracticeHoursStart(); // cal the time slots
				String endTime = doc.getPracticeHoursEnd();
				String[] arrOfStr = strTime.split(":", 2);
				int str = Integer.parseInt(arrOfStr[0]);
				String[] arrOfStr1 = endTime.split(":", 2);
				int end = Integer.parseInt(arrOfStr1[0]);
				while (str < end) { //inserting each time slots to db
					String str1 = str + ":" + arrOfStr[1];
					str++;
					String str2 = str + ":" + arrOfStr[1];
					Timeslot ts = new Timeslot(doc.getEmailId(), str1, str2, new java.sql.Date(millis), "booked", doc);
					Session session = this.sessionFactory.openSession();
					Transaction tx = session.beginTransaction();

					session.save(ts);
					tx.commit();
					session.close();
				}
        		
        	}
        }
       
    }

	

	@Override
	public PreferredLanguage getLanguageById(String languageId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		PreferredLanguage preferredLanguage = (PreferredLanguage)session.get(PreferredLanguage.class,languageId);
		tx.commit();
		session.close();
		return preferredLanguage;
	}
	
	public void savePref(PreferredLanguage preferredLanguage) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(preferredLanguage);
		tx.commit();
		session.close();
	}

	@Override
	public void insertDoctor(Doctor doctor, User user) {
		Session session = this.sessionFactory.openSession();
		Transaction t = session.beginTransaction();
				
				session.save(user);
				session.save(doctor);
				t.commit();
				session.close();
		
	}



	@Override
	public void saveHistory(History history) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(history);
		tx.commit();
		session.close();
	}





	@Override
	public void saveAdmin(Admin admin) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(admin);
		tx.commit();
		session.close();
		
	}



	@Override
	public Doctor getDoctorByEmailId(String emailId) {
		Session session = this.sessionFactory.openSession();
		Doctor doctor = (Doctor)session.get(Doctor.class,emailId);
		session.close();
		return doctor;
	}



	@Override
	public boolean aadharExist(double aadhar) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from User where aadhar = ?");
		q.setDouble(0, aadhar);
		List<User> userList = q.list();
		session.close();
		if(!userList.isEmpty()) {
			return true;
		}
		return false;
	}



	@Override
	public boolean contactExist(String contact) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from User where contactNo = ?");
		q.setString(0, contact);
		List<User> userList = q.list();
		session.close();
		if(!userList.isEmpty()) {
			return true;
		}
		return false;
	}



	@Override
	public Patient getPatientByEmailId(String emailId) {
		Session session = this.sessionFactory.openSession();
		Patient patient = (Patient)session.get(Patient.class,emailId);
		session.close();
		return patient;
	}



	@Override
	public List<Doctor> getApprovedDoctor() {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from Doctor where status = ?");
		q.setString(0, "Approved");
		List<Doctor> docList = q.list();
		session.close();
		return docList;
	}

}

	

//@Transactional
//@Repository
//public class MedicoDaoImple extends AbstractDao<Integer, User> implements MedicoDao {
//
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	public boolean validateUser(final User user) {
//		
//		
//		try {
//		Session session = getSession();
//
//		Transaction tx = session.getTransaction();
//		
//				Query q = session.createQuery("from User where userName = ? and password = ?");
//q.setString(0, user.getUserName());
//q.setString(1, user.getPassword());
//List<User> userList = q.list();
//				if(!tx.wasCommitted()) {
//				tx.commit();
//				}
//				System.out.println("here");
//		if(!userList.isEmpty()) {
//			return true;
//		}	
//		return false;
//		}catch(Exception e) {
//			System.out.println(e.getStackTrace());
//			return false;
//		}
//	}
//	
//	
//}

