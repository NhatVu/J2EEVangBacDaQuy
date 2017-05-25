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
			<!-- Content Header (Page header) -->
			<section class="content-header">
					<div class="row text-center">
						<h4 style="margin-bottom: 25px !important;">
							Danh sách sản phẩm
						</h4>
					</div>
				<hr/>
			</section>

			<!-- solid sales graph -->
			<div class="">
				<!-- /.box-body -->
				<div class="box-footer no-border">
					<div class="row">
								<div class="col-xs-12">
									<div class="box" style="border: none !important;">
										<div class="box-body">
											<table id="tableSanPham"
												class="table table-bordered table-striped">
												<thead>
													<tr>
														<th>Mã Sản phẩm</th>
														<th>Tên Sản phẩm</th>
														<th>Đơn Giá Mua</th>
														<th>Đơn Giá Bán</th>
														<th>Số Luợng Tồn Kho</th>
														<th>Action <a href="javascript:void(0)" id="btnAddKW"><i
																	class="fa fa-plus-square"></i> Add</a> </th>
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
							<!-- /.row -->
					<!-- /.row -->
				</div>
				<!-- /.box-footer -->
			</div>
			<!-- /.box -->

			</section>
			<!-- /.content -->
		
		</div>
		<jsp:include page="../../../layout/Footer.jsp" flush="true"></jsp:include>
		<style>
			input.form-control.input-sm{
				width: 200px;
			}
		</style>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#showKW").click(function() {
					$("#modelShowKW").modal('show');
				});
			})
		</script>
		
		
	</div>
		
			<!-- Model keyword -->
			<div id="modelShowKW" class="modal modal-wide fade ">
				<div class="modal-dialog" style="width: 800px;">
					<div class="modal-content" >
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Keywords Set</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<div class="box" style="border: none !important;">
										<div class="box-body">
											<table id="tableKW"
												class="table table-bordered table-striped">
												<thead>
													<tr>
														<th>Id</th>
														<th>Topic</th>
														<th>Keywords</th>
														<th>Action <a href="javascript:void(0)" id="btnAddKW"><i
																	class="fa fa-plus-square"></i> Add</a> </th>
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
							<!-- /.row -->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
<!-- 							<button type="button" class="btn btn-primary">Save -->
<!-- 								changes</button> -->
						</div>
					</div>
				</div>
			</div>
			<!-- .Modal keywords -->
			
			
			<!-- Modal edit keyword -->
			<!-- Modal keyword -->
			<div id="modalEditKW" class="modal fade">
				<div class="modal-dialog" style="margin-top: 150px;">
					<div class="modal-content">
						<div id="txtMessage" class="alert" style="display:none;">
							Cập nhật keyword thành công!
						</div>
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
								<input type="hidden" id="txtId" value="">
							Topic: <input id="txtTopic" class="form-control" value="Nhập chủ đề">
						</div>
						<div class="modal-body">
							Keyword: 
							<textarea id="txtKeyword" class="form-control" rows="3">Nhập keyword tại đây, cách nhau bởi dấu phẩy</textarea>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button id="btnUpdateKW" type="button" class="btn btn-primary" >Save
								changes</button>
						</div>
					</div>
				</div>
			</div>
			<!-- .Model keywords -->
			<!-- .Model edit keyword -->
			
			<!-- Modal confirm -->
