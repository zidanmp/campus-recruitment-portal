package DAO;

import java.sql.Connection;		
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.*;

public class Dao {
	static Connection con;
	static PreparedStatement stmt;
	static ResultSet rs;
	   
	public static void connection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
	}

	public static String loginStudent(String usn, String password) {
		try {
			connection();
			stmt=con.prepareStatement("select * from students where usn=? and password=? and student_access=? and attendance=?");
			stmt.setString(1, usn);
			stmt.setString(2, password);
			stmt.setString(3, "b");
			stmt.setInt(4, 0);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				con.close();
				return "not_approved";
			}
			stmt=con.prepareStatement("select * from students where usn=? and password=?");
			stmt.setString(1, usn);
			stmt.setString(2, password);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				con.close();
				return "true";
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static String getQuestion(String usn) {
		try {
			connection();
			stmt=con.prepareStatement("select squestion from students where usn=?");
			stmt.setString(1, usn);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				String ques=rs.getString(1);
				con.close();
				return ques;
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static String getPassword(String usn, String ans) {
		try {
			connection();
			stmt=con.prepareStatement("select password from students where usn=? and sanswer=?");
			stmt.setString(1, usn);
			stmt.setString(2, ans);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				String password=rs.getString(1);
				con.close();
				return password;
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static boolean registerStudent(Students register) {
		try {
			connection();
			stmt=con.prepareStatement("insert into students values(?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, register.getUsn());
			stmt.setString(2, register.getName());
			stmt.setString(3, register.getEmail());
			stmt.setLong(4, register.getPhone());
			stmt.setString(5, register.getDept_name());
			stmt.setFloat(6, register.getCgpa());
			stmt.setString(7, register.getPassword());
			stmt.setString(8, register.getSquestion());
			stmt.setString(9, register.getSanswer());
			stmt.setString(10, register.getStudent_access());
			stmt.setString(11, register.getUnblock_msg());
			stmt.setInt(12, register.getAttendance());
			int noe=stmt.executeUpdate();
			con.close();
			if(noe>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList<Students> fetchRequests() {
		try {
			connection();
			stmt=con.prepareStatement("select * from students where student_access=? and attendance=?");
			stmt.setString(1, "b");
			stmt.setInt(2, 0);
			rs=stmt.executeQuery();
			ArrayList<Students> requests=new ArrayList<Students>();
			while(rs.next())
			{
				Students stu=new Students(rs.getString(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getFloat(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12));
				requests.add(stu);
			}
			con.close();
			return requests;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Students> acceptRequests(String usn) {
		try {
			connection();
			stmt=con.prepareStatement("update students set student_access=? where usn=?");
			stmt.setString(1, "ub");
			stmt.setString(2, usn);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				connection();
				stmt=con.prepareStatement("select * from students where student_access=? and attendance=?");
				stmt.setString(1, "b");
				stmt.setInt(2, 0);
				rs=stmt.executeQuery();
				ArrayList<Students> requests=new ArrayList<Students>();
				while(rs.next())
				{
					Students stu=new Students(rs.getString(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getFloat(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12));
					requests.add(stu);
				}
				con.close();
				return requests;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Students> rejectRequests(String usn) {
		try {
			connection();
			stmt=con.prepareStatement("delete from students where usn=?");
			stmt.setString(1, usn);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				connection();
				stmt=con.prepareStatement("select * from students where student_access=? and attendance=?");
				stmt.setString(1, "b");
				stmt.setInt(2, 0);
				rs=stmt.executeQuery();
				ArrayList<Students> requests=new ArrayList<Students>();
				while(rs.next())
				{
					Students stu=new Students(rs.getString(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getFloat(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12));
					requests.add(stu);
				}
				con.close();
				return requests;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static boolean acceptallRequests() {
		try {
			connection();
			stmt=con.prepareStatement("update students set student_access=? where student_access=? and attendance=?");
			stmt.setString(1, "ub");
			stmt.setString(2, "b");
			stmt.setInt(3, 0);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean rejectallRequests() {
		try {
			connection();
			stmt=con.prepareStatement("delete from students where student_access=? and attendance=?");
			stmt.setString(1, "b");
			stmt.setInt(2, 0);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static int createDrive(Jobs drive) {
		try {
			connection();
			stmt=con.prepareStatement("select jobid from jobs where job_title=? and company_name=?");
			stmt.setString(1, drive.getJob_title());
			stmt.setString(2, drive.getCompany_name());
			rs=stmt.executeQuery();
			if(!rs.next())
			{
				con.close();
				connection();
				stmt=con.prepareStatement("insert into jobs values(jobid_seq.nextval,?,?,?,?,?,?,?,?,?,?)");
				stmt.setString(1, drive.getJob_title());
				stmt.setString(2, drive.getCompany_name());
				stmt.setString(3, drive.getJob_description());
				stmt.setString(4, drive.getCampus_description());
				stmt.setString(5, drive.getLocation());
				stmt.setFloat(6, drive.getCtc());
				stmt.setFloat(7, drive.getMin_cgpa());
				stmt.setString(8, drive.getDepts_eligible());
				stmt.setString(9, drive.getStatus());
				stmt.setString(10, drive.getRemarks());
				int noe=stmt.executeUpdate();
				con.close();
				if(noe>0)
				{
					connection();
					stmt=con.prepareStatement("select jobid from jobs where job_title=? and company_name=?");
					stmt.setString(1, drive.getJob_title());
					stmt.setString(2, drive.getCompany_name());
					rs=stmt.executeQuery();
					if(rs.next())
					{
						int jobid=rs.getInt(1);
						con.close();
						return jobid;
					}
				}
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public static ArrayList fetchDrives() {
		try {
			connection();
			stmt=con.prepareStatement("select company_name, job_title from jobs where status=?");
			stmt.setString(1, "opened");
			rs=stmt.executeQuery();
			ArrayList drives=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[2];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				drives.add(arr);
			}
			con.close();
			return drives;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList fetchClosedDrives() {
		try {
			connection();
			stmt=con.prepareStatement("select company_name, job_title from jobs where status=?");
			stmt.setString(1, "closed");
			rs=stmt.executeQuery();
			ArrayList drives=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[2];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				drives.add(arr);
			}
			con.close();
			return drives;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList fetchCancelledDrives() {
		try {
			connection();
			stmt=con.prepareStatement("select company_name, job_title from jobs where status=?");
			stmt.setString(1, "cancelled");
			rs=stmt.executeQuery();
			ArrayList drives=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[2];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				drives.add(arr);
			}
			con.close();
			return drives;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static Jobs fetchjob(String company, String title) {
		try {
			connection();
			stmt=con.prepareStatement("select * from jobs where company_name=? and job_title=?");
			stmt.setString(1, company);
			stmt.setString(2, title);
			rs=stmt.executeQuery();
			Jobs job=null;
			if(rs.next())
			{
				job=new Jobs(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getFloat(7),rs.getFloat(8),rs.getString(9),rs.getString(10),rs.getString(11));
			}
			con.close();
			return job;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static boolean updateJob(Jobs drive) {
		try {
			connection();
			stmt=con.prepareStatement("update jobs set job_title=?, company_name=?, job_description=?,campus_description=?, location=?, ctc=?, min_cgpa=?, DEPTS_ELIGIBLE=?, status=?, remarks=? where jobid=?");
			stmt.setString(1, drive.getJob_title());
			stmt.setString(2, drive.getCompany_name());
			stmt.setString(3, drive.getJob_description());
			stmt.setString(4, drive.getCampus_description());
			stmt.setString(5, drive.getLocation());
			stmt.setFloat(6, drive.getCtc());
			stmt.setFloat(7, drive.getMin_cgpa());
			stmt.setString(8, drive.getDepts_eligible());
			stmt.setString(9, drive.getStatus());
			stmt.setString(10, drive.getRemarks());
			stmt.setInt(11, drive.getJobid());
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean closeDrive(int jobid, String remarks) {
		try {
			connection();
			stmt=con.prepareStatement("update jobs set status=?, remarks=? where jobid=?");
			stmt.setString(1, "closed");
			stmt.setString(2, remarks);
			stmt.setInt(3, jobid);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean cancelDrive(int jobid, String remarks) {
		try {
			connection();
			stmt=con.prepareStatement("update jobs set status=?, remarks=? where jobid=?");
			stmt.setString(1, "cancelled");
			stmt.setString(2, remarks);
			stmt.setInt(3, jobid);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deleteDrive(int jobid) {
		try {
			connection();
			stmt=con.prepareStatement("delete from jobs where jobid=?");
			stmt.setInt(1, jobid);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList fetchStudents() {
		try {
			connection();
			stmt=con.prepareStatement("select usn, name from students where student_access=?");
			stmt.setString(1, "ub");
			rs=stmt.executeQuery();
			ArrayList students=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[2];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				students.add(arr);
			}
			con.close();
			return students;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList fetchBlockedStudents() {
		try {
			connection();
			stmt=con.prepareStatement("select usn, name from students where student_access=? and attendance=?");
			stmt.setString(1, "b");
			stmt.setInt(2, 3);
			rs=stmt.executeQuery();
			ArrayList students=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[2];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				students.add(arr);
			}
			con.close();
			return students;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static Students getStudent(String usn) {
		try {
			connection();
			stmt=con.prepareStatement("select * from students where usn=?");
			stmt.setString(1, usn);
			rs=stmt.executeQuery();
			Students student=null;
			if(rs.next())
			{
				student=new Students(rs.getString(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getFloat(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12));
			}
			con.close();
			return student;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static boolean blockStudent(String usn) {
		try {
			connection();
			stmt=con.prepareStatement("update students set student_access=?, attendance=? where usn=?");
			stmt.setString(1, "b");
			stmt.setInt(2, 3);
			stmt.setString(3, usn);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean updateAttendance(String usn, int attendance) {
		try {
			connection();
			stmt=con.prepareStatement("update students set  attendance=? where usn=?");
			stmt.setInt(1, attendance);
			stmt.setString(2, usn);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean deleteStudent(String usn) {
		try {
			connection();
			stmt=con.prepareStatement("delete from students where usn=?");
			stmt.setString(1, usn);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean unblockStudent(String usn, int attendance) {
		try {
			connection();
			stmt=con.prepareStatement("update students set student_access=?, attendance=?, unblock_msg=null  where usn=?");
			stmt.setString(1, "ub");
			stmt.setInt(2, attendance);
			stmt.setString(3, usn);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList fetchUnblockRequests() {
		try {
			connection();
			stmt=con.prepareStatement("select usn,name from students where unblock_msg is not null");
			rs=stmt.executeQuery();
			ArrayList requests=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[2];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				requests.add(arr);
			}
			con.close();
			return requests;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static String getUnblockMsg(String usn) {
		try {
			connection();
			stmt=con.prepareStatement("select unblock_msg from students where usn=?");
			stmt.setString(1, usn);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				String unblock_msg=rs.getString(1);
				con.close();
				return unblock_msg;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static boolean updateStudentProfile(Students update) {
		try {
			connection();
			stmt=con.prepareStatement("update students set name=?, email=?, phone=?, dept_name=?, cgpa=?  where usn=?");
			stmt.setString(1, update.getName());
			stmt.setString(2, update.getEmail());
			stmt.setLong(3, update.getPhone());
			stmt.setString(4, update.getDept_name());
			stmt.setFloat(5, update.getCgpa());
			stmt.setString(6, update.getUsn());
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static boolean addUnblockRequestMsg(String usn, String msg) {
		try {
			connection();
			stmt=con.prepareStatement("update students set unblock_msg=? where usn=?");
			stmt.setString(1, msg);
			stmt.setString(2, usn);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList fetchDrivesBasedOnBranch(String branch, String usn) {
		try {
			connection();
			stmt=con.prepareStatement("select company_name, job_title from jobs where status=? and depts_eligible like '%"+branch+"%' and jobid not in(select jobid from applications where usn=?)");
			stmt.setString(1, "opened");
			stmt.setString(2, usn);
			rs=stmt.executeQuery();
			ArrayList drives=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[2];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				drives.add(arr);
			}
			con.close();
			return drives;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static boolean applyFoDrive(int jobid, String usn, String application_id, String dat) {
		try {
			connection();
			stmt=con.prepareStatement("insert into applications(APPLICATION_ID, USN, JOBID, APPLICATION_DATE) values(?,?,?,?)");
			stmt.setString(1, application_id);
			stmt.setString(2, usn);
			stmt.setInt(3, jobid);
			stmt.setString(4, dat);
			int noe=stmt.executeUpdate();
			con.close();
			if(noe>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList<String> fetchDesignations(String branch, String usn) {
		try {
			connection();
			stmt=con.prepareStatement("select distinct JOB_TITLE from jobs where status=? and depts_eligible like '%"+branch+"%' and jobid not in(select jobid from applications where usn=?)");
			stmt.setString(1, "opened");
			stmt.setString(2, usn);
			rs=stmt.executeQuery();
			ArrayList<String> designations=new ArrayList<String>();
			while(rs.next())
			{
				designations.add(rs.getString(1));
			}
			con.close();
			return designations;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Float> fetchCtc(String branch, String usn) {
		try {
			connection();
			stmt=con.prepareStatement("select distinct ctc from jobs where status=? and depts_eligible like '%"+branch+"%' and jobid not in(select jobid from applications where usn=?)");
			stmt.setString(1, "opened");
			stmt.setString(2, usn);
			rs=stmt.executeQuery();
			ArrayList<Float> ctc=new ArrayList<Float>();
			while(rs.next())
			{
				ctc.add(rs.getFloat(1));
			}
			con.close();
			return ctc;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<String> fetchLocations(String branch, String usn) {
		try {
			connection();
			stmt=con.prepareStatement("select distinct location from jobs where status=? and depts_eligible like '%"+branch+"%' and jobid not in(select jobid from applications where usn=?)");
			stmt.setString(1, "opened");
			stmt.setString(2, usn);
			rs=stmt.executeQuery();
			ArrayList<String> designations=new ArrayList<String>();
			while(rs.next())
			{
				designations.add(rs.getString(1));
			}
			con.close();
			return designations;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList fetchDrivesBasedOnDesignation(String branch, String usn, String desig) {
		try {
			connection();
			stmt=con.prepareStatement("select company_name, job_title from jobs where job_title=? and status=? and depts_eligible like '%"+branch+"%' and jobid not in(select jobid from applications where usn=?)");
			stmt.setString(1, desig);
			stmt.setString(2, "opened");
			stmt.setString(3, usn);
			rs=stmt.executeQuery();
			ArrayList drives=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[2];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				System.out.println(arr);
				drives.add(arr);
			}
			con.close();
			return drives;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList fetchDrivesBasedOnCtc(String branch, String usn, String c) {
		try {
			connection();
			stmt=con.prepareStatement("select company_name, job_title from jobs where ctc>=? and status=? and depts_eligible like '%"+branch+"%' and jobid not in(select jobid from applications where usn=?)");
			stmt.setString(1, c);
			stmt.setString(2, "opened");
			stmt.setString(3, usn);
			rs=stmt.executeQuery();
			ArrayList drives=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[2];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				drives.add(arr);
			}
			con.close();
			return drives;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList fetchDrivesBasedOnLocation(String branch, String usn, String loc) {
		try {
			connection();
			stmt=con.prepareStatement("select company_name, job_title from jobs where location=? and status=? and depts_eligible like '%"+branch+"%' and jobid not in(select jobid from applications where usn=?)");
			stmt.setString(1, loc);
			stmt.setString(2, "opened");
			stmt.setString(3, usn);
			rs=stmt.executeQuery();
			ArrayList drives=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[2];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				drives.add(arr);
			}
			con.close();
			return drives;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList fetchOpenApplicationHistory(String usn) {
		try {
			connection();
			stmt=con.prepareStatement("select a.application_id, j.company_name, j.job_title ,j.ctc from jobs j, applications a where a.usn=? and j.jobid=a.jobid and j.status=?");
			stmt.setString(1, usn);
			stmt.setString(2, "opened");
			rs=stmt.executeQuery();
			ArrayList history=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[4];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				arr[2]=rs.getString(3);
				arr[3]=rs.getString(4);
				history.add(arr);
			}
			con.close();
			return history;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList fetchCloseApplicationHistory(String usn) {
		try {
			connection();
			stmt=con.prepareStatement("select a.application_id, j.company_name, j.job_title ,j.ctc from jobs j, applications a where a.usn=? and j.jobid=a.jobid and j.status=?");
			stmt.setString(1, usn);
			stmt.setString(2, "closed");
			rs=stmt.executeQuery();
			ArrayList history=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[4];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				arr[2]=rs.getString(3);
				arr[3]=rs.getString(4);
				history.add(arr);
			}
			con.close();
			return history;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList fetchCancelApplicationHistory(String usn) {
		try {
			connection();
			stmt=con.prepareStatement("select a.application_id, j.company_name, j.job_title ,j.ctc from jobs j, applications a where a.usn=? and j.jobid=a.jobid and j.status=?");
			stmt.setString(1, usn);
			stmt.setString(2, "cancelled");
			rs=stmt.executeQuery();
			ArrayList history=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[4];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				arr[2]=rs.getString(3);
				arr[3]=rs.getString(4);
				history.add(arr);
			}
			con.close();
			return history;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static boolean deleteDriveApplication(String applicationId) {
		try {
			connection();
			stmt=con.prepareStatement("delete from applications where application_id=?");
			stmt.setString(1, applicationId);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList<Students> fetchApplication(String company, String jobTitle) {
		try {
			connection();
			stmt=con.prepareStatement("select s.usn,s.name,s.email,s.phone,s.dept_name,s.cgpa,a.application_id from students s, applications a, jobs j where s.usn=a.usn and a.jobid= j.jobid and j.company_name=? and  j.job_title=? and a.job_status is null");
			stmt.setString(1, company);
			stmt.setString(2, jobTitle);
			rs=stmt.executeQuery();
			ArrayList applications=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[7];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				arr[2]=rs.getString(3);
				arr[3]=rs.getString(4);
				arr[4]=rs.getString(5);
				arr[5]=rs.getString(6);
				arr[6]=rs.getString(7);
				applications.add(arr);
			}
			con.close();
			return applications;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList fetchApplication(String jobid) {
		try {
			connection();
			stmt=con.prepareStatement("select s.usn,s.name,s.email,s.phone,s.dept_name,s.cgpa,a.application_id from students s, applications a where s.usn=a.usn and a.jobid= ? and a.job_status is null");
			stmt.setString(1, jobid);
			rs=stmt.executeQuery();
			ArrayList applications=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[7];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				arr[2]=rs.getString(3);
				arr[3]=rs.getString(4);
				arr[4]=rs.getString(5);
				arr[5]=rs.getString(6);
				arr[6]=rs.getString(7);
				applications.add(arr);
			}
			con.close();
			return applications;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static boolean updatePlacement(String applicationid, String remarks) {
		try {
			connection();
			stmt=con.prepareStatement("update applications set job_status=?, remarks=? where application_id=?");
			stmt.setString(1, "placed");
			stmt.setString(2, remarks);
			stmt.setString(3, applicationid);
			int nor=stmt.executeUpdate();
			con.close();
			if(nor>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList<String> getCompanies() {
		try {
			connection();
			stmt=con.prepareStatement("select distinct company_name from jobs");
			rs=stmt.executeQuery();
			ArrayList<String> companies=new ArrayList<String>();
			while(rs.next())
			{
				companies.add(rs.getString(1));
			}
			con.close();
			return companies;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList getAllStudentReport() {
		try {
			connection();
			stmt=con.prepareStatement("select s.usn, s.name, j.company_name, j.ctc from students s, applications a, jobs j where s.usn=a.usn and a.jobid=j.jobid and a.job_status=?");
			stmt.setString(1, "placed");
			rs=stmt.executeQuery();
			ArrayList students=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[4];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				arr[2]=rs.getString(3);
				arr[3]=rs.getString(4);
				students.add(arr);
			}
			con.close();
			return students;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList getStudentReportByBranch(String branch) {
		try {
			connection();
			stmt=con.prepareStatement("select s.usn, s.name, j.company_name, j.ctc from students s, applications a, jobs j where s.usn=a.usn and a.jobid=j.jobid and a.job_status=? and s.dept_name=?");
			stmt.setString(1, "placed");
			stmt.setString(2,  branch);
			rs=stmt.executeQuery();
			ArrayList students=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[4];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				arr[2]=rs.getString(3);
				arr[3]=rs.getString(4);
				students.add(arr);
			}
			con.close();
			return students;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList getStudentReportByCompany(String company) {
		try {
			connection();
			stmt=con.prepareStatement("select s.usn, s.name, j.company_name, j.ctc from students s, applications a, jobs j where s.usn=a.usn and a.jobid=j.jobid and a.job_status=? and j.company_name=?");
			stmt.setString(1, "placed");
			stmt.setString(2,  company);
			rs=stmt.executeQuery();
			ArrayList students=new ArrayList();
			while(rs.next())
			{
				String[] arr=new String[4];
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
				arr[2]=rs.getString(3);
				arr[3]=rs.getString(4);
				students.add(arr);
			}
			con.close();
			return students;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
