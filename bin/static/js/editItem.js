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


//save Description

const submitDescriptionBtn = document.querySelector('.submitDescription');
const itemDescription = document.querySelector('[name="itemDescription"]')
const menuId = document.querySelector("[name='menuId']");
const itemId = document.querySelector("[name='itemId']");
submitDescriptionBtn.addEventListener("click", function saveChanges(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function (response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            const descriptions = JSON.parse(response.currentTarget.response)
            let html = '';
            descriptions.forEach(description =>{
                html+=`
                    <li class = "itemDescription">
                        <p class = "description" th:text="|Description: ${item.description}|"></p>
                        <button id ="editDescriptionBtn">Edit</button>
                        <div id = "description-modal-screen">
                            <div id = "description-modal-box">
                                <header>
                                    <h3>
                                        Edit description of this item
                                    </h3>
                                    <button id = "close-description-modal">Cancel</button>
                                </header>
                                    <label>Description: <input type="text" name="itemDescription" th:placeholder="${item.description}" /></label>
                                    <button class="submitDescription">Save description</button>
                            </div>
                        </div>
                    </li>
                
                `
                })
            itemDescription.innerHTML = html;
        }
    })
    xhr.open("PATCH", `/api/menus/${menuId.value}/items/${itemId.value}?description=${itemDescription.value}`, true);
    xhr.send();

})

