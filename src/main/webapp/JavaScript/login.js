let updateReimbursement;

const url = "http://localhost:8080/project1/"
document.getElementById("loginBtn").addEventListener("click", fetchFunc);
let userRole = "";
async function fetchFunc() {
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        username: usern,
        password: userp
    }

    let resp = await fetch(url + "login", {
        method: 'POST',
        body: JSON.stringify(user),
        credentials: "include"
    })

    if (resp.status === 200) {
        let role = await resp.json();
        console.log(role);
        document.getElementById("loginRow").innerText = "YOU HAVE LOGGED IN.";
        //get all avengers button show
        document.getElementById("reimbForm").style.visibility = "visible";
        let button = document.createElement('button');
        button.className = "btn btn-warning";
        button.id = "findAllBtn";
        button.innerText = "Find All Reimbursements";
        button.onclick = findAll;
        document.getElementById("reimbursementRow").appendChild(button);
        //add avenger button show
        document.getElementById("reimbursementRow").style.visibility = "visible";
        let button2 = document.createElement('button');
        button2.className = "btn btn-warning";
        button2.id = "addBtn";
        button2.innerText = "Add a Reimbursement";
        button2.onclick = addFunc;
        document.getElementById("reimbForm").appendChild(button2);

        if (role.roleName === "admin"){
        let button3 = document.createElement("button");
        button3.className = "btn btn-warning";
        button3.id = "updateBtn";
        button3.innerText = "Search for Pending Reimbursements";
        button3.onclick = searchPendingFunc;
        document.getElementById("reimbursementRow").appendChild(button3);
        }
        userRole = role.roleName;
    } else {
        document.getElementById("loginRow").innerText = "Login failed!";
    }
    
}

async function findAll(){
        document.getElementById("reimbursement-table-body").innerText ="";
    
       
        let resp = await fetch(url + "reimbursements", {
            method: 'GET',
            credentials: "include"
        })
    
       
        if (resp.status==200){
            let reimbursements = await resp.json();
            console.log(reimbursements);
            
            for (let reimbursement of reimbursements) {
                let row = document.createElement("tr");
                let cell = document.createElement("td");
                cell.innerHTML = reimbursement.reimbursementId;
                row.appendChild(cell);
                let cell2 = document.createElement("td");
                cell2.innerHTML = "$ " +reimbursement.amount.toFixed(2);
                row.appendChild(cell2);
                let cell3 = document.createElement("td");
                cell3.innerHTML = new Date(reimbursement.timeSubmitted);
                row.appendChild(cell3);
                let cell4 = document.createElement("td");
                if (reimbursement.timeResolved !== null){
                cell4.innerHTML = new Date(reimbursement.timeResolved);
                } else {
                cell4.innerHTML = "N/A";
                }
                row.appendChild(cell4);
                let cell5 = document.createElement("td");
                cell5.innerHTML = reimbursement.description;
                row.appendChild(cell5);
                let cell6 = document.createElement("td");
                cell6.innerHTML = reimbursement.ersAuthor.firstName;
                row.appendChild(cell6);
                let cell7 = document.createElement("td");
                if (reimbursement.ersResolver !== null){
                cell7.innerHTML = reimbursement.ersResolver.firstName;
                } else {
                cell7.innerHTML = "N/A"
                }
                row.appendChild(cell7);
                let cell8 = document.createElement("td");
                cell8.innerHTML = reimbursement.reimbursementStatus.status;
                row.appendChild(cell8);
                let cell9 = document.createElement("td");
                cell9.innerHTML = reimbursement.reimbursementType.type;
                row.appendChild(cell9);
                if (userRole === "admin"){
                    row.addEventListener("click", function(){
                        stageFunc(reimbursement);
                    });
                }
                document.getElementById("reimbursement-table-body").appendChild(row);
        }
    }
}
        

async function addFunc(){

    let amount = Number(document.getElementById("reimbAmount").value);
    let description = document.getElementById("reimbDescription").value;
    let type = document.getElementById("reimbType").value;

    let reimb = {
        "amount" : amount,
        "reimbDescription" : description,
        "reimbType" : type
    }
  
    if (reimb.amount > 0 && reimb.type != false ){
        console.log(reimb)
        let resp = await fetch(url + "reimbursements", {
            method: 'POST',
            body: JSON.stringify(reimb),
            credentials: "include"
        })
    
        if (resp.status===201){
            findAll();
        }
    } else {
        document.getElementById("loginRow").innerText = "Reimbursement Log Failed.";
    }


    
}

