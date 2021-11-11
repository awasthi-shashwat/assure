
// var dt = new Date();

// document.getElementById("time").innerHTML = `${dt.getHours()}:${dt.getMinutes()}`;

let input_regis_log = document.querySelectorAll(".input_regis_log");

input_regis_log.forEach((input) => {
    input.addEventListener('click', (e) => {
        e.target.style.borderBottom = "1px solid #063035";
        input_regis_log.forEach((i) =>{
            if(i != e.target && i.value.length <= 0){
                i.style.borderBottom = "1px solid #C4C4C4";
            }
        })
    });
});


let submit_btn = document.getElementById("submit_btn");

submit_btn.addEventListener('click', async(e) =>{
    let name_input = document.getElementById("name_input").value;
    let email_input = document.getElementById("email_input").value;
    let mob_input = document.getElementById("mob_input").value;
    let pass_input = document.getElementById("pass_input").value;
    let confirm_pass_input = document.getElementById("confirm_pass_input").value;
    let otp_input = document.getElementById("otp").value;

    e.preventDefault();

    clearAllErrors();

    if(pass_input == confirm_pass_input){

        const loginData = {
            userName : name_input,
            userEmail : email_input,
            userMobile : mob_input,
            userPass : pass_input,
            otp : otp_input
        };
    
        fetch("http://localhost:8070/user/authenticate", {
            method:"POST",
            body: JSON.stringify(loginData),
            mode: 'cors',
            headers:{
                "Content-Type":"application/json; charset=UTF-8"
            },
        })
        .then((res) => {
           if(res.status == 200){
               showOTPEnter();
               disableInput();
           }
           else if(res.status == 406){
                document.getElementById("email_symb").style.visibility = "visible";
                document.getElementById("email_error").style.visibility = "visible";
                document.getElementById("email_error").innerText = "Enter correct email";
           }
           else if(res.status == 417){
                document.getElementById("mobile_symb").style.visibility = "visible";
                document.getElementById("mobile_error").style.visibility = "visible";
                document.getElementById("mobile_error").innerText = "Enter correct mobile number";
           }
           else{
                res.json().then((r) =>{
                    if(r.message == "Enter name"){
                        document.getElementById("name_symb").style.visibility = "visible";
                        document.getElementById("name_error").style.visibility = "visible";
                        document.getElementById("name_error").innerText = "Enter name";
                    }
                    else if(r.message == "Name should be more than 2 characters"){
                        document.getElementById("name_symb").style.visibility = "visible";
                        document.getElementById("name_error").style.visibility = "visible";
                        document.getElementById("name_error").innerText = "Name should be more than 2 characters";
                    }
                    else if(r.message == "Enter email"){
                        document.getElementById("email_symb").style.visibility = "visible";
                        document.getElementById("email_error").style.visibility = "visible";
                        document.getElementById("email_error").innerText = "Enter email";
                    }
                    else if(r.message == "Email Already Registered"){
                        document.getElementById("email_symb").style.visibility = "visible";
                        document.getElementById("email_error").style.visibility = "visible";
                        document.getElementById("email_error").innerText = "Email Already Registered";
                    }
                    else if(r.message == "Enter mobile"){
                        document.getElementById("mobile_symb").style.visibility = "visible";
                        document.getElementById("mobile_error").style.visibility = "visible";
                        document.getElementById("mobile_error").innerText = "Enter mobile";
                    }
                    else if(r.message == "Mobile Already Registered"){
                        document.getElementById("mobile_symb").style.visibility = "visible";
                        document.getElementById("mobile_error").style.visibility = "visible";
                        document.getElementById("mobile_error").innerText = "Mobile Already Registered";
                    }
                    else if(r.message == "Enter pass"){
                        document.getElementById("pass_symb").style.visibility = "visible";
                        document.getElementById("pass_error").style.visibility = "visible";
                        document.getElementById("pass_error").innerText = "Enter pass";
                    }
                    else if(r.message == "Password should be more that 4 characters"){
                        document.getElementById("pass_symb").style.visibility = "visible";
                        document.getElementById("pass_error").style.visibility = "visible";
                        document.getElementById("pass_error").innerText = "Password should be more that 4 characters";
                    }
                })
            }
        })
        
    }
    else{
        document.getElementById("confirm_symb").style.visibility = "visible";
        document.getElementById("confirm_error").style.visibility = "visible";
        document.getElementById("confirm_error").style.innerText = "Password does not match";
    }
})


