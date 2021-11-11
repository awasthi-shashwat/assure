
// var dt = new Date();

// document.getElementById("time").innerHTML = `${dt.getHours()}:${dt.getMinutes()}`;

var input_regis_log = document.querySelectorAll(".input_regis_log");

var submit_btn = document.getElementById("submit_btn");

input_regis_log.forEach((input) => {
    input.addEventListener('click', (e) => {
        e.target.style.borderBottom = "1px solid #063035";
        input_regis_log.forEach((i) =>{
            if(i != e.target){
                i.style.borderBottom = "1px solid #C4C4C4";
            }
        })
    });
  });


submit_btn.addEventListener('click', () =>{
    console.log(input_regis_log);
})
