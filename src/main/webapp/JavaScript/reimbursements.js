
const url = "http://localhost:8080/project1/";

document.getElementById("reimbursement-table").addEventListener("load", loadReimbursements, false);

async function loadReimbursements(){
    
    let response = await fetch(url+"reimbursement", {
        method : "GET",
        credentials : "include"
    });

    if (response.status === 200){
        console.log(response);
        let data = await response.json();
        console.log(data);
        findAllfunc(data);

        let button = document.createElement("button");
        button.className = "btn btn-success";
        button.id = "findAllBtn";
        button.innerText = "Find All Avengers";
        button.onclick = findAllFunc;
        document.getElementById("table-row").appendChild(button);

        let button2 = document.createElement("button");
        button2.className = "btn btn-success";
        button2.id = "addReimbursementBtn";
        button2.innerText = "Add Reimbursement";
        button2.onclick = AddFunc;
        document.getElementById("formbtn").appendChild(button2);
    }
}

async function findAllfunc(data){
    let table = document.getElementById("reimbursement-table-body");
    table.innerText = "";
    for (let reimbursement of data){
        console.log(reimbursement);
        let row = document.createElement("tr");


        let id = document.createElement("td");
        id.innerText = reimbursement.reimbursementId;
        row.appendChild(id);


        let amount = document.createElement("td");
        amount.innerText = reimbursement.reimbursementAmount;
        row.appendChild(amount);


        let timeSubmitted = document.createElement("td");
        timeSubmitted.innerText = reimbursement.timeSubmitted;
        row.appendChild(timeSubmitted);


        let timeResolved = document.createElement("td");
        if (reimbursement.ersResolver != null){
        timeResolved.innerText = reimbursement.timeResolved;
        } else {
            timeResolved.innerText = "NONE";
        }
        row.appendChild(timeResolved);


        let descrip = document.createElement("td");
        descrip.innerText = reimbursement.description;
        row.appendChild(descrip);


        let author = document.createElement("td");
        author.innerText = reimbursement.ersAuthor;
        row.appendChild(author);


        let resolver = document.createElement("td");
        if (reimbursement.ersResolver != null){
        resolver.innerText = reimbursement.ersResolver;
        } else {
            resolver.innerText = "NONE";
        }
        row.appendChild(resolver);

        let status = document.createElement("td");
        status.innerText = reimbursement.reimbursementStatus.staus;
        row.appendChild(status);

        let type = document.createElement("td");
        type.innerText = reimbursement.reimbursementType.type;
        row.appendChild(type);

        table.appendChild(row);
    }
}

async function addReimbursement(){

}