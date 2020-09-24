<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@page import="com.payment.models.Payment"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
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
    text-align: center;
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
    .control-enter:focus,.role:focus {
       outline: none;
    }
    .label-input {
    display: inline-block;
    width: 30%;
    color: #4b83b3;
    font-size: 14px;
    font-family: arial;
    }
    .role {
     width: 65%;
    padding: 7px 0;
    border: 1px solid #ddd;
    color: #656363;
    border-radius: 2px;
    margin: 5px;
    }
  
    .Login-submit {
           border: 1px solid #ffffff;
        padding: 10px 22px;
    background: #4394e8;
    margin: 17px 0;
    margin-top: 25px;
    width:66%;
    color: #fff;
    border-radius: 7px;
    cursor: pointer;
       }
       .Login-submit:focus {
       outline:none;
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
    
    <form id="loginFormDiv" class="loginForm"  action="UpdatePayment" method="post">
        <div class="login-title">
           <p>Payment Update</p>
        </div>
		<div class="form-controll">
		    <label class="label-input">Payment Type</label>
		    <% Payment pay =(Payment)session.getAttribute("paymentUpdate"); %>
			<input type="text" class="control-enter" id="paymentType" name="paymentType" value='<% out.print(pay.getPaymentType());%>' />
		</div>
		
		<div class="form-controll">
            <label class="label-input">Payment Date</label>
			<input type="text"  class="control-enter" id="paymentDate" name="paymentDate" value='<% out.print(pay.getPaymentDate());%>' />
		</div>
		<div class="form-controll">
            <label class="label-input">Card No</label>
			<input type="text"  class="control-enter" id="cardNo" name="cardNo" value='<% out.print(pay.getCardNo());%>' />
            
		</div>
		<div class="form-controll">
            <label class="label-input">Card Expiry Date</label>
			<input type="text"  class="control-enter" id="cardExpiryDate" name="cardExpiryDate" value='<% out.print(pay.getCardExpiryDate());%>' />
            
		</div>
		<div class="form-controll">
		    <label class="label-input">Order ID</label>
			<input type="text"  class="control-enter" id="orderId" name="orderId"  value='<% out.print(pay.getOrderId());%>' />
		</div>
		<div class="form-controll">
		    <label class="label-input">CVV</label>
			<input type="text"  class="control-enter" id="cvv" name="cvv" value='<% out.print(pay.getCvv());%>' />
		</div>
		<div class="form-controll">
		    <label class="label-input">Payment Status</label>
			<input type="text"  class="control-enter" id="paymentStatus" name="paymentStatus" value='<% out.print(pay.getPaymentStatus());%>' />
		</div>
		<input type="hidden" name="paymentId" value='<% out.print(pay.getPaymenyID());%>'>
		<div>
			<input type="submit" class="Login-submit" value="Save Changes" onclick="login()" />
		</div>
	   </form>
</body>
</html>