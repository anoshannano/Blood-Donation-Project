<%-- 
    Document   : loginDonor
    Created on : Jul 20, 2021, 12:33:30 AM
    Author     : Hanna
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Donor Login</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link href="plugins/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css" type="text/css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css" type="text/css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <!-- /.login-logo -->
  <div class="card card-outline card-primary">
    <div class="card-header text-center">
      <a href="loginAdmin.jsp" class="h1"><b>Donor</b></a>
    </div>
    <div class="card-body">
      <p class="login-box-msg">Sign in to start your session</p>

      <form  action="LoginDonorController.do" method="POST">
        <div class="input-group mb-3">
          <input type="text" class="form-control" name="donorIC" id="donorIC" placeholder="Enter IC" required>
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" name="donorPass" id="donorPass" placeholder="Password" required>
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
           <center>
              <input type="submit" class="btn btn-primary btn-block" value="Sign In">
              <a href="homepage.jsp" class="btn btn-default btn-block"> Cancel</a>
             <p>Not yet register?  <a href="registerDonor.jsp">Click here to register</a>.</p>
            
          </center>
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
              <label for="remember">
                  <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
                         : request.getAttribute("errMessage") %></span>
                  </label>
            </div>
          </div>
          <!-- /.col -->
          
          
          <!-- /.col -->
        </div>
      </form>
    </div>
    <!-- /.card-body -->
  </div>
  <!-- /.card -->
</div>
<!-- /.login-box -->

</body>
</html>

