<%-- 
    Document   : updateOrgForm
    Created on : Jul 19, 2021, 11:41:18 PM
    Author     : Hanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="model.Organization" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Organization</title>
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
                      
                        <h2>Update Organization Profile</h2>
                    </div>
                    <p>Please edit the input values and submit to update the record.</p>
                    <form action="UpdateOrgController.do" method="POST" onsubmit="return validate();">
                        
                    <% int orgID = (Integer)session.getAttribute("currentSessionUser"); %>
                    
                   <sql:query var="result" dataSource="${myDatasource}">
                    SELECT *  FROM ORGANIZATION WHERE ORGID = <%=orgID %>
                    </sql:query>
                    
                    <c:forEach var="admin" items="${result.rows}">
                      <div >
                            <label>Admin IC</label>
                            <input type="text" name="admIC" class="form-control" value="<c:out value='${admin.admIC}' />" readonly><br>
                        </div>
                        <div >
                        <div >
                            <label>Admin Name</label>
                            <input type="text" name="admName" class="form-control" value="<c:out value='${admin.admName}' />"><br>
                        </div>
                        <div >
                            <label>Email</label>
                            <input type="text" name="admEmail" class="form-control" value="${admin.admEmail}">
                        </div><br>
                        <div >
                            <label>Address</label>
                            <input type="text" name="admAddress" class="form-control" value="${admin.admAddress}"><br>
                        </div>
                         <div >
                            <label>Phone Number</label>
                            <input type="text" name="admNumTel" class="form-control" value="${admin.admNumTel}"><br>
                        </div>
                        <br>
                        <input type="hidden" name="admPass" class="form-control" value="${admin.admPass}"><br>
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
                        <input type="submit" name="submit" class="btn btn-primary" value="Submit">
                        <button class="btn btn-primary" style='width: 100px;' onclick="if(confirm('Cancel edit ?')) window.location.href = 'indexAdmin.jsp'; return false;">Cancel</button>
                </div>
                    </form>
            </div> 
                    
        </div>
    </div>
</body>
</html>