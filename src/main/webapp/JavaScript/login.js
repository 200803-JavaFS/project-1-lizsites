const url = "http://localhost:8080/project1/"
document.getElementById("loginBtn").addEventListener("click", fetchFunc);

function ajaxFunc(){
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;
    let user = {
        username : usern,
        password : userp
    }
    let data = JSON.stringify(user);
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        console.log(this.readyState + " " + this.status);
        if(this.readyState==4 && this.status==200){
            document.getElementById("title").innerText = "Yay you logged in!!";
            let button = document.createElement('button');
            button.className = "btn btn-success";
            button.id = "findAllBtn";
            button.innerText = "Find All Reimbursements";
            button.onclick = findAll;
            document.getElementById("loginRow").appendChild(button);
           
            let button2 = document.createElement('button');
            button2.className = "btn btn-success";
            button2.id = "addBtn";
            button2.innerText = "Add a Reimbursement";
            button2.onclick = addFunc;
            document.getElementById("reimbForm").appendChild(button2);
        } 
    }

    xhr.open("POST" , url + "login");
    xhr.send(data);
}

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
        console.log(resp)
        document.getElementById("loginRow").innerText = "YOU HAVE LOGGED IN.";
        //get all avengers button show
        let button = document.createElement('button');
        button.className = "btn btn-success";
        button.id = "findAllBtn";
        button.innerText = "Find All Reimbursements";
        button.onclick = findAll;
        document.getElementById("loginRow").appendChild(button);
        //add avenger button show
        let button2 = document.createElement('button');
        button2.className = "btn btn-success";
        button2.id = "addBtn";
        button2.innerText = "Add a Reimbursement";
        button2.onclick = AddFunc;
        document.getElementById("reimbForm").appendChild(button2);
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
            console.log(resp);
            let reimbursements = resp.json();
            for (let reimbursement of reimbursements) {
                console.log(reimbursement);
                let row = document.createElement("tr");
                let cell = document.createElement("td");
                cell.innerHTML = reimbursement.reimbursementId;
                row.appendChild(cell);
                let cell2 = document.createElement("td");
                cell2.innerHTML = reimbursement.amount;
                row.appendChild(cell2);
                let cell3 = document.createElement("td");
                cell3.innerHTML = reimbursement.timeSubmitted;
                row.appendChild(cell3);
                let cell4 = document.createElement("td");
                cell4.innerHTML = reimbursement.timeResolved;
                row.appendChild(cell4);
                let cell5 = document.createElement("td");
                cell5.innerHTML = reimbursement.description;
                row.appendChild(cell5);
                let cell6 = document.createElement("td");
                cell6.innerHTML = reimbursement.ersAuthor.username;
                row.appendChild(cell6);
                let cell7 = document.createElement("td");
                cell7.innerHTML = reimbursement.ersResolver.username;
                row.appendChild(cell7);
                let cell8 = document.createElement("td");
                cell8.innerHTML = reimbursement.reimbursementStatus.status;
                row.appendChild(cell8);
                let cell9 = document.createElement("td");
                cell9.innerHtml = reimbursement.reimbursementType.type;
                document.getElementById("reimbursement-table-body").appendChild(row);
        }
    }
}
        

async function addFunc(){

    let amount = document.getElementById("reimbAmount").value;
    let description = document.getElementById("reimbDescription").value;
    let type = document.getElementById("reimbType").value;

    let reimb = {
        "amount" : amount,
        "reimbDescription" : description,
        "reimbType" : type
    }


    let resp = await fetch(url + "reimbursements", {
        method: 'POST',
        body: JSON.stringify(reimb),
        credentials: "include"
    })

    if (resp.status===200){
        
    }
}
