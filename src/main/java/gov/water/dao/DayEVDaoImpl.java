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

	@Override
	public DayEV selectByDate(String stcd, String date) {
		// TODO Auto-generated method stub
		String hql="from DayEV where stcd=?0 and CONVERT(varchar(10), tm, 23)=?1";
        Query query = getSession().createQuery(hql).setString("0", stcd).setString("1", date);
        if( query != null ){
        	return (DayEV)query.uniqueResult();
        }
        return null;
	}
	
	@Override
	public int insertByPrimaryKey(DayEV dayEV) {
		// TODO Auto-generated method stub
		Session session = getSession();
        Transaction tran = session.beginTransaction();
        session.save(dayEV);    //执行
        tran.commit();  //提交
        session.close();
        return 1;
	}

	@Override
	public int updateByPrimaryKey(DayEV dayEV) {
		// TODO Auto-generated method stub
		/*String hql="update DayEV set dye=:dye where stcd=:daypk.stcd and CONVERT(varchar(10), tm, 23)=:daypk.tm";
		Query query = getSession().createQuery(hql);
		query.setProperties(dayEV);
        return query.executeUpdate();*/
		Session session = getSession();
        Transaction tran = session.beginTransaction();
        session.update(dayEV);    //执行
        tran.commit();  //提交
        session.close();
        return 1;
	}
	
	@Override
	public Long selectCount(String stcd, String from, String to) {
		// TODO Auto-generated method stub
		String hql="select count(*) from DayEV where stcd=?0 and CONVERT(varchar(10), tm, 23)>=?1 and CONVERT(varchar(10), tm, 23)<=?2";
        Query query = getSession().createQuery(hql).setString("0", stcd).setString("1", from).setString("2", to);
        if( query != null ){
        	return (Long)query.uniqueResult();
        }
        return null;
	}

	@Override
	public List<DayEV> selectFromTo(String stcd, String from, String to, Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		String hql = "from DayEV where stcd=?0 and CONVERT(varchar(10), tm, 23)>=?1 and CONVERT(varchar(10), tm, 23)<=?2";
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
