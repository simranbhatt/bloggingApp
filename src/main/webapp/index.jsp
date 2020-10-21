<html>
<title>Pense - Think Out Loud</title>
<%
//if the user is logged in, automatically redirect them to home
 if (session.getAttribute("username") != null) {
       response.sendRedirect("home.jsp");
       }
 %>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
 <style>
    @import url('https://fonts.googleapis.com/css2?family=Secular+One&display=swap');
    body {
    background-image:linear-gradient(#ECD9BA, #DEC19B);
    font-family: 'Secular One', sans-serif; color:white;
    text-align: center;
    overflow: hidden;
    }
    .get_blogging {
        display:inline-block;
        resize: both;
        margin-left:auto;
        margin-right:auto;
        margin-top: 10%;
        font-family: 'Secular One', sans-serif; color:#FFFAF1;
        overflow: hidden;
        font-size:50px;
        width: 100%;
        text-align: center;
    }
    .container {
     display:block;
     text-align: center;
     }
    form {
    resize: both;
    display: inline-block;
    text-align: center;
    background-color:#F4F0DB;
    margin-left: auto;
    margin-right: auto;
    margin-top: 10px;
    width: 50%;
    padding: 20px 0px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }


     *:focus { /* to prevent black outline appearing on the current form field being filled */
        outline:none;
      }

    input[type = text], input[type = password] {
        display:inline-block;
        border:none;
        border-radius: 3px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        width: 70%;
        margin-top: 10px;
        margin-bottom:10px;
        padding:5px;
        font-family: Arial, sans-serif;
    }

    input[type = submit] {
    width: 40%;
    margin: auto;
    padding:5px;
    margin-top: 20px;
    margin-bottom: 30px;
    border: none;
    border-radius:3px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    cursor:pointer;
    font-weight:bold;
    }
    input[type = submit]:hover {
        opacity:0.8;
    }
    .msg {
    color: red;
    display: inline-block;
    }
    .signup a {
     width: 90%;
     text-align: right;
     display:inline-block;
     margin-right:5px;
     margin-bottom:10px;
     color:#696969;
    }

    .signup:hover a {
      cursor:pointer;
      opacity:0.6;
    }

 </style>
</head>

<body>

 <p><span class="get_blogging">Get Blogging.</p>

 <form action = "/login" method = "post">

    <div class = "container">

        <label for = "emailId"></label>
        <input type = "text" placeholder = "Enter email" name = "emailId" required>

        <label for = "password"></label>
        <input type = "password" placeholder = "Enter password" name = "password" required>

        <input type = "submit" value = "Login" name = "loginButton">

        <span class="signup"> <a href="signup.jsp">Don't have an account?</a></span>
        <span class = "msg"> ${message} </span>
    </div>
    </form>

 </body>

</html>

