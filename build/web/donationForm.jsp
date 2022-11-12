<%-- 
    Document   : donationForm
    Created on : Jul 20, 2021, 11:41:50 AM
    Author     : Hanna
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="model.Donor" %>
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

<% String donorIC = (String)request.getAttribute("donorIC"); %>
 <sql:query var="result" dataSource="${myDatasource}">
SELECT *  FROM DONOR WHERE DONORIC = '<%=donorIC %>'
</sql:query>

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
          <a href="#" class="d-block"><%=session.getAttribute("currentSessionUser") %></a>
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
            <a href="reqBlood.jsp" class="nav-link">
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

    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-12">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Blood Donation Form</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="AddBloodBankController.do" method="POST">
                <div class="card-body">
                  <div class="form-group">
                  <c:forEach var="donor" items="${result.rows}">
                    <label for="orgID">Organization ID </label>
                    <input type="text" class="form-control" name="orgID" value="<%=session.getAttribute("currentSessionUser") %>" readonly>
                  </div>
                  <div class="form-group">
                    <label>Donor IC </label>
                    <input type="text" class="form-control" name="donorIC" value="${donor.donorIC}" readonly>
                  </div>
                  <div class="form-group">
                    <label >Donor Name </label>
                    <input type="text" class="form-control" name="donorName" value="${donor.donorName}" disabled>
                  </div> 
                  <div class="form-group">
                    <label >Blood Type </label>
                   <input type="text" class="form-control" name="bloodType" value="${donor.donorBloodType}" readonly>
                  </div>
                   <div class="form-group">
                <%
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
                    Date donateDate = new Date();
                    if(request.getParameter("donateDate") != null)
                        donateDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("donateDate"));
                %>
                    <label >Donation Date</label>
                    <input type="date" class="form-control" name="donateDate" value="<%=formatter.format(donateDate)%>" readonly>
                  </div>
                  <div class="form-group">
                    <label >Blood Quantity(ml) </label>
                    <input type="text" class="form-control" name="bloodQty" required>
                    <input type="hidden" class="form-control" name="status" value="Available">
                  </div>
                </div>
                <!-- /.card-body -->
                <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
                         : request.getAttribute("errMessage") %></span>
                <div class="card-footer" align="center">
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
                </c:forEach>
              </form>
            </div>
            <!-- /.card -->

            <!-- general form elements -->

            </div><!-- /.card -->
          </div>
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
</body>
</html>
