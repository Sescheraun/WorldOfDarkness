console.log("Validate New User");

var validateForm = () => {
    console.log("Submission button was pressed");
    let error = "";
    /******************************************************************
    **                           First Name                          **
    ******************************************************************/
    let NamefirstName = document.querySelector("#firstName").value;

    if (firstName.length < 1) {
        error += "First Name is a required Field <br />";
    }


    /******************************************************************
     **                          Last Name                           **
     ******************************************************************/
    let lastName = document.querySelector("#lastName").value;

    if (lastName.length < 1) {
        error += "Last Name is a required Field <br />";
    }
    /******************************************************************
     **                           User Name                          **
     ******************************************************************/
    let user = document.querySelector("#userName").value;

    if (user.length < 1) {
        error += "User Name is a required Field <br />";
    }

    /******************************************************************
     **                         Email Address                        **
     ******************************************************************/
    let email = document.querySelector("#email").value;

    if (email.length < 1) {
        error += "Email is a required Field <br />";
    }
    /******************************************************************
     **                            Password                          **
     ******************************************************************/
    let password1 = document.querySelector("#password").value;
    let password2 = document.querySelector("#password2").value;

    if (password1 != password2) {
        error += "Passwords do not match.<br />";
    } else if (password1.length < 10) {
        error += "Password must be at least 10 characters<br />";
    }

    console.log(error);

    if (error = "") {
        return true;
    } else {
        $("#errorDisplay").textContent = error;
        return false;
    }
}