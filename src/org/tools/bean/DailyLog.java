package org.tools.bean;

public class DailyLog {
	private String id;
	private String date;
	private String week;
	private String context;
	private String log;
	public DailyLog() {
		
	}
	public DailyLog(String id, String date, String week, String context,
			String log) {
		this.setId(id);
		this.setDate(date);
		this.setWeek(week);
		this.setContext(context);
		this.setLog(log);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
}
