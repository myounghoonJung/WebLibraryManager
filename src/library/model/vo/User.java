package library.model.vo;

import java.sql.Date;

public class User {
	
	private String userId; // 아이디
	private String userPw; // 패스워드
	private String userName; // 이름
	private String gender; // 성별 (M,F)
	private int age; // 나이
	private String phone; // 핸드폰번호 - 000-0000-0000 형식

	private int borrowPresentCount; // 유저가 현재 대출한 책 권수, 최대 3권까지 가능
	private int borrowHistoryCount; // 유저가 총 대출한 책 권수
	
	private Date enrollDate; // 가입 날짜
	
	public User() {}
	
	public User(String userId, String userPw, String userName, String gender, int age, String phone) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
	}
	
	public User(String userId, String userPw, String userName, String gender, int age, String phone,
			int borrowHistoryCount, Date enrollDate) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.borrowHistoryCount = borrowHistoryCount;
		this.enrollDate = enrollDate;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getBorrowPresentCount() {
		return borrowPresentCount;
	}
	public void setBorrowPresentCount(int borrowPresentCount) {
		this.borrowPresentCount = borrowPresentCount;
	}
	public int getBorrowHistoryCount() {
		return borrowHistoryCount;
	}
	public void setBorrowHistoryCount(int borrowHistoryCount) {
		this.borrowHistoryCount = borrowHistoryCount;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return userId + "\t" + userPw + "\t" + userName
				+ "\t" + gender + "\t" + age + "\t" + phone + "\t"
				+ borrowPresentCount + "\t" + borrowHistoryCount + "\t" + enrollDate;
	}
	
	
	
	
}
