//edit menuName
const openMenuNameModal = function(){
    document.body.classList.add('menuName-modal-open');
};

const closeMenuNameModal = function(){
    document.body.classList.remove('menuName-modal-open');
};

const openMenuNameModalBtn = document.getElementById('renameMenuBtn');
openMenuNameModalBtn.addEventListener('click', openMenuNameModal);

const closeMenuNameModalBtn = document.getElementById('close-menuName-modal');
closeMenuNameModalBtn.addEventListener('click', closeMenuNameModal);


//save menuName
const submitMenuNameBtn = document.querySelector('.submitMenuNameBtn');
const menuRenameInput = document.querySelector('[name="menuRenameInput"]')
const menuIdApi = document.querySelector("[name='menuId']");
const menuNameToChange = document.querySelector('.menuNameToChange')
submitMenuNameBtn.addEventListener('click', closeMenuNameModal);
submitMenuNameBtn.addEventListener("click", function saveChanges(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function (response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            const menuRename = JSON.parse(response.currentTarget.response)
            menuNameToChange.innerText = menuRename.menuName;

        }
    })
    xhr.open("PUT", `/api/menus/${menuIdApi.value}?menuName=${menuRenameInput.value}`, true);
    xhr.send();
})