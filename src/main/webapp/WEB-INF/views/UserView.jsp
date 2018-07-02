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
			<c:if test="${error != null}">
			<div class="error">${error}</div>
			</c:if>
			<div class="container-fluid">
				<div class="row">
					<div class="content-column-area col-sm-12 col-xs-12">
						<div class="fieldset">
							<h2 class="corpcolor-font"><span>用户登录</span></h2>
							<form method="post">
								<table>
									<tbody>
										<tr>
											<td>用户名</td>
										</tr>
										<tr>
											<td><input type="text" name="user_stcd" class="form-control input-sm required" placeholder="用户名" value="${user_stcd}" /></td>
										</tr>
										<tr>
											<td>密码</td>
										</tr>
										<tr>
											<td><input type="password" name="user_pwd" class="form-control input-sm required" placeholder="密码" /></td>
										</tr>
										<tr>
											<td><input type="checkbox" name="user_auto" class=""/> 记住该账户</td>
										</tr>
										<tr>
											<td><button type="submit" class="btn-login btn btn-sm btn-primary pull-right"><i class="glyphicon glyphicon-send"></i> 登录</button></td>
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