let enter_btn = document.getElementById("enter_btn");

enter_btn.addEventListener('click', async(e) =>{
    let name_input = document.getElementById("name_input").value;
    let email_input = document.getElementById("email_input").value;
    let mob_input = document.getElementById("mob_input").value;
    let pass_input = document.getElementById("pass_input").value;
    let otp_input = document.getElementById("otp").value;

    clearAllErrors();

    e.preventDefault();

    const loginData = {
        userName : name_input,
        userEmail : email_input,
        userMobile : mob_input,
        userPass : pass_input,
        otp : otp_input
    };

    fetch("http://localhost:8070/user/authenticate", {
        method:"POST",
        body: JSON.stringify(loginData),
        mode: 'cors',
        headers:{
            "Content-Type":"application/json; charset=UTF-8"
        },
    })
    .then((res) => {
        if(res.status == 201){
            res.json().then((r) => {
                localStorage.setItem("UserID", JSON.stringify(r));
                window.location = "./home_navigation.htm";
            })
        }
        else{
            res.json().then((r) =>{
                if(r.message == "Incorrect OTP entered"){
                    document.getElementById("otp_error").style.visibility = "visible";
                    document.getElementById("otp_error").style.innerText = "Incorrect OTP entered";
                }
                else if(r.message == "OTP not entered"){
                    document.getElementById("otp_error").style.visibility = "visible";
                    document.getElementById("otp_error").style.innerText = "OTP not entered";
                }
            })
        }

    })

})

let cancel = document.getElementById("cancel");

cancel.addEventListener('click', async(e) =>{
    let name_input = document.getElementById("name_input").value;
    let email_input = document.getElementById("email_input").value;
    let mob_input = document.getElementById("mob_input").value;
    let pass_input = document.getElementById("pass_input").value;
    let otp_input = document.getElementById("otp").value;

    e.preventDefault();

    const loginData = {
        userName : name_input,
        userEmail : email_input,
        userMobile : mob_input,
        userPass : pass_input,
        otp : otp_input
    };

    fetch("http://localhost:8070/user/phoneotp", {
        method:"POST",
        body: JSON.stringify(loginData),
        mode: 'cors',
        headers:{
            "Content-Type":"application/json; charset=UTF-8"
        },
    })
    .then((res) =>{
        showRegister();
        enableInput();
    })
})


let clearAllErrors = () =>{
    let vanish = document.querySelectorAll(".vanish");
    vanish.forEach((e) => {
        e.style.visibility = "hidden";
    })
}

let showOTPEnter = () =>{
    document.getElementById("regis").style.visibility = "hidden";
    document.getElementById("otp_enter").style.visibility = "visible";
}

let showRegister = () =>{
    document.getElementById("regis").style.visibility = "visible";
    document.getElementById("otp_enter").style.visibility = "hidden";
}

let disableInput = () =>{
    document.getElementById("name_input").disabled = true;
    document.getElementById("email_input").disabled = true;
    document.getElementById("mob_input").disabled = true;
    document.getElementById("pass_input").disabled = true;
    document.getElementById("confirm_pass_input").disabled = true;
}

let enableInput = () =>{
    document.getElementById("name_input").disabled = false;
    document.getElementById("email_input").disabled = false;
    document.getElementById("mob_input").disabled = false;
    document.getElementById("pass_input").disabled = false;
    document.getElementById("confirm_pass_input").disabled = false;
}

