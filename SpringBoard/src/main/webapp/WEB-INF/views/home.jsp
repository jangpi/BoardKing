<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>로그인 / 회원가입 폼 템플릿</title>
        <link rel="stylesheet" href="resources/css/style.css">
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <script type="text/javascript">
	$(document).ready(function(){
		$("#logoutBtn").on("click", function(){
			location.href="member/logout";
		})
		
		$("#registerBtn").on("click", function(){
			location.href = "member/register";
		})
		
		$("#memberUpdateBtn").on("click", function(){
			location.href = "member/memberUpdateView";
		})
		
		$("#memberDeleteBtn").on("click", function(){
			location.href = "member/memberDeleteView";
		})
	})
	</script>
    <body>
        <div class="wrap">
            <div class="form-wrap">
                <div class="button-wrap">
                    <div id="btn"></div>
                    <button type="button" class="togglebtn" onclick="login()">LOG IN</button>
                    <button type="button" class="togglebtn" onclick="register()">REGISTER</button>
                </div>
                <div class="social-icons">
                    <img src="resources/img/fb.png" alt="facebook">
                    <img src="resources/img/tw.png" alt="twitter">
                    <img src="resources/img/gl.png" alt="google">
                </div>
                <form id="login" action="/member/login" class="input-group" name='homeForm' method = "post">
                    <input type="text" id="userId" name="userId" class="input-field" placeholder="User name or ID" required>
                    <input type="password" id="userPass" name="userPass" class="input-field" placeholder="Enter Password" required>
                    <input type="checkbox" class="checkbox"><span>Remember Password</span>
                    <button class="submit">Login</button>
                    
					<c:if test="${member != null }">
						<div>
							<p>${member.userId}님 환영 합니다.</p>
							<button id ="memberUpdateBtn" type = "button">회원정보수정</button>
							<button id ="memberDeleteBtn" type = "button">회원탈퇴</button>
							<button id="logoutBtn" type="button">로그아웃</button>
						</div>
					</c:if>	
                </form>
                <form id="register" action="" class="input-group">
                    <input type="text" class="input-field" placeholder="User name or Email" required>
                    <input type="email" class="input-field" placeholder="Your Email" required>
                    <input type="password" class="input-field" placeholder="Enter Password" required>
                    <input type="checkbox" class="checkbox"><span>Terms and conditions</span>
                    <button class="submit">REGISTER</button>
                </form>
            </div>
        </div>
        <script>
            var x = document.getElementById("login");
            var y = document.getElementById("register");
            var z = document.getElementById("btn");
            
            
            function login(){
                x.style.left = "50px";
                y.style.left = "450px";
                z.style.left = "0";
            }

            function register(){
                x.style.left = "-400px";
                y.style.left = "50px";
                z.style.left = "110px";
            }
            
            function 
        </script>
    </body>
</html>