async function searchPendingFunc(){
    document.getElementById("reimbursement-table-body").innerText = "";
    let resp = await fetch( url + "reimbursements/*",{
        method: 'GET',
        credentials: "include"
    });
    
    if (resp.status === 200){
        let reimbursements = await resp.json();
            for (let reimbursement of reimbursements) {
                console.log(reimbursement);
                let row = document.createElement("tr");
                let cell = document.createElement("td");
                cell.innerHTML = reimbursement.reimbursementId;
                
                row.appendChild(cell);
                let cell2 = document.createElement("td");
                cell2.innerHTML = "$ " +reimbursement.amount.toFixed(2);
                
                row.appendChild(cell2);
                let cell3 = document.createElement("td");
                cell3.innerHTML = new Date(reimbursement.timeSubmitted);
                
                row.appendChild(cell3);
                let cell4 = document.createElement("td");
                if (reimbursement.timeResolved !== null){
                cell4.innerHTML = new Date(reimbursement.timeResolved);
                } else {
                cell4.innerHTML = "N/A";
                }
                
                row.appendChild(cell4);
                let cell5 = document.createElement("td");
                cell5.innerHTML = reimbursement.description;
   
                row.appendChild(cell5);
                let cell6 = document.createElement("td");
                cell6.innerHTML = reimbursement.ersAuthor.firstName;
                
                row.appendChild(cell6);
                let cell7 = document.createElement("td");
                if (reimbursement.ersResolver !== null){
                cell7.innerHTML = reimbursement.ersResolver.firstName;
                } else {
                cell7.innerHTML = "N/A"
                }
               
                row.appendChild(cell7);
                let cell8 = document.createElement("td");
                cell8.innerHTML = reimbursement.reimbursementStatus.status;
                
                row.appendChild(cell8);
                let cell9 = document.createElement("td");
                cell9.innerHTML = reimbursement.reimbursementType.type;
                
                row.appendChild(cell9);
                if (userRole === "admin"){
                    row.addEventListener("click", function (){
                        stageFunc(reimbursement);
                    });
                }
                document.getElementById("reimbursement-table-body").appendChild(row);
    }
    
}
}
async function stageFunc(reimbursement){
    updateReimbursement = reimbursement;
    console.log("Function being staged :::::");
    console.log(updateReimbursement)
    document.getElementById("update-table-body").innerHTML = "";
    document.getElementById("updateTable").style.visibility = "visible";
    let row = document.createElement("tr");
    row.id="row";
    let cell = document.createElement("td");
    cell.id = "cell";
    cell.innerHTML = reimbursement.reimbursementId;
    row.appendChild(cell);
    let cell2 = document.createElement("td");
    cell2.innerHTML = "$ " +reimbursement.amount.toFixed(2);
    cell2.id = "cell2";
    row.appendChild(cell2);
    let cell3 = document.createElement("td");
    cell3.innerHTML = new Date(reimbursement.timeSubmitted);
    cell3.id = "cell3";
    row.appendChild(cell3);
    let cell4 = document.createElement("td");
    if (reimbursement.timeResolved !== null){
    cell4.innerHTML = new Date(reimbursement.timeResolved);
    } else {
    cell4.innerHTML = "N/A";
    }
    cell4.id = "cell4";
    row.appendChild(cell4);
    let cell5 = document.createElement("td");
    cell5.innerHTML = reimbursement.description;
    cell5.id = "cell5";
    row.appendChild(cell5);
    let cell6 = document.createElement("td");
    cell6.innerHTML = reimbursement.ersAuthor.firstName;
    cell6.id = "cell6";
    row.appendChild(cell6);
    let cell7 = document.createElement("td");
    if (reimbursement.ersResolver !== null){
    cell7.innerHTML = reimbursement.ersResolver.firstName;
    } else {
    cell7.innerHTML = "N/A"
    }
    cell7.id = "cell7";
    row.appendChild(cell7);
    let cell8 = document.createElement("select");
    let option1 = document.createElement("option");
    let option2 = document.createElement("option");
    option1.value = 2;
    option1.innerHTML = "APPROVE";
    option2.value = 1;
    option2.innerHTML = "DECLINE";
    cell8.appendChild(option1);
    cell8.appendChild(option2);
    cell8.id = "cell8";
    row.appendChild(cell8);
    let cell9 = document.createElement("td");
    cell9.innerHTML = reimbursement.reimbursementType.type;
    cell9.id = "cell9";
    row.appendChild(cell9);
    if (document.getElementById("updateReim")==null){
    let button5 = document.createElement("button");
    
    button5.addEventListener ("click", function (){
        updateReimbursement.reimbursementStatus.statusId = document.getElementById("cell8").value;
        updateFunc();
        updateReimbursement = null;
    });
    button5.id = "updateReim";
    button5.innerText = "Update Reimbursement";
    button5.className = "btn btn-warning";
    document.getElementById("updateBtn").appendChild(button5);
    }
    document.getElementById("update-table-body").appendChild(row);
}


async function updateFunc(){
    console.log("id of function about to be added " + document.getElementById("cell").innerHTML)
    let id = updateReimbursement.reimbursementId;
    let amount = updateReimbursement.amount.toFixed(2);
    let submitted = updateReimbursement.timeSubmitted;
    let resolved = updateReimbursement.timeResolved;
    let description = updateReimbursement.description;
    let author = updateReimbursement.ersAuthor;
    let resolver = updateReimbursement.ersResolver;
    let status = updateReimbursement.reimbursementStatus;
    let type = updateReimbursement.reimbursementType;


    let reimb = {
        "reimbursementId" : id,
        "amount" : amount,
        "timeSubmitted" : submitted,
        "timeResolved" : resolved,
        "description" : description,
        "ersAuthor" : author,
        "ersResolver" : resolver,
        "reimbursementStatus" : status,
        "reimbursementType" : type
    }
    console.log("Reimbursement being updated::::")
    console.log(reimb)
    let resp = await fetch(url + "reimbursements/" + id, {
        method: 'POST',
        body: JSON.stringify(reimb),
        credentials: "include"
    })

    if (resp.status===201){
        findAll();
        document.getElementById("update-table-body").innerHTML = "";
    }
}