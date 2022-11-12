<%-- 
    Document   : loginOrg
    Created on : Jul 19, 2021, 9:17:01 PM
    Author     : Hanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Organization Login</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link href="plugins/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css" type="text/css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css" type="text/css">
   <script>
            function validate()
            {
                var username = document.form.orgID.value;
                var password = document.form.orgPass.value;
                
                if (username==null || username=="")
                {
                    alert("Username cannot be blank");
                    return false;
                }
                else if (password==null || password=="")
                {
                    alert("Password cannot be blank");
                    return false;
                }
            }
        </script>
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <!-- /.login-logo -->
  <div class="card card-outline card-primary">
    <div class="card-header text-center">
      <a href="loginOrg.jsp" class="h1"><b>Organization</b></a>
    </div>
    <div class="card-body">
      <p class="login-box-msg">Sign in to start your session</p>

      <form action="LoginOrgController.do" method="POST" onsubmit="return validate()">
        <div class="input-group mb-3">
          <input type="text" class="form-control" name="orgID"  placeholder="Enter ID" >
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" name="orgPass" placeholder="Password">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
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
          
          <center>
            <input type="submit" class="btn btn-primary btn-block" name="submit" value="Sign In">
            <a href="homepage.jsp"> Cancel</a>
          </center>
          
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

