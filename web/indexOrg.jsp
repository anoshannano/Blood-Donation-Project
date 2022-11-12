<%-- 
    Document   : indexOrg
    Created on : Jul 19, 2021, 9:55:33 PM
    Author     : Hanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="model.Organization"%>
<%@page import="java.util.*" %>

<%
//prevent Caching of JSP pages
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
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
            <a href="viewBloodBankOrg.jsp" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Blood Bank
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
            <div class="card">
            </div>
            <div class="card card-primary card-outline">
              <div class="card-body">
                  <% int orgID = (Integer)session.getAttribute("currentSessionUser"); %>
                   <sql:query var="result" dataSource="${myDatasource}">
                    SELECT *  FROM ORGANIZATION WHERE ORGID = <%=orgID %>
                    </sql:query>
                    
                <form action="updateOrgForm.jsp" method="POST">
                    <c:forEach var="org" items="${result.rows}">
                <h3 class="text-primary"><i class="fas fa-paint-brush"></i> Profile</h3>

                 <strong><i class="fas fa-pencil-alt mr-1"></i> Organization ID</strong>
                <p class="text-muted">
                 ${org.orgID}
                 <input type="hidden" name="orgID" value="${org.orgID}"></td> 
                </p>

                <hr>
               <strong><i class="fas fa-book mr-1"></i> Name</strong>
                <p class="text-muted">
                  ${org.orgName} 
                  <input type="hidden" name="orgName" value="${org.orgName}">
                </p>
                <hr>
              <strong><i class="fas fa-book mr-1"></i> Phone Number</strong>
                <p class="text-muted">
                  ${org.orgNumtel}
                  <input type="hidden" name="orgNumtel" value="${org.orgNumtel}">
                </p>
                <hr>
                <strong><i class="fas fa-map-marker-alt mr-1"></i>Address</strong>

                <p class="text-muted"> ${org.orgAddress}</p>
               <input type="hidden" name="orgAddress" value="${org.orgAddress}">
                <hr>

                <strong><i class="fas fa-pencil-alt mr-1"></i> Email</strong>

                <p class="text-muted">
                  ${org.orgEmail}
                  <input type="hidden" name="orgEmail" value="${org.orgEmail}">
                </p>
                
                <hr>

                <strong><i class="fas fa-pencil-alt mr-1"></i> State</strong>

                <p class="text-muted">
                  ${org.orgState}
                  <input type="hidden" name="orgState" value="${org.orgState}">
                </p>
                <hr>

                <strong><i class="fas fa-pencil-alt mr-1"></i> Type</strong>

                <p class="text-muted">
                  ${org.orgType}
                  <input type="hidden" name="orgType" value="${org.orgType}">
                </p>

         <div class="col-12">
             <input type="hidden" name="admIC" value="${org.admIC}">
        </div>
                </c:forEach>
                </form>
              </div>

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
