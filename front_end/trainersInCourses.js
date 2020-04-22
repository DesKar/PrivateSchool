const formElement = document.querySelector("form");
const formContainer = document.getElementById("form-container");
const newTrainersInCourseButton = document.getElementById("newTrainersInCourse");
const cards = document.getElementById("trainersInCourses");
const courses = [];

addDemoData();
hideForm();

function addDemoData() {
    const demoData = [
        {
            course: "Mathematics",
            trainers: [
                "Helen Moss",
            ]
        },
        {
            course: "Algorithms",
            trainers: [
                "Marianne Uriol",
            ]
        },
        {
            course: "Cooking",
            trainers: [
                "John Oliver",
                "Martin Nusli",
            ]
        }

    ]

    for (let i = 0; i < demoData.length; i++) {
        addCard(demoData[i]);

    }
}

formElement.addEventListener("submit", function (e) {
    e.preventDefault();

    const trainersInCourse = getDataFromForm();
    const course = trainersInCourse.course;

    if (courses.indexOf(course) === -1) {
        addCard(trainersInCourse);
    } else {
        trainersInCourse.courseIndex = courses.indexOf(course);
        const card = document.getElementById("row-content-" + trainersInCourse.courseIndex);
        const table = card.querySelector(".trainers");
        table.innerHTML = "";
        addTable(trainersInCourse.trainers, table);
    }
    formElement.reset();
    hideForm();
})


function getDataFromForm() {
    const course = formElement.course.value;
    const trainers = $(formElement.trainers).val();

    return {
        course,
        trainers
    }
}

function addCard(trainersInCourse) {

    trainersInCourse.courseIndex = cards.children.length;

    const card = document.createElement("div");
    card.className = "card";
    card.innerHTML =
        `<div class="card-header" id="row-heading-${trainersInCourse.courseIndex}">
            <h2 class="mb-0">
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#row-content-${trainersInCourse.courseIndex}"
                    aria-expanded="false" aria-controls="collapseOne">
                    ${trainersInCourse.course}
                </button>
                <button class="btn btn-secondary btn-sm update-button right-bt">Update</button>
                <button class="btn btn-secondary btn-sm edit-button right-bt">Edit</button>
            </h2>
        </div>

        <div id="row-content-${trainersInCourse.courseIndex}" class="collapse" aria-labelledby="row-heading-${trainersInCourse.courseIndex}"
            data-parent="#trainersInCourses">
            <div class="card-body">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Trainers name</th>
                        </tr>
                    </thead>
                    <tbody class="trainers">
                    </tbody>
                </table>
            </div>
        </div>`;
    courses.push(trainersInCourse.course);
    cards.appendChild(card);
    card.querySelector(".edit-button").addEventListener("click", function (e) {
        fillUpdateForm(trainersInCourse, "Edit trainers of course");
    })

    card.querySelector(".update-button").addEventListener("click", function (e) {
        fillUpdateForm(trainersInCourse, "Update trainers of course");
    })

    const table = card.querySelector(".trainers");
    addTable(trainersInCourse.trainers, table);
}

function fillUpdateForm(trainersInCourse, title) {
    showForm();
    document.getElementById("form-title").innerText = title;
    formElement.course.value = trainersInCourse.course;
    const inputCourse = document.getElementById("course");
    inputCourse.disabled = true;
}

function addTable(trainers, table) {

    for (let i = 0; i < trainers.length; i++) {
        const row = table.insertRow(-1);
        row.innerHTML =
            `<td>${trainers[i]}</td>`
    }
}

newTrainersInCourseButton.addEventListener("click", function (e) {

    document.getElementById("form-title").innerText = "Add trainers to course";
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
    newTrainersInCourseButton.style.display = "none";
    formContainer.style.display = "";
}

function hideForm() {
    newTrainersInCourseButton.style.display = "";
    formContainer.style.display = "none";
}