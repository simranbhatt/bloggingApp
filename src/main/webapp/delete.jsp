<html>
<%
//if the user isnt logged in, send them to the login page
if(session.getAttribute("username") == null) {
  response.sendRedirect("index.jsp");
  }
%>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>

    body {
        background-image:linear-gradient(#ECD9BA, #DEC19B);
        font-family: 'Secular One', sans-serif; color:white;
        text-align: center;
        overflow: hidden;
        margin: 0;
    }
    .navigation {
        display: block;
        resize: both;
        background-color: #FFFAF1;
        overflow: hidden;
        width: 100%;
     }

     .navigation a {
       float: left;
       text-align: center;
       background-color: #FFFAF1;
       color: black;
       margin: none;
       padding: 14px 16px;
       text-decoration: none;
       font-size: 17px;
       border: none;
       cursor: pointer;
     }

     .navigation a:hover {
       opacity: 0.8;
     }
     /* give active page icon a different background color */
     .navigation a.active {
       background-color: #D2B48C;
       color: white;
     }

    /* mobile display settings*/
    /* hide hamburger icon when on a computer screen*/
    .navigation .icon {
      display: none;
    }

    @media screen and (max-width: 600px) {
      .navigation a:not(.active) { /*on mobile screens, hide all the title icons except the current one */
      display: none;
      }
      .navigation a.icon { /*hamburger icon*/
        float: right;
        display: block;
      }
    }
    /*display when the hamburger icon is tapped */
    @media screen and (max-width: 600px) {
      .navigation.responsive {
      position: relative;
      overflow:hidden;
      }
      .navigation.responsive .icon {
        position: absolute;
        right: 0;
        top: 0;
        display: block;
      }
      .navigation.responsive a {
        float: none;
        display: block;
        text-align: left;
      }
    }

</style>

<script>
function myFunction() {
  var x = document.getElementById("navigator");
  if (x.className === "navigation") {
    x.className += " responsive";
  } else {
    x.className = "navigation";
  }
}
</script>
<body>

 <div class = "navigation" id = "navigator">
 <a href = "home.jsp">${sessionScope.username}</a>
 <a href = "create.jsp">Create</a>
 <a href = "search.jsp">Search</a>
 <a class = "active" href = "delete.jsp">Delete</a>
 <a href = "logout.jsp">Logout</a>
<a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
 </div>


</body>
</html>