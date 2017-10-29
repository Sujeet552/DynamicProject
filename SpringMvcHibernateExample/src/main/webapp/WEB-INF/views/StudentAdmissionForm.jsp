<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>
        <body>
             <form action="AddStudent" method="post" >
            <table>
            <tr>
            <td>Enrollment Number: </td>
            <td>
            <input type="number" name="EnrollmentNumber">
           </td></tr>
           <tr>
           <td>ID: </td>
           <td>
            <input type="number" name="ID">
           </td></tr>
           <tr>
           <td>First Name: </td>
           <td>
            <input type="text" name="FirstName">
           </td></tr>
           <tr>
           <td>Middle Name: </td>
           <td>
            <input type="text" name="MiddleName">
           </td></tr>
           <tr>
           <td>Last Name: </td>
           <td>
            <input type="text" name="Lastname">
           </td></tr>
           <tr>
           <td>Course: </td>
           <td>
            <input type="text" name="Course">
           </td></tr>
           <tr>
           <td>Qualification: </td>
           <td>
            <input type="text" name="Qualification">
           </td></tr>
           
           <tr>
           <td>Telephone No.: </td>
           
           <td>
            <input type="number" name="TelephoneNo">
           </td></tr>
           <tr>
           <td>Mobile No.: </td>
           <td>
            <input type="number" name="MobileNo">
           </td></tr>
           <tr>
           <td>Email Id: </td>
           <td>
            <input type="text" name="EmailId">
           </td></tr>
           <tr>
           <td>Present Activity: </td>
           <td>
            <input type="text" name="PresentActivity">
           </td></tr>
           <tr>
           
           <td>Referenced By: </td>
           <td>
            <input type="text" name="ReferencedBy">
           </td></tr>
            <tr>
            <td>Date Of Joining: </td>
            <td>
            <input type="date" name="DateOfJoining">
           </td></tr>
           <tr>
           <td>Address: </td>
           <td>
            <textarea name="Address" rows="10" cols="30" ></textarea>
           </td></tr>
           <tr><td><input type="submit" value="Submit"></td></tr>
            </table>
            </form>
        </body>
        </html>