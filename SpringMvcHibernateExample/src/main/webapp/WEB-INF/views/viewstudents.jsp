<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
  
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
               <img src="resources/css/images/LOGO.png" alt="DCE"">
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
            <!-- Page Heading -->
      <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>EnrollmentID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Mobile</th>
                <th>Date of Joining</th>
                <th>Qualification</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>EnrollmentID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Mobile</th>
                <th>Date of Joining</th>
                <th>Qualification</th>
            </tr>
        </tfoot>
        
    </table>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
<script>
	
	
	
$(document).ready(function() {
	
   // $('#example').DataTable();
    var t = $('#example').DataTable();
    loadStudentData(t);
} );

 loadStudentData=function(t){
	        data="";
    	   	//alert(document.getElementById("search").value);		
    		$.ajax({
    			url:'studentlist',
    			type:'POST',
    			success: function(response){
    				data = response.data;
    				console.log("SUCCESS: ", data);
    				
    				//alert(response.data[0].enrollmentNumber);
    				$('.tr').remove();
    				for(i=0;i<response.data.length;i++){
    					t.row.add( [
    					            response.data[i].enrollmentNumber,
    					            response.data[i].firstName +" "+response.data[i].lastname,
    					            response.data[i].address,
    					            response.data[i].phoneNumber,
    					            response.data[i].dateOfJoining,
    					            response.data[i].qualification
    					        ] ).draw( false );
    					
    				}
    				
    			}
    		
    		}
    		);
    	

    		
    		
    	
    } 
	
</script>
    <!-- /#page-wrapper -->
</div><!-- /#wrapper -->




 </body>
</html>