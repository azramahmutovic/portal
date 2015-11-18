/**
 * Created by Edin on 11/17/2015.
 */
var validirano = false;
var validacija_emaila =false;
var validacija_passworda =false;


function validateLoginForm(){

    validirano = true;

    /*------------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------Validacija email-a--------------------------------------------------------*/
    var email = document.getElementById('email');
    var mail_error =document.getElementById('email_error');

    if(email.value.length == 0){

        validirano = false;
        email.style.backgroundColor = "red";
        mail_error.innerHTML = "Niste unijeli email.";
        mail_error.style.display = "block";

    }
    else if(!email.value.match(/^[a-z\._0-9]+@[a-z]+\.[a-z]{2,4}$/)) {
        validirano=false;
        email.style.background ="red";
        mail_error.innerHTML = "Neispravan format emaila.";
        mail_error.style.display = "block";

    }
    else{

        mail_error.style.display ="none";
        email.style.backgroundColor ="green";

        validacija_emaila=true;

    }
    /*------------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------Validacija passworda------------------------------------------------------*/
    var password = document.getElementById('password');
    var password_error =document.getElementById('password');

    if(password.value.length == 0){

        validirano = false;
        password.style.backgroundColor = "red";
        password_error.innerHTML = "Niste unijeli email.";
        password_error.style.display = "block";

    }
    else if(!password.value.match(/^[a-z\._0-9]$/)) {
        validirano=false;
        email.style.background ="red";
        password_error.innerHTML = "Neispravan format emaila.";
        password_error.style.display = "block";

    }
    else{

        password_error.style.display ="none";
        password.style.backgroundColor ="green";

        validacija_passworda =true;

    }


   /*------------------------------------------------------------------------------*/

    if(validirano == true){

        document.getElementById('loginbtn').type = "submit";
    }



}