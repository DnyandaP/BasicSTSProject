package com.team.medico.dao;


import java.util.ArrayList;
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
import com.team.medico.model.AppointmentBooking;
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

	//@Scheduled(fixedRate = 155000)
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



	@Override
	public List<Timeslot> getBookedTimeSlots(String emailId) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from Timeslot where timeSlotStatus = ? and emailId=?");
		q.setString(0, "booked");
		q.setString(1, emailId);
		List<Timeslot> timeSlotList = q.list();
		session.close();
		return timeSlotList;
	}



	@Override
	public List<AppointmentBooking> getBookedAppointment(String emailId) {
		List<AppointmentBooking> appList = new ArrayList<AppointmentBooking>();
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from Timeslot where timeSlotStatus = ? and emailId=?");
		q.setString(0, "booked");
		q.setString(1, emailId);
		List<Timeslot> timeSlotList = q.list();
		for(Timeslot slot : timeSlotList ) {
			AppointmentBooking app = (AppointmentBooking)session.get(AppointmentBooking.class,slot.getSlotId());
			appList.add(app);
		}
		
		session.close();
		return appList;
	}



	@Override
	public Timeslot getTimeSlotById(int slotId) {
		Session session = this.sessionFactory.openSession();
		Timeslot timeslot = (Timeslot)session.get(Timeslot.class,slotId);
		session.close();
		return timeslot;
	}



	@Override
	public void insertTokenToAppointment(String token,int slotId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		AppointmentBooking app = (AppointmentBooking)session.get(AppointmentBooking.class, slotId);
		app.setToken(token);
		session.save(app);
		tx.commit();
		session.close();	
	}



	@Override
	public boolean checkToken(int slotId) {
		Session session = this.sessionFactory.openSession();
		AppointmentBooking app = (AppointmentBooking)session.get(AppointmentBooking.class, slotId);
		session.close();
		if(app.getToken()!=null) {
			return true;
		}
		return false;
	}



	@Override
	public String getToken(int slotId) {
		Session session = this.sessionFactory.openSession();
		AppointmentBooking app = (AppointmentBooking)session.get(AppointmentBooking.class, slotId);
		session.close();
		return app.getToken();
	}



	@Override
	public void updateTimeSlotStatus(int slotId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Timeslot timeslot = (Timeslot)session.get(Timeslot.class,slotId);
		timeslot.setTimeSlotStatus("completed");
		session.save(timeslot);
		tx.commit();
		session.close();
	}



	@Override
	public void updateAppointmentBookingStatus(int slotId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		AppointmentBooking app = (AppointmentBooking)session.get(AppointmentBooking.class, slotId);
		app.setStatus("completed");
		session.save(app);
		tx.commit();
		session.close();
	}



	@Override
	public List<AppointmentBooking> getBookedAppointmentForPat(String emailId) {
		Session session = this.sessionFactory.openSession();
		List<AppointmentBooking> appList;
		Query q = session.createQuery("from AppointmentBooking where emailId=? and status=?");
		q.setString(1, "booked");
		q.setString(0, emailId);
		appList = q.list();
		session.close();
		return appList;
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

