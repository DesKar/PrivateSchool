const formElement = document.querySelector("form");
const formContainer = document.getElementById("form-container");
const newCourseButton = document.getElementById("newCourse");
const tableRef = document.getElementById("courses");

addDemoData();
hideForm();

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
        },
        {
            title: "Cooking",
            stream: "Home Economics",
            type: "Lab",
            startDate: "2020-05-01",
            endDate: "2020-05-15",
        }
    ]

    for (let i = 0; i < demoData.length; i++) {
        addRow(demoData[i]);

    }
}

formElement.addEventListener("submit", function (e) {
    e.preventDefault();

    if(!validateStartEndDates()){
        return;
    }

    if (formElement.courseId.value === "new") {
        const newCourse = getCourseFromForm();
        addRow(newCourse);
        formElement.reset();
    } else {
        const course = getCourseFromForm();
        course.id = Number(formElement.courseId.value);
        setRowContent(tableRef.rows[course.id], course);
    }
    hideForm();

})

formElement.addEventListener("reset", function (e) {
    hideForm();
})

function getCourseFromForm() {
    const title = formElement.title.value;
    const stream = formElement.stream.value;
    const type = formElement.type.value;
    const startDate = formElement.startDate.value;
    const endDate = formElement.endDate.value;

    return {
        title,
        stream,
        type,
        startDate,
        endDate,
    }
}


function addRow(newCourse) {
    const lastRowIndex = tableRef.rows.length;
    const newRow = tableRef.insertRow(-1);
    newCourse.id = lastRowIndex;
    setRowContent(newRow, newCourse)
}

function setRowContent(row, course) {
    row.innerHTML =
        `<th scope="row">${course.id + 1}</th>
         <td>${course.title}</td>
         <td>${course.stream}</td>
         <td>${course.type}</td>
         <td>${course.startDate}</td>
         <td>${course.endDate}</td>
         <td>
            <button class="btn btn-secondary btn-sm edit-button">Edit</button>
         </td>
         <td>
         <button class="btn btn-secondary btn-sm update-button">Update</button>
      </td>`

    row.querySelector(".edit-button").addEventListener("click", function (e) {
        fillUpdateForm(course, "Edit Course");
    })

    row.querySelector(".update-button").addEventListener("click", function (e) {
        fillUpdateForm(course, "Update Course");
    })

}

function fillUpdateForm(course, title) {
    showForm();
    document.getElementById("form-title").innerText = title;
    formElement.courseId.value = course.id;
    formElement.title.value = course.title;
    formElement.stream.value = course.stream;
    formElement.type.value = course.type;
    formElement.startDate.value = course.startDate;
    formElement.endDate.value = course.endDate;
}


newCourseButton.addEventListener("click", function (e) {

    document.getElementById("form-title").innerText = "New Course";
    formElement.courseId.value = "new";
    showForm();
})

function validateStartEndDates() {
    document.getElementById("alert").innerHTML = "";
    const startDate = formElement.startDate.value;
    const endDate = formElement.endDate.value;

    if (startDate > endDate) {
        setAlert("Starting date should be before ending date.")
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
    newCourseButton.style.display = "none";
    formContainer.style.display = "";
}

function hideForm() {
    newCourseButton.style.display = "";
    formContainer.style.display = "none";
}
