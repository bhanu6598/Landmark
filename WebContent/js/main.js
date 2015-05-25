function calculate() {
	var myBox1 = document.getElementById('box1').value;
	var myBox2 = document.getElementById('box2').value;
	var myBox3 = document.getElementById('box3').value;
	var myBox4 = document.getElementById('box4').value;
	var result = document.getElementById('result');
	var result2 = document.getElementById('result2');
	var result3 = document.getElementById('result3');
	var result4 = document.getElementById('result4');
	var myResult = myBox1 * 199.99;
	document.getElementById('result').innerHTML = myResult;
	var myResult2 = myBox2 * 176.99;
	document.getElementById('result2').innerHTML = myResult2;
	var myResult3 = myBox3 * 159.99;
	document.getElementById('result3').innerHTML = myResult3;
	var myResult4 = myBox4 * 196.99;
	document.getElementById('result4').innerHTML = myResult4;
	var total = myResult + myResult2 + myResult3 + myResult4;
	document.getElementById('total').innerHTML = total;
}