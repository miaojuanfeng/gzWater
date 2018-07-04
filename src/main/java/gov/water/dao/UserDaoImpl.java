package gov.water.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gov.water.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getSession() {
        return sessionFactory.openSession();
    }

	public User selectByPrimaryKey(String stcd) {
		// TODO Auto-generated method stub
		String hql="from User where stcd=?0";
        Query query = getSession().createQuery(hql).setString("0", stcd);
        if( query != null ){
        	return (User)query.uniqueResult();
        }
        return null;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		String hql = "from User where type='s'";
		Query query = getSession().createQuery(hql);
        return (List<User>)query.list();
	}

}
