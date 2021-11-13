let selected_claim=JSON.parse(localStorage.getItem("choosen_claim"));
document.getElementById("claim_heading").innerText=selected_claim.selected;

if(selected_claim.selected=="Call & Claim"){
    document.getElementById("call_icon").classList.remove('d-none');
}