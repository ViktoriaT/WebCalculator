function ajaxFunction() {
	var ajaxRequest;
	if (window.XMLHttpRequest) {
		ajaxRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	ajaxRequest.onreadystatechange = function() {
		if (ajaxRequest.readyState == 4) {
			var jsonObj = JSON.parse(ajaxRequest.responseText);
			document.getElementById("result").value = jsonObj.result;
			document.getElementById("error").innerHTML = jsonObj.err;
		}
	}
	var firstNumber = document.getElementById('firstNumber').value;
	var secondNumber = document.getElementById('secondNumber').value;
	var operation = document.getElementById('operation').value;
	var queryString = "?firstNumber=" + firstNumber + "&operation=" + operation
			+ "&secondNumber=" + secondNumber;
	ajaxRequest.open("Post", "CalcServlet" + queryString, true);
	ajaxRequest.send(null);
}
function resetFunction() {
	document.getElementById("firstNumber").value = " ";
	document.getElementById("secondNumber").value = " ";
	document.getElementById("result").value = " ";
	document.getElementById("error").innerHTML = " ";
}