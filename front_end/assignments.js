const formElement = document.querySelector("form");
const formContainer = document.getElementById("form-container");
const newAssignmentButton = document.getElementById("newAssignment");
const tableRef = document.getElementById("assignments");

addDemoData();
hideForm();

function addDemoData() {
    const demoData = [
        {
            title: "Linear Algebra",
            description: "Individual assingment",
            subDate: "2020-03-06",
            oralMark: "10",
            localMark: "10",
        },
        {
            title: "Essay on El Greco",
            description: "Bibliographic research",
            subDate: "2020-12-12",
            oralMark: "5",
            localMark: "5",
        },
        {
            title: "Binary Search algorithm",
            description: "Implementation in Java",
            subDate: "2020-04-08",
            oralMark: "10",
            localMark: "10",
        },
        {
            title: "Basic recipes",
            description: "Collect basic recipes",
            subDate: "2020-05-15",
            oralMark: "5",
            localMark: "5",
        },
        {
            title: "Buchberger's algorithm",
            description: "Implementation in Java",
            subDate: "2020-04-28",
            oralMark: "10",
            localMark: "10",
        },
        {
            title: "Marc Chagall",
            description: "Summary of life and work",
            subDate: "2020-11-25",
            oralMark: "5",
            localMark: "5",
        },
        {
            title: "Linear Algebra",
            description: "Individual assignment",
            subDate: "2020-03-15",
            oralMark: "10",
            localMark: "10",
        },
    ]

    for (let i = 0; i < demoData.length; i++) {
        addRow(demoData[i]);

    }
}

formElement.addEventListener("submit", function (e) {
    e.preventDefault();

    if(!validateSubDate()){
        return;
    }

    if (formElement.assignmentId.value === "new") {
        const newAssignment = getAssignmentFromForm();
        addRow(newAssignment);
        formElement.reset();
    } else {
        const assignment = getAssignmentFromForm();
        assignment.id = Number(formElement.assignmentId.value);
        setRowContent(tableRef.rows[assignment.id], assignment);
        formElement.reset();
    }
    hideForm();

})

formElement.addEventListener("reset", function (e) {
    document.getElementById("alert").innerHTML = "";
    hideForm();
})

function getAssignmentFromForm() {
    const title = formElement.title.value;
    const description = formElement.description.value;
    const subDate = formElement.subDate.value;
    const oralMark = formElement.oralMark.value;
    const localMark = formElement.localMark.value;

    return {
        title,
        description,
        subDate,
        oralMark,
        localMark,
    }
}


function addRow(newAssignment) {
    const lastRowIndex = tableRef.rows.length;
    const newRow = tableRef.insertRow(-1);
    newAssignment.id = lastRowIndex;
    setRowContent(newRow, newAssignment)
}

function setRowContent(row, assingment) {
    row.innerHTML =
        `<th scope="row">${assingment.id + 1}</th>
         <td>${assingment.title}</td>
         <td>${assingment.description}</td>
         <td>${assingment.subDate}</td>
         <td>${assingment.oralMark}</td>
         <td>${assingment.localMark}</td>
         <td>
            <button class="btn btn-secondary btn-sm edit-button">Edit</button>
         </td>
         <td>
         <button class="btn btn-secondary btn-sm update-button">Update</button>
      </td>`

    row.querySelector(".edit-button").addEventListener("click", function (e) {
        fillUpdateForm(assingment, "Edit Assignment");
    })

    row.querySelector(".update-button").addEventListener("click", function (e) {
        fillUpdateForm(assingment, "Update Assignment");
    })

}

function fillUpdateForm(assignment, title) {
    showForm();
    document.getElementById("form-title").innerText = title;
    formElement.assignmentId.value = assignment.id;
    formElement.title.value = assignment.title;
    formElement.description.value = assignment.description;
    formElement.subDate.value = assignment.subDate;
    formElement.oralMark.value = assignment.oralMark;
    formElement.localMark.value = assignment.localMark;
}


newAssignmentButton.addEventListener("click", function (e) {
    document.getElementById("form-title").innerText = "New Assignment";
    formElement.assignmentId.value = "new";
    showForm();
})

function validateSubDate() {
    document.getElementById("alert").innerHTML = "";
    const subDate = formElement.subDate.value;
    const today = new Date().toISOString().substring(0,10);

    if (today > subDate) { 
        setAlert("The submission date should be in the future.")
        return false;
    };
    return true;
}

function setAlert(message) {
    document.getElementById("alert").innerHTML =
        `<div class="alert alert-warning alert-dismissible fade show" role="alert">
        ${message}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>`;
}

function showForm() {
    newAssignmentButton.style.display = "none";
    formContainer.style.display = "";
}

function hideForm() {
    newAssignmentButton.style.display = "";
    formContainer.style.display = "none";
}
