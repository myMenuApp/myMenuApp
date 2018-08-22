const itemList = document.querySelector('.itemsList')

itemList.addEventListener('click', removeItem)

function removeItem(event) {
	if (event.target.classList.contains('deleteItemButton')) {
		const deleteItemBtn = event.target
		const itemContainer = deleteItemBtn.parentElement.parentElement
		
		const hrefArray = itemContainer.querySelector('a').getAttribute('href').split("/")
		const restaurantName =hrefArray[2]
		const menuId = hrefArray[4]
		const itemId = hrefArray[6]
		
		const xhr = new XMLHttpRequest()
		
		xhr.onreadystatechange = function(response) {
			if(xhr.readyState == 4 && xhr.status == 200){
				const remainingItems = JSON.parse(response.currentTarget.response);
				let html = ''
					remainingItems.forEach(function(item) {
					html += `
							<li class="${item.enabled ? 'inStock' : 'outStock'}">
								<input type="hidden" name="enabled" value="${item.enabled}"/>
								<a href="/index/${restaurantName}/menus/${menuId}/items/${item.itemId}">
									${item.itemName}
									<img src="${item.picture}" style="width:10vw" />
								</a>
								<button class="soldOut">Sold Out</button>
								<button class="deleteItemButton">Delete Item</button>
							</li>			
					`
				})
				itemList.innerHTML = html
			}
		}

		xhr.open("DELETE",`/api/restaurants?restaurantName=${restaurantName}&menuId=${menuId}&itemId=${itemId}`, true )
		xhr.send()
	}
}
