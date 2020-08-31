let url = "http://localhost:8080/project1/";

document.getElementById("loginBtn").addEventListener("click", login, false);

async function login(){
    let name = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let user = {
        username : name,
        password : password
    }

    console.log(user);
    let resp = await fetch(url + "login", {
        method: 'POST',
        body: JSON.stringify(user),
        credentials: "include"
    })
    if (resp.status===200){
        console.log(resp);
        let data = await resp.json();
        console.log(data);
        document.getElementById("LoginRow").innerText ="Successfully Logged in!!!";
        let button = document.createElement("button");
        button.className = "btn btn-success";
        button.id = "findAllBtn";
        button.innerText = "Find ALl Reimbursements";
        button.onclick = findALlFunc;
        document.getElementById("logintable").appendChild(button);

    } else {
        document.getElementById("LoginRow").innerText = "LOGIN FAILED";
    }
};

async function findAllFunc(){
    document.getElementById("table-body").innerText = "";
    let resp = await fetch(url+"reimbursement", {
        credentials : "include"
    });

    if (resp.status === 200){
        let data = await resp.json();
        for (let reimbursement of data){
            console.log(reimbursement);
            let row = document.createElement("tr");
            let cell = document.createElement("td");
            cell.innerHTML = reimbursement.reimbursementId;
            row.appendChild(cell);
            let cell2 = document.createElement("td");
            cell2.innerHTML = reimbursement.reimbursementAmount;
            row.appendChild(cell2);
            let cell3 = document.createElement("td");
            cell3.innerHTML = reimbursement.reimbursementStatus.status;
            row.appendChild(cell3);
            document.getElementById("table-body").appendChild(row);


        }
    }
}