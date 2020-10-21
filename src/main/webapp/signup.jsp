<html>
<title>Pense | Sign Up</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<style>
    @import url('https://fonts.googleapis.com/css2?family=Secular+One&display=swap');

    body {
        background-image: linear-gradient(#ECD9BA, #DEC19B);
        font-family: 'Secular One', sans-serif; color:white;
        text-align: center;
        overflow: hidden;
    }
    .header { /* styling for the title tagline ("sign up to start sharing") */
          display:block;
          resize: both;
          margin-left:auto;
          margin-right:auto;
          margin-top: 7%;
          font-family: 'Secular One', sans-serif; color:#FFFAF1;
          overflow: hidden;
          font-size:50px;
          width: 100%;
          text-align: center;
    }

    .container { /* form container to prevent messy mobile display */
    display: block;
    text-align: center;
    }

    form {
        display: inline-block;
        resize: both;
        background-color: #F4F0DB;
        text-align: center;
        margin-left: auto;
        margin-right: auto;
        margin-top: 10px;
        width:50%;
        padding: 20px 0px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }
    *:focus { /* to prevent black outline appearing on the current form field being filled */
            outline:none;
    }

    input { /*styling the input form fields */
        display: inline-block;
        border:none;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        width: 80%;
        margin-top: 10px;
        margin-bottom:10px;
        padding:5px;
        font-family: Arial, sans-serif;
        border-radius:3px;
    }

    input[type = submit] { /* styling the Register button */
        width: 60%;
        margin: auto;
        padding:5px;
        margin-top: 20px;
        margin-bottom: 30px;
        background-color: #F4F0DB;
        border: none;
        border-radius: 3px;
        font-weight: bold;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        cursor:pointer;
    }

    input[type = submit]:hover {
        opacity:0.8;
    }
    .msg {
    display: inline-block;
    text-align:left;
    margin-left: 10%;
    width: 100%;
    color: red;
    }
</style>
<p><span class="header">Sign Up To Start Sharing!</p>
<form action="/login" method = "post">
    <div class = "container">

      <label for = "firstname"></label>
      <input type = "text" placeholder = "First Name" name = "firstname" required>
       <span class = "msg"> ${namemessage} </span>
      <label for = "lastname"></label>
      <input type = "text" placeholder = "Last Name (optional)" name = "lastname">

       <label for = "emailId"></label>
       <input type = "text" placeholder = "Email Address" name = "emailId">
       <span class = "msg"> ${emailmessage} </span>

        <label for = "password"></label>
        <input type = "password" placeholder = "Password" name = "password" required>
        <span class = "msg"> ${passwordmessage} </span>


        <input type = "submit" value = "Register" name = "registerButton">

        </div>
        </form>
</body>
</html>