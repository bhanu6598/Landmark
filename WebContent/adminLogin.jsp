<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="j_security_check" method="get" >
            <label>Username</label>
            
            <input type="text" name="j_username">
            <label>Password</label>
            <input type="password" name="j_password" ><br>
            <input type="submit" value="Login"  id="alogin">
            
    </form>
    </body>
</html>
