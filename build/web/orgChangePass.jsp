<%-- 
    Document   : admChangePass
    Created on : Jul 8, 2021, 5:29:12 PM
    Author     : Hanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@page import="model.Organization" %>
<%@page import="sql.OrganizationDAO" %>
<%@page import="java.util.*" %>

<%
//get the session and check if session is null, redirect to login page
if(session.getAttribute("currentSessionUser")==null)
response.sendRedirect("loginOrg.jsp");
%>

<sql:setDataSource var="myDatasource"
driver="org.apache.derby.jdbc.ClientDriver"
url="jdbc:derby://localhost:1527/bloodDonationDB" user="app"
password="app"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>ORGANIZATION</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="LogoutOrgController.do" class="nav-link">Logout</a>
      </li>
    </ul>
    <!-- Right navbar links -->

        <!-- /.dropdown-user -->
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
     <!-- BRAND LOGO -->
    <a href="#" class="brand-link">
      <img src="imageHome/logo.png" alt="ourlogo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">MERCY</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="info">
            <input type="hidden" value="<%= session.getAttribute("currentSessionUser") %>" />
          <a href="#" class="d-block">ORGANIZATION</a>
        </div>
      </div>
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item menu-open">
          <li class="nav-item">
            <a href="indexOrg.jsp" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Profile
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="searchForm.jsp" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Donation Form
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="requestList.jsp" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Request List
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="orgChangePass.jsp" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Change Password
              </p>
            </a>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
    </div>
    <!-- /.content-header -->

     <!-- Content Wrapper. Contains page content -->
      <!-- Main content -->
    <section class="content">
        <div class="container-fluid">
                <div class="row">
          <div class="col-lg-12">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Change Password</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="EditPassOrganization.do" method="post">
                  <% int orgID = (Integer)session.getAttribute("currentSessionUser"); %>
                   <sql:query var="result" dataSource="${myDatasource}">
                    SELECT *  FROM ORGANIZATION WHERE ORGID = <%=orgID %>
                    </sql:query>
                    <c:forEach var="org" items="${result.rows}">
                <div class="card-body">
                  <div class="form-group">
                    <label for="orgID">Organization ID </label>
                    <input type="text" class="form-control" name="orgID" value="<c:out value='${org.orgID}' />" readonly>
                  </div>
                  <div class="form-group">
                    <label>Organization Name </label>
                    <input type="text" class="form-control" name="orgName" value="<c:out value='${org.orgName}' />" readonly>
                  </div>
                  <div class="form-group">
                    <label>Password </label>
                    <input type="password" class="form-control" name="orgPass" >
                  </div>
                  <div class="form-group">
                    <label >Comfirm Password </label>
                    <input type="password" class="form-control" name="orgPassCom">
                  </div> 
                </div>
                <!-- /.card-body -->
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
                                <input style='width: 100px;' type='submit' class="btn btn-primary" value='Update' style='width: 200px;'>
                                <button style='width: 100px;' class="btn btn-default" onclick="if(confirm('Cancel update ?')) window.location.href = 'indexOrg.jsp'; return false;">Cancel</button>
                           </c:forEach>
                    </form>
            </div>
            <!-- /.card -->

            <!-- general form elements -->
            </div>
        </div>
 </div>
    </section>

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
</body>
</html>

