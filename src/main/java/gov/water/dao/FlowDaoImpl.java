package gov.water.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gov.water.model.River;

@Repository
public class FlowDaoImpl implements FlowDao{

	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getSession() {
        return sessionFactory.openSession();
    }

	public Long selectCount(String from, String to) {
		// TODO Auto-generated method stub
		String hql="select count(*) from River where CONVERT(varchar(10), tm, 23)>=?1 and CONVERT(varchar(10), tm, 23)<=?2";
        Query query = getSession().createQuery(hql).setString("1", from).setString("2", to);
        if( query != null ){
        	return (Long)query.uniqueResult();
        }
        return null;
	}

	public List<River> selectFromTo(String from, String to, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		String hql = "from River where CONVERT(varchar(10), tm, 23)>=?1 and CONVERT(varchar(10), tm, 23)<=?2 order by tm desc, stcd asc";
		Query query = getSession().createQuery(hql).setString("1", from).setString("2", to);
		if( offset > -1 ){
			query.setFirstResult(offset);
		}
		if( pageSize > 0 ){
			query.setMaxResults(pageSize);
		}
        return (List<River>)query.list();
	}

	public Long selectCount(String stcd, String from, String to) {
		// TODO Auto-generated method stub
		String hql="select count(*) from River where stcd=?0 and CONVERT(varchar(10), tm, 23)>=?1 and CONVERT(varchar(10), tm, 23)<=?2";
        Query query = getSession().createQuery(hql).setString("0", stcd).setString("1", from).setString("2", to);
        if( query != null ){
        	return (Long)query.uniqueResult();
        }
        return null;
	}

	public List<River> selectFromTo(String stcd, String from, String to, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		String hql = "from River where stcd=?0 and CONVERT(varchar(10), tm, 23)>=?1 and CONVERT(varchar(10), tm, 23)<=?2 order by tm desc";
		Query query = getSession().createQuery(hql).setString("0", stcd).setString("1", from).setString("2", to);
		if( offset > -1 ){
			query.setFirstResult(offset);
		}
		if( pageSize > 0 ){
			query.setMaxResults(pageSize);
		}
        return (List<River>)query.list();
	}

}
