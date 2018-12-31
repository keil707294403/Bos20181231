package cn.itcast.bos.domain.zm;

import java.util.Date;

/**
 * 配送签收
 * @author seawind
 *
 */
public class ReceiveGoodsInfo {
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
