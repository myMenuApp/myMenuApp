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
const menuName = document.querySelector('[name="menuRename"]')
const menuIdApi = document.querySelector("[name='menuId']");
submitMenuNameBtn.addEventListener('click', closeMenuNameModal);
submitMenuNameBtn.addEventListener("click", function saveChanges(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function (response){
        if(xhr.readyState == 4 && xhr.status == 200) {
            const menuName = JSON.parse(response.currentTarget.response)
            let html=`
            <h1 text="${menuName.menuName}"></h1>
            <input type="hidden" name="menuId" value="${menuName.menuId}" />
            <button id="renameMenuBtn">Rename</button>
            <div id = "menuName-modal-screen">
                <div id = "menuName-modal-box">
                    <header>
                        <h3>Rename menu</h3>
                        <button id = "close-menuName-modal">Cancel</button>
                    </header>
                    <label>Picture: <input type="text" name="menuRename" placeholder="${menuName.menuName}" /></label>
                    <button class="submitMenuNameBtn">Save changes</button>
                </div>
            </div>
                
                `
                
            itemName.innerHTML = html;
        }
    })
    xhr.open("PUT", `/api/menus/${menuIdApi.value}?menuName=${menuName.value}`, true);
    xhr.send();

})