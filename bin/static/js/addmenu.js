const submitMenuButton = document.querySelector(".submitMenuButton");
const addMenuNameApi = document.querySelector("[name='addMenuNameApi']");
const restaurantName = document.querySelector("[name='apiRestaurantName']");
const menusList = document.querySelector(".menusList");


submitMenuButton.addEventListener("click", function submitMenu(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function (response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            const menus = JSON.parse(response.currentTarget.response)
            let list = '';
            menus.forEach(menu =>{

                list += `
                <li>
                    <a href= "/index/${restaurantName.value}/menus/${menu.menuId}">
                        ${menu.menuName}
                    </a>
                    <button class="deleteMenuButton">Delete Menu</button>
                </li>
                
                `
            })
            menusList.innerHTML = list;
        }
    })
    xhr.open("POST", `/api/index/${restaurantName.value}/menus?menuName=${addMenuNameApi.value}`, true);
    xhr.send();
})
