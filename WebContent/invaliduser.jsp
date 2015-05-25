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
			    <form action="LoginServlet" method="post">
			    <p>Invalid UserID/Password</p>
	<table>
	    <tr>  
                    <td>UserId</td>  
                    <td><input type="text" name="userId" /></td>  
                </tr>  
                <tr>  
                    <td>Password</td>  
                    <td><input type="password" name="userpass" /></td>  
                </tr>  
                <tr>  
                    <td colspan=2 align="center"><input type="submit" value="Login" /></td>
                </tr>
				<tr>  
                    <td></td>
                </tr></table>
    </form>
            <a href="registration.jsp">New users click here to register</a>
    
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