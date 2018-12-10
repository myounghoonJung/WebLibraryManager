package library.model.vo;

import java.sql.Date;

public class UserQuit extends User {
	
	private Date quitDate; // 탈퇴 시간

	
	public UserQuit() {}
	
	public UserQuit(String userId, String userPw, String userName, String gender, int age, String phone,
			int borrowHistoryCount, Date enrollDate) {
		super(userId, userPw, userName, gender, age, phone, borrowHistoryCount, enrollDate);
	}

	public Date getQuitDate() {
		return quitDate;
	}
	
	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}

	@Override
	public String toString() {
		return super.getUserId() + "\t" + super.getUserPw() + "\t" + super.getUserName() + "\t" + super.getGender()
		+ "\t" + super.getAge() + "\t" + super.getPhone() + "\t" + super.getBorrowHistoryCount() + "\t" + super.getEnrollDate() 
		+ "\t" + quitDate;
	}
	
	
	
}
