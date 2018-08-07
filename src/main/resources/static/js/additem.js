//add item to current menu
const submitItemButton = document.querySelector(".submitItemButton");
const addItemNameApi = document.querySelector("[name='addItemNameApi']");
const addDescriptionApi = document.querySelector("[name='addDescriptionApi']");
const addPriceApi = document.querySelector("[name='addPriceApi']");
const addImageApi = document.querySelector("[name='addImageApi']");
const addCaloriesApi = document.querySelector("[name='addCaloriesApi']");
const addIngredientsApi = document.querySelector("[name='addIngredientsApi']");
const menuId = document.querySelector("[name='menuId']");
const restaurantName = document.querySelector("[name='restaurantName']");
const itemsList = document.querySelector(".itemsList");

submitItemButton.addEventListener("click", function submitItem(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function (response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            console.log(response.currentTarget.response)
            const items = JSON.parse(response.currentTarget.response)
            let list = '';
            items.forEach(item =>{
                list += `
                <li>
                    <a href= "/index/${restaurantName.value}/menus/${menuId.value}/items/${item.itemId}">${item.itemName}

                        <img src="${item.picture}" style="width:10vw" />
                    </a>
                    <button class="deleteItemButton">Delete Item</button> 
                </li>    
                `
            })
            itemsList.innerHTML = list;
        }
    })
    xhr.open("POST", `/api/menu/${menuId.value}/items?itemName=${addItemNameApi.value}&description=${addDescriptionApi.value}&price=${addPriceApi.value}&picture=${addImageApi.value}&calories=${addCaloriesApi.value}&ingredients=${addIngredientsApi.value}`, true);
    xhr.send();

})

