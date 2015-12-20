    
function loadPosts(stranica){

	var ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4 && ajax.status == 200)
			document.getElementById("postWrapper").innerHTML = ajax.responseText;
		if (ajax.readyState == 4 && ajax.status == 404)
			document.getElementById("postWrapper").innerHTML = "Greska: nepoznat URL";
	}
	ajax.open("GET", stranica, true);
	ajax.send();
	
	return false;
}

function loadMessages(prijatelj){
	
	var ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function() {
		if (ajax.readyState == 4 && ajax.status == 200)
			document.getElementById("messagesBox").innerHTML = ajax.responseText;
		if (ajax.readyState == 4 && ajax.status == 404)
			document.getElementById("messagesBox").innerHTML = "Greska: nepoznat URL";
	}
	ajax.open("POST", 'get-messages' , true);
	ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    ajax.send("prijateljID=" + prijatelj);
    
	return false;
}

function sendMessage(){
	
}