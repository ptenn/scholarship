<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
  <title>New Student page</title>
</head>
<body>
  <h1>New Student page</h1>
  <form:form method="POST" commandName="student" action="${pageContext.request.contextPath}/student/create.html">
    <table>
      <tbody>
      <tr>
        <td>Student First name:</td>
        <td><form:input path="firstName"/></td>
        <td><form:errors path="firstName" cssStyle="color: red;"/></td>
      </tr>
      <tr>
        <td>Student Last name:</td>
        <td><form:input path="lastName"/></td>
        <td><form:errors path="lastName" cssStyle="color: red;"/></td>
      </tr>

      <tr>
        <td>Student number:</td>
        <td><form:input path="studentNumber"/></td>
        <td><form:errors path="studentNumber" cssStyle="color: red;"/></td>
      </tr>
      <tr>
        <td><input type="submit" value="Create"/></td>
        <td></td>
        <td></td>
      </tr>
      </tbody>
    </table>
  </form:form>
  <a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>