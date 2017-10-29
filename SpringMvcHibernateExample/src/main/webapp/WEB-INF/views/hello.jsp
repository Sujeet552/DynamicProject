<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body onload="load();">
         
      <table id="details">
         <tr>
              <td><input type="hidden" id="user_id" value="0" name="user_id"></td>
         </tr>
         <tr>
              <td>Name:</td><td> <input type="text" id="username" required="required" name="username"></td>
         </tr>
         <tr>
             <td>Password:</td><td> <input type="password" id="password" required="required" name="password"></td>
         </tr>
         <tr>
             <td>Firstname:</td><td> <input type="text" name="firstname" id="firstname" required="required"></td>  
         </tr>
         <tr>
             <td>Lastname:</td><td> <input type="text" name="lastname" id="lastname" ></td>
         </tr>
         <tr>
             <td>Email:</td><td> <input type="email" id="email" required="required" name="email"></td>
         </tr>
         <tr>
             <td>Address:</td><td> <input type="text" name="address" id="address" ></td>
         </tr>
         <tr>
             <td> Phone:</td><td> <input type="phone" name="phone" id="phone" required="required"></td>  
         </tr>
         <tr>
             
             <td>                      
                 <button onclick="submit();">Submit</button>
             </td>
         </tr>
         
     </table>
         
     <table id="search_table"> 
        <tr>
             <td>
              <input type="text" name="search" id="search" onchange="searchlist();">
             </td>
              <td>                      
                 <button type="search" onclick="searchlist();">Search</button>
             </td>
         </tr>    
     </table>   
         
 <h1>Users List</h1>  
<table id="table" border="1" width="70%" cellpadding="2">  
<tr><th>ID</th><th>Username</th><th>Email</th><th>Edit</th><th>Delete</th></tr>

</table>


<script type="text/javascript">
data="";
submit=function(){
    
	 var retVal = confirm("Do you want to continue ?");
     
	 if( retVal == true ){
            
	$.ajax({
		url:'saveOrUpdate',
		type:'POST',
		data:{user_id:$("#user_id").val(), username:$("#username").val(),password:$("#password").val(),firstname:$("#firstname").val(),lastname:$("#lastname").val(),email:$("#email").val(),address:$("#address").val(),phone:$("#phone").val()},
		success: function(response){
						
			alert(response.message);
			load();
			clear();
		  }
	});
	
     }
     else{
        document.write ("User does not want to continue!");
        return false;
     }
			
}
// ###Author:- Sujeet
clear=function(){
	
	$("#user_id").val("0");
	$("#username").val("");	
	$("#password").val("");
	$("#firstname").val("");
	$("#lastname").val("");
	$("#email").val("");	
	$("#address").val("");	
	$("#phone").val("");	
}

delete_=function(id){
	
		
	 var retVal = confirm("Do you want to continue ?");
     if( retVal == true ){
    	 $.ajax({
    			url:'delete',
    			type:'POST',
    			data:{user_id:id},
    			success: function(response){
    				
    				alert(response.message);
    				load();
    			}
    		});
     }
     else{
        document.write ("User does not want to continue!");
        return false;
     }

	
			
}

edit = function (index){
	
	//document.getElementById("details").style.visibility="visible"; 
	//alert(index+" Data: "+data[index].id);	
	$("#user_id").val(data[index].user_id);
	$("#username").val(data[index].username);
	$("#password").val(data[index].password);
	$("#firstname").val(data[index].firstname);
	$("#lastname").val(data[index].lastname);
	$("#email").val(data[index].email);
	$("#address").val(data[index].address);
	$("#phone").val(data[index].phone);
}

//@Author: Sujeet Yadav 
searchlist=function(){
	
	//alert(document.getElementById("search").value);
	
	$.ajax({
		url:'searchlist',
		type:'POST',
		data:{search:$("#search").val()},
		success: function(response){
			data = response.data;
			$('.tr').remove();
			for(i=0;i<response.data.length;i++){
				$("#table").append("<tr class='tr'><td> "+response.data[i].user_id+"</td><td> "+response.data[i].username+"</td><td>"+response.data[i].email+"</td><td><a href='#' onclick='edit("+i+");'>Edit</a></td><td><a href='#' onclick='delete_("+response.data[i].user_id+");'>Delete</a></td></tr>");
			}
			
		}
	});
}

load=function(){
	
	//document.getElementById("details").style.visibility="hidden";
	
	$.ajax({
		url:'list',
		type:'POST',
		success: function(response){
			data = response.data;
			$('.tr').remove();
			for(i=0;i<response.data.length;i++){
				$("#table").append("<tr class='tr'><td> "+response.data[i].user_id+"</td><td> "+response.data[i].username+"</td><td>"+response.data[i].email+"</td><td><a href='#' onclick='edit("+i+");'>Edit</a></td><td><a href='#' onclick='delete_("+response.data[i].user_id+");'>Delete</a></td></tr>");
			}
			
		}
	});
}

</script>
</body>
</html>