package gov.water.model;

import java.util.Date;

public class River {

	private DayPK daypk;
	private Float z;
	private Float q;
	private Float xsa;
	private Float xsavv;
	private Float xsmxv;
	private String flwchrcd;
	private String wptn;
	private String msqmt;
	private String msamt;
	private String msvmt;
	private Date tmInsert;
	private Date insertTime;
	private String stationTYP;
	public DayPK getDaypk() {
		return daypk;
	}
	public void setDaypk(DayPK daypk) {
		this.daypk = daypk;
	}
	public Float getZ() {
		return z;
	}
	public void setZ(Float z) {
		this.z = z;
	}
	public Float getQ() {
		return q;
	}
	public void setQ(Float q) {
		this.q = q;
	}
	public Float getXsa() {
		return xsa;
	}
	public void setXsa(Float xsa) {
		this.xsa = xsa;
	}
	public Float getXsavv() {
		return xsavv;
	}
	public void setXsavv(Float xsavv) {
		this.xsavv = xsavv;
	}
	public Float getXsmxv() {
		return xsmxv;
	}
	public void setXsmxv(Float xsmxv) {
		this.xsmxv = xsmxv;
	}
	public String getFlwchrcd() {
		return flwchrcd;
	}
	public void setFlwchrcd(String flwchrcd) {
		this.flwchrcd = flwchrcd;
	}
	public String getWptn() {
		return wptn;
	}
	public void setWptn(String wptn) {
		this.wptn = wptn;
	}
	public String getMsqmt() {
		return msqmt;
	}
	public void setMsqmt(String msqmt) {
		this.msqmt = msqmt;
	}
	public String getMsamt() {
		return msamt;
	}
	public void setMsamt(String msamt) {
		this.msamt = msamt;
	}
	public String getMsvmt() {
		return msvmt;
	}
	public void setMsvmt(String msvmt) {
		this.msvmt = msvmt;
	}
	public Date getTmInsert() {
		return tmInsert;
	}
	public void setTmInsert(Date tmInsert) {
		this.tmInsert = tmInsert;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public String getStationTYP() {
		return stationTYP;
	}
	public void setStationTYP(String stationTYP) {
		this.stationTYP = stationTYP;
	}
	
	
}
