<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<%
    String role = (String) session.getAttribute("userRole");
    if (role == null || !role.equals("Admin")) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<h2>Welcome Admin</h2>
<a href="LogoutServlet">Logout</a>

<!DOCTYPE html>
<html>
<head>
  <title>Admin Dashboard</title>
  <link rel="stylesheet" href="css/style.css">
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHqT94m8bMN1F+TyHqOw+Y9ev0Hz5xAB/l9EfuSh2MLpue2RRGR0q1UG8+MFGKjohP+iPluQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
  
</head>
<body>
<div class="container">
  <aside class="sidebar">
    <header>
        <div class="title">Warehouse Manager</div>
    </header>
    <div class="alldiv">
        <div class="container-fluid">
                <div class="col-md-2 sidebar">
                    <a href="#"><i class="fas fa-users me-2"></i> Sales Management</a>
                    <a href="#"><i class="fas fa-truck me-2"></i> Driver Management</a>
                    <a href="#"><i class="fas fa-boxes me-2"></i> Warehouse Management</a>
                    <a href="#"><i class="fas fa-building me-2"></i> Admin</a>
                </div>
        </div>
  </aside>
  <main class="main">
    <div class="topbar">
      <div class="user-profile">
        <img src="images/avatar.png" class="avatar" />
        <div><strong>Kristin Watson</strong><br><span class="role">Admin</span></div>
      </div>
    </div>
    <header><h1>Inventory Dashboard</h1></header>
    <section class="cards">
      <div class="card"><h3>Total Products</h3><p>100</p></div>
      <div class="card"><h3>Total Orders</h3><p>250</p></div>
      <div class="card"><h3>Total Users</h3><p>45</p></div>
      <div class="card"><h3>Total Stores</h3><p>5</p></div>
    </section>
  </main>
</div>
</body>
</html>
