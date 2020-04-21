const formElement = document.querySelector("form");
const formContainer = document.getElementById("form-container");
const newStudentsInCourseButton = document.getElementById("newStudentInCourse");
const cards = document.getElementById("studentsInCourse");
const courses = [];

addDemoData();
hideForm();

function addDemoData() {
    const demoData = [
        {
            course: "Mathematics",
            students: [
                "John Doe",
                "Jane Doe",
                "Ana Johnson"
            ]
        },
        {
            course: "Algorithms",
            students: [
                "John Doe",
                "Ada Lovelace",
                "Ana Johnson"
            ]
        },
        {
            course: "Cooking",
            students: [
                "Ada Lovelace",
                "Mary Smith",
                "Maria Sanchez"
            ]
        }

    ]

    for (let i = 0; i < demoData.length; i++) {
        addCard(demoData[i]);

    }
}

formElement.addEventListener("submit", function (e) {
    e.preventDefault();

    const newStudentsInCourse = getDataFromForm();
    const course = newStudentsInCourse.course;

    if (courses.indexOf(course) === -1) {
        addCard(newStudentsInCourse);
        formElement.reset();
        hideForm();
    } else {
        setAlert("The course already has students. Please edit the existing course.")
        return false;
    }
})

function getDataFromForm() {
    const course = formElement.course.value;
    const students = formElement.students.value;

    return {
        course,
        students
    }
}

function addCard(studentsInCourse) {

    const index = cards.children.length;

    const card = document.createElement("div");
    card.className = "card";
    card.innerHTML =
        `<div class="card-header" id="row-heading-${index}">
            <h2 class="mb-0">
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#row-content-${index}"
                    aria-expanded="false" aria-controls="collapseOne">
                    ${studentsInCourse.course}
                </button>
                <button class="btn btn-secondary btn-sm edit-button">Edit</button>
                <button class="btn btn-secondary btn-sm update-button">Update</button>
            </h2>
        </div>

        <div id="row-content-${index}" class="collapse" aria-labelledby="row-heading-${index}"
            data-parent="#studentsInCourse">
            <div class="card-body">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Student name</th>
                        </tr>
                    </thead>
                    <tbody class="students">
                    </tbody>
                </table>
            </div>
        </div>`;
    courses.push(studentsInCourse.course);
    cards.appendChild(card);
    card.querySelector(".edit-button").addEventListener("click", function (e) {
        fillUpdateForm(studentsInCourse, "Edit students of course");
    })

    card.querySelector(".update-button").addEventListener("click", function (e) {
        fillUpdateForm(studentsInCourse, "Update students of course");
    })

    const table = card.querySelector(".students");
    addTable(studentsInCourse.students, table);
}

function fillUpdateForm(studentsInCourse, title) {
    showForm();
    document.getElementById("form-title").innerText = title;
    formElement.course.value = studentsInCourse.course;
}

function addTable(students, table) {

    for (let i = 0; i < students.length; i++) {
        const row = table.insertRow(-1);
        row.innerHTML =
            `<td>${students[i]}</td>`
    }
}

newStudentsInCourseButton.addEventListener("click", function (e) {

    document.getElementById("form-title").innerText = "Add students to course";
    showForm();
})

formElement.addEventListener("reset", function (e) {
    document.getElementById("alert").innerHTML = "";
    hideForm();
})

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
    newStudentsInCourseButton.style.display = "none";
    formContainer.style.display = "";
}

function hideForm() {
    newStudentsInCourseButton.style.display = "";
    formContainer.style.display = "none";
}