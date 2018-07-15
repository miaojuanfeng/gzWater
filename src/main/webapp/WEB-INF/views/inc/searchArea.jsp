<%@ page contentType="text/html; charset=UTF-8" %>
<form method="get">
								<table>
									<tbody>
										<tr>
											<td>
												<span class="input-group date datetimepicker">
													<input name="from" type="text" class="form-control input-sm date-mask valid" placeholder="开始日期 (YYYY-MM-DD)" value="${from}">
													<span class="input-group-addon">
														<span class="glyphicon glyphicon-calendar"></span>
													</span>
												</span>
											</td>
										</tr>
										<tr>
											<td>
												<span class="input-group date datetimepicker">
													<input name="to" type="text" class="form-control input-sm date-mask valid" placeholder="结束日期 (YYYY-MM-DD)" value="${to}">
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