const formElement = document.querySelector("form");
const formContainer = document.getElementById("form-container");
const newStudentButton = document.getElementById("newStudent");
const tableRef = document.getElementById("students");

addDemoData();
hideForm();

function addDemoData() {
    const demoData = [
        {
            firstName: "John",
            lastName: "Doe",
            dateOfBirth: "1988-02-03",
            tuitionFees: "1850"
        },
        {
            firstName: "Ada",
            lastName: "Lovelace",
            dateOfBirth: "1983-01-23",
            tuitionFees: "1500"
        },
        {
            firstName: "Jane",
            lastName: "Doe",
            dateOfBirth: "1983-06-19",
            tuitionFees: "2000"
        },
        {
            firstName: "Markus",
            lastName: "Miller",
            dateOfBirth: "1993-08-25",
            tuitionFees: "2000"
        },
        {
            firstName: "Sam",
            lastName: "Mendes",
            dateOfBirth: "1994-12-03",
            tuitionFees: "0"
        },
        {
            firstName: "Ana",
            lastName: "Johnson",
            dateOfBirth: "1975-09-16",
            tuitionFees: "2000"
        },
        {
            firstName: "Maria",
            lastName: "Sanchez",
            dateOfBirth: "1986-11-23",
            tuitionFees: "18500"
        },
        {
            firstName: "George",
            lastName: "Stevenson",
            dateOfBirth: "1987-03-03",
            tuitionFees: "1500"
        },
        {
            firstName: "John",
            lastName: "Papadopoulos",
            dateOfBirth: "1988-05-03",
            tuitionFees: "1500"
        },
    ]

    for (let i = 0; i < demoData.length; i++) {
        addRow(demoData[i]);

    }
}

formElement.addEventListener("submit", function (e) {
    e.preventDefault();

    if (!validateDateOfBirth()) {
        return;
    }

    if (formElement.studentId.value === "new") {
        const newStudent = getStudentFromForm();
        addRow(newStudent);
        formElement.reset();
    } else {
        const student = getStudentFromForm();
        student.id = Number(formElement.studentId.value);
        setRowContent(tableRef.rows[student.id], student);
        formElement.reset();
    }
    hideForm();

})

formElement.addEventListener("reset", function (e) {
    hideForm();
})

function getStudentFromForm() {
    const firstName = formElement.firstName.value;
    const lastName = formElement.lastName.value;
    const dateOfBirth = formElement.dateOfBirth.value;
    const tuitionFees = formElement.tuitionFees.value;

    return {
        firstName,
        lastName,
        dateOfBirth,
        tuitionFees,
    }
}


function addRow(newStudent) {
    const lastRowIndex = tableRef.rows.length;
    const newRow = tableRef.insertRow(-1);
    newStudent.id = lastRowIndex;
    setRowContent(newRow, newStudent)
}

function setRowContent(row, student) {
    row.innerHTML =
        `<th scope="row">${student.id + 1}</th>
         <td>${student.firstName}</td>
         <td>${student.lastName}</td>
         <td>${student.dateOfBirth}</td>
         <td>${student.tuitionFees}</td>
         <td>
            <button class="btn btn-secondary btn-sm edit-button">Edit</button>
         </td>
         <td>
         <button class="btn btn-secondary btn-sm update-button">Update</button>
      </td>`

    row.querySelector(".edit-button").addEventListener("click", function (e) {
        fillUpdateForm(student, "Edit Student");
    })

    row.querySelector(".update-button").addEventListener("click", function (e) {
        fillUpdateForm(student, "Update Student");
    })

}

function fillUpdateForm(student, title) {
    showForm();
    document.getElementById("form-title").innerText = title;
    formElement.studentId.value = student.id;
    formElement.firstName.value = student.firstName;
    formElement.lastName.value = student.lastName;
    formElement.dateOfBirth.value = student.dateOfBirth;
    formElement.tuitionFees.value = student.tuitionFees;
}


newStudentButton.addEventListener("click", function (e) {

    document.getElementById("form-title").innerText = "New Student";
    formElement.studentId.value = "new";
    showForm();
})

function validateDateOfBirth() {
    document.getElementById("alert").innerHTML = ""; 
    const dateOfBirth = formElement.dateOfBirth.value;
    const date = new Date();

    const year = date.getFullYear();
    const yearOfBirth = Number(dateOfBirth.substring(0, 4));
    const age  = year - yearOfBirth;

    if (age < 6) {
        setAlert("The student is very young for the courses.")
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
    newStudentButton.style.display = "none";
    formContainer.style.display = "";
}

function hideForm() {
    newStudentButton.style.display = "";
    formContainer.style.display = "none";
}
