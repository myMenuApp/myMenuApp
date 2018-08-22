(function(){
	
	const itemsList = document.querySelector('.itemsList');

	itemsList.addEventListener('click', markSoldOut)
	function markSoldOut(event){

		if (event.target.classList.contains('soldOut')){
			const soldOutBtn = event.target
			const freezeContainer = soldOutBtn.parentElement.parentElement
			
			const hrefArray = freezeContainer.querySelector('a').getAttribute('href').split("/")
			const menuId = document.querySelector("[name='menuId']");
			const itemId = hrefArray[6]
			
			const xhr = new XMLHttpRequest();
			
			 xhr.addEventListener("readystatechange", function (response){
				if (xhr.readyState == 4 && xhr.status == 200){
					const freezeItems = JSON.parse(response.currentTarget.response);
					let html = ''
					freezeItems.forEach(function(item){
						html += `
						<li class="${item.enabled ? 'inStock' : 'outStock'}">
						<input type="hidden" name="enabled" value="${item.enabled}"/>
						<a href="/index/${restaurantName.value}/menus/${menuId.value}/items/${item.itemId}">
						${item.itemName}
						<img src="${item.picture}" style="width:10vw" />
						</a>
						<button class="soldOut" innerText=>Sold Out</button>
						<button class="deleteItemButton">Delete Item</button>
						</li>
						`
					})
					itemsList.innerHTML = html
				}
			})
			xhr.open("PUT", `/api/index?itemId=${itemId}&menuId=${menuId.value}` ,true)
			xhr.send()
		}
		}
	
	
})();