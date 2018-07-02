package gov.water.model;

import java.util.Date;

public class DayEV {
	
	private DayPK daypk;
	private String eptp;
	private Float dye;
	
	public DayPK getDaypk() {
		return daypk;
	}
	public void setDaypk(DayPK daypk) {
		this.daypk = daypk;
	}
	public String getEptp() {
		return eptp;
	}
	public void setEptp(String eptp) {
		this.eptp = eptp;
	}
	public Float getDye() {
		return dye;
	}
	public void setDye(Float dye) {
		this.dye = dye;
	}
}
