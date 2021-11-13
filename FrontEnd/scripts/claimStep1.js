let selected_claim=JSON.parse(localStorage.getItem("choosen_claim"));
document.getElementById("claim_heading").innerText=selected_claim.selected;

if(selected_claim.selected=="Call & Claim"){
    document.getElementById("call_icon").classList.remove('d-none');


    
}

function storedetails(){
    let claim_details=
    { 
    Location :document.getElementById("select_location").value,
    hospitalName:document.getElementById("select_hospital").value,
    PolicyNumber:document.getElementById('select_policy').value
    };
    localStorage.setItem('claim_details',JSON.stringify(claim_details));
    location.href="./claim_step2.html";
}