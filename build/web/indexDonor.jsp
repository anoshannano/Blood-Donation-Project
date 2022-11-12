<%-- 
    Document   : indexDonor
    Created on : Jul 20, 2021, 12:36:02 AM
    Author     : Hanna
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="model.Donor" %>
<%@page import="java.util.*" %>

<%
//prevent Caching of JSP pages
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
//get the session and check if session is null, redirect to login page
if(session.getAttribute("currentSessionUser")==null)
response.sendRedirect("loginDonor.jsp");
%>

<sql:setDataSource var="myDatasource"
driver="org.apache.derby.jdbc.ClientDriver"
url="jdbc:derby://localhost:1527/bloodDonationDB" user="app"
password="app"/>

<% String donorIC = (String)session.getAttribute("currentSessionUser"); %>
                   <sql:query var="result" dataSource="${myDatasource}">
                    SELECT *  FROM DONOR WHERE DONORIC = '<%=donorIC %>'
                    </sql:query>
                    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>DONOR</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">

  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="LogoutDonorContoller.do" class="nav-link">Logout</a>
      </li>
    </ul>

    <!-- Right navbar links -->
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- BRAND LOGO -->
    <a href="index3.html" class="brand-link">
      <img src="imageHome/logo.png" alt="ourlogo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">MERCY</span>
    </a>
    <c:forEach var="donor" items="${result.rows}">
    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="info">
          <a href="#" class="d-block">${donor.donorName}</a>
        </div>
      </div>
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item menu-open">
            <li class="nav-item">
              <a href="indexDonor.jsp" class="nav-link">
                <i class="nav-icon fas fa-th"></i>
                <p>Home</p>
              </a>
            </li>
          </li>
          <li class="nav-item menu-open">
            <li class="nav-item">
              <a href="viewOrgDonor.jsp" class="nav-link">
                <i class="nav-icon fas fa-th"></i>
                <p>View Organization</p>
              </a>
            </li>
          </li>
          <li class="nav-item menu-open">
            <li class="nav-item">
              <a href="donationHistory.jsp" class="nav-link">
                <i class="nav-icon fas fa-th"></i>
                <p>History</p>
              </a>
            </li>
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
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Donor Profile</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Donor Profile</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
            </div>
              <form action="updateDonorForm.jsp" method="POST">
            <div class="card card-primary card-outline">
              <div class="card-body">
                <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                      <tr>
                      <th>IC Number</th>
                      <td>${donor.donorIC}</td>
                      <input type="hidden" name="donorIC" value="${donor.donorIC}">
                    </tr>
                    <tr>
                      <th>Full Name</th>
                      <td>${donor.donorName}</td>
                      <input type="hidden" name="donorName" value="${donor.donorName}">
                    </tr>
                    <tr>
                      <th>Email</th>
                      <td>${donor.donorEmail}</td>
                      <input type="hidden" name="donorEmail" value="${donor.donorEmail}">
                    </tr>
                    <tr>
                      <th>Phone Number</th>
                      <td>${donor.donorNumTel}</td>
                      <input type="hidden" name="donorNumTel" value="${donor.donorNumTel}">
                    </tr>
                    <tr>
                      <th>Address</th>
                      <td>${donor.donorAddress}</td>
                      <input type="hidden" name="donorAddress" value="${donor.donorAddress}">
                    </tr>
                    <tr>
                      <th>Blood Type</th>
                      <td>${donor.donorBloodType}</td>
                      <input type="hidden" name="donorBloodType" value="${donor.donorBloodType}">
                      <input type="hidden" name="donorPass" value="${donor.donorPass}">
                    </tr>
                  </thead>
                   <div class="col-12">
                    <input type="submit" value="Update Profile" class="btn btn-success float-right">
                    </div>
                </table>
                   
              </div>
              </div>
            </div>
                     </form><!-- /.card -->
          </div>
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  </c:forEach>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->
<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
</body>
</html>
