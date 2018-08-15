//edit itemName
const openItemNameModal = function(){
    document.body.classList.add('itemName-modal-open');
};

const closeItemNameModal = function(){
    document.body.classList.remove('itemName-modal-open');
};

const openItemNameModalBtn = document.getElementById('renameItemBtn');
openItemNameModalBtn.addEventListener('click', openItemNameModal);

const closeItemNameModalBtn = document.getElementById('close-itemName-modal');
closeItemNameModalBtn.addEventListener('click', closeItemNameModal);


//edit Picture
const openPictureModal = function(){
    document.body.classList.add('picture-modal-open');
};

const closePictureModal = function(){
    document.body.classList.remove('picture-modal-open');
};

const openPictureModalBtn = document.getElementById('editPictureBtn');
openPictureModalBtn.addEventListener('click', openPictureModal);

const closePictureModalBtn = document.getElementById('close-picture-modal');
closePictureModalBtn.addEventListener('click', closePictureModal);


//edit Description

const openDescriptionModal = function(){
    document.body.classList.add('description-modal-open');
};

const closeDescriptionModal = function(){
    document.body.classList.remove('description-modal-open');
};

const openDescriptionModalBtn = document.getElementById('editDescriptionBtn');
openDescriptionModalBtn.addEventListener('click', openDescriptionModal);

const closeDescriptionModalBtn = document.getElementById('close-description-modal');
closeDescriptionModalBtn.addEventListener('click', closeDescriptionModal);
    

//edit Price
const openPriceModal = function(){
    document.body.classList.add('price-modal-open');
};

const closePriceModal = function(){
    document.body.classList.remove('price-modal-open');
};

const openPriceModalBtn = document.getElementById('editPriceBtn');
openPriceModalBtn.addEventListener('click', openPriceModal);

const closePriceModalBtn = document.getElementById('close-price-modal');
closePriceModalBtn.addEventListener('click', closePriceModal);




//edit Calories
const openCaloriesModal = function(){
    document.body.classList.add('calories-modal-open');
};

const closeCaloriesModal = function(){
    document.body.classList.remove('calories-modal-open');
};

const openCaloriesModalBtn = document.getElementById('editCaloriesBtn');
openCaloriesModalBtn.addEventListener('click', openCaloriesModal);

const closeCaloriesModalBtn = document.getElementById('close-calories-modal');
closeCaloriesModalBtn.addEventListener('click', closeCaloriesModal);




//edit Ingredients
const openIngredientsModal = function(){
    document.body.classList.add('ingredients-modal-open');
};

const closeIngredientsModal = function(){
    document.body.classList.remove('ingredients-modal-open');
};

const openIngredientsModalBtn = document.getElementById('editIngredientsBtn');
openIngredientsModalBtn.addEventListener('click', openIngredientsModal);

const closeIngredientsModalBtn = document.getElementById('close-ingredients-modal');
closeIngredientsModalBtn.addEventListener('click', closeIngredientsModal);


//save itemName

const submitRenameBtn = document.querySelector('.submitRenameBtn');
const itemName = document.querySelector('[name="itemRename"]')
const menuIdApi = document.querySelector("[name='menuId']");
const itemIdApi = document.querySelector("[name='itemId']");
submitRenameBtn.addEventListener('click', closeItemNameModal);
submitRenameBtn.addEventListener("click", function saveChanges(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function (response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            const itemName = JSON.parse(response.currentTarget.response)
            let html=`
            <h1 text="${itemName.itemName}"></h1>
            <button id="renameItemBtn">Rename</button>
            <div id = "itemName-modal-screen">
                <div id = "itemName-modal-box">
                    <header>
                        <h3>Rename item</h3>
                        <button id = "close-itemName-modal">Cancel</button>
                    </header>
                    <label>Picture: <input type="text" name="itemRename" placeholder="${itemName.itemName}" /></label>
                    <button class="submitRenameBtn">Save changes</button>
                </div>
            </div>
                
                `
                
            itemName.innerHTML = html;
        }
    })
    xhr.open("PUT", `/api/menus/${menuIdApi.value}/items/${itemIdApi.value}?itemName=${itemName.value}`, true);
    xhr.send();

})


//save Description

const submitDescriptionBtn = document.querySelector('.submitDescription');
const itemDescription = document.querySelector('[name="itemDescription"]')
submitDescriptionBtn.addEventListener('click', closeDescriptionModal);
submitDescriptionBtn.addEventListener("click", function saveChanges(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function (response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            const description = JSON.parse(response.currentTarget.response)
            let html=`
                    <li class = "itemDescription">
                        <p class = "description" text="|Description: ${description.description}|"></p>
                        <button id ="editDescriptionBtn">Edit</button>
                        <div id = "description-modal-screen">
                            <div id = "description-modal-box">
                                <header>
                                    <h3>
                                        Edit description of this item
                                    </h3>
                                    <button id = "close-description-modal">Cancel</button>
                                </header>
                                    <label>Description: <input type="text" name="itemDescription" placeholder="${description.description}" /></label>
                                    <button class="submitDescription">Save description</button>
                            </div>
                        </div>
                    </li>
                
                `
                
            itemDescription.innerHTML = html;
        }
    })
    xhr.open("PUT", `/api/menus/${menuIdApi.value}/items/${itemIdApi.value}?description=${itemDescription.value}`, true);
    xhr.send();

})


