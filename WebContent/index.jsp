<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<%@ include file="user-navigation.jsp" %>
  <!-- Main -->
  <div id="main">
    <div class="cl">&nbsp;</div>
    <!-- Content -->
    <div id="content">
      <div id="slider" class="box">
        <div id="slider-holder">
        </div>
      </div>
      <!-- Products -->
      <div class="products">
        <div class="cl">&nbsp;</div>
        <p>Welcome to Landmark BookStore. The most convenient way to purchase books online.</p>
        <p>Your one stop place for all reading needs. Discounted products for students. Keep buying.</p>
        <a href="<c:url value="/admin/AdminPage.jsp"/>">Administartive Access</a>
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