const submitButton = document.getElementById("submitComment");
const commentList = document.querySelector(".commentList");
const creator = document.querySelector("[name='Creator']");
const comment = document.querySelector("[name='comment']");
const item = document.querySelector("[name='itemId']");
const menuId = document.querySelector("[name='menuId']");

submitComment.addEventListener('click', function addComment(){
	const xhr= new XMLHttpRequest()
	xhr.addEventListener("readystatechange", function(response) {
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(response.currentTarget.response)
			const comments= JSON.parse(response.currentTarget.response)
			let list= ''
				comments.forEach(function(comment){
					list+=`
						<li>
						<span>${comment.creator}</span>
						<span>${comment.comment}</span>
						</li>
					`
				})
				commentList.innerHTML= list
		}
		
	})
	
	xhr.open("POST", `/api/menus/${menuId.value}/items/${item.value}?creator=${creator.value}&comment=${comment.value}&items=${item.value}`,true)
	xhr.send();
})
