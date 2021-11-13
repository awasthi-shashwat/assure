let selected_claim=JSON.parse(localStorage.getItem("choosen_claim"));
document.getElementById("claim_heading").innerText=selected_claim.selected;

function submit(){
    console.log("submit");
    document.getElementById("form_claim").classList.remove("d-block");
document.getElementById("form_claim").classList.add('d-none');
document.getElementById("nav_steps_img").classList.add('d-none'); 
document.getElementById("processing").classList.remove('d-none');
setTimeout(()=>{
    let img=document.getElementById("nav_steps_img");
    img.src="../icons/Component 8payment_success.svg";
    img.classList.remove('d-none');
    img.classList.add("d-block"); 
    document.getElementById("processing").classList.add('d-none');
   document.getElementById("content_success").classList.remove('d-none');
  },2000);

}