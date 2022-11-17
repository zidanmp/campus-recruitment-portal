package Model;

public class Applications {
	private String application_id;
	private String usn;
	private int jobid;
	private String application_date;
	private String application_status;
	private String remarks;
	private String job_status;
	public Applications(String application_id, String usn, int jobid, String application_date,
			String application_status, String remarks, String job_status) {
		super();
		this.application_id = application_id;
		this.usn = usn;
		this.jobid = jobid;
		this.application_date = application_date;
		this.application_status = application_status;
		this.remarks = remarks;
		this.job_status = job_status;
	}
	public String getApplication_id() {
		return application_id;
	}
	public void setApplication_id(String application_id) {
		this.application_id = application_id;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getApplication_date() {
		return application_date;
	}
	public void setApplication_date(String application_date) {
		this.application_date = application_date;
	}
	public String getApplication_status() {
		return application_status;
	}
	public void setApplication_status(String application_status) {
		this.application_status = application_status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getJob_status() {
		return job_status;
	}
	public void setJob_status(String job_status) {
		this.job_status = job_status;
	}
}