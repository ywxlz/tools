package org.tools.dao;

import java.util.List;

import org.tools.bean.DailyLog;

public interface IDailyLogDao {
	/**
	 * 查询全部
	 * @return
	 */
	List<DailyLog> query();
	/**
	 * 根据用户id查询
	 * @param userid
	 * @return
	 */
	List<DailyLog> queryByUser(String userid);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	DailyLog queryById(String id);
}
