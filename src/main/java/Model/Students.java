package Model;

public class Students {
	private String usn;
	private String  name;
	private String email;
	private long phone;
	private String dept_name;
	private float cgpa;
	private String password;
	private String squestion;
	private String sanswer;
	private String student_access;
	private String unblock_msg;
	private int attendance;
	
	public Students(String usn, String name, String email, long phone, String dept_name, float cgpa, String password,
			String squestion, String sanswer, String student_access, String unblock_msg, int attendance) {
		super();
		this.usn = usn;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dept_name = dept_name;
		this.cgpa = cgpa;
		this.password = password;
		this.squestion = squestion;
		this.sanswer = sanswer;
		this.student_access = student_access;
		this.unblock_msg = unblock_msg;
		this.attendance = attendance;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public float getCgpa() {
		return cgpa;
	}
	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSquestion() {
		return squestion;
	}
	public void setSquestion(String squestion) {
		this.squestion = squestion;
	}
	public String getSanswer() {
		return sanswer;
	}
	public void setSanswer(String sanswer) {
		this.sanswer = sanswer;
	}
	public String getStudent_access() {
		return student_access;
	}
	public void setStudent_access(String student_access) {
		this.student_access = student_access;
	}
	public String getUnblock_msg() {
		return unblock_msg;
	}
	public void setUnblock_msg(String unblock_msg) {
		this.unblock_msg = unblock_msg;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
}