<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
     <title>Save Customer</title>
     <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
     <link href="<c:url value="/resources/css/add-customer-style.css"/>" rel="stylesheet">
      
</head>
<body>

    <div id="wrapper">
         <div id="header">
              <h2>CRM - Customer Relationship Manager</h2>
         </div>
    </div>

    <div id="container">
    <form:form action="saveCustomer" modelAttribute="customer" method="POST">
         <!-- need to associate this data with customer ID -->
         <form:hidden path="id"/>
         
         <table>
            <tbody>
               <tr>
                  <td><label>First Name:</label></td>
                  <td><form:input path="firstName"/></td>
               </tr>
               <tr>
                  <td><label>Last Name:</label></td>
                  <td><form:input path="lastName"/></td>
               </tr>
               <tr>
                  <td><label>Email:</label></td>
                  <td><form:input path="email"/></td>
               </tr>
               <tr>
                  <td><input type="submit" value="Save" class="save"/></td>
               </tr>
            </tbody>
         </table>
    
    </form:form>
    
    <div style="clear;both;"></div>
    <p>
      <a href="${pageContext.request.contextPath}/customer/list">Back to Customer List</a>
    </p>   
    </div>
</body>
</html>