document.querySelector("form").addEventListener("submit", function (e) {
    e.preventDefault();
    document.getElementById("alert").innerHTML = "";
    const form = this;

    const start_date = form.start_date.value;
    console.log(start_date);

    const end_date = form.end_date.value;
    
    if(start_date>end_date){
        addAlert("Starting date should be before ending date.")
    };;

})

function addAlert(message){
    document.getElementById("alert").innerHTML = 
    `<div class="alert alert-warning alert-dismissible fade show" role="alert">
        ${message}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>`;


}