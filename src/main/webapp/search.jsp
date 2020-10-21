<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
//if the user is not logged in, send them to the login page
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
        overflow-y: scroll;
        margin: 0;
    }
    .navigation {
        display: block;
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


    .navigation .search-container  {
      float: right;
    }

    .navigation input[type=search] {
      padding: 5px;
      margin-top: 10px;
      margin-bottom: -7px;
      font-size: 15px;
      border: none;
    }

    .navigation .search-container button {
      float: right;
      padding: 5px;
      margin-top: 10px;
      margin-right: 20px;
      background: #ddd;
      font-size: 17px;
      border: none;
      cursor: pointer;
    }

    .navigation .search-container button:hover {
      background: #ccc;
    }

     /*styling the post shown on the page */
        .wrapPost {
           display: inline-block;
           float: left;
           margin-top:2%;
           margin-left: 1%;
           margin-bottom:2%;
           border: solid-white;
           background-color: white;
           border-radius: 6px;
           max-width: 70%;

        }

        .titlesStyle {
           float: left;
           text-align: left;
           width: 100%;
           display: inline-block;
           font-family: 'Raleway', sans-serif;
           font-weight: bold;
           font-size:30px;
           color: black;
           text-decoration: none;
           margin-top: 1%;
           margin-left: 1%;
           max-width: 50%;
           padding: 5px;
           padding-bottom:10px;
           border: none;
        }

        .nameStyle {
           float: left;
           text-align: left;
           width: 100%;
           display: inline-block;
           font-family: 'Raleway', sans-serif;
           color: black;
           text-decoration: none;
           margin-left: 2%;
           padding: 5px;
           border: none;
        }

        .postStyle {
           float: left;
           width:90%;
           text-align: left;
           display: inline-block;
           font-family: 'Raleway', sans-serif;
           color: black;
           text-decoration: none;
           margin-top: 1.5%;
           margin-left: 2%;
           padding: 20px;
           padding-left:5px;
           border: none;
        }


    /* mobile display settings*/
    /* hide hamburger icon when on a computer screen*/
    .navigation .icon {
      display: none;
    }

    @media screen and (max-width: 600px) {
      .navigation a:not(.active) {
      display: none;
      }
      .navigation a.icon {
        float: right;
        display: block;
      }
    }

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
 <a href = "logout.jsp">Logout</a>
 <div class="search-container">
  <form action="/blogaction" method = "post">
     <input type="search" name="search" placeholder="Search...">
     <button name = "searchButton" type="submit"><i class="fa fa-search"></i></button>
   </form>
   </div>
<a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
 </div>
 <! -- for-each loop using JSTL to display search results retrieved from the session attribute "searchResult" -->
 <! -- set in BlogPostServlet attribute. Note that the taglib on line 2 has to be defined -->

 <c:forEach items="${sessionScope.searchResult}" var="result">
 <div class = "wrapPost" id = "postWrapper">
 <div class = "titlesStyle">${result.title}</div>
 <div class = "nameStyle"><i>${result.email} posted at ${result.timestamp} </i> </div>
 <div class = "nameStyle"><b>Tags:</b> ${result.tag}</div>
 <div class = "postStyle">${result.description}</div>
 </c:forEach>



</body>
</html>