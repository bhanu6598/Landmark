function validateForm()
{
	var b=document.forms["payment"]["card_number"].value;
	var c=document.forms["payment"]["cvv"].value;
	
	if (b==null || b=="" || isNaN(b) || b.length!=16)
	  {
	  alert("Please provide a valid 16 digit card number.");
	  return false;
	  }

	if (c==null || c=="" || isNaN(c) || c.length!=3)
	  {
	  alert("Please provide valid 3 digit cvv.");
	  return false;
	  }
	
}