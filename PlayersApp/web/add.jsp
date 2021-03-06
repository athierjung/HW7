
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheet.css" />
        <title>Add A New Player</title>
    </head>
    <body>
        <div class="wrap">  <!--div to hold all other divs -->
        
            <%@ include file="includes/header.jsp" %>
                        
            
            <%@ include file="includes/menu.jsp" %>
            
            <div class="main"> <!--main div-->
        
        <h1>Add A New Player</h1>
        
        <form name="addForm" action="addPlayer" method="get">
            <label>Player Name:</label>
            <input type="text" name="name" value="" />
            <br>
            <label>Team Name:</label>
            <input type="text" name="team" value="" />
            <br>
            <label>Position:</label>
            <input type="text" name="position" value="" />
            <br>
            <label>Age:</label>
            <input type="text" name="age" value="" />
            <br>
            <input type="reset" name="reset" value="Clear" />
            <input type="submit" name="submit" value="Submit" />
        </form>
        
        </div>  <!--close main div-->
        
        <%@ include file="includes/footer.jsp" %>
        
        </div>  <!--close wrap div -->
            
    </body>
</html>
