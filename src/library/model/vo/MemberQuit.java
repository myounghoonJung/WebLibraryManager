package library.model.vo;

import java.sql.Date;

public class MemberQuit extends Member {
	private int quitNo;
	private Date quitDate;
	
	public MemberQuit() {}
	
	public MemberQuit(int quitNo, Date quitDate, String memberId, String memberPw, String memberName, String gender, Date birthDay, String phone,
			String favoriteGenre, int historyBorrowCount, Date enrollDate) {
		super(memberId, memberPw, memberName, gender, birthDay, phone, favoriteGenre, historyBorrowCount, enrollDate);
		this.quitNo = quitNo;
		this.quitDate = quitDate;
	}
	
	@Override
	public String toString() {
		return quitNo + "\t" + quitDate + "\t" + super.getMemberId() + "\t" + super.getMemberPw() + "\t" + super.getMemberName() + "\t" + super.getGender()
			+ "\t" + super.getBirthDay() + "\t" + super.getPhone() + "\t" + super.getFavoriteGenre() + "\t" + super.getHistoryBorrowCount()
			+ "\t" + super.getEnrollDate() + "\t";
	}
}
