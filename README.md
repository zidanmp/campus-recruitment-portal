# Campus Recruitment Portal
---------------------------------------------------------------------------------------------------------------------------------------------
<p align="center">
  <img width="700" height="200" src="https://user-images.githubusercontent.com/98027659/216571566-aecb9d33-9ee2-406e-b972-ec374ea50fdf.png">
</p>

[![Watches](https://img.shields.io/github/watchers/zidanmp/campus-recruitment-portal?style=social)](https://github.com/zidanmp/campus-recruitment-portal/)
[![Fork](https://img.shields.io/github/forks/zidanmp/campus-recruitment-portal?style=social)](https://github.com/zidanmp/campus-recruitment-portal/fork)
[![Repo Size](https://img.shields.io/github/repo-size/zidanmp/campus-recruitment-portal)](https://github.com/zidanmp/campus-recruitment-portal/)
[![Issues](https://img.shields.io/github/issues/zidanmp/campus-recruitment-portal)](https://github.com/zidanmp/campus-recruitment-portal/issues)
[![Languages](https://img.shields.io/github/languages/top/zidanmp/campus-recruitment-portal?color=brightgreen)](https://github.com/zidanmp/campus-recruitment-portal/)
[![License](https://img.shields.io/github/license/zidanmp/campus-recruitment-portal)](https://github.com/zidanmp/campus-recruitment-portal/blob/master/License.txt)
---------------------------------------------------------------------------------------------------------------------------------------------------

A **fully responsive** web-based Campus Recruitment System for managing campus placements based on the **Model View Controller (MVC) Architecture** made using **Java Enterprise Technologies**. Using this Application, TPO can add drive details and students can register for the same. The system has two users: **__Admin(TPO) and User(Student)__**.

## Features
* TPO can create drives and manage applications.
 * Students can register themselves with an acadmic profile that includes basic details like Name, USN, Dept, Grade, etc. Also they can later update it.
 * Students can apply for several drives and can track application history.
 
 ## Technologies Used
 * **Frontend:** HTML, CSS, JavaScript, Java Server Pages (JSPs)
 * **Backend:**  Java Servlets, JDBC, Oracle Database
 
------------------------

# Screenshots
<p width = "100%">
 <img width="49%" src="https://user-images.githubusercontent.com/98027659/216573917-7ab147c8-33a5-4b6c-8553-5f2f90492cc5.png">
 <img width="49%" src="https://user-images.githubusercontent.com/98027659/216573936-9eab5bad-ee69-46f6-82b0-882d4469d5e7.png">
</p>

**Home Page** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Admin Login**<br>

<p width = "100%">
 <img width="49%" src="https://user-images.githubusercontent.com/98027659/216573958-d3452ee9-d5f0-47d5-b12f-388fefb5e373.png">
 <img width="49%" src="https://user-images.githubusercontent.com/98027659/216573982-f8ee607b-6258-4617-8f0e-7013bc4049c8.png">
</p>

**Student Registration**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Registration Requests**<br>


<p width = "100%">
 <img width="49%" src="https://user-images.githubusercontent.com/98027659/216574018-1b37052b-acc9-4e83-85f9-ace25bcdc826.png">
 <img width="49%" src="https://user-images.githubusercontent.com/98027659/216574078-06d6a16c-b6bb-4ad9-b252-db3f6cd35039.png">
</p>

**Drives** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Drive Registration**<br>

<p width = "100%">
 <img width="49%" src="https://user-images.githubusercontent.com/98027659/216574147-d87ceabc-7944-44f1-8f58-27f74e5d1b82.png">
 <img width="49%" src="https://user-images.githubusercontent.com/98027659/216574175-d4163a23-4eef-4591-adaa-fa873618dc2f.png">
</p>

**Report Generation** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Filter Drives**<br>

-----------

## Dependencies
* Java 8 or higher
* Eclipse IDE
* Apache Tomcat Server
* JDBC Driver - [odbc14](https://docs.oracle.com/database/121/JJDBC/getsta.htm#JJDBC28065)
## Setup

1.  Open  [Eclipse JEE](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/photonr)
2.  Import -> Existing Projects into Workspace
3.  Clone and Select the folder of this repository
4.  Finish
5.  Ensure you have  [Apache Tomcat](http://tomcat.apache.org/)  installed

## Future Scope or To Do List
* Generating reports in PDF format.
* Implementing SMS/e-mail functionality.
* Improving GUI.

## Authors
* [Mohammed Zidan M P](https://www.linkedin.com/in/zidanmp/)
* [Prajesh Poojary](https://www.linkedin.com/in/prajesh-perady/)
* [Sushmitha Acharya](https://www.linkedin.com/in/sushmitha-acharya-744a35206/)
* [H.N Nikhil]

## License
This project is licensed under the MIT License - see the [MIT license](https://github.com/zidanmp/campus-recruitment-portal/blob/master/License.txt) for details.
