<%-- 
    Document   : searchForm
    Created on : Jul 20, 2021, 2:22:53 AM
    Author     : Hanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//get the session and check if session is null, redirect to login page
if(session.getAttribute("currentSessionUser")==null)
response.sendRedirect("loginOrg.jsp");
%>
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
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
         <h2 class="text-center display-4">Search Donor IC</h2>
            <div class="row">
                <div class="col-md-8 offset-md-2">
                    <form action="SearchDonorController.do" method="POST">
                        <div class="input-group">
                            <input type="text" name="searchDonorIC" class="form-control form-control-lg" placeholder="Type donor IC here">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-lg btn-default">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                     <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
                         : request.getAttribute("errMessage") %></span>
                </div>
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.content -->
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

