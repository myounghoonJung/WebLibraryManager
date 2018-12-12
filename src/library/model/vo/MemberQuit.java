package library.model.vo;

import java.sql.Date;

public class MemberQuit extends Member {
	
	public MemberQuit() {}
	
	public MemberQuit(String memberId, String memberPw, String memberName, String gender, Date birthDay, String phone,
			String favoriteGenre, int historyBorrowCount, Date enrollDate, Date quitDate) {
		super(memberId, memberPw, memberName, gender, birthDay, phone, favoriteGenre, historyBorrowCount, enrollDate, quitDate);
	}
	
	@Override
	public String toString() {
		return super.getMemberId() + "\t" + super.getMemberPw() + "\t" + super.getMemberName() + "\t" + super.getGender()
			+ "\t" + super.getBirthDay() + "\t" + super.getPhone() + "\t" + super.getFavoriteGenre() + "\t" + super.getHistoryBorrowCount()
			+ "\t" + super.getEnrollDate() + "\t" + super.getQuitDate(); 
	}
}
