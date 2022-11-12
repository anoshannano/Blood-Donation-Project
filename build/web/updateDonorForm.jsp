<%-- 
    Document   : updateDonorForm
    Created on : Jul 20, 2021, 12:52:58 AM
    Author     : Hanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="model.Donor" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Donor</title>
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
                      
                        <h2>Update Admin Profile</h2>
                    </div>
                    <p>Please edit the input values and submit to update the record.</p>
                    <form action="UpdateDonorController.do" method="POST">
                        
                    <% String donorIC = (String)session.getAttribute("currentSessionUser"); %>
                    
                   <sql:query var="result" dataSource="${myDatasource}">
                    SELECT *  FROM DONOR WHERE DONORIC = '<%=donorIC %>'
                    </sql:query>
                    
                    <c:forEach var="donor" items="${result.rows}">
                      <div >
                            <label>Donor IC</label>
                            <input type="text" name="donorIC" class="form-control" value="<c:out value='${donor.donorIC}' />" readonly><br>
                        </div>
                        <div >
                        <div >
                            <label>Name</label>
                            <input type="text" name="donorName" class="form-control" value="<c:out value='${donor.donorName}' />"><br>
                        </div>
                        <div >
                            <label>Email</label>
                            <input type="text" name="donorEmail" class="form-control" value="<c:out value='${donor.donorEmail}' />">
                        </div><br>
                        <div >
                            <label>Address</label>
                            <input type="text" name="donorAddress" class="form-control" value="${donor.donorAddress}"><br>
                        </div>
                        <div>
                            <label>Phone Number</label>
                            <input type="text" name="donorNumTel" class="form-control" value="${donor.donorNumTel}"><br>
                        </div>
                        <div >
                            <label>Blood Type</label>
                            <select name="donorBloodType">
                                <option value="<c:out value='${donor.donorBloodType}' />">${donor.donorBloodType}</option>
                                <option value="AB">AB</option>
                                <option value="A">A</option>
                                <option value="B">B</option>
                                <option value="O">O</option>
                            </select>
                        </div>
                        <br>
                        <input type="hidden" name="donorPass" class="form-control" value="${donor.donorPass}"><br>
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
                        <button class="btn btn-primary" style='width: 100px;' onclick="if(confirm('Cancel edit ?')) window.location.href = 'indexDonor.jsp'; return false;">Cancel</button>
                </div>
                    </form>
            </div> 
                    
        </div>
    </div>
</body>
</html>
