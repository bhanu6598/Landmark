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
       <br>
       <h3>Administrator Menu</h3>
       <br>
       	<form id="vieworders" action="AdminController" method="post"><a class="btn" href="#" onclick="document.getElementById('vieworders').submit()"><input type="hidden" name="action" value="viewOrders"/>Display All Orders</a></form>
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