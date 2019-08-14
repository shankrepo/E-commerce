<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <title>Daily Shop | Cart Page</title>
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
  
   <%@include file="../../includes/menu.jsp" %>
  <!-- catg header banner section -->
  

 <!-- Cart view section -->
 <section id="cart-view">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
         <div class="cart-view-area">
           <div class="cart-view-table">
             <form action="">
               <div class="table-responsive">
                  <table class="table">
                    <thead>
                      <tr>
                        <th></th>
                        <th>Product</th>
                        <th>Size</th>
                        <th>Price</th>
                        <th>Total</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${wishlist}" varStatus="incr">
                    
                      <tr>
                        <td><a class="remove" href="${pageContext.request.contextPath}/cart/wishlist/order/remove/${product.id}"><fa class="fa fa-close"></fa></a></td>
                        <td><a class="aa-cart-title" href="#">${product.productEntity.productName} Polo T-Shirt</a></td>
                        <td>${product.productPrice.size}</td>
                        <td>${product.productPrice.discountPrice}</td>
                        <td id="totalRowPrice${product.id}">${product.quantity * product.productPrice.discountPrice}</td>
                      </tr>
                      </c:forEach>
                      </tbody>
                  </table>
                </div>
             </form>
             <!-- Cart Total view -->
           </div>
         </div>
       </div>
     </div>
   </div>
 </section>
  </body>
<%@include file="../../includes/footer.jsp" %>
</html>