    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h3>${searchcategory}</h3>
        <ul>
        <c:forEach items="${categoryproducts}" var="product"><li>
        <form id="${product.productcode}" action="CatalogController" method="get">
        <a href="#" onclick="getElementById('${product.productcode}').submit();">
        <input type="hidden" name="action" value="${product.productcode}"/>
    <c:out value="${product.productname }"/>
    <img width="128" height="192" src="<c:url value="${product.imageurl}"/>" alt="" /></a><br/></form>
  </li></c:forEach></ul>
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