package cn.itcast.bos.domain.zm;

import java.util.Date;

/**
 * 出库
 * @author seawind
 *
 */
public class OutStore {
	private String id;
	private String info;
	private Date updateTime;
	
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
