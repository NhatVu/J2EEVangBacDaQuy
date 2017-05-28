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
							Phiếu bán hàng
						</h4>
					</div>
				<hr/>
			</section>

			<div class="container customer-infor">
				<div class="row">
					<div id="maPhieu" class="col-md-1">Mã phiếu</div>
					<div class="col-md-3"> <input type="text" disabled="disabled" class="form-control"></div>
					<div class="col-md-2"></div>
					<div class="col-md-1"></div>
					<div class="col-md-3"></div>
				</div>
				<div class="row">
					<div class="col-md-1">Ngày bán</div>
					<div class="col-md-3">
						<div class="form-group pull-left">
							<div class='input-group date''>
								<input type='text'  disabled="disabled" class="form-control" id="ngayBan" /> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>
					<div class="col-md-2"></div>
					<div class="col-md-2">Ngày thanh toán</div>
					<div class="col-md-2">
						<div class="form-group pull-left">
							<div class='input-group date''>
								<input type='text' id="ngayThanhToan" class="form-control" /> <span
									class="input-group-addon"> <span
									class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-1">Mã KH</div>
					<div class="col-md-3">  <input id="maKhachHang" type="text" class="form-control"></div>
					<div class="col-md-2"><button id="kiemtra" type="button" class="btn btn-info btn-block">Kiểm tra</button></div>
					<div class="col-md-2">Họ tên</div>
					<div class="col-md-2"><input id="hoten" type="text" class="form-control"></div>
				</div>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-5"><button id="layMaKH" type="button" class="btn btn-primary btn-block">Lấy mã khách hàng tiếp theo</button></div>
					<div class="col-md-2"></div>
					<div class="col-md-2"></div>
				</div>
				<div class="row">
					<div class="col-md-1">Địa chỉ</div>
					<div class="col-md-9"><input id="diaChi" type="text" class="form-control"></div>
				</div>
			</div>

			<!-- solid sales graph -->
			<div class="">
				<!-- /.box-body -->
				
				<div class="box-footer no-border">
					<div class="row col-xs-12">
						<strong>Danh sách chi tiết phiếu bán hàng</strong>
					</div>
					<div class="row">
								<div class="col-xs-12">
									<div class="box" style="border: none !important;">
										<div class="box-body">
											<table id="tableSanPham"
												class="table table-bordered table-striped">
												<thead>
													<tr>
														<th>Tên sản phẩm</th>
														<th>Số luợng</th>
														<th>Đơn giá bán</th>
														<th>Thành tiền</th>
													</tr>
												</thead>
												<tbody>
														<tr>
															<td style="width: 200px;">
																<div class="dropdown">
																  <button class="btn btn-default dropdown-toggle" style="width: 100%" type="button" id="danhSachSanPham" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
																    Dropdown
																    <span class="caret"></span>
																  </button>
																  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
																    <li><a href="#">Action</a></li>
																    <li><a href="#">Another action</a></li>
																    <li><a href="#">Something else here</a></li>
																    <li role="separator" class="divider"></li>
																    <li><a href="#">Separated link</a></li>
																  </ul>
																</div>
															</td>
															<td style="width: 200px;"> <input type="text" class="form-control"></td>
															<td></td>
															<td></td>
															<td></td>
														</tr>
												</tbody>
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
			.customer-infor .row{
				margin-bottom: 10px;
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
							Mã DV: <input id=txtMaDichVu disabled="disabled" class="form-control" value="">
						</div>
						<div class="modal-body">
							Tên DV: 
							<textarea id="txtTenDichVu" class="form-control" rows="3"></textarea>
							Đơn giá: 
							<textarea id="txtDonGia" class="form-control" rows="3"></textarea>
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
// 				initTable();
			});
			
			function initTable(){
				var edit = "<a href=\"javascript:void(0)\" onClick=\"editKeyword(this);\"><i class=\"fa fa-edit\"></i> Edit</a>";
				var remove = "</br><a href=\"javascript:void(0)\" onClick=\"removeKeyword(this);\"><i class=\"fa fa-remove\"></i> Remove</a>";
				$('#tableSanPham').DataTable( {
			        fixedHeader: true,
					destroy: true,
			        "ajax": "getAllDichVu",
			        "columns": [
			            { "data": "maDV" },
			            { "data": "tenDV" },
			            { "data": "donGia" }
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
					$("#txtMaDichVu").val(data.maDV);
					$("#txtTenDichVu").val(data.tenDV);
					$("#txtDonGia").html(data.donGia);
					$("#txtDonGia").val(data.donGia);
				}else{
					$("#txtMaDichVu").val("");
					$("#txtTenDichVu").val("");
					$("#txtDonGia").val("");
				}
			}
			
			function removeKeyword(keyword){
				var result = confirm("Want to delete?");
				if (result) {
					var table = $("#tableSanPham").DataTable();
					var data = table.row( $(keyword).parents('tr') ).data();
					console.log(data);
					$.ajax({
						url: 'removeDichVu?maDV='+data.maDV,
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
			
			function updateKeyword(maDV, tenDV, donGia){
				var object = new Object();
				object.maDV = maDV;
				object.tenDV = tenDV;
				object.donGia = donGia;
				console.log("keyword: " + object);
				$.ajax({
				    url: 'updateDichVu',
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
			
			function addKeyword(tenDV, donGia){
				var object = new Object();
				object.tenDV = tenDV;
				object.donGia = donGia;
				console.log("keyword: " + object);
				$.ajax({
				    url: 'addDichVu',
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
				var id = $("#txtMaDichVu").val();
				if(id != null && id != undefined && id != ''){
					updateKeyword($("#txtMaDichVu").val(), $("#txtTenDichVu").val(), $("#txtDonGia").val());
				}else{
					addKeyword($("#txtTenDichVu").val(), $("#txtDonGia").val());
				}
				
			});
			
			$("#btnAddKW").click(function(){
				$("#modalEditKW").modal('show');
				$("#txtMessage").css("display","none");
				$("#txtMaDichVu").prop('disabled', true);
				$(".modal-header-remove").css("display","none");
				$("#txtMaDichVu").val('');
				$("#txtTenDichVu").val('');
				$("#txtDonGia").html('');
				$("#txtDonGia").val('');
				$("#txtDonGiaBan").val('');
				$("#txtSoLuongTonKho").val("");
			});
			
		</script>
</body>
