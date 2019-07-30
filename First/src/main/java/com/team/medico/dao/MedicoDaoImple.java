package com.team.medico.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
import com.team.medico.model.Disease;
import com.team.medico.model.Doctor;
import com.team.medico.model.History;
import com.team.medico.model.Patient;
import com.team.medico.model.PreferredLanguage;
import com.team.medico.model.Symptoms;
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

	
		Session session = this.sessionFactory.openSession();
		User user1 = (User) session.get(User.class, user.getEmailId());
		session.close();

		if (BCrypt.checkpw(user.getPassword(), user1.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public User getUserByEmailId(String emailId) {
		Session session = this.sessionFactory.openSession();
		User user = (User) session.get(User.class, emailId);
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

	//@Scheduled(fixedRate = 86400000)
	public void demoServiceMethod() {
		long millis = System.currentTimeMillis(); // current date
		updateAppointmentBookingStatusToUnused();
		updateTimeslotStatusToUnused();
		List<Doctor> docList = getApprovedDoctor();// fetching all approved doctor
		if (docList != null) {
			for (Doctor doc : docList) {

				String strTime = doc.getPracticeHoursStart(); // cal the time slots
				String endTime = doc.getPracticeHoursEnd();
				String[] arrOfStr = strTime.split(":", 2);
				int str = Integer.parseInt(arrOfStr[0]);
				String[] arrOfStr1 = endTime.split(":", 2);
				int end = Integer.parseInt(arrOfStr1[0]);
				while (str < end) { // inserting each time slots to db
					String str1 = str + ":" + arrOfStr[1];
					str++;
					String str2 = str + ":" + arrOfStr[1];
					Timeslot ts = new Timeslot(doc.getEmailId(), str1, str2, new java.sql.Date(millis), "unbooked",
							doc);
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
		PreferredLanguage preferredLanguage = (PreferredLanguage) session.get(PreferredLanguage.class, languageId);
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
		Doctor doctor = (Doctor) session.get(Doctor.class, emailId);
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
		if (!userList.isEmpty()) {
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
		if (!userList.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Patient getPatientByEmailId(String emailId) {
		Session session = this.sessionFactory.openSession();
		Patient patient = (Patient) session.get(Patient.class, emailId);
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
		for (Timeslot slot : timeSlotList) {
			AppointmentBooking app = (AppointmentBooking) session.get(AppointmentBooking.class, slot.getSlotId());
			if (app != null) {
				appList.add(app);
			}
		}

		session.close();
		return appList;
	}

	@Override
	public Timeslot getTimeSlotById(int slotId) {
		Session session = this.sessionFactory.openSession();
		Timeslot timeslot = (Timeslot) session.get(Timeslot.class, slotId);
		session.close();
		return timeslot;
	}

	@Override
	public void insertTokenToAppointment(String token, int slotId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		AppointmentBooking app = (AppointmentBooking) session.get(AppointmentBooking.class, slotId);
		app.setToken(token);
		session.save(app);
		tx.commit();
		session.close();
	}

	@Override
	public boolean checkToken(int slotId) {
		Session session = this.sessionFactory.openSession();
		AppointmentBooking app = (AppointmentBooking) session.get(AppointmentBooking.class, slotId);
		session.close();
		if (app.getToken() != null) {
			return true;
		}
		return false;
	}

	@Override
	public String getToken(int slotId) {
		Session session = this.sessionFactory.openSession();
		AppointmentBooking app = (AppointmentBooking) session.get(AppointmentBooking.class, slotId);
		session.close();
		return app.getToken();
	}

	@Override
	public void updateTimeSlotStatus(int slotId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Timeslot timeslot = (Timeslot) session.get(Timeslot.class, slotId);
		timeslot.setTimeSlotStatus("completed");
		session.save(timeslot);
		tx.commit();
		session.close();
	}

	@Override
	public void updateAppointmentBookingStatus(int slotId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		AppointmentBooking app = (AppointmentBooking) session.get(AppointmentBooking.class, slotId);
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

	@Override
	public void updateAppointmentBookingStatusToUnused() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from AppointmentBooking where status=?");
		q.setString(0, "unbooked");
		List<AppointmentBooking> appList = q.list();
		for (AppointmentBooking appointment : appList) {
			appointment.setStatus("unused");
			session.save(appointment);
		}
		tx.commit();
		session.close();
	}

	@Override
	public void updateTimeslotStatusToUnused() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery("from Timeslot where timeSlotStatus=?");
		q.setString(0, "unbooked");
		List<Timeslot> slotList = q.list();
		for (Timeslot slot : slotList) {
			slot.setTimeSlotStatus("unused");
			session.save(slot);
		}
		tx.commit();
		session.close();
	}

	@Override
	public List<Doctor> getAllDoctor() {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from Doctor");
		List<Doctor> doctorList = q.list();
		session.close();
		if (!doctorList.isEmpty()) {
			return doctorList;
		}
		return null;
	}

	@Override
	public Doctor getDoctor1(String email) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from Doctor where email_id=?");
		q.setString(0, email);
		q.setMaxResults(1);
		Doctor doctor = (Doctor) q.uniqueResult();

		session.close();
		if (doctor != null) {
			return doctor;
		}
		return null;
	}

	@Override
	public List<User> getAllUser() {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from User");
		List<User> userList = q.list();
		session.close();
		if (!userList.isEmpty()) {
			return userList;
		}
		return userList;
	}

	@Override
	public Doctor approveDoctor(String email) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("update Doctor set status='Approved' where emailId=?");
		q.setParameter(0, email);
		int count = q.executeUpdate();

		session.close();
		if (count > 0) {

			return null;
		}
		return null;
	}

	@Override
	public Doctor deleteDoctor(String email) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("update User set isActive=? where emailId=?");
		q.setBoolean(0, false);
		q.setParameter(1, email);
		int count = q.executeUpdate();

		Query q1 = session.createQuery("update Doctor set status=? where emailId=?");
		q1.setString(0, "deleted");
		q1.setParameter(1, email);
		int count1 = q1.executeUpdate();
		session.close();
		if (count > 0) {

			return null;
		}
		return null;
	}

	@Override
	public List<Doctor> getApprovedDoctorSpec(String spec) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from Doctor where status = ? and specialization = ?");
		q.setString(0, "Approved");
		q.setString(1, spec);
		List<Doctor> docListSpec = q.list();
		session.close();
		return docListSpec;
	}

	@Override
	public List<Timeslot> getTimeSlotOfDoctor(String emailId) {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from Timeslot where emailId = ? and timeSlotStatus = ?");
		q.setString(0, emailId);
		q.setString(1, "unbooked");
		List<Timeslot> timeList = q.list();
		session.close();
		return timeList;
	}

	@Override
	public void updateTimeSlotUpdateToBooked(int slotId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Timeslot timeslot = (Timeslot) session.get(Timeslot.class, slotId);
		timeslot.setTimeSlotStatus("booked");
		session.save(timeslot);
		tx.commit();
		session.close();
	}

	@Override
	public void insertIntoAppointmentBooking(int slotId, String emailId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Timeslot timeslot = (Timeslot) session.get(Timeslot.class, slotId);
		Patient patient = (Patient) session.get(Patient.class, emailId);
		AppointmentBooking app = new AppointmentBooking(slotId, emailId, "booked", patient, timeslot);
		session.save(app);
		tx.commit();
		session.close();

	}

	@Override
	public List<User> getUserPatient() {
		Session session = this.sessionFactory.openSession();
		Query q = session.createQuery("from User where userType=?");
		q.setString(0, "patient");
		List<User> userList = q.list();
		session.close();
		return userList;
	}

	@Override
	public List<Symptoms> showSymtoms() {
		Session session = this.sessionFactory.openSession();

		Query q = session.createQuery("from Symptoms");
		List<Symptoms> symptomsList = q.list();

		return symptomsList;
	}

	@Override
	public Disease getDetails(int[] syList) {
		Session session = this.sessionFactory.openSession();
		List<Integer> newList = new ArrayList<Integer>();

		for (Integer s : syList) {
			newList.add(s);
		}

		Query q = session.createQuery("from Symptoms where symptomsId in (:list)").setParameterList("list", newList);

		List<Symptoms> symptomList = q.list();

		List<Integer> disList = new ArrayList<Integer>();
		for (Symptoms si : symptomList) {
			Set<Disease> disease = si.getDisease();
			for (Disease d : disease) {
				disList.add(d.getDiseaseId());
			}
		}

		// hashmap to store the frequency of element
		Map<Integer, Integer> hm = new TreeMap<Integer, Integer>();

		for (Integer disId : disList) {
			Integer count = hm.get(disId);
			hm.put(disId, (count == null) ? 1 : count + 1);
		}

		Map.Entry<Integer, Integer> max = null;
		// displaying the occurrence of elements in the arraylist
		for (Map.Entry<Integer, Integer> val : hm.entrySet()) {
			if (max == null || val.getValue().compareTo(max.getValue()) > 0) {
				max = val;
			}
		}


		Session session1 = this.sessionFactory.openSession();
		Disease d1 = (Disease) session1.get(Disease.class, max.getKey());

		

		session1.close();
		return d1;
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
