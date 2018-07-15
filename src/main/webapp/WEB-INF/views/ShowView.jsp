<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>蒸发量查询 - 赣州市水文局日蒸发量查询报送系统</title>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

		<%@ include file="inc/headArea.jsp" %>
	</head>

	<body>
		<div class="login-area">
			<h2 class="title-wrapper"><span>赣州市水文局日蒸发量查询报送系统</span></h2>
			<div class="container-fluid menu-wrapper">
				<div class="row">
					<div class="content-column-area col-sm-12 col-xs-12">
						<div class="fieldset show-wrapper">
							<h2 class="corpcolor-font"><span>导航菜单</span></h2>
							<div class="row">
								<div class="no-margin-top col-sm-6 col-xs-12">
									<a class="btn btn-sm btn-primary" href="<c:url value="/cms"></c:url>">导航菜单</a>
								</div>
								<div class="no-margin-top col-sm-6 col-xs-12">
									<a class="btn btn-sm btn-primary" href="<c:url value="/cms/post"></c:url>">蒸发量报送</a>
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
							<h2 class="corpcolor-font"><span>日蒸发量查询 - ${stnm}站</span></h2>
							<%@ include file="inc/searchArea.jsp" %>
							<hr>
							<div>
								<table class="table-striped">
									<c:choose> 
	     								<c:when test="${type == 's'}"> 
											<tbody class="tbody-station">
												<tr>
													<th class="th-date">日期</th>
													<th class="th-time">时间</th>
													<th class="th-data">蒸发量</th>
												</tr>
												<c:forEach items="${dayEVs}" var="item">
												<tr>
													<td class="th-date"><fmt:formatDate  value="${item.daypk.tm}"  pattern="yyyy-MM-dd" /></td>
													<td class="th-time"><fmt:formatDate  value="${item.daypk.tm}"  pattern="HH:mm" /></td>
													<td class="th-data">${item.dye}</td>
												</tr>
												</c:forEach>
												
												<c:if test="${totalRecord == 0}">
													<tr class="list-row">
														<td colspan="10" align="center">暂无数据</td>
													</tr>
												</c:if>
											</tbody>
										</c:when>
										<c:otherwise>   
											<tbody class="tbody-admin">
												<tr>
													<th class="th-stcd">站码</th>
													<th class="th-stnm">站名</th>
													<th class="th-date">日期</th>
													<th class="th-time">时间</th>
													<th class="th-data">蒸发量</th>
												</tr>
												<c:forEach items="${dayEVs}" var="item">
												<tr>
													<td class="th-stcd">${item.daypk.stcd}</td>
													<td class="th-stnm">${stations[item.daypk.stcd]}</td>
													<td class="th-date"><fmt:formatDate  value="${item.daypk.tm}"  pattern="yyyy-MM-dd" /></td>
													<td class="th-time"><fmt:formatDate  value="${item.daypk.tm}"  pattern="HH:mm" /></td>
													<td class="th-data">${item.dye}</td>
												</tr>
												</c:forEach>
												
												<c:if test="${totalRecord == 0}">
													<tr class="list-row">
														<td colspan="10" align="center">暂无数据</td>
													</tr>
												</c:if>
											</tbody>
	  									</c:otherwise>
									</c:choose>
								</table>
								<div class="page-area">
										<span class="btn btn-sm btn-default">${totalRecord}</span>
										<c:if test="${totalRecord > 0}">
										<span class="pagination-area">
											<c:if test="${page-1 > 1}">
												<a href="<c:url value="/cms/show/1${parameters}"></c:url>" class="btn btn-sm btn-primary">&lt;&lt;</a>
											</c:if>
											<c:if test="${page != 1}">
												<a href="<c:url value="/cms/show/${page-1}${parameters}"></c:url>" class="btn btn-sm btn-primary">&lt;</a>
											</c:if>
											<c:if test="${page-1 > 0}">
												<a href="<c:url value="/cms/show/${page-1}${parameters}"></c:url>" class="btn btn-sm btn-primary">${page-1}</a>
											</c:if>
											<a href="<c:url value="/cms/show/${page}${parameters}"></c:url>" class="btn btn-sm btn-primary disabled">${page}</a>
											<c:if test="${page+1 <= totalPage}">
												<a href="<c:url value="/cms/show/${page+1}${parameters}"></c:url>" class="btn btn-sm btn-primary">${page+1}</a>
											</c:if>
											<c:if test="${page != totalPage}">
												<a href="<c:url value="/cms/show/${page+1}${parameters}"></c:url>" class="btn btn-sm btn-primary">&gt;</a>
											</c:if>
											<c:if test="${page+1 < totalPage}">
												<a href="<c:url value="/cms/show/${totalPage}${parameters}"></c:url>" class="btn btn-sm btn-primary">&gt;&gt;</a>
											</c:if>
										</span>
										</c:if>
									</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</body>
</html>