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
        
        <h3>Contact Us</h3>
        
<table class="contact">
 <tr>
 <td>First Name *
 </td>
 <td>
  <input  type="text" name="first_name" maxlength="50" size="30">
 </td>
</tr>
<tr>
 <td>Last Name
 </td>
 <td>
  <input  type="text" name="last_name" maxlength="50" size="30">
 </td>
</tr>
<tr>
 <td>Email Address *
 </td>
 <td>
  <input  type="text" name="email" maxlength="80" size="30">
 </td>
</tr>
<tr>
 <td>
  Telephone Number
 </td>
 <td>
  <input  type="text" name="telephone" maxlength="30" size="30">
 </td>
</tr>
<tr>
 <td>
  Comments *
 </td>
 <td>
  <textarea  name="comments" cols="25" rows="6"></textarea>
 </td>

</tr>
<tr>
 <td colspan="2" style="text-align:center">
  
  <input type="submit" value="Submit">   
 </td>
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