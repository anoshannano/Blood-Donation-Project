<%-- 
    Document   : viewOrgDonor
    Created on : Jul 20, 2021, 1:58:57 AM
    Author     : Hanna
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page import="model.Organization" %>
<%@page import="sql.OrganizationDAO" %>
<%@page import="model.Donor" %>
<%@page import="java.util.*" %>

<sql:setDataSource var="myDatasource"
driver="org.apache.derby.jdbc.ClientDriver"
url="jdbc:derby://localhost:1527/bloodDonationDB" user="app"
password="app"/>

    <% 
        List orgList = new ArrayList ();
        OrganizationDAO orgDao = new OrganizationDAO();
        String orderBy = "ORGID";
        if (request.getParameter("sortBy")!= null)
            orderBy = request.getParameter("sortBy");
        if(orderBy.equals("Name"))
            orderBy = "ORGNAME";
        if(orderBy.equals("Email"))
            orderBy = "ORGEMAIL";
        if(orderBy.equals("PhoneNumber"))
            orderBy = "ORGNUMTEL";
        if(orderBy.equals("Type"))
            orderBy = "ORGTYPE";
        if(orderBy.equals("Address"))
            orderBy = "ORGADDRESS";
        if(orderBy.equals("State"))
            orderBy = "ORGSTATE";
        orgList = orgDao.getOrg(orderBy);
    %>
<<%
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
                <h3 class="card-title">List of Organization( <span style='color:blue;'><%=orgList.size()%></span> )</h3>
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
                <%
                    List ths = new ArrayList();
                    ths.add("Name");
                    ths.add("Email");
                    ths.add("Phone Number");
                    ths.add("Type");
                    ths.add("Address");
                    ths.add("State");
                    Iterator thIt = ths.iterator();
                    while (thIt.hasNext()) {
                        String th = (String) thIt.next();
                        String thNs = th.replaceAll("\\s+","");
                %>
                <form name='sort<%=thNs%>' action='#' method='GET'>
                    <th>
                        <input type='hidden' name='sortBy' value='<%=thNs%>'>
                        <a href='' onclick='document.sort<%=thNs%>.submit();return false;'><%=th%></a>
                    </th>
                </form>
                <%  }   %>
                </tr>
                <%
            Iterator orgIt = orgList.iterator();
            int n = 1;
            while (orgIt.hasNext()) {
                Organization orgs = (Organization) orgIt.next();

            %>
                  </thead>
                  <tbody>
                    <tr>
                     <td> <%=n%> </td>
                      <td><%=orgs.getOrgName()%></td>
                      <td><%=orgs.getOrgEmail()%></td>
                      <td>+<%=orgs.getOrgNumtel()%></td>
                      <td><%=orgs.getOrgType()%></td>
                       <td> <%=orgs.getOrgAddress().replaceAll("\\n", "<br>")%> </td>
                       <td><%=orgs.getOrgState()%></td>
                  <% n=n+1;
                   }%>
                    </tr>
                  </tbody>
                </table>
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
    </c:forEach>
  <!-- /.content-wrapper -->


<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>

</body>
</html>

