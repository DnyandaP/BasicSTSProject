package com.team.medico.dao;


import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
		Query q = session.createQuery("from User where userName = ? and password = ?");
		q.setString(0, user.getUserName());
		q.setString(1, user.getPassword());
		List<User> userList = q.list();
		session.close();
		if(!userList.isEmpty()) {
			return true;
		}
		return false;
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
//				q.setString(0, user.getUserName());
//				q.setString(1, user.getPassword());
//				List<User> userList = q.list();
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

