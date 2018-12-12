package library.model.vo;

import java.sql.Date;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String gender;
	private Date birthDay; // 생년월일
	private String phone;
	private String favoriteGenre; // 좋아하는 장르. 띄어쓰기없이 ,로 구분
	private int presentBorrowCount; // 현재 대여권수
	private int historyBorrowCount; // 총 대여권수
	private Date enrollDate; // 가입날짜
	private String quitflag; // 탈퇴유무(Y,N)
	private Date quitDate; // 탈퇴날짜
	
	public Member() {}

	// 회원가입용 생성자
	public Member(String memberId, String memberPw, String memberName, String gender, Date birthDay, String phone,
			String favoriteGenre) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.gender = gender;
		this.birthDay = birthDay;
		this.phone = phone;
		this.favoriteGenre = favoriteGenre;
	}
	
	// 회원조회용 생성자
	public Member(String memberId, String memberPw, String memberName, String gender, Date birthDay, String phone,
			String favoriteGenre, int presentBorrowCount, int historyBorrowCount, Date enrollDate, String quitflag,
			Date quitDate) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.gender = gender;
		this.birthDay = birthDay;
		this.phone = phone;
		this.favoriteGenre = favoriteGenre;
		this.presentBorrowCount = presentBorrowCount;
		this.historyBorrowCount = historyBorrowCount;
		this.enrollDate = enrollDate;
		this.quitflag = quitflag;
		this.quitDate = quitDate;
	}
	
	// 회원탈퇴용 생성자
	public Member(String memberId, String memberPw, String memberName, String gender, Date birthDay, String phone,
			String favoriteGenre, int historyBorrowCount, Date enrollDate, Date quitDate) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.gender = gender;
		this.birthDay = birthDay;
		this.phone = phone;
		this.favoriteGenre = favoriteGenre;
		this.historyBorrowCount = historyBorrowCount;
		this.enrollDate = enrollDate;
		this.quitDate = quitDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFavoriteGenre() {
		return favoriteGenre;
	}

	public void setFavoriteGenre(String favoriteGenre) {
		this.favoriteGenre = favoriteGenre;
	}

	public int getPresentBorrowCount() {
		return presentBorrowCount;
	}

	public void setPresentBorrowCount(int presentBorrowCount) {
		this.presentBorrowCount = presentBorrowCount;
	}

	public int getHistoryBorrowCount() {
		return historyBorrowCount;
	}

	public void setHistoryBorrowCount(int historyBorrowCount) {
		this.historyBorrowCount = historyBorrowCount;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getQuitflag() {
		return quitflag;
	}

	public void setQuitflag(String quitflag) {
		this.quitflag = quitflag;
	}

	public Date getQuitDate() {
		return quitDate;
	}

	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}

	@Override
	public String toString() {
		return memberId + "\t" + memberPw + "\t" + memberName + "\t"
				+ gender + "\t" + birthDay + "\t" + phone + "\t" + favoriteGenre
				+ "\t" + presentBorrowCount + "\t" + historyBorrowCount
				+ "\t" + enrollDate + "\t" + quitflag + "\t" + quitDate;
	}
}
