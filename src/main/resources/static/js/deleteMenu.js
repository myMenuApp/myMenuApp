const menuList = document.querySelector('.menusList')
menuList.addEventListener('click', removeMenu)

function removeMenu(event) {
	if (event.target.classList.contains('deleteMenuButton')) {
		const deleteMenuButton = event.target
		const menuContainer = deleteMenuButton.parentElement.parentElement
		
		const hrefArray = menuContainer.querySelector('a').getAttribute('href').split("/")
		const restaurantName = hrefArray[2]
		const menuId = hrefArray[4]
		
		const xhr = new XMLHttpRequest()
		
		xhr.onreadystatechange = function(response) {
			if(xhr.readyState == 4 && xhr.status == 200) {
				const remainingMenus = JSON.parse(response.currentTarget.response);
				let list = ''
					remainingMenus.forEach(function(menu) {
						list +=`
							 <li>
								<a href= "/index/${restaurantName}/menus/${menu.menuId}">
									${menu.menuName}
								</a> 
								 <div class="button-group">
									<button class = "deleteMenuButton">Delete Menu</button>
								</div>
							</li>
						`		
					})
					menuList.innerHTML = list
			}
		}
		xhr.open("DELETE",`/api/menus?menuId=${menuId}&restaurantName=${restaurantName}&itemId=${itemId.value}`,true)
		xhr.send()
	}
	
}