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
        <h3>Invoice</h3>
        <p style="font-family: sans-serif">
            Order Date: ${currentOrder.orderDateDefaultFormat} &nbsp; <br><br>
            <b><span style="text-decoration: underline;">Ship To/Bill To:</span><br></b>${theUser.addressHTMLFormat}
        </p>
        
        		<table class="carttable">
			<tr>
				<th class="carttable">Item</th>
				<th class="carttable">Quantity</th>
				<th class="carttable">Price</th>
			</tr>
			<c:forEach var="item" items="${currentOrder.orderItems}">
  			<tr>
  			<td>${item.product.productname}</td>
		    <td>${item.quantity}</td>
		    <td>${item.totalCurrencyFormat}</td>
		  	</tr>
		  	</c:forEach>
		  	<tr>
		  	<td>Sales Tax</td>
		  	<td>${currentOrder.tax}%</td>
		  	<td>$${currentOrder.taxAmount}</td>
		  	</tr>
		  	<tr>
		    <th>Total:</th>
		    <td></td>
		    <td>${currentOrder.orderTotalCurrencyFormat}</td>
		  	</tr>
			</table>
			<table class="totaltable">
			<tr><td class="cartbuttons"><a href="cart.jsp" class="btn">Back to Cart</a></td>
			</tr>
			<tr><td class="cartbuttons"><a href="payment.jsp" class="btn">Purchase</a></td>
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