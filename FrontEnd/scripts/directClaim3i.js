let visibleSection = document.getElementById("info");
let processingSection = document.getElementById("processing");
let doneSection = document.getElementById("payment_success_section");
let successButton = document.getElementById('paymentDone');
let checkBtn = document.getElementById('agreeCheck');

document.querySelector('form').addEventListener('submit', (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    console.log(formData.get('checkbox'));
   if(checkBtn.checked){
        visibleSection.style.display = "none";
        processingSection.style.display = "block";
        setTimeout(() => {
            processingSection.style.display = "none";
            doneSection.style.display = "block";
        }, 2000);
   }
    
});


successButton.addEventListener('click', () => {
    window.location = "./home_navigation.htm";
});