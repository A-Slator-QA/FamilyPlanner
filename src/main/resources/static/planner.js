
const personUrl = "http://localhost:8080/person";
const taskUrl = "http://localhost:8080/task";
const removePerson = document.querySelector("#removePerson");
const addPerson = document.querySelector("#addPerson");
const editPerson = document.querySelector("#updatePerson");
const removeTask = document.querySelector("#removeTask");
const addTask = document.querySelector("#addTask");
const editTask = document.querySelector("#updateTask");
const modal = document.querySelector('#my-modal');
const addButton = document.getElementById('#add-button');
const closeButton = document.querySelector('.close');
const addTheButton = document.querySelector('.btn btn-primary');

const newPersonName = document.getElementById('newPersonName');
const newPersonAge = document.getElementById('newPersonAge');
const newPersonParent = document.getElementById('newPersonParent');
const newTaskname = document.getElementById('newTaskName');
const newTaskComplete = document.getElementById('newTaskComplete');
const newTaskAssigned = document.getElementById('newTaskAssigned');
const newTaskAssignee = document.getElementById('newTaskAssignee');

const editPersonId = document.getElementById('updatePersonId');
const editPersonName = document.getElementById('updatePersonName');
const editPersonAge = document.getElementById('updatePersonAge');
const editPersonParent = document.getElementById('updatePersonParent');
const editTaskId = document.getElementById('updateTaskId');
const editTaskName = document.getElementById('updateTaskName');
const editTaskComplete = document.getElementById('updateTaskComplete');
const editTaskAssigned = document.getElementById('updateTaskAssigned');
const editTaskAssignee = document.getElementById('updateTaskAssignee');

const deletePersonId = document.getElementById('deletePersonId');
const deleteTaskId = document.getElementById('deleteTaskid');

const getPeople = () => {
	
	fetch(`${personUrl}/getPeople`)
            .then(function (response) {
                return response.json();
            })
            .then(function (data) {				
                appendData(data);
            })
            .catch(function (err) {
                console.log('error: ' + err);
            });
        function appendData(data) {
            var mainContainer = document.getElementById("myData");
            mainContainer.textContent = '';
            for (var i = 0; i < data.length; i++) {
                var div = document.createElement("div");
                div.innerHTML = 'Name: ' + data[i].name + '  Age: ' + data[i].age + '  Parent: ' + data[i].parent;
                mainContainer.appendChild(div);
                }
                }
               };
    
const createPerson = () => {
    const newPersonNameCreate = newPersonName.value;
    const newPersonAgeCreate = newPersonAge.value;
    const newPersonParentCreate = newPersonParent.value;

    let data = {
        "name": newPersonNameCreate,
        "age": newPersonAgeCreate,
        "parent": newPersonParentCreate,
    }
    console.log(data)

    fetch(`${personUrl}/createPerson`, {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Age": "application/json"
        }
    })
        .then(response => response.json())
        .then(model => {
            console.log(model);
            getPeople();
        })
        .catch(err => console.error(`error ${err}`));
};

const updatePerson = () => {
    const editPersonIdUpdate = editPersonId.value;
    const editPersonNameUpdate = editPersonName.value;
    const editPersonAgeUpdate = editPersonAge.value;
    const editPersonParentUpdate = editPersonParent.value;

    let data = {
        "name": editPersonNameUpdate,
        "age": editPersonAgeUpdate,
        "parent": editPersonParentUpdate,
    }

    fetch(`${personUrl}/updatePerson/${editPersonIdUpdate}`, {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
            "Content-Age": "application/json"
        }
    })
        .then(response => response.json())
        .then(model => {
            console.log(model)
            readPerson();
        })
        .catch(err => console.error(`error ${err}`));
};

const deletePerson = () => {
    const editPersonIdDelete = deletePersonId.value;

    fetch(`${personUrl}/deletePerson/${editPersonIdDelete}`, {
        method: "DELETE",
        headers: {
            "Content-Age": "application/json"
        }
    })
        .then(response => console.log(response))
        .then(() => {
            console.log("Deleted person successfully");
            readPerson();
        })
        .catch(err => console.error(`error ${err}`));
};

const getTasks = () => {
	
	fetch(`${taskUrl}/getTasks`)
            .then(function (response) {
                return response.json();
            })
            .then(function (data) {				
                appendData(data);
            })
            .catch(function (err) {
                console.log('error: ' + err);
            });
        function appendData(data) {
            var mainContainer = document.getElementById("myData");
            mainContainer.textContent = '';
            for (var i = 0; i < data.length; i++) {
                var div = document.createElement("div");
                div.innerHTML = 'Name: ' + data[i].name + '  Complete: ' + data[i].type + '  Assigned: ' + data[i].level + '  Assignee: ' + data[i].heldItem;
                mainContainer.appendChild(div);
                }
                }
               };
    
const createTask = () => {
    const newTaskNameCreate = newTaskName.value;homeUrl
    const newTaskCompleteCreate = newTaskComplete.value;
    const newTaskAssignedCreate = newTaskAssigned.value;
    const newTaskAssigneeCreate = newTaskAssignee.value;

    let data = {
        "name": newTaskNameCreate,
        "Complete": newTaskCompleteCreate,
        "Assigned": newTaskAssignedCreate,
        "Assignee": newTaskAssigneeCreate,
    }
    console.log(data)

    fetch(`${taskUrl}/createTask`, {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Age": "application/json"
        }
    })
        .then(response => response.json())
        .then(model => {
            console.log(model);
            getTasks();
        })
        .catch(err => console.error(`error ${err}`));
};

const updateTask = () => {
    const editTaskIdUpdate = editTaskId.value;
    const editTaskNameUpdate = editTaskName.value;
    const editTaskCompleteUpdate = editTaskComplete.value;
    const editTaskAssignedUpdate = editTaskAssigned.value;
    const editTaskAssigneeUpdate = editTaskAssignee.value;

    let data = {
        "name": editTaskNameUpdate,
        "complete": editTaskCompleteUpdate,
        "assigned": editTaskAssignedUpdate,
        "assignee": editTaskAssigneeUpdate,
    }

    fetch(`${taskUrl}/updateTask/${editTaskIdUpdate}`, {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
            "Content-Age": "application/json"
        }
    })
        .then(response => response.json())
        .then(model => {
            console.log(model)
            readPerson();
        })
        .catch(err => console.error(`error ${err}`));
};

const deleteTask = () => {
    const editTaskIdDelete = deleteTaskId.value;

    fetch(`${taskUrl}/deleteTask/${editTaskIdDelete}`, {
        method: "DELETE",
        headers: {
            "Content-Age": "application/json"
        }
    })
        .then(response => console.log(response))
        .then(() => {
            console.log("Deleted task\ successfully");
            readPerson();
        })
        .catch(err => console.error(`error ${err}`));
};