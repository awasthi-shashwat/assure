localStorage.setItem("UserID", JSON.stringify(1));
let userId = JSON.parse(localStorage.getItem("UserID"));

async function loadUser() {
    
    let a  = await fetch(`http://localhost:8070/claim/${userId}`);
    let b = await a.json();

    if (b.id !== null) {
        
    }
}