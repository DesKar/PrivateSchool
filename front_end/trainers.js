const formElement = document.querySelector("form");
const formContainer = document.getElementById("form-container");
const newCourseButton = document.getElementById("newTrainer");
const tableRef = document.getElementById("trainers");

addDemoData();
hideForm();

function addDemoData() {
    const demoData = [
        {
            firstName: "Marianne",
            lastName: "Uriol",
            subject: "Art",
        },
        {
            firstName: "Zoe",
            lastName: "Kraft",
            subject: "Physics",
        },
        {
            firstName: "Helen",
            lastName: "Moss",
            subject: "Computer Science",
        },
        {
            firstName: "John",
            lastName: "Oliver",
            subject: "Science",
        },
        {
            firstName: "Martin",
            lastName: "Husli",
            subject: "House Economics",
        },
    ]

    for (let i = 0; i < demoData.length; i++) {
        addRow(demoData[i]);

    }
}

formElement.addEventListener("submit", function (e) {
    e.preventDefault();

    if (formElement.trainerId.value === "new") {
        const newTrainer = getTrainerFromForm();
        addRow(newTrainer);
        formElement.reset();
    } else {
        const trainer = getTrainerFromForm();
        trainer.id = Number(formElement.trainerId.value);
        setRowContent(tableRef.rows[trainer.id], trainer);
        formElement.reset();
    }
    hideForm();

})

formElement.addEventListener("reset", function (e) {
    hideForm();
})

function getTrainerFromForm() {
    const firstName = formElement.firstName.value;
    const lastName = formElement.lastName.value;
    const subject = formElement.subject.value;

    return {
        firstName,
        lastName,
        subject,
    }
}


function addRow(newTrainer) {
    const lastRowIndex = tableRef.rows.length;
    const newRow = tableRef.insertRow(-1);
    newTrainer.id = lastRowIndex;
    setRowContent(newRow, newTrainer)
}

function setRowContent(row, trainer) {
    row.innerHTML =
        `<th scope="row">${trainer.id + 1}</th>
         <td>${trainer.firstName}</td>
         <td>${trainer.lastName}</td>
         <td>${trainer.subject}</td>
         <td>
            <button class="btn btn-secondary btn-sm edit-button">Edit</button>
         </td>
         <td>
         <button class="btn btn-secondary btn-sm update-button">Update</button>
      </td>`

    row.querySelector(".edit-button").addEventListener("click", function (e) {
        fillUpdateForm(trainer, "Edit Trainer");
    })

    row.querySelector(".update-button").addEventListener("click", function (e) {
        fillUpdateForm(trainer, "Update Trainer");
    })

}

function fillUpdateForm(trainer, title) {
    showForm();
    document.getElementById("form-title").innerText = title;
    formElement.trainerId.value = trainer.id;
    formElement.firstName.value = trainer.firstName;
    formElement.lastName.value = trainer.lastName;
    formElement.subject.value = trainer.subject;
}


newCourseButton.addEventListener("click", function (e) {

    document.getElementById("form-title").innerText = "New Trainer";
    formElement.trainerId.value = "new";
    showForm();
})

function showForm() {
    newCourseButton.style.display = "none";
    formContainer.style.display = "";
}

function hideForm() {
    newCourseButton.style.display = "";
    formContainer.style.display = "none";
}
