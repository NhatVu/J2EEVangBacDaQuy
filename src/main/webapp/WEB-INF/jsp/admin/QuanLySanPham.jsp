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
						<div class="modal-header modal-header-remove">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							Mã SP: <input id=txtMaSanPham disabled="disabled" class="form-control" value="">
						</div>
						<div class="modal-body">
							Tên SP: 
							<textarea id="txtTenSanPham" class="form-control" rows="3"></textarea>
							Đơn giá mua: 
							<textarea id="txtDonGiaMua" class="form-control" rows="3"></textarea>
							Đơn giá bán: 
							<textarea id="txtDonGiaBan" class="form-control" rows="3"></textarea>
							Số Luợng tồn kho: 
							<textarea id="txtSoLuongTonKho" class="form-control" rows="3"></textarea>
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
				
				var table = $('#tableSanPham').DataTable();
				var data = table.row( $(keyword).parents('tr') ).data();
				if (data != null || data !== undefined){
					$("#txtMaSanPham").val(data.maSP);
					$("#txtTenSanPham").val(data.tenSP);
					$("#txtDonGiaMua").html(data.donGiaMua);
					$("#txtDonGiaBan").val(data.donGiaBan);
					$("#txtSoLuongTonKho").val(data.soLuongTon);
				}else{
					$("#txtMaSanPham").val("");
					$("#txtTenSanPham").val("");
					$("#txtDonGiaMua").val("");
					$("#txtDonGiaBan").val("");
					$("#txtSoLuongTonKho").val("");
				}
			}
			
			function removeKeyword(keyword){
				var result = confirm("Want to delete?");
				if (result) {
					var table = $("#tableSanPham").DataTable();
					var data = table.row( $(keyword).parents('tr') ).data();
					console.log(data);
					$.ajax({
						url: 'removeSanPham?maSP='+data.maSP,
						type: 'GET',
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
			
			function updateKeyword(maSp, tenSP, donGiaMua, donGiaBan, soLuongTon){
				var object = new Object();
				object.maSP = maSp;
				object.tenSP = tenSP;
				object.donGiaMua = donGiaMua;
				object.donGiaBan = donGiaBan;
				object.soLuongTon = soLuongTon;
				console.log("keyword: " + object);
				$.ajax({
				    url: 'updateSanPham',
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
			
			function addKeyword(tenSP, donGiaMua, donGiaBan, soLuongTon){
				var object = new Object();
				object.tenSP = tenSP;
				object.donGiaMua = donGiaMua;
				object.donGiaBan = donGiaBan;
				object.soLuongTon = soLuongTon;
				console.log("keyword: " + object);
				$.LoadingOverlay("show");
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
				var id = $("#txtMaSanPham").val();
				if(id != null && id != undefined && id != ''){
					updateKeyword($("#txtMaSanPham").val(), $("#txtTenSanPham").val(), $("#txtDonGiaMua").val(), $("#txtDonGiaBan").val(), $("#txtSoLuongTonKho").val());
				}else{
					addKeyword($("#txtTenSanPham").val(), $("#txtDonGiaMua").val(), $("#txtDonGiaBan").val(), $("#txtSoLuongTonKho").val());
				}
				
			});
			
			$("#btnAddKW").click(function(){
				$("#modalEditKW").modal('show');
				$("#txtMessage").css("display","none");
				$("#txtMaSanPham").prop('disabled', true);
				$(".modal-header-remove").css("display","none");
				$("#txtMaSanPham").val('');
				$("#txtTenSanPham").val('');
				$("#txtDonGiaMua").html('');
				$("#txtDonGiaMua").val('');
				$("#txtDonGiaBan").val('');
				$("#txtSoLuongTonKho").val("");
			});
			
		</script>
</body>
