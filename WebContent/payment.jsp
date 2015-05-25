<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="js/payment.js"></script>

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
        <h3>Enter Your Payment Information</h3>
        
        <form id="order" name="payment" action="OrderController" onsubmit="return validateForm()" method="post">
				<table class="contact">
				 <tr>
				 <td>Credit Card Type:
				 </td>
				 <td>
				  <select name="Category">
	    			<option>Card Type</option>
  					<option value="Visa">Visa</option>
  					<option value="Master Card">Master Card</option>
  					<option value="Discover">Discover</option>
  					<option value="American Express">American Express</option>
					</select>
				 </td>
				</tr>
				<tr>
				 <td>Card Number:
				 </td>
				 <td>
				  <input  type="text" name="card_number" maxlength=16>
				 </td>
				</tr>
				<tr>
				 <td>Expiration Date(MM/YYYY):
				 </td>
				 <td>
				  <select name="Month">
	    			<option>Month</option>
  					<option value="jan">Jan</option>
  					<option value="feb">Feb</option>
  					<option value="mar">Mar</option>
  					<option value="apr">Apr</option>
  					<option value="may">May</option>
  					<option value="jun">Jun</option>
  					<option value="jul">Jul</option>
  					<option value="aug">Aug</option>
  					<option value="sep">Sep</option>
  					<option value="oct">Oct</option>
  					<option value="nov">Nov</option>
  					<option value="dec">Dec</option>
					</select>
					<select name="Year">
	    			<option>Year</option>
  					<option value="2014">2014</option>
  					<option value="2015">2015</option>
  					<option value="2016">2016</option>
  					<option value="2017">2017</option>
  					<option value="2018">2018</option>
  					<option value="2019">2019</option>
  					<option value="2020">2020</option>
  					<option value="2021">2021</option>
  					<option value="2022">2022</option>
  					<option value="2023">2023</option>
					</select>
				 </td>
				</tr>
				<tr>
				 <td>
				  CVV (3-digit):
				 </td>
				 <td>
				  <input  type="password" name="cvv" maxlength=3>
				 </td>
				</tr>
				<tr>
				<td colspan="2">
				<p>Your card will be charged a total of: ${currentOrder.orderTotalCurrencyFormat}</p>
				</td>
				</tr>
				<tr><td><input type="submit" name="action" value="confirmOrder" /></td>
				</tr>
				</table>
				</form>
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