<%-- 
    Document   : registerDonor
    Created on : Jul 20, 2021, 1:18:06 AM
    Author     : Hanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="model.Donor" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register Donor</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
    <style type="text/css">
        .wrapper{
            width: 500px;
            margin: 0 auto;
        }
    </style>
    
<sql:setDataSource var="myDatasource"
driver="org.apache.derby.jdbc.ClientDriver"
url="jdbc:derby://localhost:1527/bloodDonationDB" user="app"
password="app"/>
</head>
<body>
    <div class="wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                      
                        <h2>Register Donor Profile</h2>
                    </div>
                    <p>Please edit the input values and submit to update the record.</p>
                    <form action="RegisterDonorController.do" method="POST">
                    
                      <div >
                            <label>Donor IC</label>
                            <input type="text" name="donorIC" class="form-control"><br>
                        </div>
                        <div >
                        <div >
                            <label>Name</label>
                            <input type="text" name="donorName" class="form-control"><br>
                        </div>
                        <div >
                            <label>Email</label>
                            <input type="text" name="donorEmail" class="form-control" >
                        </div><br>
                        <div >
                            <label>Address</label>
                            <input type="text" name="donorAddress" class="form-control" ><br>
                        </div>
                        <div>
                            <label>Phone Number</label>
                            <input type="text" name="donorNumTel" class="form-control"><br>
                        </div>
                        <div >
                            <label>Blood Type</label>
                            <select name="donorBloodType">
                                <option value="AB">AB</option>
                                <option value="A">A</option>
                                <option value="B">B</option>
                                <option value="O">O</option>
                            </select>
                        </div>
                        <br>
                         <div>
                            <label>Password</label>
                            <input type="text" name="donorPass" class="form-control" ><br>
                        </div>
                        <div>
                            <label>Comfirm Password</label>
                            <input type="text" name="donorPassCom" class="form-control" >
                        </div>
                        <center>
                    <h3 style="color:red;">
                   <c:if test="${not empty errorMsgs}">
                <div style='padding-left:100px;'>
                <font color='red'>
                <c:forEach var="message" items="${errorMsgs}">
                 - ${message}<br>
                </c:forEach>
                </font>
                </div>
             </c:if>
            </c:forEach>
                    </h3>
                    </center>
                        <input type="submit" style='width: 100px;' name="submit" class="btn btn-primary" value="Submit">
                        <button class="btn btn-default" style='width: 100px;' onclick="if(confirm('Cancel register ?')) window.location.href = 'loginDonor.jsp'; return false;">Cancel</button>
                </div>
                    </form>
            </div> 
                    
        </div>
    </div>
</body>
</html>

