<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Players" %>
<% Players player = (Players) request.getAttribute("player"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheet.css" />
        <title>Update A Player</title>
    </head>
    <body>
        <h1>Update A Player Record</h1>
        
        <form name="updateForm" action="updatePlayer" method="get">
            <label>Player ID:</label>
            <input type="text" name="id" value="<%= player.getPlayerID() %>" readonly/>
            <br>
            <label>Player Name:</label>
            <input type="text" name="name" value="<%= player.getPlayerName() %>" />
            <br>
            <label>Team Name:</label>
            <input type="text" name="team" value="<%= player.getTeam() %>" />
            <br>
            <label>Position:</label>
            <input type="text" name="position" value="<%= player.getPositionName() %>" />
            <br>
            <label>Age:</label>
            <input type="text" name="age" value="<%= player.getAge() %>" />
            <br>
            <input type="reset" name="reset" value="Clear" />
            <input type="submit" name="submit" value="Update" />
        </form>
    </body>
</html>
