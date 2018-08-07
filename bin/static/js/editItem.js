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

