package gov.water.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gov.water.model.DayEV;

@Repository
public class DayEVDaoImpl implements DayEVDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getSession() {
        return sessionFactory.openSession();
    }

	public DayEV selectByPrimaryKey(String stcd) {
		// TODO Auto-generated method stub
		String hql="from DayEV where stcd=?0";
        Query query = getSession().createQuery(hql).setString("0", stcd);
        if( query != null ){
        	return (DayEV)query.uniqueResult();
        }
        return null;
	}

	public DayEV selectByDate(String stcd, String date) {
		// TODO Auto-generated method stub
		String hql="from DayEV where stcd=?0 and CONVERT(varchar(10), tm, 23)=?1";
        Query query = getSession().createQuery(hql).setString("0", stcd).setString("1", date);
        if( query != null ){
        	return (DayEV)query.uniqueResult();
        }
        return null;
	}

	public int insertByPrimaryKey(DayEV dayEV) {
		// TODO Auto-generated method stub
		Session session = getSession();
        Transaction tran = session.beginTransaction();
        session.save(dayEV);
        tran.commit();
        session.close();
        return 1;
	}

	public int updateByPrimaryKey(DayEV dayEV) {
		// TODO Auto-generated method stub
		Session session = getSession();
        Transaction tran = session.beginTransaction();
        session.update(dayEV);
        tran.commit();
        session.close();
        return 1;
	}

	public Long selectCount(String from, String to) {
		// TODO Auto-generated method stub
		String hql="select count(*) from DayEV where CONVERT(varchar(10), tm, 23)>=?1 and CONVERT(varchar(10), tm, 23)<=?2";
        Query query = getSession().createQuery(hql).setString("1", from).setString("2", to);
        if( query != null ){
        	return (Long)query.uniqueResult();
        }
        return null;
	}

	public List<DayEV> selectFromTo(String from, String to, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		String hql = "from DayEV where CONVERT(varchar(10), tm, 23)>=?1 and CONVERT(varchar(10), tm, 23)<=?2 order by tm desc, stcd asc";
		Query query = getSession().createQuery(hql).setString("1", from).setString("2", to);
		if( offset > -1 ){
			query.setFirstResult(offset);
		}
		if( pageSize > 0 ){
			query.setMaxResults(pageSize);
		}
        return (List<DayEV>)query.list();
	}

	public Long selectCount(String stcd, String from, String to) {
		// TODO Auto-generated method stub
		String hql="select count(*) from DayEV where stcd=?0 and CONVERT(varchar(10), tm, 23)>=?1 and CONVERT(varchar(10), tm, 23)<=?2";
        Query query = getSession().createQuery(hql).setString("0", stcd).setString("1", from).setString("2", to);
        if( query != null ){
        	return (Long)query.uniqueResult();
        }
        return null;
	}

	public List<DayEV> selectFromTo(String stcd, String from, String to, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		String hql = "from DayEV where stcd=?0 and CONVERT(varchar(10), tm, 23)>=?1 and CONVERT(varchar(10), tm, 23)<=?2 order by tm desc";
		Query query = getSession().createQuery(hql).setString("0", stcd).setString("1", from).setString("2", to);
		if( offset > -1 ){
			query.setFirstResult(offset);
		}
		if( pageSize > 0 ){
			query.setMaxResults(pageSize);
		}
        return (List<DayEV>)query.list();
	}
}
