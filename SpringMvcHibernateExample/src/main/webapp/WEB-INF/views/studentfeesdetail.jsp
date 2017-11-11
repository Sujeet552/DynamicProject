<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>
       <head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
  
  <link rel="stylesheet" href="resources/css/style.css">

 </head>
 <body>
  <div id="throbber" style="display:none; min-height:120px;"></div>
<div id="noty-holder"></div>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">
                <img src="resources/css/images/LOGO.png" alt="DCE">
            </a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li><a href="#" data-placement="bottom" data-toggle="tooltip" href="#" data-original-title="Stats"><i class="fa fa-bar-chart-o"></i>
                </a>
            </li>            
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin User <b class="fa fa-angle-down"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#"><i class="fa fa-fw fa-user"></i> Edit Profile</a></li>
                    <li><a href="#"><i class="fa fa-fw fa-cog"></i> Change Password</a></li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="fa fa-fw fa-power-off"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li>
                    <a href="#" data-toggle="collapse" data-target="#submenu-1"><i class="fa fa-fw fa-star"></i>Student Management<i class="fa fa-fw fa-angle-down pull-right"></i></a>
                    <ul id="submenu-1" class="collapse">
                        <li><a href="register"><i class="fa fa-angle-double-right"></i>Add Student</a></li>
                        <li><a href="viewstudents"><i class="fa fa-angle-double-right"></i>View Student</a></li>
                       
                    </ul>
                </li>
                <li>
                    <a href="#" data-toggle="collapse" data-target="#submenu-2"><i class="fa fa-fw fa-star"></i>Fees Management<i class="fa fa-fw fa-angle-down pull-right"></i></a>
                    <ul id="submenu-2" class="collapse">
                        <li><a href="#">Student Fees Report<i class="fa fa-angle-double-right"></i> </a></li>
                       
                        
                    </ul>
                </li>
                <!-- <li>
                    <a href="investigaciones/favoritas"><i class="fa fa-fw fa-user-plus"></i>  MENU 3</a>
                </li>
                <li>
                    <a href="sugerencias"><i class="fa fa-fw fa-paper-plane-o"></i> MENU 4</a>
                </li>
                <li>
                    <a href="faq"><i class="fa fa-fw fa fa-question-circle"></i> MENU 5</a>
                </li> -->
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>
<div id="page-wrapper">
    <div class="container-fluid">
    <h1 class="well">Fees Detail</h1>
	<div class="col-lg-12 well">
	<div class="row">
				<form action="AddAll" method="post">
					<div class="col-sm-12">
					
					     <div class="row">
							
							<div class="col-sm-4 form-group">
								<label>Student Enrollment Number</label>
								<input type="text" name="EnrollmentNumber" id="EnrollmentNumber" value="${EnrollmentNumber}" class="form-control" readonly>
							</div>
							
							<div class="col-sm-4 form-group">
								<label>Current Date</label>
								<input type="text" name="paymentDate" value="${localDate}" class="form-control" readonly>
							</div>
						</div>	
						
						<div class="row">
							<div class="col-sm-4 form-group">
								<label>Current Payment Amount</label>
								<input type="text" name="paidAmount" id="paidAmount" placeholder="Enter current amount..." class="form-control">
							</div>
							
							<div class="col-sm-4 form-group">
								<label class="sr-only">Recipt Number</label>
								<input type="hidden" name="reciptNum" id="reciptNum" class="form-control" value="0" readonly>
							</div>
							
					  </div>					
					
					<div class="row">
							
							<div class="col-sm-4 form-group">
								<label>Total Fees</label>
								<input type="text" name="totalfees" id="totalfees"  class="form-control">
							</div>
							
						</div>		
											
			
				
					<button type="submit"  class="btn btn-lg btn-info" >Submit</button>					
					</div>
					
				</form> 
				</div>
	  </div>
	</div>
	
  </div>	 
	 
	 
<script type="text/javascript">


$(document).ready(function() {	
	//alert("working");
    function disableBack() { window.history.forward() }
    window.onload = disableBack();
    window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
});

onsubmit = function(){
	
	var enrollmentNo="";
	var firstName = document.getElementById("FirstName").value;
	var serialNo = document.getElementById("ID").value;
    var firstNameFirstTwoChar = firstName.substring(0, 2);
    
    if(serialNo < 10){
    	
    	enrollmentNo= firstNameFirstTwoChar.toUpperCase()+'00'+serialNo;
    }else if(serialNo > 10 && serialNo < 100){
    	
    	enrollmentNo= firstNameFirstTwoChar.toUpperCase()+'0'+serialNo;
    	
    } else{
    	
    	enrollmentNo= firstNameFirstTwoChar.toUpperCase()+serialNo;
    	
    }
    
   // alert(enrollmentNo);
    document.getElementById("EnrollmentNumber").value = enrollmentNo;
    
}
	
</script>
	 
    <!-- /#page-wrapper -->
  </div><!-- /#wrapper -->
 </body>
</html>