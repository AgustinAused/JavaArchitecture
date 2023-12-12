/**
 * 
 */
 function validation() {
		let isbnValue = document.getElementByid("isbn");
		let miForm = document.getElementByid("");
		if (isbnValue == "") {
			alert("datos invalidos");
			return false;
		} else {
			miForm.submit();
		}
	}