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
							<h2 class="corpcolor-font"><span>导航菜单</span></h2>
							<div class="row">
								<!-- div class="no-margin-top col-sm-4 col-xs-12">
									<a class="btn btn-sm btn-primary" href="asd">è¸åéæ¥è¯¢</a>
								</div-->
								<div class="no-margin-top col-sm-6 col-xs-12">
									<a class="btn btn-sm btn-primary" href="<c:url value="/post"></c:url>">蒸发量报送</a>
								</div>
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
						<div class="fieldset show-wrapper">
							<h2 class="corpcolor-font"><span>蒸发量查询 - ${stnm}站</span></h2>
							<form method="post">
								<table>
									<tbody>
										<tr>
											<td>
												<span class="input-group date datetimepicker">
													<input id="invoice_create_greateq" name="invoice_create_greateq" type="text" class="form-control input-sm date-mask valid" placeholder="开始日期 (YYYY-MM-DD)">
													<span class="input-group-addon">
														<span class="glyphicon glyphicon-calendar"></span>
													</span>
												</span>
											</td>
										</tr>
										<tr>
											<td>
												<span class="input-group date datetimepicker">
													<input id="invoice_create_greateq" name="invoice_create_greateq" type="text" class="form-control input-sm date-mask valid" placeholder="结束日期 (YYYY-MM-DD)">
													<span class="input-group-addon">
														<span class="glyphicon glyphicon-calendar"></span>
													</span>
												</span>
											</td>
										</tr>
										<tr>
											<td><button type="submit" class="btn-login btn btn-sm btn-primary pull-right"><i class="glyphicon glyphicon-send"></i> 查询</button></td>
										</tr>
									</tbody>
								</table>
							</form>
							<hr>
							<div>
								<table class="table-striped">
									<tbody>
										<tr>
											<th class="th-date">日期</td>
											<th class="th-time">时间</td>
											<th class="th-data">蒸发量</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-30</td>
											<td class="th-time">08:00</td>
											<td class="th-data">123.2</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-29</td>
											<td class="th-time">08:00</td>
											<td class="th-data">103.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-28</td>
											<td class="th-time">08:00</td>
											<td class="th-data">73.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-27</td>
											<td class="th-time">08:00</td>
											<td class="th-data">53.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-26</td>
											<td class="th-time">08:00</td>
											<td class="th-data">83.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-25</td>
											<td class="th-time">08:00</td>
											<td class="th-data">93.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-30</td>
											<td class="th-time">08:00</td>
											<td class="th-data">123.2</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-29</td>
											<td class="th-time">08:00</td>
											<td class="th-data">103.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-28</td>
											<td class="th-time">08:00</td>
											<td class="th-data">73.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-27</td>
											<td class="th-time">08:00</td>
											<td class="th-data">53.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-26</td>
											<td class="th-time">08:00</td>
											<td class="th-data">83.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-25</td>
											<td class="th-time">08:00</td>
											<td class="th-data">93.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-30</td>
											<td class="th-time">08:00</td>
											<td class="th-data">123.2</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-29</td>
											<td class="th-time">08:00</td>
											<td class="th-data">103.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-28</td>
											<td class="th-time">08:00</td>
											<td class="th-data">73.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-27</td>
											<td class="th-time">08:00</td>
											<td class="th-data">53.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-26</td>
											<td class="th-time">08:00</td>
											<td class="th-data">83.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-25</td>
											<td class="th-time">08:00</td>
											<td class="th-data">93.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-30</td>
											<td class="th-time">08:00</td>
											<td class="th-data">123.2</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-29</td>
											<td class="th-time">08:00</td>
											<td class="th-data">103.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-28</td>
											<td class="th-time">08:00</td>
											<td class="th-data">73.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-27</td>
											<td class="th-time">08:00</td>
											<td class="th-data">53.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-26</td>
											<td class="th-time">08:00</td>
											<td class="th-data">83.8</td>
										</tr>
										<tr>
											<td class="th-date">2018-06-25</td>
											<td class="th-time">08:00</td>
											<td class="th-data">93.8</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</body>
</html>