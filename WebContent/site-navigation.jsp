<div id="sidebar">
      <!-- Categories -->
      <div class="box categories">
        <h2>Links<span></span></h2>
        <div class="box-content">
        <form id="ct" action="CatalogController" method="post">
          <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="#" onclick="getElementById('ct').submit();"><input type="hidden" name="action" value="catalog"/>Catalog</a></li>
            <li><a href="about.jsp">About</a></li>
            <li class="last"><a href="contact.jsp">Contact Us</a></li>
          </ul>
        </form>
        </div>
      </div>
      <!-- End Categories -->
</div>