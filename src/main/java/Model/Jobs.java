package Model;

public class Jobs {
	private int jobid;
	private String job_title;
	private String company_name;
	private String job_description;
	private String campus_description;
	private String location;
	private float ctc;
	private float min_cgpa;
	private String depts_eligible;
	private String status;
	private String remarks;
	public Jobs(int jobid, String job_title, String company_name, String job_description, String campus_description,
			String location, float ctc, float min_cgpa, String depts_eligible, String status, String remarks) {
		super();
		this.jobid = jobid;
		this.job_title = job_title;
		this.company_name = company_name;
		this.job_description = job_description;
		this.campus_description = campus_description;
		this.location = location;
		this.ctc = ctc;
		this.min_cgpa = min_cgpa;
		this.depts_eligible = depts_eligible;
		this.status = status;
		this.remarks = remarks;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	public String getCampus_description() {
		return campus_description;
	}
	public void setCampus_description(String campus_description) {
		this.campus_description = campus_description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getCtc() {
		return ctc;
	}
	public void setCtc(float ctc) {
		this.ctc = ctc;
	}
	public float getMin_cgpa() {
		return min_cgpa;
	}
	public void setMin_cgpa(float min_cgpa) {
		this.min_cgpa = min_cgpa;
	}
	public String getDepts_eligible() {
		return depts_eligible;
	}
	public void setDepts_eligible(String depts_eligible) {
		this.depts_eligible = depts_eligible;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}