//save Picture

const submitPictureBtn = document.querySelector('.submitPictureBtn');
const itemPicture = document.querySelector('[name="itemPicture"]')
submitPictureBtn.addEventListener('click', closePictureModal);
submitPictureBtn.addEventListener("click", function saveChanges(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function (response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            const picture = JSON.parse(response.currentTarget.response)
            let html=`
                    <li class = "itemPicture">
                        <img class = "picture" src="${picture.picture}"></img>
                        <button id ="editPictureBtn">Edit</button>
                        <div id = "picture-modal-screen">
                            <div id = "picture-modal-box">
                                <header>
                                    <h3>
                                        Enter picture file path
                                    </h3>
                                    <button id = "close-picture-modal">Cancel</button>
                                </header>
                                    <label>Picture: <input type="text" name="itemPicture" placeholder="${picture.picture}" /></label>
                                    <button class="submitPictureBtn">Save picture</button>
                            </div>
                        </div>
                    </li>
                
                `
                
            itemPicture.innerHTML = html;
        }
    })
    xhr.open("PUT", `/api/menus/${menuIdApi.value}/items/${itemIdApi.value}?picture=${itemPicture.value}`, true);
    xhr.send();

})



//save Price

const submitPriceBtn = document.querySelector('.submitPrice');
const itemPrice = document.querySelector('[name="itemPrice"]')
submitPriceBtn.addEventListener('click', closePriceModal);
submitPriceBtn.addEventListener("click", function saveChanges(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function (response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            const price = JSON.parse(response.currentTarget.response)
            let html=`
            		<li class = "itemPrice">
	                <p class = "price" text="|Price: $${price.price}|"></p>
	                <button id="editPriceBtn">Edit</button>
	                <div id = "price-modal-screen">
	                    <div id = "price-modal-box">
	                        <header>
	                            <h3>
	                                Edit price of this item
	                            </h3>
	                            <button id = "close-price-modal">Cancel</button>
	                        </header>
	                            <label>Price: <input type="text" name="itemPrice" placeholder="${price.price}" /></label>
	                            <button class="submitPrice">Save changes</button>
	                    </div>
	                </div>
	            </li>
                
                `
                
            itemPrice.innerHTML = html;
        }
    })
    xhr.open("PUT", `/api/menus/${menuIdApi.value}/items/${itemIdApi.value}?price=${itemPrice.value}`, true);
    xhr.send();

})


//save Calories

const submitCaloriesBtn = document.querySelector('.submitCalories');
const itemCalories = document.querySelector('[name="itemCalories"]')
submitCaloriesBtn.addEventListener('click', closeCaloriesModal);
submitCaloriesBtn.addEventListener("click", function saveChanges(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function (response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            const calories = JSON.parse(response.currentTarget.response)
            let html=`
	            <li class="itemCalories">
	                <p class = "calories" text="|Calories: ${calories.calories}|"></p>
	                <button id="editCaloriesBtn">Edit</button>
	                <div id = "calories-modal-screen">
	                    <div id = "calories-modal-box">
	                        <header>
	                            <h3>
	                                Edit calories of this item
	                            </h3>
	                            <button id = "close-calories-modal">Cancel</button>
	                        </header>
	                            <label>Calories: <input type="text" name="itemCalories" placeholder="${calories.calories}" /></label>
	                            <button class="submitCalories">Save changes</button>
	                    </div>
	                </div>
		            </li>
                
                `
                
            itemCalories.innerHTML = html;
        }
    })
    xhr.open("PUT", `/api/menus/${menuIdApi.value}/items/${itemIdApi.value}?calories=${itemCalories.value}`, true);
    xhr.send();

})


//save Price

const submitIngredientsBtn = document.querySelector('.submitIngredients');
const itemIngredients = document.querySelector('[name="itemIngredients"]')
submitIngredientsBtn.addEventListener('click', closeIngredientsModal);
submitIngredientsBtn.addEventListener("click", function saveChanges(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function (response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            const ingredients = JSON.parse(response.currentTarget.response)
            let html=`
	            <li class="itemIngredients">
	                <p class = "ingredients" text="|Ingredients: ${ingredients.ingredients}|"></p>
	                <button id="editIngredientsBtn">Edit</button>
	                <div id = "ingredients-modal-screen">
	                    <div id = "ingredients-modal-box">
	                        <header>
	                            <h3>
	                                Edit ingredients of this item
	                            </h3>
	                            <button id = "close-ingredients-modal">Cancel</button>
	                        </header>
	                            <label>Ingredients: <input type="text" name="itemIngredients" placeholder="${ingredients.ingredients}" /></label>
	                            <button class="submitIngredients">Save changes</button>
	                    </div>
	                </div>
	            </li>
                
                `
                
            itemIngredients.innerHTML = html;
        }
    })
    xhr.open("PUT", `/api/menus/${menuIdApi.value}/items/${itemIdApi.value}?ingredients=${itemIngredients.value}`, true);
    xhr.send();

})