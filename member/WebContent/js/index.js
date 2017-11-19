
function cambiar_login() {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";  
document.querySelector('.cont_form_login').style.display = "block";
document.querySelector('.cont_form_sign_up').style.opacity = "0";               

setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);  
  
setTimeout(function(){    
document.querySelector('.cont_form_sign_up').style.display = "none";
},200);  

$("#login").hide();
$("#doLogin").show();
  }

function cambiar_sign_up(at) {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
  document.querySelector('.cont_form_sign_up').style.display = "block";
document.querySelector('.cont_form_login').style.opacity = "0";
  
setTimeout(function(){  document.querySelector('.cont_form_sign_up').style.opacity = "1";
},100);  

setTimeout(function(){   document.querySelector('.cont_form_login').style.display = "none";
},400);  

$('#register').hide();
$("#doRegister").show();
}    



function ocultar_login_sign_up() {

document.querySelector('.cont_forms').className = "cont_forms";  
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.querySelector('.cont_form_login').style.opacity = "0"; 

setTimeout(function(){
document.querySelector('.cont_form_sign_up').style.display = "none";
document.querySelector('.cont_form_login').style.display = "none";
},500);  

  }

function doLogin() {
	var email = $("#login_email").val();
	var passWord = $("#login_passWord").val();
	alert("点击了登录" + email);
	  $.ajax({
          url: "/member/do?type=login",
          type: "POST",
          dataType: "json",
          data:{
              email:email,passWord:passWord
          },
          complete: function(result){
              alert(result.responseText);
          }
      });
}
function doRegister() {
	var email = $("#register_email").val();
	var userName = $("#register_name").val();
	var passWord = $("#register_passWord").val();
	var passWord2 = $("#register_passWord_again").val();
	if (passWord != passWord2) {
		alert("两次输入的密码不一致");
		$("#register_passWord_again").val('');
		return;
	}
	  $.ajax({
          url: "/member/do?type=register",
          type: "POST",
          dataType: "json",
          data:{
              email:email,userName:userName,passWord:passWord
          },
          complete: function(result){
              alert(result.responseText);
          }
      });
}