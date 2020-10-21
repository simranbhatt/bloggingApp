<html>
<%
//if the user isnt logged in, send them to the login page
if(session.getAttribute("username") == null) {
  response.sendRedirect("index.jsp");
  }
%>
<title>Pense | Create</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
 @import url('https://fonts.googleapis.com/css2?family=Secular+One&display=swap');
    body {
        background-image:linear-gradient(#ECD9BA, #DEC19B);
        font-family: 'Secular One', sans-serif; color:white;
        text-align: center;
        overflow: hidden;
        margin: 0;
    }
    .navigation {
        display: block;
        background-color: #FFFAF1;
        overflow: hidden;
        width: 100%;
     }
     .navigation:after {
         clear: both;
     }

     .navigation a {
       height:20px;
       float: left;
       text-align: center;
       background-color: #FFFAF1;
       color: black;
       margin: none;
       padding: 14px 16px;
       text-decoration: none;
       font-size: 17px;
       border: none;
     }

     .navigation a:hover {
       opacity: 0.8;
       cursor: pointer;
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
    }

    /*blog post form*/

    form {
     display: block;
     overflow:hidden;
     width: 100%;
     }

     input[name = post_title] {
      display:inline-block;
      float:center;
      border: none;
      width: 95%;
      margin-left: 1%;
      margin-right:1%;
      margin-top: 2%;
      padding: 20px;
     }

     input[name = post_tags] {
      display:inline-block;
      float:center;
      border: none;
      width: 95%;
      margin-left: 1%;
      margin-right:1%;
      margin-top: 1%;
      padding: 20px;
     }

    textarea#post_description {
     display: inline-block;
     border: none;
     overflow:hidden;
     width: 95%;
     height: 350px;
     margin-left: 1%;
     margin-right:1%;
     margin-top: 1%;
     padding: 20px;
     font-family: Arial;
     }

     input[name = "postButton"] {
          width: 20%;
          margin: auto;
          padding:10px;
          margin-top: 1%;
          border: none;
          border-radius:3px;
          box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
          font-weight:bold;
          font-size: 20px;
          font-family: 'Secular One', sans-serif; color: #654321;

      }

      input[name = "postButton"]:hover {
           opacity:0.8;
           cursor:pointer;
      }

     *:focus {
      outline:none;
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
 <a class = "active" href = "create.jsp">Create</a>
 <a href = "logout.jsp">Logout</a>
 <div class="search-container">
  <form action="/blogaction" method = "post">
     <input type="search" name="search" placeholder="Search...">
     <button name = "searchButton" type="submit"><i class="fa fa-search"></i></button>
   </form>
   </div>
 <a href = "javascript:void(0);" class = "icon" onclick = "myFunction()"><i class="fa fa-bars"></i></a>
 </div></id>

  <div class = "BlogFormContainer">
    <form action = "/makepost" method = "post" id = "BlogForm">

     <label for = "post_title"></label>
     <input type = "text" placeholder = "Title your post" name = "post_title" maxlength = "200" required>

     <label for = "post_tags"></label>
     <input type = "text" placeholder = "Enter some tags (e.g., fitness, art, poetry)" name = "post_tags" maxlength = "30" required>

     <label for = "post_description"></label>
     <textarea name = "post_description" rows = "15" cols = "75" type = "text" placeholder = "Share your thoughts here..." id = "post_description" maxlength = "5000" required></textarea>

     <input type = "submit" value = "Post!" name = "postButton">

     </form>
  </div>
</body>
</html>