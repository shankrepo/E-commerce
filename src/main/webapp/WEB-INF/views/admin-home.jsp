<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Daily Shop | Admin Home</title>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
     <%@include file="../../includes/header.jsp" %>
  </head>
  <body>
   <c:if test="${ not empty message}">
   <script type="text/javascript">
    <c:set var="mssg" value="${message}"/> 
      var msg = '<c:out value="${mssg}"/>';
      swal("",msg);   
   </script>
  </c:if>
  
   <%@include file="../../includes/adminmenu.jsp" %>
  <!-- catg header banner section -->
  

 <!-- Cart view section -->
 <section id="cart-view">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
          <h1>Wel-come admin
          </h1>
       </div>
     </div>
   </div>
 </section>
  </body>
<%@include file="../../includes/footer.jsp" %>
</html>