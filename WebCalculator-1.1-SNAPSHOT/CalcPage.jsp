<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebCalculator</title>
<script src="script.js"> </script>
 <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<form id="form" method="post">
		<div class=block1>
			<input type="text" id="firstNumber" name="firstNumber" /> <select
				class="operation" id="operation">
				<option selected="selected" value="add">+</option>
				<option value="subtract">-</option>
				<option value="multiply">*</option>
				<option value="divide">/</option>
			</select> <input type="text" id="secondNumber" name="secondNumber" /> = <input
				type="text" id="result" name="result" readonly="readonly" />

		</div>
		<div class=block2>
			<br> <input class="btn" type="button" value="Count"
				onclick="ajaxFunction()" /> <input class="btn" type="button"
				value="Reset" onclick="resetFunction()" />
		</div>
		<div class=block3>
			<p id="error"></p>
		</div>
	</form>
</body>
</html>