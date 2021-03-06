<!-- <html>
<head>
<style>
* { box-sizing: border-box; }
body {
	font-family: "HelveticaNeue-Light","Helvetica Neue Light","Helvetica Neue",Helvetica,Arial,"Lucida Grande",sans-serif;
  color:white;
  font-size:12px;
  background:#333 url(/images/classy_fabric.png);
  background-image: url("banner.jpg");
  background-color: #cccccc;
  height: 100%;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
form {
 	background:#111; 
  width:300px;
  margin:30px auto;
  border-radius:0.4em;
  border:1px solid #191919;
  overflow:hidden;
  position:relative;
  box-shadow: 0 5px 10px 5px rgba(0,0,0,0.2);
}
form:after {
  content:"";
  display:block;
  position:absolute;
  height:1px;
  width:100px;
  left:20%;
  background:linear-gradient(left, #111, #444, #b6b6b8, #444, #111);
  top:0;
}
form:before {
 	content:"";
  display:block;
  position:absolute;
  width:8px;
  height:5px;
  border-radius:50%;
  left:34%;
  top:-7px;
  box-shadow: 0 0 6px 4px #fff;
}
.inset {
 	padding:20px; 
  border-top:1px solid #19191a;
}
form h1 {
  font-size:18px;
  text-shadow:0 1px 0 black;
  text-align:center;
  padding:15px 0;
  border-bottom:1px solid rgba(0,0,0,1);
  position:relative;
}
form h1:after {
 	content:"";
  display:block;
  width:250px;
  height:100px;
  position:absolute;
  top:0;
  left:50px;
  pointer-events:none;
  transform:rotate(70deg);
  background:linear-gradient(50deg, rgba(255,255,255,0.15), rgba(0,0,0,0)); 
}
label {
 	color:#666;
  display:block;
  padding-bottom:9px;
}
input[type=text],
input[type=number],
input[type=float]
 {
 	width:100%;
  padding:8px 5px;
  background:linear-gradient(#1f2124, #27292c);
  border:1px solid #222;
  box-shadow:
    0 1px 0 rgba(255,255,255,0.1);
  border-radius:0.3em;
  margin-bottom:20px;
}
label[for=remember]{
 	color:white;
  display:inline-block;
  padding-bottom:0;
  padding-top:5px;
}
input[type=checkbox] {
 	display:inline-block;
  vertical-align:top;
}
.p-container {
 	padding:5 10px 10px 10px; 
}
.p-container:after {
 	clear:both;
  display:table;
  content:"";
}
.p-container span {
  display:block;
  float:left;
  color:#0d93ff;
  padding-top:8px;
}
input[type=submit] {
 	padding:5px 20px;
  border:1px solid rgba(0,0,0,0.4);
  text-shadow:0 -1px 0 rgba(0,0,0,0.4);
  box-shadow:
    inset 0 1px 0 rgba(255,255,255,0.3),
    inset 0 10px 10px rgba(255,255,255,0.1);
  border-radius:0.3em;
  background:#0184ff;
  color:white;
  float:right;
  font-weight:bold;
  cursor:pointer;
  font-size:13px;
}
input[type=submit]:hover {
  box-shadow:
    inset 0 1px 0 rgba(255,255,255,0.3),
    inset 0 -10px 10px rgba(255,255,255,0.1);
}
input[type=text]:hover,
input[type=number]:hover,
input[type=float]:hover
label:hover ~ input[type=text],
label:hover ~ input[type=number],
label:hover ~ input[type=float] {
 	background:#27292c;
}
</style>
</head>
<body>
<form>
  <h1>New Order</h1>
  <div class="inset">
  <p>
    <label for="userid">User Id</label>
    <input type="number" name="userid" id="userid">
  </p>
  <p>
    <label for="price">Price</label>
    <input type="number" name="price" id="price">
  </p>
  <p>
    <label for="price">Number of shares</label>
    <input type="number" name="shares" id="shares">
  </p>
  <p>
    <label for="Company Name">Company Name</label>
    <input type="text" name="companyname" id="company name">
  </p>
  <label for="buy or sell">Buy or Sell:</label>

  <select name="buyorsell" id="buy or sell">
  <option>--select</option>
  <option value="buy">Buy</option>
  <option value="sell">Sell</option>
</select>
<label for="Trader Name">Trader Name:</label>
<select name="tradername" id="Trader Name">
  <option>--select</option>
  <option value="nyse">nyse</option>
  <option value="bse">bse</option>
  <option value="sor">sor</option>
</select>
  </div>
  <p class="p-container">
    <input type="submit" name="placeorder" id="placeorder" value="Place Order" formaction="${pageContext.request.contextPath}/validate">
	<input type="submit" name="back" id="back" value="Back To Home" formaction="homepage.jsp">
  </p>
</form>
</body>
</html>-->



<html>
<head>
<style>
* { box-sizing: border-box; }
body {
	font-family: "HelveticaNeue-Light","Helvetica Neue Light","Helvetica Neue",Helvetica,Arial,"Lucida Grande",sans-serif;
  color:white;
  font-size:12px;
  background:#333 url(/images/classy_fabric.png);
  background-color: #cccccc;
  height: 100%;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  background: url(banner.jpg) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
form {
 	background:#111; 
  width:300px;
  margin:30px auto;
  border-radius:0.4em;
  border:1px solid #191919;
  overflow:hidden;
  position:relative;
  box-shadow: 0 5px 10px 5px rgba(0,0,0,0.2);
}
form:after {
  content:"";
  display:block;
  position:absolute;
  height:1px;
  width:100px;
  left:20%;
  background:linear-gradient(left, #111, #444, #b6b6b8, #444, #111);
  top:0;
}
form:before {
 	content:"";
  display:block;
  position:absolute;
  width:8px;
  height:5px;
  border-radius:50%;
  left:34%;
  top:-7px;
  box-shadow: 0 0 6px 4px #fff;
}
.inset {
 	padding:20px; 
  border-top:1px solid #19191a;
}
form h1 {
  font-size:18px;
  text-shadow:0 1px 0 black;
  text-align:center;
  padding:15px 0;
  border-bottom:1px solid rgba(0,0,0,1);
  position:relative;
}
form h1:after {
 	content:"";
  display:block;
  width:250px;
  height:100px;
  position:absolute;
  top:0;
  left:50px;
  pointer-events:none;
  transform:rotate(70deg);
  background:linear-gradient(50deg, rgba(255,255,255,0.15), rgba(0,0,0,0)); 
}
label,
option {
 	color:#666;
  display:block;
  padding-bottom:9px;
}
input[type=text],
input[type=number],
input[type=float],
select
 {
 	width:100%;
  padding:8px 5px;
  background:linear-gradient(#1f2124, #27292c);
  border:1px solid #222;
  box-shadow:
    0 1px 0 rgba(255,255,255,0.1);
  border-radius:0.3em;
  margin-bottom:20px;
  color: white;
}
label[for=remember]{
 	color:white;
  display:inline-block;
  padding-bottom:0;
  padding-top:5px;
}
input[type=checkbox] {
 	display:inline-block;
  vertical-align:top;
}
.p-container {
 	padding:5 10px 10px 10px; 
}
.p-container:after {
 	clear:both;
  display:table;
  content:"";
}
.p-container span {
  display:block;
  float:left;
  color:#0d93ff;
  padding-top:8px;
}
input[type=submit] {
 	padding:5px 20px;
  border:1px solid rgba(0,0,0,0.4);
  text-shadow:0 -1px 0 rgba(0,0,0,0.4);
  box-shadow:
    inset 0 1px 0 rgba(255,255,255,0.3),
    inset 0 10px 10px rgba(255,255,255,0.1);
  border-radius:0.3em;
  background:#0184ff;
  color:white;
  float:right;
  font-weight:bold;
  cursor:pointer;
  font-size:13px;
}
input[type=submit]:hover {
  box-shadow:
    inset 0 1px 0 rgba(255,255,255,0.3),
    inset 0 -10px 10px rgba(255,255,255,0.1);
}
input[type=text]:hover,
input[type=number]:hover,
input[type=float]:hover
label:hover ~ input[type=text],
label:hover ~ input[type=number],
label:hover ~ input[type=float] {
 	background:#27292c;
}
</style>
</head>
<body>
<form>
  <h1>New Order</h1>
   <div class="inset">
  <p>
    <label for="price">Price</label>
    <input type="number" name="price" id="price">
  </p>
  <p>
    <label for="price">Number of shares</label>
    <input type="number" name="shares" id="shares">
  </p>
    <label for="Company Name">Company Name</label>
  <select  name="companyname" id="company name">
  <option>--select</option>
  <option value="google">Google</option>
  <option value="flipkart">Flipkart</option>
  <option value="amazon">Amazon</option>
</select>
  
  <label for="buy or sell">Buy or Sell:</label>

  <select name="buyorsell" id="buy or sell">
  <option>--select</option>
  <option value="buy">Buy</option>
  <option value="sell">Sell</option>
</select>
<label for="Trader Name">Trader Name:</label>
<select name="tradername" id="Trader Name">
  <option>--select</option>
  <option value="nyse">NYSE</option>
  <option value="bse">BSE</option>
  <option value="sor">SORT</option>
</select>
  </div>
  <p class="p-container">
      <input type="submit" name="placeorder" id="placeorder" value="Place Order" formaction="${pageContext.request.contextPath}/validate">
	<input type="submit" name="back" id="back" value="Back To Home" formaction="homepage.jsp">
  </p>
</form>
</body>
</html>