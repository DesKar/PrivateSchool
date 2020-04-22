const formElement = document.querySelector("form");
const formContainer = document.getElementById("form-container");
const newStudentsInCourseButton = document.getElementById("newAssignmentsInCourse");
const cards = document.getElementById("assignmentsInCourses");
const courses = [];

addDemoData();
hideForm();

function addDemoData() {
    const demoData = [
        {
            course: "Mathematics",
            assignments: [
                "Linear Algebra 1",
                "Linear Algebra 2",
            ]
        },
        {
            course: "Algorithms",
            assignments: [
                "Binary Search algorithm",
                "Buchberger's algorithm",
            ]
        },
        {
            course: "Art History",
            assignments: [
                "Essay on El Greco",
                "Marc Chagall",
            ]
        }
    ]

    for (let i = 0; i < demoData.length; i++) {
        addCard(demoData[i]);

    }
}

formElement.addEventListener("submit", function (e) {
    e.preventDefault();

    const assignmentsInCourse = getDataFromForm();
    const course = assignmentsInCourse.course;

    if (courses.indexOf(course) === -1) {
        addCard(assignmentsInCourse);
    } else {
        assignmentsInCourse.courseIndex = courses.indexOf(course);
        const card = document.getElementById("row-content-" + assignmentsInCourse.courseIndex);
        const table = card.querySelector(".assignments");
        table.innerHTML = "";
        addTable(assignmentsInCourse.assignments, table);
    }
    formElement.reset();
    hideForm();
})


function getDataFromForm() {
    const course = formElement.course.value;
    const assignments = $(formElement.assignments).val();

    return {
        course,
        assignments
    }
}

function addCard(assignmentsInCourse) {

    assignmentsInCourse.courseIndex = cards.children.length;

    const card = document.createElement("div");
    card.className = "card";
    card.innerHTML =
        `<div class="card-header" id="row-heading-${assignmentsInCourse.courseIndex}">
            <h2 class="mb-0">
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#row-content-${assignmentsInCourse.courseIndex}"
                    aria-expanded="false" aria-controls="collapseOne">
                    ${assignmentsInCourse.course}
                </button>
                <button class="btn btn-secondary btn-sm update-button right-bt">Update</button>
                <button class="btn btn-secondary btn-sm edit-button right-bt">Edit</button>
            </h2>
        </div>

        <div id="row-content-${assignmentsInCourse.courseIndex}" class="collapse" aria-labelledby="row-heading-${assignmentsInCourse.courseIndex}"
            data-parent="#assignmentsInCourses">
            <div class="card-body">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Student name</th>
                        </tr>
                    </thead>
                    <tbody class="assignments">
                    </tbody>
                </table>
            </div>
        </div>`;
    courses.push(assignmentsInCourse.course);
    cards.appendChild(card);
    card.querySelector(".edit-button").addEventListener("click", function (e) {
        fillUpdateForm(assignmentsInCourse, "Edit assignments of course");
    })

    card.querySelector(".update-button").addEventListener("click", function (e) {
        fillUpdateForm(assignmentsInCourse, "Update assignments of course");
    })

    const table = card.querySelector(".assignments");
    addTable(assignmentsInCourse.assignments, table);
}

function fillUpdateForm(assignmentsInCourse, title) {
    showForm();
    document.getElementById("form-title").innerText = title;
    formElement.course.value = assignmentsInCourse.course;
    const inputCourse = document.getElementById("course");
    inputCourse.disabled = true;
}

function addTable(assignments, table) {

    for (let i = 0; i < assignments.length; i++) {
        const row = table.insertRow(-1);
        row.innerHTML =
            `<td>${assignments[i]}</td>`
    }
}

newStudentsInCourseButton.addEventListener("click", function (e) {

    document.getElementById("form-title").innerText = "Add assignments to course";
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