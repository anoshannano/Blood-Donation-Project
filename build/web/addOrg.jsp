<%-- 
    Document   : addOrg
    Created on : Jul 19, 2021, 12:38:38 PM
    Author     : Hanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="model.Organization" %>
<%@page import="sql.OrganizationDAO" %>
<%@page import="java.util.*" %>

<sql:setDataSource var="myDatasource"
driver="org.apache.derby.jdbc.ClientDriver"
url="jdbc:derby://localhost:1527/bloodDonationDB" user="app"
password="app"/>
<% String admIC = (String)session.getAttribute("currentSessionUser"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ADD ORGANIZATION</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
    <style type="text/css">
        .wrapper{
            width: 500px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <div class="wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                      
                        <h2>Add Organization Form</h2>
                    </div>
                    <p>Please edit the input values and submit to update the record.</p>
                    <form action="AddOrganization.do" method="post">
                      
                        <div >
                            <label>Organization Name</label>
                            <input type="text" name="orgName" class="form-control" placeholder="Enter name"><br>
                        </div>
                        <div >
                            <label>Email</label>
                            <input type="text" name="orgEmail" class="form-control" placeholder="Enter email">
                        </div><br>
                        <div >
                            <label>Type of Organization</label>
                            <select name="orgType">
                                <option value="Hospital">Hospital</option>
                                <option value="Clinic">Clinic</option>
                                <option value="NGO">NGO Event</option>
                            </select>
                        </div><br>
                        <div >
                            <label>State</label>
                            <select name="orgState">
                                <option value="Negeri Sembilan">Negeri Sembilan</option>
                                <option value="Kuala Lumpur">Kuala Lumpur</option>
                                <option value="Melaka">Melaka</option>
                                <option value="Johor">Johor</option>
                                <option value="Perlis">Perlis</option>
                                <option value="Kelantan">Kelantan</option>
                                <option value="Terengganu">Terengganu</option>
                                <option value="Selangor">Selangor</option>
                                <option value="Penang">Penang</option>
                                <option value="Kedah">Kedah</option>
                                <option value="Sabah">Sabah</option>
                                <option value="Sarawak">Sarawak</option>
                            </select>
                        </div><br>
                        <div >
                            <label>Address</label>
                            <input type="text" name="orgAddress" class="form-control" placeholder="Enter address" ><br>
                        </div>
                         <div >
                            <label>Phone Number</label>
                            <input type="text" name="orgNumtel" class="form-control" placeholder="Enter phone number"><br>
                        </div>
                        <div>
                            <label>Admin IC</label>
                            <input type="text" name="admIC" class="form-control" value="<%=admIC %>" readonly><br>
                        </div>
                        <div>
                            <label>Password</label>
                            <input type="text" name="orgPass" class="form-control" placeholder="Enter Password"><br>
                        </div>
                        <div>
                            <label>Comfirm Password</label>
                            <input type="text" name="orgPassCom" class="form-control" placeholder="Enter comfirm password"><br>
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
                    </h3>
                    </center>
                        <br>
                        <input type="submit" class="btn btn-primary" value="Submit">
                        <a href="viewOrgAdmin.jsp" class="btn btn-default">Cancel</a>
                    </form>
                </div>
            </div>        
        </div>
    </div>
</body>
</html>