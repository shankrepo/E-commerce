<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
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
   
   <%@include file="../../includes/adminmenu.jsp" %>
  <!-- catg header banner section -->
  
<section id="cart-view">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
         <div class="cart-view-area">
           <div class="cart-view-table">
              <form:form
		action="${pageContext.request.contextPath}/product/save/category"
		modelAttribute="productCategory" enctype="multipart/form-data" method="post">
               <div class="table-responsive">
                  <table class="table">
                    <thead>
                      <tr>
                        <th>Category Name :</th>
                        <th><form:input path="categoryName"  /></th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>Gender :</td>
                        <td><form:select path="gender" items="${genderList}" itemValue="id"
											itemLabel="id" name="gender" class="form-control"
											aria-label="..." required="true">
										</form:select></td>
                      </tr>
                      <tr>
                        <td colspan="6" class="aa-cart-view-bottom">
                          <input class="aa-cart-view-btn" type="submit" value="Submit">
                        </td>
                      </tr>
                      </tbody>
                  </table>
                </div>
             </form:form>
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