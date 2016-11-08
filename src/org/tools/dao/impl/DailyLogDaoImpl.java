package org.tools.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.tools.bean.DailyLog;
import org.tools.dao.IDailyLogDao;

/**
 * 
 * @author yuwei
 * @date 2016年11月8日 下午3:16:39
 * @version 1.0
 */

public class DailyLogDaoImpl extends HibernateDaoSupport implements IDailyLogDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<DailyLog> query() {
		String hql = "select * from dailylog";
		List<DailyLog> logs = super.getHibernateTemplate().find(hql);
		return logs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DailyLog> queryByUser(String userid) {
		String hql = "select * from dailylog";
		List<DailyLog> logs = super.getHibernateTemplate().find(hql);
		return logs;
	}

	@Override
	public DailyLog queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
