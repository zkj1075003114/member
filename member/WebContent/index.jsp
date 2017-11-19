<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>Sign Up Login</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="cotn_principal">
  <div class="cont_centrar" style="margin-top: 150px;">
    <div class="cont_login">
      <div class="cont_info_log_sign_up">
        <div class="col_md_login">
          <div class="cont_ba_opcitiy">
            <h2>LOGIN</h2>
            <p>Lorem ipsum dolor sit amet, consectetur.</p>
            <button class="btn_login" onClick="cambiar_login()">LOGIN</button>
          </div>
        </div>
        <div class="col_md_sign_up">
          <div class="cont_ba_opcitiy">
            <h2>SIGN UP</h2>
            <p>Lorem ipsum dolor sit amet, consectetur.</p>
            <button class="btn_sign_up" onClick="cambiar_sign_up()">SIGN UP</button>
          </div>
        </div>
      </div>
      <div class="cont_back_info">
        <div class="cont_img_back_grey"> <img src="po.jpg" alt="" /> </div>
      </div>
      <div class="cont_forms" >
        <div class="cont_img_back_"> <img src="po.jpg" alt="" /> </div>
        <div class="cont_form_login"> <a href="#" onClick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a>
          <h2>LOGIN</h2>
         
          <input type="text" id="login_email" placeholder="Email" />
          <input type="password" id="login_passWord" placeholder="Password" />
          <button id="login" class="btn_login" onClick="cambiar_login()">LOGIN</button>
          <button id="doLogin" class="btn_login" onClick="doLogin()" style="display: none">LOGIN</button>
        </div>
        <div class="cont_form_sign_up"> <a href="#" onClick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
          <h2>SIGN UP</h2>
          <input type="text" id="register_email" placeholder="Email" />
          <input type="text" id="register_name" placeholder="User" />
          <input type="password" id="register_passWord" placeholder="Password" />
          <input type="password" id="register_passWord_again" placeholder="Confirm Password" />
          <button id="register" class="btn_sign_up" onClick="cambiar_sign_up()">SIGN UP</button>
          <button id="doRegister" class="btn_sign_up" onClick="doRegister()" style="display: none">SIGN UP</button>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="js/index.js" charset="utf-8"></script>
<div style="text-align:center;">
<p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>
