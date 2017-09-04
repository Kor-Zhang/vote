/**
 * 得到当前在href中的项目的路径
 */
function getHrefPath() {
	var webProjectName = undefined;
	//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	//获取带"/"的项目名，如：/uimcardprj
	webProjectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

	return webProjectName;
}