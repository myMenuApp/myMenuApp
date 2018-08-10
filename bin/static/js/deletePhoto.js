const itemDetails = document.querySelector('.itemDetails');
itemDetails.addEventListener('click', removeDetail)
function removeDetail(event){
    if (event.target.classList.contains('deletePhoto')) {
		const deletePhotoBtn = event.target
        const photoContainer = deletePhotoBtn.parentElement
        
    }
}