function ucitaj(stranica){

	var ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4 && ajax.status == 200)
			document.getElementById("wrapper").innerHTML = ajax.responseText;
		if (ajax.readyState == 4 && ajax.status == 404)
			document.getElementById("wrapper").innerHTML = "Greska: nepoznat URL";
	}
	ajax.open("GET", stranica, true);
	ajax.send();

}