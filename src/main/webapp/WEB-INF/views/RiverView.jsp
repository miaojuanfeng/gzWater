<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>流量查询 - 赣州市水文局日流量查询报送系统</title>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

		<%@ include file="inc/headArea.jsp" %>
	</head>

	<body>
		<div class="login-area">
			<h2 class="title-wrapper"><span>赣州市水文局日流量查询报送系统</span></h2>
			<div class="container-fluid menu-wrapper">
				<div class="row">
					<div class="content-column-area col-sm-12 col-xs-12">
						<div class="fieldset show-wrapper">
							<h2 class="corpcolor-font"><span>导航菜单</span></h2>
							<div class="row">
								<div class="no-margin-top col-sm-12 col-xs-12">
									<a class="btn btn-sm btn-primary" href="<c:url value="/cms"></c:url>">导航菜单</a>
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
						<div class="fieldset show-wrapper flow-wrapper">
							<h2 class="corpcolor-font"><span>日流量查询 - ${stnm}站</span></h2>
							<%@ include file="inc/searchArea.jsp" %>
							<hr>
							<div>
								<div class="table-wrapper">
								<table class="table-striped">
									<c:choose> 
	     								<c:when test="${type == 's'}"> 
											<tbody>
												<tr>
													<th class="no-padding-left text-align-left">日期</th>
													<th>时间</th>
													<th>水位</th>
													<th>流量</th>
													<th>水势</th>
													<th class="no-padding-right text-align-right">测流方法</th>
												</tr>
												<c:forEach items="${dayEVs}" var="item">
												<tr>
													<td class="no-padding-left text-align-left"><fmt:formatDate  value="${item.daypk.tm}"  pattern="yyyy-MM-dd" /></td>
													<td class="th-time"><fmt:formatDate  value="${item.daypk.tm}"  pattern="HH:mm" /></td>
													<td class="th-data">${item.z}</td>
													<td class="th-data"><c:choose><c:when test="${item.q!=null}">${item.q}</c:when><c:otherwise>-</c:otherwise></c:choose></td>
													<td class="th-data">${item.z}</td>
													<td class="no-padding-right text-align-right">${item.z}</td>
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
											<tbody>
												<tr>
													<th class="no-padding-left text-align-left">站码</th>
													<th>站名</th>
													<th>日期</th>
													<th>时间</th>
													<th>水位</th>
													<th>流量</th>
													<th>水势</th>
													<th class="no-padding-right text-align-right">测流方法</th>
												</tr>
												<c:forEach items="${dayEVs}" var="item">
												<tr>
													<td class="no-padding-left text-align-left">${item.daypk.stcd}</td>
													<td>${stations[item.daypk.stcd]}</td>
													<td><fmt:formatDate  value="${item.daypk.tm}"  pattern="yyyy-MM-dd" /></td>
													<td><fmt:formatDate  value="${item.daypk.tm}"  pattern="HH:mm" /></td>
													<td>${item.z}</td>
													<td><c:choose><c:when test="${item.q!=null}">${item.q}</c:when><c:otherwise>-</c:otherwise></c:choose></td>
													<td>${item.z}</td>
													<td class="no-padding-right text-align-right">${item.z}</td>
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
								</div>
								<div class="page-area">
										<span class="btn btn-sm btn-default">${totalRecord}</span>
										<c:if test="${totalRecord > 0}">
										<span class="pagination-area">
											<c:if test="${page-1 > 1}">
												<a href="<c:url value="/cms/flow/show/1${parameters}"></c:url>" class="btn btn-sm btn-primary">&lt;&lt;</a>
											</c:if>
											<c:if test="${page != 1}">
												<a href="<c:url value="/cms/flow/show/${page-1}${parameters}"></c:url>" class="btn btn-sm btn-primary">&lt;</a>
											</c:if>
											<c:if test="${page-1 > 0}">
												<a href="<c:url value="/cms/flow/show/${page-1}${parameters}"></c:url>" class="btn btn-sm btn-primary">${page-1}</a>
											</c:if>
											<a href="<c:url value="/cms/flow/show/${page}${parameters}"></c:url>" class="btn btn-sm btn-primary disabled">${page}</a>
											<c:if test="${page+1 <= totalPage}">
												<a href="<c:url value="/cms/flow/show/${page+1}${parameters}"></c:url>" class="btn btn-sm btn-primary">${page+1}</a>
											</c:if>
											<c:if test="${page != totalPage}">
												<a href="<c:url value="/cms/flow/show/${page+1}${parameters}"></c:url>" class="btn btn-sm btn-primary">&gt;</a>
											</c:if>
											<c:if test="${page+1 < totalPage}">
												<a href="<c:url value="/cms/flow/show/${totalPage}${parameters}"></c:url>" class="btn btn-sm btn-primary">&gt;&gt;</a>
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