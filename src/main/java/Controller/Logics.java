package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import DAO.Dao;
import Model.Applications;
import Model.Jobs;
import Model.Students;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;	

@WebServlet("/Logics")
public class Logics extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("accept")!=null)
		{
			String usn=request.getParameter("accept");
			ArrayList<Students> requests;
			requests=Dao.acceptRequests(usn);
			if(!requests.isEmpty() && requests!=null)
			{
				request.setAttribute("msg", "Request accepted successfully");
				request.setAttribute("requests", requests);
			}
			RequestDispatcher rd=request.getRequestDispatcher("registrationrequests.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("reject")!=null)
		{
			String usn=request.getParameter("reject");
			ArrayList<Students> requests;
			requests=Dao.rejectRequests(usn);
			if(!requests.isEmpty() && requests!=null)
			{
				request.setAttribute("msg", "Request rejected successfully");
				request.setAttribute("requests", requests);
			}
			RequestDispatcher rd=request.getRequestDispatcher("registrationrequests.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("acceptall")!=null)
		{
			boolean requests=Dao.acceptallRequests();
			if(requests)
			{
				request.setAttribute("msg", "All Requests accepted successfully");
				RequestDispatcher rd=request.getRequestDispatcher("registrationrequests.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getParameter("rejectall")!=null)
		{
			boolean requests=Dao.rejectallRequests();
			if(requests)
			{
				request.setAttribute("msg", "All Requests rejected successfully");
				RequestDispatcher rd=request.getRequestDispatcher("registrationrequests.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getParameter("create")!=null)
		{
			String title=request.getParameter("title").toUpperCase();
			String companyName=request.getParameter("companyName").toUpperCase();
			String jobDesc=request.getParameter("jobDesc");
			String campusDesc=request.getParameter("campusDesc");
			String location=request.getParameter("location").toUpperCase();
			float ctc=Float.parseFloat(request.getParameter("ctc"));
			float cgpa=Float.parseFloat(request.getParameter("cgpa"));
			String streams=" ";
			if(request.getParameter("cse")!=null)
			{
				streams=streams+request.getParameter("cse")+" ";
			}
			if(request.getParameter("ise")!=null)
			{
				streams=streams+request.getParameter("ise")+" ";
			}
			if(request.getParameter("eee")!=null)
			{
				streams=streams+request.getParameter("eee")+" ";
			}
			if(request.getParameter("ece")!=null)
			{
				streams=streams+request.getParameter("ece")+" ";
			}
			if(request.getParameter("me")!=null)
			{
				streams=streams+request.getParameter("me");
			}
			Jobs drive=new Jobs(0,title,companyName,jobDesc,campusDesc,location,ctc,cgpa,streams,"opened",null);
			int jobid;
			if((jobid=Dao.createDrive(drive))>0)
			{
				request.setAttribute("msg", "Drive successfully created with jobid "+jobid);
			}
			else
			{
				request.setAttribute("errormsg", "Same drive is already created");
			}
			RequestDispatcher rd=request.getRequestDispatcher("createDrives.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("view")!=null)
		{
			ArrayList drives,closedDrives,cancelledDrives;
			drives=Dao.fetchDrives();
			closedDrives=Dao.fetchClosedDrives();
			cancelledDrives=Dao.fetchCancelledDrives();
			if(drives!=null)
			{
				if(!drives.isEmpty())
				{
					request.setAttribute("drives", drives);
				}
			}
			if(closedDrives!=null)
			{
				if(!closedDrives.isEmpty())
				{
					request.setAttribute("closedDrives", closedDrives);
				}
			}
			if(cancelledDrives!=null)
			{
				if(!cancelledDrives.isEmpty())
				{
					request.setAttribute("cancelledDrives", cancelledDrives);
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("viewDrives.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("indetail")!=null)
		{
			Jobs job=Dao.fetchjob(request.getParameter("company"),request.getParameter("title"));
			if(job!=null)
			{
					request.setAttribute("job", job);
			}
			RequestDispatcher rd=request.getRequestDispatcher("jobInDetail.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("update")!=null)
		{
			int jobid=Integer.parseInt(request.getParameter("jobid"));
			String title=request.getParameter("title").toUpperCase();
			String companyName=request.getParameter("companyName").toUpperCase();
			String jobDesc=request.getParameter("jobDesc");
			String campusDesc=request.getParameter("campusDesc");
			String location=request.getParameter("location").toUpperCase();
			float ctc=Float.parseFloat(request.getParameter("ctc"));
			float cgpa=Float.parseFloat(request.getParameter("cgpa"));
			String streams=" ";
			if(request.getParameter("cse")!=null)
			{
				streams=streams+request.getParameter("cse")+" ";
			}
			if(request.getParameter("ise")!=null)
			{
				streams=streams+request.getParameter("ise")+" ";
			}
			if(request.getParameter("eee")!=null)
			{
				streams=streams+request.getParameter("eee")+" ";
			}
			if(request.getParameter("ece")!=null)
			{
				streams=streams+request.getParameter("ece")+" ";
			}
			if(request.getParameter("me")!=null)
			{
				streams=streams+request.getParameter("me");
			}
			Jobs drive=new Jobs(jobid,title,companyName,jobDesc,campusDesc,location,ctc,cgpa,streams,"opened",null);
			if(Dao.updateJob(drive))
			{
				request.setAttribute("msg", "Drive successfully updated ");
			}
			else
			{
				request.setAttribute("errormsg", "Error");
			}
			RequestDispatcher rd=request.getRequestDispatcher("Logics?company="+companyName+"&title="+title+"&indetail=true");
			rd.forward(request, response);
		}
		if(request.getParameter("close")!=null)
		{
			int jobid=Integer.parseInt(request.getParameter("jobid"));
			request.setAttribute("jobid", jobid);
			RequestDispatcher rd=request.getRequestDispatcher("remarks.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("closeremarks")!=null)
		{
			int jobid=Integer.parseInt(request.getParameter("jobid"));
			String remarks=request.getParameter("remarks");
			if(Dao.closeDrive(jobid,remarks))
			{
				request.setAttribute("msg", "Drive successfully closed");
			}
			else
			{
				request.setAttribute("errormsg", "Error");
			}
			RequestDispatcher rd=request.getRequestDispatcher("remarks.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("cancel")!=null)
		{
			int jobid=Integer.parseInt(request.getParameter("jobid"));
			request.setAttribute("jobid", jobid);
			RequestDispatcher rd=request.getRequestDispatcher("cancelremarks.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("cancelremarks")!=null)
		{
			int jobid=Integer.parseInt(request.getParameter("jobid"));
			String remarks=request.getParameter("remarks");
			if(Dao.cancelDrive(jobid,remarks))
			{
				request.setAttribute("msg", "Drive successfully cancelled");
			}
			else
			{
				request.setAttribute("errormsg", "Error");
			}
			RequestDispatcher rd=request.getRequestDispatcher("cancelremarks.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("open")!=null)
		{
			int jobid=Integer.parseInt(request.getParameter("jobid"));
			String title=request.getParameter("title").toUpperCase();
			String companyName=request.getParameter("companyName").toUpperCase();
			String jobDesc=request.getParameter("jobDesc");
			String campusDesc=request.getParameter("campusDesc");
			String location=request.getParameter("location").toUpperCase();
			float ctc=Float.parseFloat(request.getParameter("ctc"));
			float cgpa=Float.parseFloat(request.getParameter("cgpa"));
			String streams=" ";
			if(request.getParameter("cse")!=null)
			{
				streams=streams+request.getParameter("cse")+" ";
			}
			if(request.getParameter("ise")!=null)
			{
				streams=streams+request.getParameter("ise")+" ";
			}
			if(request.getParameter("eee")!=null)
			{
				streams=streams+request.getParameter("eee")+" ";
			}
			if(request.getParameter("ece")!=null)
			{
				streams=streams+request.getParameter("ece")+" ";
			}
			if(request.getParameter("me")!=null)
			{
				streams=streams+request.getParameter("me");
			}
			Jobs drive=new Jobs(jobid,title,companyName,jobDesc,campusDesc,location,ctc,cgpa,streams,"opened",null);
			
			if(Dao.updateJob(drive))
			{
				request.setAttribute("msg", "Drive successfully opened");
			}
			else
			{
				request.setAttribute("errormsg", "Error");
			}
			RequestDispatcher rd=request.getRequestDispatcher("cancelremarks.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("delete")!=null)
		{
			int jobid=Integer.parseInt(request.getParameter("jobid"));
			request.setAttribute("jobid", jobid);
			if(Dao.deleteDrive(jobid))
			{
				request.setAttribute("msg", "Drive successfully deleted");
			}
			else
			{
				request.setAttribute("errormsg", "Error");
			}
			RequestDispatcher rd=request.getRequestDispatcher("remarks.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("viewStudents")!=null)
		{
			ArrayList students,blockedStudents;
			students=Dao.fetchStudents();
			blockedStudents=Dao.fetchBlockedStudents();
			if(students!=null)
			{
				if(!students.isEmpty())
				{
					request.setAttribute("students", students);
				}
			}
			if(blockedStudents!=null)
			{
				if(!blockedStudents.isEmpty())
				{
					request.setAttribute("blockedStudents", blockedStudents);
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("viewStudents.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("studentDetail")!=null)
		{
			Students student=Dao.getStudent(request.getParameter("usn"));
			if(student!=null)
			{
					request.setAttribute("student", student);
			}
			RequestDispatcher rd=request.getRequestDispatcher("studentDetails.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("block")!=null)
		{
			if(Dao.blockStudent(request.getParameter("usn")))
			{
				request.setAttribute("msg", "Blocked successfully");
			}
			else {
				request.setAttribute("errormsg", "Error");
			}
			RequestDispatcher rd=request.getRequestDispatcher("studentRemarks.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("updateAtt")!=null)
		{
			String usn=request.getParameter("usn");
			int attendance=Integer.parseInt(request.getParameter("attendance"));
			if(Dao.updateAttendance(usn,attendance))
			{
				request.setAttribute("msg", "Attendance updated successfully");
			}
			else {
				request.setAttribute("errormsg", "Error");
			}
			RequestDispatcher rd=request.getRequestDispatcher("studentRemarks.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("deleteStudent")!=null)
		{
			String usn=request.getParameter("usn");
			if(Dao.deleteStudent(usn))
			{
				request.setAttribute("msg", "student "+usn+" deleted successfully");
				
			}
			else
			{
				request.setAttribute("errormsg", "Error");
			}
			RequestDispatcher rd=request.getRequestDispatcher("studentRemarks.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("unblock")!=null)
		{
			String usn=request.getParameter("usn");
			int attendance=2;
			if(Integer.parseInt(request.getParameter("attendance"))!=3)
			{
				attendance=Integer.parseInt(request.getParameter("attendance"));
			}
			if(Dao.unblockStudent(usn,attendance))
			{
				request.setAttribute("msg", "student "+usn+" is Unblocked");
			}
			else
			{
				request.setAttribute("errormsg", "Error");
			}
			RequestDispatcher rd=request.getRequestDispatcher("studentRemarks.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("unblockRequests")!=null)
		{
			ArrayList unblockRequests;
			unblockRequests=Dao.fetchUnblockRequests();
			if(unblockRequests!=null)
			{
				if(!unblockRequests.isEmpty())
				{
					request.setAttribute("requests", unblockRequests);
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("unblockRequests.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("unBlockRequestDetails")!=null)
		{
			String usn=request.getParameter("usn");
			String name=request.getParameter("name");
			String unblock_msg=Dao.getUnblockMsg(usn);
			if(unblock_msg!=null)
			{
				request.setAttribute("usn",usn);
				request.setAttribute("name",name);
				request.setAttribute("unblock_msg",unblock_msg);
			}
			RequestDispatcher rd=request.getRequestDispatcher("unblockRequestStudent.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("unblockStudent")!=null)
		{
			String usn=request.getParameter("usn");
			int attendance=2;
			if(Dao.unblockStudent(usn,attendance))
			{
				request.setAttribute("msg", "student "+usn+" is Unblocked");
			}
			else
			{
				request.setAttribute("errormsg", "Error");
			}
			RequestDispatcher rd=request.getRequestDispatcher("unblockRequestStudent.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("studentProfile")!=null) 
		{
			String usn=request.getParameter("usn");
			Students profile=Dao.getStudent(usn);
			if(profile!=null)
			{
					request.setAttribute("student", profile);
			}
			RequestDispatcher rd=request.getRequestDispatcher("studentProfile.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("updateProfile")!=null)
		{
			Students update=new Students(request.getParameter("usn"),request.getParameter("name"),request.getParameter("email"),Long.parseLong(request.getParameter("phone")),request.getParameter("dept"),Float.parseFloat(request.getParameter("cgpa")),null,null,null,null,null,0);
			if(Dao.updateStudentProfile(update))
			{
				request.setAttribute("msg", "Updated Successfully");
			}
			else
			{
				request.setAttribute("errormsg", "Error");
			}
			RequestDispatcher rd=request.getRequestDispatcher("studentProfile.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("raiseUnblockRequest")!=null)
		{
			String usn=request.getParameter("usn");
			request.setAttribute("usn", usn);
			RequestDispatcher rd=request.getRequestDispatcher("raiseUnblockRequest.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("unblockRequest")!=null)
		{
			String usn=request.getParameter("usn");
			String msg=request.getParameter("unblockRequestMsg");
			if(Dao.addUnblockRequestMsg(usn,msg))
			{
				request.setAttribute("msg", "Unblock Request Raised successfully");
			}
			else
			{
				request.setAttribute("errormsg", "Error");
			}
			RequestDispatcher rd=request.getRequestDispatcher("studentProfile.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("viewDrives")!=null)
		{
			HttpSession session=request.getSession();
			ArrayList drives;
			ArrayList<String> designation, location;
			ArrayList<Float> ctc;
			String usn=(String)session.getAttribute("username");
			String branch=request.getParameter("branch");
			if(branch==null) {
			if(usn.contains("cs")||usn.contains("CS"))
			{
				branch="CSE";
			}
			else if(usn.contains("is")||usn.contains("IS"))
			{
				branch="ISE";
			}
			else if(usn.contains("ee")||usn.contains("EE"))
			{
				branch="EEE";
			}
			else if(usn.contains("ec")||usn.contains("EC"))
			{
				branch="ECE";
			}
			else if(usn.contains("me")||usn.contains("ME"))
			{
				branch="ME";
			}
			}
			drives=Dao.fetchDrivesBasedOnBranch(branch, usn);
			designation=Dao.fetchDesignations(branch, usn);
			location=Dao.fetchLocations(branch, usn);
			ctc=Dao.fetchCtc(branch, usn);
			if(drives!=null)
			{
				if(!drives.isEmpty())
				{
					request.setAttribute("branch", branch);
					request.setAttribute("drives", drives);
				}
			}
			if(designation!=null)
			{
				if(!designation.isEmpty())
				{
					request.setAttribute("designation", designation);
				}
			}
			if(location!=null)
			{
				if(!location.isEmpty())
				{
					request.setAttribute("location", location);
				}
			}
			if(ctc!=null)
			{
				if(!ctc.isEmpty())
				{
					request.setAttribute("ctc", ctc);
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("studentDrives.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("viewDetailedDrive")!=null)
		{
			Jobs job=Dao.fetchjob(request.getParameter("company"),request.getParameter("title"));
			if(job!=null)
			{
					request.setAttribute("job", job);
			}
			RequestDispatcher rd=request.getRequestDispatcher("viewDetailedDrive.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("apply")!=null)
		{
			int jobid=Integer.parseInt(request.getParameter("jobid"));
			String jid=Integer.toString(jobid);
			Date date=new Date();
			SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yy");
			String dat=formatter.format(date);
			HttpSession session=request.getSession();
			String usn=(String)session.getAttribute("username");
			try {
				char usnPart[]=new char[5];
				usn.getChars(5, usn.length(), usnPart, 0);
				String newusn=new String(usnPart);
				String application_id=jid+newusn;
				if(Dao.applyFoDrive(jobid, usn, application_id, dat))
				{
					request.setAttribute("msg", "Applied for the drive successfully and your Application Id is "+application_id);
				}
				else {
					request.setAttribute("errormsg", "Error");
				}
			}
			catch(Exception e)
			{
				request.setAttribute("errormsg", "Error");
			}
			RequestDispatcher rd=request.getRequestDispatcher("viewDetailedDrive.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("filterDesignation")!=null)
		{
			HttpSession session=request.getSession();
			ArrayList drives;
			ArrayList<String> designation, location;
			ArrayList<Float> ctc;
			String usn=(String)session.getAttribute("username");
			String branch=request.getParameter("branch");
			String desig=request.getParameter("designation");
			drives=Dao.fetchDrivesBasedOnDesignation(branch, usn,desig);
			designation=Dao.fetchDesignations(branch, usn);
			location=Dao.fetchLocations(branch, usn);
			ctc=Dao.fetchCtc(branch, usn);
			if(drives!=null)
			{
				if(!drives.isEmpty())
				{
					request.setAttribute("branch", branch);
					request.setAttribute("drives", drives);
				}
			}
			if(designation!=null)
			{
				if(!designation.isEmpty())
				{
					request.setAttribute("designation", designation);
				}
			}
			if(location!=null)
			{
				if(!location.isEmpty())
				{
					request.setAttribute("location", location);
				}
			}
			if(ctc!=null)
			{
				if(!ctc.isEmpty())
				{
					request.setAttribute("ctc", ctc);
				}
			}
			request.setAttribute("desig", desig);
			RequestDispatcher rd=request.getRequestDispatcher("studentDrives.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("filterCtc")!=null)
		{
			HttpSession session=request.getSession();
			ArrayList drives;
			ArrayList<String> designation, location;
			ArrayList<Float> ctc;
			String usn=(String)session.getAttribute("username");
			String branch=request.getParameter("branch");
			String c=request.getParameter("ctc");
			drives=Dao.fetchDrivesBasedOnCtc(branch, usn,c);
			designation=Dao.fetchDesignations(branch, usn);
			location=Dao.fetchLocations(branch, usn);
			ctc=Dao.fetchCtc(branch, usn);
			if(drives!=null)
			{
				if(!drives.isEmpty())
				{
					request.setAttribute("branch", branch);
					request.setAttribute("drives", drives);
				}
			}
			if(designation!=null)
			{
				if(!designation.isEmpty())
				{
					request.setAttribute("designation", designation);
				}
			}
			if(location!=null)
			{
				if(!location.isEmpty())
				{
					request.setAttribute("location", location);
				}
			}
			if(ctc!=null)
			{
				if(!ctc.isEmpty())
				{
					request.setAttribute("ctc", ctc);
				}
			}
			request.setAttribute("c", c);
			RequestDispatcher rd=request.getRequestDispatcher("studentDrives.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("filterLocation")!=null)
		{
			HttpSession session=request.getSession();
			ArrayList drives;
			ArrayList<String> designation, location;
			ArrayList<Float> ctc;
			String usn=(String)session.getAttribute("username");
			String branch=request.getParameter("branch");
			String loc=request.getParameter("location");
			drives=Dao.fetchDrivesBasedOnLocation(branch, usn,loc);
			designation=Dao.fetchDesignations(branch, usn);
			location=Dao.fetchLocations(branch, usn);
			ctc=Dao.fetchCtc(branch, usn);
			if(drives!=null)
			{
				if(!drives.isEmpty())
				{
					request.setAttribute("branch", branch);
					request.setAttribute("drives", drives);
				}
			}
			if(designation!=null)
			{
				if(!designation.isEmpty())
				{
					request.setAttribute("designation", designation);
				}
			}
			if(location!=null)
			{
				if(!location.isEmpty())
				{
					request.setAttribute("location", location);
				}
			}
			if(ctc!=null)
			{
				if(!ctc.isEmpty())
				{
					request.setAttribute("ctc", ctc);
				}
			}
			request.setAttribute("loc", loc);
			RequestDispatcher rd=request.getRequestDispatcher("studentDrives.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("viewApplicationHistory")!=null)
		{
			HttpSession session=request.getSession();
			String usn=(String)session.getAttribute("username");
			ArrayList openHistory,closeHistory,cancelHistory;
			openHistory=Dao.fetchOpenApplicationHistory(usn);
			closeHistory=Dao.fetchCloseApplicationHistory(usn);
			cancelHistory=Dao.fetchCancelApplicationHistory(usn);
			if(openHistory!=null)
			{
				if(!openHistory.isEmpty())
				{
					request.setAttribute("openHistory", openHistory);
				}
			}
			if(closeHistory!=null)
			{
				if(!closeHistory.isEmpty())
				{
					request.setAttribute("closeHistory", closeHistory);
				}
			}
			if(cancelHistory!=null)
			{
				if(!cancelHistory.isEmpty())
				{
					request.setAttribute("cancelHistory", cancelHistory);
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("applicationHistory.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("cancelApplication")!=null)
		{
			String applicationId=(String)request.getParameter("cancelApplication");
			if(Dao.deleteDriveApplication(applicationId))
			{
				request.setAttribute("msg", "Application cancelled successfully");
				HttpSession session=request.getSession();
				String usn=(String)session.getAttribute("username");
				ArrayList openHistory,closeHistory,cancelHistory;
				openHistory=Dao.fetchOpenApplicationHistory(usn);
				closeHistory=Dao.fetchCloseApplicationHistory(usn);
				cancelHistory=Dao.fetchCancelApplicationHistory(usn);
				if(openHistory!=null)
				{
					if(!openHistory.isEmpty())
					{
						request.setAttribute("openHistory", openHistory);
					}
				}
				if(closeHistory!=null)
				{
					if(!closeHistory.isEmpty())
					{
						request.setAttribute("closeHistory", closeHistory);
					}
				}
				if(cancelHistory!=null)
				{
					if(!cancelHistory.isEmpty())
					{
						request.setAttribute("cancelHistory", cancelHistory);
					}
				}
				RequestDispatcher rd=request.getRequestDispatcher("applicationHistory.jsp");
				rd.forward(request, response);
			}
			request.setAttribute("errormsg", "Error!");
			RequestDispatcher rd=request.getRequestDispatcher("applicationHistory.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("viewApplications")!=null)
		{
			ArrayList drives,closedDrives,cancelledDrives;
			drives=Dao.fetchDrives();
			closedDrives=Dao.fetchClosedDrives();
			cancelledDrives=Dao.fetchCancelledDrives();
			if(drives!=null)
			{
				if(!drives.isEmpty())
				{
					request.setAttribute("drives", drives);
				}
			}
			if(closedDrives!=null)
			{
				if(!closedDrives.isEmpty())
				{
					request.setAttribute("closedDrives", closedDrives);
				}
			}
			if(cancelledDrives!=null)
			{
				if(!cancelledDrives.isEmpty())
				{
					request.setAttribute("cancelledDrives", cancelledDrives);
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("viewAllApplications.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("indetailApplications")!=null)
		{
			ArrayList applications=Dao.fetchApplication(request.getParameter("company"),request.getParameter("title"));
			if(applications!=null)
			{
				if(!applications.isEmpty())
				{
					request.setAttribute("applications", applications);
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("applicationInDetail.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("rejectApplication")!=null)
		{
			String applicationId=(String)request.getParameter("rejectApplication");
			if(Dao.deleteDriveApplication(applicationId))
			{
				char applicationIdPart[]=new char[4];
				applicationId.getChars(0, 4, applicationIdPart, 0);
				String jobid=new String(applicationIdPart);
				ArrayList applications=Dao.fetchApplication(jobid);
				if(applications!=null)
				{
					if(!applications.isEmpty())
					{
						request.setAttribute("applications", applications);
					}
				}
				request.setAttribute("msg","application is succesfully rejected!");
				RequestDispatcher rd=request.getRequestDispatcher("applicationInDetail.jsp");
				rd.forward(request, response);
			}
			request.setAttribute("errormsg", "Error!");
			RequestDispatcher rd=request.getRequestDispatcher("applicationHistory.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("placed")!=null)
		{
			request.setAttribute("applicationid", request.getParameter("placed"));
			RequestDispatcher rd=request.getRequestDispatcher("placementRemarks.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("placementRemarks")!=null)
		{
			String applicationid=(String)request.getParameter("applicationid");
			String remarks=(String)request.getParameter("remarks");
			if(Dao.updatePlacement(applicationid, remarks))
			{
				char applicationIdPart[]=new char[4];
				applicationid.getChars(0, 4, applicationIdPart, 0);
				String jobid=new String(applicationIdPart);
				ArrayList applications=Dao.fetchApplication(jobid);
				if(applications!=null)
				{
					if(!applications.isEmpty())
					{
						request.setAttribute("applications", applications);
					}
				}
				request.setAttribute("msg","successfully marked as placed!");
				RequestDispatcher rd=request.getRequestDispatcher("applicationInDetail.jsp");
				rd.forward(request, response);
			}
			request.setAttribute("errormsg", "Error!");
			RequestDispatcher rd=request.getRequestDispatcher("applicationInDetail.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("getReport")!=null)
		{
			ArrayList<String> companies=Dao.getCompanies();
			if(companies!=null) {
				if(!companies.isEmpty())
				{
					request.setAttribute("companies",companies);
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("getReport.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("allStudentReport")!=null)
		{
			ArrayList students=Dao.getAllStudentReport();
			if(students!=null) {
				if(!students.isEmpty())
				{
					request.setAttribute("students",students);
				}
				else {
					request.setAttribute("errormsg","error");
					ArrayList<String> companies=Dao.getCompanies();
					if(companies!=null) {
						if(!companies.isEmpty())
						{
							request.setAttribute("companies",companies);
						}
					}
				}
			}
			else
			{
				request.setAttribute("errormsg","error");
				ArrayList<String> companies=Dao.getCompanies();
				if(companies!=null) {
					if(!companies.isEmpty())
					{
						request.setAttribute("companies",companies);
					}
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("getReport.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("branchReport")!=null)
		{
			String branch=(String)request.getParameter("branch");
			ArrayList students=Dao.getStudentReportByBranch(branch);
			if(students!=null) {
				if(!students.isEmpty())
				{
					request.setAttribute("students",students);
				}
				else {
					request.setAttribute("errormsg","error");
					ArrayList<String> companies=Dao.getCompanies();
					if(companies!=null) {
						if(!companies.isEmpty())
						{
							request.setAttribute("companies",companies);
						}
					}
				}
			}
			else
			{
				request.setAttribute("errormsg","error");
				ArrayList<String> companies=Dao.getCompanies();
				if(companies!=null) {
					if(!companies.isEmpty())
					{
						request.setAttribute("companies",companies);
					}
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("getReport.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("companyReport")!=null)
		{
			String company=(String)request.getParameter("company");
			ArrayList students=Dao.getStudentReportByCompany(company);
			if(students!=null) {
				if(!students.isEmpty())
				{
					request.setAttribute("students",students);
				}
				else {
					request.setAttribute("errormsg","error");
					ArrayList<String> companies=Dao.getCompanies();
					if(companies!=null) {
						if(!companies.isEmpty())
						{
							request.setAttribute("companies",companies);
						}
					}
				}
			}
			else
			{
				request.setAttribute("errormsg","error");
				ArrayList<String> companies=Dao.getCompanies();
				if(companies!=null) {
					if(!companies.isEmpty())
					{
						request.setAttribute("companies",companies);
					}
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("getReport.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}