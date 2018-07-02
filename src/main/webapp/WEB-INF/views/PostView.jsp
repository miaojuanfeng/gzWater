<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Login</title>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

		<%@ include file="inc/headArea.jsp" %>
	</head>

	<body>
		<div class="login-area">
			<h2 class="title-wrapper"><span>江西省水文局蒸发量查询报送系统</span></h2>
			<div class="container-fluid menu-wrapper">
				<div class="row">
					<div class="content-column-area col-sm-12 col-xs-12">
						<div class="fieldset show-wrapper">
							<h2 class="corpcolor-font"><span>导航菜单</span></h2>
							<div class="row">
								<div class="no-margin-top col-sm-6 col-xs-12">
									<a class="btn btn-sm btn-primary" href="<c:url value="/show"></c:url>">蒸发量查询</a>
								</div>
								<!-- div class="no-margin-top col-sm-6 col-xs-12">
									<a class="btn btn-sm btn-primary" href="asd">蒸发量报送</a>
								</div !-->
								<div class="no-margin-top col-sm-6 col-xs-12">
									<a class="btn btn-sm btn-primary" href="<c:url value="/logout"></c:url>">退出登录</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<c:if test="${error != null}">
			<div class="error">${error}</div>
			</c:if>
			<div class="container-fluid">
				<div class="row">
					<div class="content-column-area col-sm-12 col-xs-12">
						<div class="fieldset post-wrapper">
							<h2 class="corpcolor-font"><span>蒸发量报送 - ${stnm}站</span></h2>
							<form method="post">
								<table>
									<tbody>
										<tr>
											<td>前日蒸发量</td>
										</tr>
										<tr>
											<td class="yesterday-data">${dye}</td>
										</tr>
										<tr>
											<td>昨日蒸发量</td>
										</tr>
										<tr>
											<td>
												<input type="hidden" name="stcd" value="${stcd}" />
												<input type="number" min="0" step="0.1" name="dye" class="form-control input-sm required" placeholder="昨日蒸发量" />
											</td>
										</tr>
										<tr>
											<td><button type="submit" class="btn-login btn btn-sm btn-primary pull-right"><i class="glyphicon glyphicon-send"></i> 提交</button></td>
										</tr>
									</tbody>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>