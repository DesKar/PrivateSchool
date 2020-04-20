const courses = [];
addDemoData();

const formElement = document.querySelector("form");
const formContainer = document.getElementById("form");
const newCourseButton = document.getElementById("newCourse");

function addDemoData() {
    const demoData = [
        {
            title: "Mathematics",
            stream: "Technology",
            type: "Lab",
            startDate: "2020-01-08",
            endDate: "2020-06-05",
        },
        {
            title: "Algorithms",
            stream: "Technology",
            type: "Lab",
            startDate: "2020-04-03",
            endDate: "2020-06-05",
        },
        {
            title: "Art History",
            stream: "Humanistics",
            type: "Seminar",
            startDate: "2020-05-10",
            endDate: "2020-06-15",
        }
    ]

    for(let i = 0; i < demoData.length; i++){
        courses.push(demoData[i]);
        addRow(demoData[i]);

    }
}

formElement.addEventListener("submit", function (e) {
    e.preventDefault();
    const form = this;

    validateStartEndDates(form);
    addCourse(form);

    newCourseButton.style.display = "";

})

formElement.addEventListener("reset", function (e) {
    formContainer.style.display = "none";
    newCourseButton.style.display = "";
})

function addCourse(form) {
    const title = form.title.value;
    const stream = form.stream.value;
    const type = form.type.value;
    const startDate = form.startDate.value;
    const endDate = form.endDate.value;

    const newCourse = {
        title,
        stream,
        type,
        startDate,
        endDate,
    }
    courses.push(newCourse);
    addRow(newCourse);
    form.reset();
}

function addRow(newCourse) {
    const tableRef = document.getElementById("courses");
    const lastRowIndex = tableRef.rows.length - 1;
    const newRow = tableRef.insertRow(-1);
    newRow.innerHTML =
        `<th scope="row">${lastRowIndex}</th>
         <td>${newCourse.title}</td>
         <td>${newCourse.stream}</td>
         <td>${newCourse.type}</td>
         <td>${newCourse.startDate}</td>
         <td>${newCourse.endDate}</td>
         <td>
            <button class="btn btn-secondary btn-sm edit-button">Edit</button>
         </td>
         <td>
         <button class="btn btn-secondary btn-sm update-button">Update</button>
      </td>`

    newRow.querySelector(".edit-button").addEventListener("click", function (e) {
        editCourse(newCourse);
    })

    newRow.querySelector(".update-button").addEventListener("click", function (e) {
        updateCourse(newCourse);
    })

    form.style.display = "none";
}

function editCourse(newCourse) {
    formContainer.style.display = "";
    formElement.title.value = newCourse.title;
    formElement.stream.value = newCourse.stream;
    formElement.type.value = newCourse.type;
    formElement.startDate.value = newCourse.startDate;
    formElement.endDate.value = newCourse.endDate;
}

function updateCourse(newCourse) {
    console.log(newCourse.title)
}

newCourseButton.addEventListener("click", function (e) {

    formContainer.style.display = "";
    newCourseButton.style.display = "none";
})

function validateStartEndDates(form) {
    const startDate = form.startDate.value;
    const endDate = form.endDate.value;

    if (startDate > endDate) {
        addAlert("Starting date should be before ending date.")
    };
}

function addAlert(message) {
    document.getElementById("alert").innerHTML =
        `<div class="alert alert-warning alert-dismissible fade show" role="alert">
        ${message}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>`;
}
