<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@page isELIgnored="false" %>
    <%@page import="com.payment.models.Payment"%>
    <%@taglib prefix="c" 
        uri="http://java.sun.com/jsp/jstl/core" %>
    
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<style type="text/css">
  *{
     margin:0;
     padding:0;
  }
    body {
        background: #f5f5f5;   
    }
    .header {
    background: #fff;
    padding: 30px;
    box-shadow: 1px 1px 3px #bbbaba;
    margin-bottom: 50px;
   
    }
    .logo {
    display:inline-block;
    }
    .logo p{
    font-size: 20px;
    font-family: arial;
    font-weight: 600;
    text-transform: uppercase;
    color:#545454;
    }
    .menu-admin {
    display:inline-block;
      float: right;
      padding-top: 12px;
    }
    .menu-user {
    display:inline-block;
        float: right;
        padding-top: 12px;
    }
    .menu-nav {
    display: inline-block;
    list-style: none;
    }
    .menu-nav li {
        display: inline-block;
    }
    .menu-nav li a{
    padding: 10px 10px;
    text-decoration: none;
    color: #545454;
    }
    .login-title {
      padding-top: 2px;
    border: 1px solid #e6e5e5;
    border-left: none;
    border-right: none;
    /* border-top: none; */
    background: #cecece;
    margin: 27px 0;
    padding-left: 14px;
    }
    .login-title p{
     font-size: 20px;
    font-weight: 600;
    color: #5f5f5f;
    font-family: arial;
    margin: 7px 0;
    text-align: left;
    }
    .loginForm{
    background: #ffffff;
    width: 500px;
    margin: 25px auto;
    box-shadow: 0px 0px 6px 1px #0e0e0e22;
    }
    .form-controll{
   
    }
    .control-enter {
    border: 1px solid #e5e6e5;
    padding: 10px;
    border-radius: 2px;
    width: 60%;
    margin: 12px 0;
    }
    .control-enter:focus {
       outline: none;
    }
  
    .Login-submit {
           border: 1px solid #ffffff;
        padding: 10px 22px;
    background: #4394e8;
    margin: 17px 0;
    margin-top: 25px;
    color: #fff;
    border-radius: 7px;
    cursor: pointer;
       }
       .Login-submit:focus {
       outline:none;
       }
.Register {
      background: #fff;
      text-decoration:none;
       padding: 9px 12px;
    border: 1px solid #ccc9c9;
    border-radius: 7px;
    display: inline-block;
    color: #3e3e3e;
    margin-left: 5px;
    font-family: arial;
    font-size: 14px;
   }
   .tableContainer {
   background: #fff;
    width: 80%;
    margin: 0 auto;
    padding: 12px 12px 30px 12px;
    box-shadow: 0px 0px 4px 2px #ececec;
    border-radius: 5px;
   }
   .payment-title {
   margin: 0 0 26px 0;
    color: #d84141;
    font-size: 18px;
    display:inline-block;
    font-weight: 600;
   }
   .user-name {
   color: #295584;
   }
   table{
    width:100%;
    margin: 0 auto;
    border-collapse: collapse;
   }
   table tr:nth-child(odd) td{
    background: #f3f2f2;
     }
    table tr:nth-child(even) td{
    background: #fff;
     }
   .table-header {
     border-radius: 3px;
   }
    th {
   padding: 10px 12px;
    background: #5ea7f3;
    color: #fff;
    font-weight: normal;
    font-size: 14px;
    font-family: arial;
    }
    td {
     padding: 7px 12px;
    text-align: center;
    color: #606565;
    font-family: arial;
    font-size: 14px;
    }
    td a{
       display: inline-block;
    color: #fff;
    text-decoration: none;
    padding: 4px 7px;
    border-radius: 4px;
    margin: 0 5px;
    font-size:13px;
    }
     .update{
       background: #2a6188;
    }
    .cancel {
    background: #ab3030;
    }
    .menu-admin li {
    list-style: none;
    }
    .menu-admin li a{
    color: #222;
    text-decoration: none;
    padding: 6px;
    background: #f1f1f1;
    border: 1px solid #ddd;
    border-radius: 4px;
    }
</style>
</head>
<body>
    <div class="container">
       <div class="header">
           <div class="logo">
             <p>Payment Management Portal</p>
           </div>
       </div>
    </div>
         <% 
         
         if(request.getSession(false)!=null && request.getSession(false).getAttribute("userRole")!=null ){
        	
            %>
              
              <div class="tableContainer">
              <p class="payment-title">Payments Management for User : <span class="user-name">${sessionScope.userName}</span> </p>
               <div class="menu-admin">
              <ul>
                  <li><a href="ShowAddPayment">Add Payment</a></li>
                  </ul>
               </div>
              <table class="table-payment">
              <tr class="table-header">
                  <th>Payment Type</th>
                  <th>Payment Date</th>
                  <th>Card Expiry Date</th>
                  <th>Card No</th>
                  <th>Order Id</th>
                  <th>Cvv</th>
                  <th>Payment Status</th>
                  <th>Actions</th>
                </tr>
               <c:choose>
               <c:when test="${paymentList!=null}">
               <c:forEach items="${paymentList}" var="paym">
                
               <tr><td>${paym.paymentType}</td>
               <td>${paym.paymentDate}</td>
               <td>${paym.cardExpiryDate}</td>
               <td>${paym.cardNo}</td>
               <td>${paym.orderId}</td>
               <td>${paym.cvv}</td>
               <td>${paym.paymentStatus}</td>
               <td>
                 <!--  <a class="update" href='ShowUpdatePage?userIDN=22'>Update Payment</a> -->
                   <a class="update" href="<c:url value="ShowUpdatePage">
                   <c:param name="userIDN" value="${paym.paymenyID}"/>
                  </c:url>">Update Payment</a>
                  <a class="cancel" href="<c:url value="CancelPayment">
                   <c:param name="paymentId" value="${paym.paymenyID}"/>
                  </c:url>">Cancel</a>
                 <!--  <a class="cancel" href="CancelPayment">Cancel</a> -->
               </td>
               </tr>
               
               </c:forEach>
                 </c:when>
                 <c:otherwise>
               <tr>
             <td >
                  No Records Found
             </td>
              </tr>
               </c:otherwise>
               </c:choose>
               </table>
             </div>
           
            <%  
           
         }
         else {
        	 %>
        	  <form id="loginFormDiv" class="loginForm" align="center" action="UserLogin" method="post">
        <div class="login-title">
           <p>Account Login</p>
        </div>
		<div class="form-controll">
			<input type="text" class="control-enter" id="userName" name="username" placeholder="User Name" />
		</div>
		
		<div class="form-controll">

			<input type="password"  class="control-enter" id="password" name="password" placeholder="Password" />
		</div>
		<div>
			<input type="submit" class="Login-submit" value="Login" onclick="login()" />
			<a href="ShowServletController" class="Register">Register</a>
		</div>
	   </form>
        <% 	 
         }
           %>
           
           
        
</body>
</html>