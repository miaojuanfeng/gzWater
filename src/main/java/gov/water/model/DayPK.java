package gov.water.model;

import java.util.Date;

public class DayPK implements java.io.Serializable{
	
	private String stcd;
	private Date tm;
	public String getStcd() {
		return stcd;
	}
	public void setStcd(String stcd) {
		this.stcd = stcd;
	}
	public Date getTm() {
		return tm;
	}
	public void setTm(Date tm) {
		this.tm = tm;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stcd == null) ? 0 : stcd.hashCode());
		result = prime * result + ((tm == null) ? 0 : tm.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DayPK other = (DayPK) obj;
		if (stcd == null) {
			if (other.stcd != null)
				return false;
		} else if (!stcd.equals(other.stcd))
			return false;
		if (tm == null) {
			if (other.tm != null)
				return false;
		} else if (!tm.equals(other.tm))
			return false;
		return true;
	}
	
	
}
