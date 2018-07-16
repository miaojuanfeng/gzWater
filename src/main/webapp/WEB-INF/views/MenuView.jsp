<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>导航菜单 - 赣州市水文局查询报送系统</title>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

		<%@ include file="inc/headArea.jsp" %>
	</head>

	<body>
		<div class="login-area">
			<h2 class="title-wrapper"><span>赣州市水文局查询报送系统</span></h2>
			<div class="container-fluid menu-wrapper">
				<div class="row">
					<div class="content-column-area col-sm-12 col-xs-12">
						<div class="fieldset show-wrapper">
							<h2 class="corpcolor-font"><span>导航菜单</span></h2>
							<div class="row">
								<div class="no-margin-top col-sm-12 col-xs-12">
									<a class="btn btn-sm btn-primary" href="<c:url value="/cms/dev/post"></c:url>">日蒸发量报送</a>
								</div>
								<div class="col-sm-12 col-xs-12">
									<a class="btn btn-sm btn-primary" href="<c:url value="/cms/flow/show"></c:url>">流量报送</a>
								</div>
								<div class="col-sm-12 col-xs-12">
									<a class="btn btn-sm btn-primary" href="<c:url value="/cms/logout"></c:url>">退出登录</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>