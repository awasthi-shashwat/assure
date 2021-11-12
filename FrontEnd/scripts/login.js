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