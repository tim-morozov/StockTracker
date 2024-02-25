//function to check if form requirements are met
function validator() {
    var fname = document.forms["myForm"]["fname"].value; //first name
    var lname = document.forms["myForm"]["lname"].value; // last name
    var username = document.forms["myForm"]["username"].value; //Username
    var password = document.forms["myForm"]["password"].value; //Username

//if statement to check for blanks
    if (fname == ""  || lname == "" || username == "" || password == ""){
        alert("Please fill out all the required fields");
        return false;
        
    
    }
}