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
        <form id="form" action="CatalogController" method="post">
        <table class="category"><tr><td>
	    <select name="Category">
	    <option>Choose a category</option>
  		<option value="fiction">Fiction</option>
  		<option value="non fiction">Non Fiction</option>
	</select></td></tr>
                <tr>  
                    <td><input type="submit" name="action" value="search" /></td>
                </tr></table></form>
        <h3>Fiction</h3>
                <ul>
        <c:forEach items="${products}" var="products">
        <c:if test="${products.category == 'Fiction'}"><li>
        <form id="${products.productcode}" action="CatalogController" method="get">
        <a href="#" onclick="getElementById('${products.productcode}').submit();">
        <input type="hidden" name="action" value="${products.productcode}"/>
    <c:out value="${products.productname }"/>
    <img width="128" height="192" src="<c:url value="${products.imageurl}"/>" alt="" /></a><br/></form>
  </li></c:if></c:forEach></ul>
        <div class="cl">&nbsp;</div>
        <h3>Non Fiction</h3>
        <ul>
        <c:forEach items="${products}" var="products">
            <c:if test="${products.category == 'Non Fiction'}"><li>
        <form id="${products.productcode}" action="CatalogController" method="get">
        <a href="#" onclick="getElementById('${products.productcode}').submit();">
        <input type="hidden" name="action" value="${products.productcode}"/>
    <c:out value="${products.productname }"/>
    <img width="128" height="192" src="<c:url value="${products.imageurl}"/>" alt="" /></a><br/></form>
  </li></c:if></c:forEach></ul>
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