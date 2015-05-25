<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="js/registration.js"></script>
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
		<form name="myForm" action="RegistrationServlet" onsubmit="return validateForm()" method="post">
	<table>
	    <tr><td colspan=2 align="center"><h3>User Details</h3></td></tr>
		<tr><td align="center">First Name:</td><td><input type="text" name="fname" /></td></tr>
		<tr><td align="center">Last Name:</td><td><input type="text" name="lname" /></td></tr>
		<tr><td align="center">Email:</td><td><input type="text" name="email" /></td></tr>
		<tr><td align="center">Address 1:</td><td><input type="text" name="addr1" /></td></tr>
		<tr><td align="center">Address 2:</td><td><input type="text" name="addr2" /></td></tr>
		<tr><td align="center">City:</td><td><input type="text" name="city" /></td></tr>
		<tr><td align="center">State:</td><td><input type="text" name="state" /></td></tr>
		<tr><td align="center">Zip:</td><td><input type="text" name="zip" /></td></tr>
		<tr><td align="center">Country:</td><td><input type="text" name="country" /></td></tr>
		<tr><td align="center">Password:</td><td><input type="password" name="password" /></td></tr>
		<tr><td align="center">Confirm Password:</td><td><input type="password" name="cpassword" /></td></tr>
                <tr>  
                    <td colspan=2 align="center"><input type="submit" value="Register" /></td>
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