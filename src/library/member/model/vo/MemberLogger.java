package library.member.model.vo;

import java.sql.Date;

public class MemberLogger {
	private int logNo;
	private Date logDate;
	private String memberId;
	private String status;
	private String ip;
	
	public MemberLogger() {}

	public MemberLogger(int logNo, Date logDate, String memberId, String status, String ip) {
		this.logNo = logNo;
		this.logDate = logDate;
		this.memberId = memberId;
		this.status = status;
		this.ip = ip;
	}

	public int getLogNo() {
		return logNo;
	}

	public void setLogNo(int logNo) {
		this.logNo = logNo;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return logNo + "\t" + logDate + "\t" + memberId + "\t" + status + "\t" + ip;
	}
	
	
}
