<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="omojan.Omojan" %>

<!DOCTYPE html>

<html>
  <head>
    <meta charset="UTF-8">
    
    <title>	HTML JSP</title>
  </head>
  <body>
  
   
    
    <% out.println(new Omojan().getWord());%>

  </body>
</html>