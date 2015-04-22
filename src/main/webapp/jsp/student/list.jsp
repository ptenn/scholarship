<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
  <title>Student List page</title>
</head>
<body>
<h1>Student List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0">
  <thead>
  <tr>
    <th width="25px">id</th>
    <th width="150px">company</th>
    <th width="25px">employees</th>
    <th width="50px">actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="student" items="${studentList}">
    <tr>
      <td>${student.id}</td>
      <td>${student.firstName}</td>
      <td>${student.lastName}</td>
      <td>${student.studentNumber}</td>
      <td>
        <a href="${pageContext.request.contextPath}/student/edit/${student.id}.html">Edit</a><br/>
        <a href="${pageContext.request.contextPath}/student/delete/${student.id}.html">Delete</a><br/>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>