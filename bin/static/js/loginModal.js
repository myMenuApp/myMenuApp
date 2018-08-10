let openModalBtn = document.getElementById('openModalBtn');


openModalBtn.addEventListener('click', function(){
let modalScreen = document.getElementById('loginModal');
modalScreen.style.display = 'block';
});

let closeModalBtn = document.getElementById('close-modal');
closeModalBtn.addEventListener('click', function(){
    let modalScreen = document.getElementById('loginModal');
    modalScreen.style.display = 'none';
});

