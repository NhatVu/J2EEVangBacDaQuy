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
			<section class="content">
			<div class="container customer-infor">
				<div class="row">
					<div id="maPhieu" class="col-md-1">Mã phiếu</div>
					<div class="col-md-3"> <input type="text" disabled="disabled" class="form-control" value='<s:property value="maPhieu"/>'></div>
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
							<div class='input-group date'' id="pickerNgayThanhToan" >
								<input type='text' class="form-control" id="ngayThanhToan"  /> <span
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
					<div class="col-md-2"><button id="kiemtra" type="button" class="btn btn-info btn-block">Kiểm tra KH quen</button></div>
					<div class="col-md-2">Họ tên</div>
					<div class="col-md-2"><input id="hoten" type="text" class="form-control"></div>
				</div>
				<div class="row" id="message" style="display:none">
					<div class="col-md-1"></div>
					<div class="col-md-5"><p style="color:#dd4b39;">Bạn không phải là khách quen</p></div>
					<div class="col-md-4"></div>
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
		
	</div>
	
	<script>
	$(document).ready(function() {
		$('#pickerNgayThanhToan').datepicker({
			forceParse: false,
			format : 'dd/mm/yyyy',
			todayHighlight : true,
			"setDate" : new Date(),
			autoclose : true,
			onSelect: $.noop
		});
	});
		$("#ngayBan").val(moment().format("DD/MM/YYYY"));
		
		$("#layMaKH").click(function(){
			$.ajax({
			    url: 'getNextCustomerId',
			    type: 'POST',
			    success: function(data) {
			    		$("#maKhachHang").val(data.data);
			    },
			    error: function(xhr, ajaxOptions, thrownError){
			    	console.log(thrownError);
			    }
			  });
			$.LoadingOverlay("hide");
		});
		
		$("#kiemtra").click(function(){
			$("#message").css("display","none");
			var maKH = $("#maKhachHang").val();
			$.ajax({
			    url: 'checkKhachQuen?maKH='+maKH,
			    type: 'GET',
			    success: function(data) {
			    	if(data.error == false){
			    		$("#message").css("display","none");
			    		$("#hoten").val(data.data.hoTen);
			    		$("#diaChi").val(data.data.diaChi);
			    	}else{
			    		$("#message").css("display","block");
			    	}
			    },
			    error: function(xhr, ajaxOptions, thrownError){
			    	console.log(thrownError);
			    }
			  });
			$.LoadingOverlay("hide");
		})
		</script>

</body>
