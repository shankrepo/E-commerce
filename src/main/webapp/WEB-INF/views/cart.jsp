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
  
  <script type="text/javascript">
  function getSumOfRow(qunt,price,id){
	  var total = qunt * price;
	  var dis = document.querySelector('#totalRowPrice'+id);
		dis.innerHTML = total;
  }
  </script>
   
   <%@include file="../../includes/menu.jsp" %>
  <!-- catg header banner section -->
  

 <!-- Cart view section -->
 <section id="cart-view">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
         <div class="cart-view-area">
           <div class="cart-view-table">
             <form action="${pageContext.request.contextPath}/cart/update/order" method="post">
               <div class="table-responsive">
                  <table class="table">
                    <thead>
                      <tr>
                        <th></th>
                        <th>Product</th>
                        <th>Size</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${products}" varStatus="incr">
                    <input type="hidden" name="productId" value="${product.id}" />
                      <tr>
                        <td><a class="remove fa fa-close" href="${pageContext.request.contextPath}/cart/order/remove/${product.id}"> </a></td>
                        <td><a class="aa-cart-title" href="#">${product.productEntity.productName} Polo T-Shirt</a></td>
                        <td>${product.productPrice.size}</td>
                        <td>${product.productPrice.discountPrice}</td>
                        <td><input class="aa-cart-quantity" name="quantity" type="number" max="4" onchange="getSumOfRow(this.value,${product.productPrice.discountPrice},${product.id});" value="${product.quantity}"></td>
                        <td id="totalRowPrice${product.id}">${product.quantity * product.productPrice.discountPrice}</td>
                      </tr>
                      </c:forEach>
                      <tr>
                        <td colspan="6" class="aa-cart-view-bottom">
                          <input class="aa-cart-view-btn" type="submit" value="Update Cart">
                        </td>
                      </tr>
                      </tbody>
                  </table>
                </div>
             </form>
             <!-- Cart Total view -->
             <div class="cart-view-total">
               <h4>Cart Totals</h4>
               <table class="aa-totals-table" >
                 <tbody>
                   <tr>
                     <th>Total</th>
                     <td>${total}</td>
                   </tr>
                 </tbody>
               </table>
               <a href="${pageContext.request.contextPath}/checkout/view" class="aa-cart-view-btn">Proced to Checkout</a>
             </div>
           </div>
         </div>
       </div>
     </div>
   </div>
 </section>
  </body>
<%@include file="../../includes/footer.jsp" %>
</html>