const menuList = document.querySelector('.menusList')
menuList.addEventListener('click', removeMenu)

function removeMenu(event) {
	if (event.target.classList.contains('deleteMenuButton')) {
		const deleteMenuButton = event.target
		const menuContainer = deleteMenuButton.parentElement
		
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
								<a href= "/index/${restaurantName}/menus/${menuId}|">
									${menu.menuName}
								</a> 
								<button class = "deleteMenuButton">Delete Menu</button>
							</li>	
						`		
					})
					menuList.innerHTML = list
			}
		}
		xhr.open("DELETE",`/api/menus?menuId=${menuId}&restaurantName=${restaurantName}`,true)
		xhr.send()
	}
	
}