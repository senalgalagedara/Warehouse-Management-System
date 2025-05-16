<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Create Report</title>
  <link rel="stylesheet" href="style.css" />
  <script>
    function handleTypeChange() {
      const type = document.getElementById("type").value;
      const valueLabel = document.getElementById("value-label");
      valueLabel.innerText = (type === "sales") ? "Sales Amount ($)" : "Stock Value / Status";
    }
  </script>
</head>
<body>
  <div class="container single-page">
    <main class="main">
      <header><h1>Create New Report</h1></header>
      <div class="form">
        <!-- ✅ Fix: Use InsertReportServlet here -->
        <form action="InsertReportServlet" method="post">
          <label for="type">Report Type:</label>
          <select id="type" name="type" onchange="handleTypeChange()" required>
            <option value="stock">Stock Level</option>
            <option value="sales">Sales Performance</option>
          </select>

          <label for="title">Title:</label>
          <input type="text" id="title" name="title" required />

          <label for="detail">Detail:</label>
          <textarea id="detail" name="detail" rows="3" required></textarea>

          <label for="date">Date:</label>
          <input type="date" id="date" name="date" required />

          <label id="value-label" for="value">Stock Value / Status:</label>
          <input type="text" id="value" name="value" required />

          <div class="form-actions">
            <button type="submit" class="editBtn">Submit</button>
            <a href="ReadReports.jsp"><button type="button" class="deleteBtn">Cancel</button></a>
          </div>
        </form>
      </div>
    </main>
  </div>
</body>
</html>
