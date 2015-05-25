<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>
<%@ include file="user-navigation.jsp" %>
  <!-- Main -->
  <div id="main">
    <div class="cl">&nbsp;</div>
    <!-- Content -->
    <div id="content">
      <!-- Products -->
      <div class="products">
       <div class="cl">&nbsp;</div> 
       <table>
			<tr>
				<th class="special">Your Cart</th>
			</tr></table>
			<form id="update" action="OrderController" method="post"><table class="carttable">
			<tr class="row">
				<th class="carttable">Item</th>
				<th class="carttable">Quantity</th>
				<th class="carttable">Price</th>
				<th class="carttable">Total</th>
			</tr>
			<c:forEach var="item" items="${theShoppingCart.items}">
			  <tr>
			    <td>${item.product.productname}</td>
			    <td>
			        <input type="hidden" name="productList" value="${item.product.productcode}">
			        <input type=text name="${item.product.productcode}" value="${item.quantity}" id="quantity">
			      </td>
			    <td>${item.product.priceCurrencyFormat}</td>
			    <td>${item.totalCurrencyFormat}</td>
			  </tr>
			</c:forEach>
			<tr><td class="cartbuttons"><a class="btn" href="#" onclick="document.getElementById('update').submit()"><input type="hidden" name="action" value="updateCart"/>Update Cart</a></td>
			</tr></table></form>
			<table class="totaltable">
			<tr><td class="cartbuttons"><form id="checkout" action="OrderController" method="post"><a class="btn" href="#" onclick="document.getElementById('checkout').submit()"><input type="hidden" name="action" value="checkout"/>Checkout</a></form></td>
			</tr>
		</table>
        <div class="cl">&nbsp;</div>
      </div>
      <!-- End Products -->
    </div>
    <!-- End Content -->
    <!-- Sidebar -->
<%@ include file="site-navigation.jsp" %>    
    <!-- End Sidebar -->
    <div class="cl">&nbsp;</div>
  </div>
  <!-- End Main -->
  <!-- Footer -->
	<%@ include file="footer.jsp" %>
  <!-- End Footer -->

<!-- End Shell -->