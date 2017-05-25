<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<jsp:include page="../../../layout/Header.jsp" flush="true"></jsp:include>
		<!-- Left side column. contains the logo and sidebar -->
		<jsp:include page="../../../layout/LeftSideBar.jsp" flush="true"></jsp:include>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="container">
				<div class="row" style="margin-top: 20px !important;">
					<div class="col-xs-6 col-xs-push-3 col-sm-6 col-md-6 col-lg-6">
						<div class="input-lg input-group input-group-sm">
							<input id="txtUrl" type="text" class="form-control"> <span
								class="input-group-btn">
								<button id="btnCrawl" type="button" class="btn btn-info btn-flat">Crawl!</button>
							</span>
						</div>
					</div>

				</div>
				
				
			</div>
			
			<div class="row">
								<div class="col-xs-12">
									<div class="box" style="border: none !important;">
										<div class="box-body">
											<table id="contentTable"
												class="table table-bordered table-striped">
												<thead>
													<tr>
														<th>Domain</th>
														<th>Url</th>
														<th>Title</th>
														<th>Content</th>
														<th>PostDate</th>
													</tr>
												</thead>
<!-- 												<tbody> -->
<%-- 													<s:iterator value="listKeyword"> --%>
<!-- 														<tr> -->
<%-- 															<td><s:property value="id"/></td> --%>
<%-- 															<td style="width: 200px;"><s:property value="key" /></td> --%>
<%-- 															<td><s:property value="value" /></td> --%>
<!-- 															<td><a href="javascript:void(0)" onClick="editKeyword(this);"><i -->
<!-- 																	class="fa fa-edit"></i> Edit</a></td> -->
<!-- 														</tr> -->
<%-- 													</s:iterator> --%>
<!-- 												</tbody> -->
											</table>
										</div>
										<!-- /.box-body -->
									</div>
									<!-- /.box -->
								</div>
								<!-- /.col -->
							</div>
		</div>
		<jsp:include page="../../../layout/Footer.jsp" flush="true"></jsp:include>
		<style>
			input.form-control.input-sm {
				width: 200px;
			}
</style>
		<script type="text/javascript">
		$("#btnCrawl").click(function(){
			$.LoadingOverlay("show");
			$('#contentTable').DataTable( {
				destroy: true,
		        "ajax": "crawlLink?url=" + $("#txtUrl").val().trim(),
		        "columns": [
		            { "data": "site" },
		            { "data": "url" },
		            { "data": "title" },
		            { "data": "content" },
		            { "data": "postDate" }
		        ]
		    } );
			$.LoadingOverlay("hide");
		});
		
		</script>
	</div>
</body>
