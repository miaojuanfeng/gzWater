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
			<h2 class="title-wrapper"><span>æ±è¥¿çæ°´æå±è¸åéæ¥è¯¢æ¥éç³»ç»</span></h2>
			<div class="error">ddd</div>
			<div class="container-fluid">
				<div class="row">
					<div class="content-column-area col-sm-12 col-xs-12">
						<div class="fieldset">
							<h2 class="corpcolor-font"><span>ç¨æ·ç»å½</span></h2>
							<form method="post">
								<table>
									<tbody>
										<tr>
											<td>ç¨æ·å</td>
										</tr>
										<tr>
											<td><input type="text" id="user_username" name="user_username" class="form-control input-sm required" placeholder="ç¨æ·å" value="" /></td>
										</tr>
										<tr>
											<td>å¯ç </td>
										</tr>
										<tr>
											<td><input type="password" id="user_password" name="user_password" class="form-control input-sm required" placeholder="å¯ç " value="" /></td>
										</tr>
										<tr>
											<td><input type="checkbox" name="user_password" class=""/> è®°ä½æ</td>
										</tr>
										<tr>
											<td><button type="submit" class="btn-login btn btn-sm btn-primary pull-right"><i class="glyphicon glyphicon-send"></i> ç»å½</button></td>
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