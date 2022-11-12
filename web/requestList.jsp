<%-- 
    Document   : requestList
    Created on : Jul 21, 2021, 2:28:24 PM
    Author     : Hanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="model.Request" %>
<%@page import="sql.RequestDAO" %>
<%@page import="java.util.*" %>

<sql:setDataSource var="myDatasource"
driver="org.apache.derby.jdbc.ClientDriver"
url="jdbc:derby://localhost:1527/bloodDonationDB" user="app"
password="app"/>

<%
//get the session and check if session is null, redirect to login page
if(session.getAttribute("currentSessionUser")==null)
response.sendRedirect("loginAdmin.jsp");
%>
    <% 
        List RList = new ArrayList ();
        RequestDAO rDao = new RequestDAO();
        RList = rDao.getReqOrg();
    %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>ADMIN</title>

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
        <a href="LogoutAdmin.do" class="nav-link">Logout</a>
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
          <a href="#" class="d-block">ADMIN</a>
        </div>
      </div>
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item menu-open">
          <li class="nav-item">
            <a href="indexAdmin.jsp" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Profile
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="viewOrgAdmin.jsp" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                View Organization
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
            <a href="viewBloodBankAdmin.jsp" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Blood Bank
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="admChangePass.jsp" class="nav-link">
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
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">List of Organization</h1>  
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">List of Organization</li>
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

            <div class="card card-primary card-outline">
              <div class="card-body">
                <!--TABLE -->
                <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">List of Request( <span style='color:blue;'><%=RList.size() %></span> )</h3>
                <div class="card-tools">
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">
                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default">
                        <i class="fas fa-search"></i>
                      </button>
                    </div>
                  </div>
                </div>
                
              </div>
              <!-- /.card-header -->
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                    <tr>
                        <th>#</th>
                        <th>Request ID</th>
                        <th>Blood Bag Number</th>
                        <th>Quantity</th>
                        <th>Status</th>
                        <th>Status</th>
                        <th>Organization ID</th>
                        <th>Accepted by</th>
                        <th colspan="2" style="width: 100px;">Action</th>
              
                </tr>
                <%
            Iterator RIt = RList.iterator();
            int n = 1;
            while (RIt.hasNext()) {
                Request bb = (Request) RIt.next();
            %>
                  </thead>
                  <tbody>
                    <tr>
                     <td> <%=n%> </td>
                      <td><%=bb.getReqID()%></td>
                      <td><%=bb.getBloodBagNum()%></td>
                      <td><%=bb.getRequestDate() %></td>
                      <td><%=bb.getReqQty() %></td>
                      <td><%=bb.getReqStatus()%></td>
                      <td><%=bb.getOrgID()%></td>
                       <td><%=bb.getAdmIC()%></td>
                      <% if(bb.getReqStatus().equals("Requested")){ %>
                      <td>
                            <form name='acc<%=bb.getReqID()%>' action='AcceptReqController.do' method='POST' >
                            <input type='hidden' name='reqID' value='<%=bb.getReqID()%>'>
                            <input type='hidden' name='reqStatus' value='Accepted'>
                            <input type='hidden' name='admIC' value='<%=session.getAttribute("currentSessionUser")%>'>
                            <input type='hidden' name='bloodBagNum' value='<%=bb.getBloodBagNum()%>'>
                            <a href='' onclick='if(confirm("Accept this request ?"))document.acc<%=bb.getReqID()%>.submit();return false;'>Accept</a>
                            </form>
                      </td><td>
                            <form name='reject<%=bb.getReqID()%>' action='RejectReqController.do' method='POST' >
                            <input type='hidden' name='reqID' value='<%=bb.getReqID()%>'>
                            <input type='hidden' name='reqStatus' value='Rejected'>
                            <input type='hidden' name='admIC' value='<%=session.getAttribute("currentSessionUser")%>'>
                            <input type='hidden' name='bloodBagNum' value='<%=bb.getBloodBagNum()%>'>
                            <a href='' onclick='if(confirm("Reject this request ?"))document.reject<%=bb.getReqID()%>.submit();return false;'>Reject</a>
                            </form>
                      </td>
                       
                  <%}else{ %>
                       <td><%=bb.getReqStatus()%></td>
                    <%   } } %>
                    </tr>
                  </tbody>
                </table>
                     <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
                         : request.getAttribute("errMessage") %></span>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div>
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


<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>

</body>
</html>

