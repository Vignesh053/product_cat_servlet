
const display = document.getElementById("display");
const table = document.getElementById("productstable");
const form = document.getElementById("submitform").addEventListener('submit', (e)=> addProduct(e));


async function displayProducts()  {

    table.innerHTML = "<tr><th>Id</th><th>Name</th><th>Price</th><th>Category</th></tr>";
    
    
    const response = await fetch("http://localhost:8080/product/list");
    const items = await response.json();

    items.forEach(element => {
        table.innerHTML += `<tr><td>${element.id}</td><td>${element.name}</td><td>${element.price}</td><td>${element.category}</td></tr>`;
    });
}

async function addProduct(e){
    e.preventDefault();
    const nameInput = document.getElementById("name");
    const priceInput = document.getElementById("price");
    const categoryInput = document.getElementById("category");

    const name = nameInput.value;
    const price = priceInput.value;
    const category = categoryInput.value;

    let newProduct = {"name": name, "price": price, "category": category}

    const requestOptions = {
        method : 'POST',
        headers : {'Content-Type': 'application/json'},
        body: JSON.stringify(newProduct)
    }

    const response = await fetch("http://localhost:8080/product/add", requestOptions);

    const result = response.json();
    displayProducts();

    nameInput.value = "";
    priceInput.value = "";
    categoryInput.value = "";
    
    console.log("submitted successfully" + result);
}


displayProducts();

display.onclick = displayProducts;