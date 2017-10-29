<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <title>Welcome</title>
    </head>
    <body>
        <table>
            <tr>
                <td>Welcome ${firstname}</td>
            </tr>
             <tr>
            </tr>
             <tr><td>Please enter the student name to view the student detail.</td>
            </tr>
            <tr>
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
         <tr>
         </tr>   
         <tr>
                <td>
                    <a href="index.jsp">Home</a>
                </td>
            </tr> 
          <tr>
         </tr>  
     </table> 
     
     <h1>Student Search Result(s)</h1>   
     <table id="table" border="1" width="70%" cellpadding="2">  
        
        <tr><th>ID</th><th>Username</th><th>Email</th><th>Edit/View</th><th>Delete</th></tr>

     </table>

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

 <script type="text/javascript" src="resources/js/crud.js"></script>

</script>  
    </body>
    </html>