<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: andrei
  Date: 18.10.2019
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>

    <title>User Search</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Users Search</h1>
</div>


<div class="w3-container w3-padding">


    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">

            <h2>Search user</h2>
        </div>
        <form name="search" method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Search User:
                <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <button class="w3-btn w3-green w3-round-large w3-margin-bottom"
                    type="submit" name="form">Submit
            </button>

        </form>

    </div>
    <table align="center">
        <% String[] subimt = request.getParameterValues("name");
            if (subimt != null) {

                int size = (int) request.getAttribute("size");
                int count = 0;
                while (count <= size) {

                    out.println("<tr class=\"w3-tr\">" + "<td class=\"w3-hover-sand\">" + "  " + request.getAttribute("users" + count) + "  " + "</td>" + "</tr>");

                    count++;


                }
                if (subimt.equals("")) {
                    out.println("<script>window.onload=function(){ \n" +
                            "    window.setTimeout(function() { document.search.submit(); }, 5000);\n" +
                            "};</script>");
                }
            }%>
    </table>
    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
        <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
    </div>
</div>


</body>
</html>