<div id="modalRemoveKW" class="modal fade">
				<div class="modal-dialog" style="margin-top: 150px;">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
								<h3>Cảnh báo! Xóa</h3>
						</div>
						<div class="modal-body">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button id="btnUpdateKW" type="button" class="btn btn-danger" >Delete</button>
						</div>
					</div>
				</div>
			</div>
			<!-- .Modal confirm -->
			
			<script>
			$(function() {
				initTable();
			});
			
			function initTable(){
				var edit = "<a href=\"javascript:void(0)\" onClick=\"editKeyword(this);\"><i class=\"fa fa-edit\"></i> Edit</a>";
				var remove = "</br><a href=\"javascript:void(0)\" onClick=\"removeKeyword(this);\"><i class=\"fa fa-remove\"></i> Remove</a>";
				$('#tableSanPham').DataTable( {
			        fixedHeader: true,
					destroy: true,
			        "ajax": "getAllSanPham",
			        "columns": [
			            { "data": "maSP" },
			            { "data": "tenSP" },
			            { "data": "donGiaMua" },
			            { "data": "donGiaBan" },
			            { "data": "soLuongTon" },
			            { "defaultContent": edit + remove}
			        ]
			    } );
			}
			
			function editKeyword(keyword){
				$("#modalEditKW").modal('show');
				$("#txtMessage").css("display","none");
				$("#btnUpdateKW").css("display","");
				
				var table = $('#tableKW').DataTable();
				var data = table.row( $(keyword).parents('tr') ).data();
				if (data != null || data !== undefined){
					$("#txtId").val(data.id);
					$("#txtTopic").val(data.key);
					$("#txtKeyword").html(data.value);
					$("#txtKeyword").val(data.value);
			        console.log( data.id + data.key + data.value );
				}else{
					$("#txtId").val('');
					$("#txtTopic").val('Nhập chủ đề');
					$("#txtKeyword").html('Nhập keyword tại đây, cách nhau bởi dấu phẩy');		
				}
			}
			
			function removeKeyword(keyword){
				var result = confirm("Want to delete?");
				if (result) {
					var table = $('#tableKW').DataTable();
					var data = table.row( $(keyword).parents('tr') ).data();
					
					$.ajax({
						url: 'removeKeyword',
						type: 'POST',
						data: data,
						success: function(data){
							if(data.error == false){
					    		alert(data.message);
					    	}else{
					    		alert(data.message);
					    	}
							initTable();
						},
						error: function(xhr, ajaxOptions, thrownError){
						   	console.log(thrownError);
						}
					});
				}
				
				
			}
			
			function updateKeyword(id, key, value){
				var object = new Object();
				object.id = id;
				object.key = key;
				object.value = value;
				console.log("keyword: " + object.value);
				$.ajax({
				    url: 'updateKeyword',
				    type: 'POST',
				    data: object,
				    success: function(data) {
				    	$("#txtMessage").css("display","block");
				    	if(data.error == false){
				    		$("#txtMessage").addClass("alert-success");
				    		$("#txtMessage").html(data.message);
				    		$("#btnUpdateKW").css("display","none");
				    	}else{
				    		$("#txtMessage").addClass("alert-danger");
				    		$("#txtMessage").html(data.message);
				    		$("#btnUpdateKW").css("display","");
				    	}
				    	initTable();
				    },
				    error: function(xhr, ajaxOptions, thrownError){
				    	console.log(thrownError);
				    }
				  });
				$.LoadingOverlay("hide");
			}
			
			function addKeyword(key, value){
				var object = new Object();
				object.key = key;
				object.value = value;
				console.log("keyword: " + object.value);
				$.ajax({
				    url: 'addKeyword',
				    type: 'POST',
				    data: object,
				    success: function(data) {
				    	$("#txtMessage").css("display","block");
				    	if(data.error == false){
				    		$("#txtMessage").addClass("alert-success");
				    		$("#txtMessage").html(data.message);
				    		$("#btnUpdateKW").css("display","none");
				    	}else{
				    		$("#txtMessage").addClass("alert-danger");
				    		$("#txtMessage").html(data.message);
				    		$("#btnUpdateKW").css("display","");
				    	}
				    	initTable();
				    },
				    error: function(xhr, ajaxOptions, thrownError){
				    	console.log(thrownError);
				    }
				  });
				$.LoadingOverlay("hide");
			}
			
			$("#btnUpdateKW").click(function(){
				debugger;
				$.LoadingOverlay("show");
				var id = $("#txtId").val();
				if(id != null && id != undefined && id != ''){
					updateKeyword($("#txtId").val(), $("#txtTopic").val(), $("#txtKeyword").val());
				}else{
					addKeyword($("#txtTopic").val(), $("#txtKeyword").val());
				}
				
			});
			
			$("#btnAddKW").click(function(){
				$("#modalEditKW").modal('show');
				$("#txtMessage").css("display","none");
				$("#txtId").val('');
				$("#txtTopic").val('Nhập chủ đề');
				$("#txtKeyword").html('Nhập keyword tại đây, cách nhau bởi dấu phẩy');
				$("#txtKeyword").val('Nhập keyword tại đây, cách nhau bởi dấu phẩy');
				$("#btnUpdateKW").css("display","");
			});
			
		</script>
</body>
