
document.querySelector('form').addEventListener('submit', (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    
    // console.log(JSON.stringify(Object.fromEntries(formData)));
    // console.log(Object.fromEntries(formData));
    addToTreatmentDocumentDetails(Object.fromEntries(formData));
});
if(localStorage.getItem("treatmentDocuments")==null){
    localStorage.setItem("treatmentDocuments", JSON.stringify([]));
}

function addToTreatmentDocumentDetails(p){
    let openTreatmentDocumentDetails = JSON.parse(localStorage.getItem("treatmentDocuments"));
    openTreatmentDocumentDetails.push(p);
    localStorage.setItem("treatmentDOcuments", JSON.stringify(openTreatmentDocumentDetails));
    window.location = "./directClaim3.html";
}