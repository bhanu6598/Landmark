  <div id="header">
    <h1 id="logo"><a href="index.jsp">Landmark Bookstore</a></h1>
    <!-- Cart -->
    <div id="cart"> <p class="cart-link">Your Shopping Cart</p>
      <div class="cl">&nbsp;</div>
      <p><span>User: <strong>${theUser.firstname}</strong></span> &nbsp;&nbsp; <span>Cost: <strong>${currentOrder.orderTotalCurrencyFormat}</strong></span> </p></div>
    <!-- End Cart -->
    <!-- Navigation -->
    <div id="navigation">
    <form id="ct1" action="OrderController" method="post">
      <ul>
        <li><a href="signin.jsp">Sign In</a></li>
        <li><a href="cart.jsp">Cart</a></li>
        <li><a href="#" onclick="getElementById('ct1').submit();"><input type="hidden" name="action" value="viewOrders"/>My Orders</a></li>
      </ul>
      </form>
    </div>
    <!-- End Navigation -->
</div>