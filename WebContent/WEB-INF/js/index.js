/**
 * 
 */

window.onload = function() {
	refresh("depots", "仓库信息");
	// console.info("第一次加载");
};

function refresh(url, name) {
	// 左侧导航栏的样式切换
	$("#depots").removeClass("active");
	$("#products").removeClass("active");
	$("#depotitems").removeClass("active");
	$("#"+url).addClass("active");
	
	// $("#content_right").empty();
	// $("#content_right").load(url);
	
	$("#miframe").attr("src", url);
	document.getElementById("content_title").innerHTML = name;
}