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
        
        <form id="formcart" action="OrderController" method="post">
        <table>
    <tr id="lor">
    <th class="first">${product.productname}</th>
    <th>${product.category}</th>
    <th>${product.productcode}</th>
    </tr>
    <tr>
    <td>
    <img width="128" height="192" class="size" src="${product.imageurl}" alt="" /></td>
    <td>${product.description}</td>
    </tr>
    <tr>
    <td class="price">$${product.price}</td>
    <td><a class="btn" href="#" onclick="getElementById('formcart').submit();"><input type="hidden" name="productList" value="${product.productcode}"/>Add to Cart</a></td>
    <td><input type="hidden" name="action" value="updateCart"></td>
    </tr>
    </table>
    </form>
    <table>
    <tr>
    <td><form id="return" action="CatalogController" method="post"><a class="btn" href="#" onclick="getElementById('return').submit();"><input type="hidden" name="action" value="catalog"/>Catalog</a></form></td>
    </tr>
    </table>
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
