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
												<tbody id ="tablePhieuBanHang">
														<tr>
															<td style="width: 200px;">
																<select id="danhSachSanPham" class="selectpicker">
																	<option value="-1">-Chọn sản phẩm-</option>
																</select>
															</td>
															<td style="width: 200px;"> <input type="number" oninput="tinhTien(this.value);" class="form-control"></td>
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
				<div class="container customer-infor">
					<div class="row">
						<div class="col-md-2"><button id="themSanPham" type="button" class="btn btn-primary btn-block">Thêm sản phẩm</button></div>
						<div class="col-md-2"><button id="xoaSanPham" type="button" class="btn btn-danger btn-block">Xóa sản phẩm</button></div>
						<div class="col-md-2"></div>
						<div id="tongCong" class="col-md-1"><strong>Tổng cộng</strong></div>
						<div class="col-md-3">
							<input type="text" disabled="disabled" class="form-control">
						</div>
					</div>
				</div>
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
		var danhSachSanPham = null;
		var tempRow = "";
		getListSanPham();
	});
		$("#ngayBan").val(moment().format("DD/MM/YYYY"));
		
		$("#layMaKH").click(function(){
			$.LoadingOverlay("show");
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
			$.LoadingOverlay("show");
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
		
		function getListSanPham(){
			$.LoadingOverlay("show");
			$.ajax({
			    url: 'getAllSanPham',
			    type: 'POST',
			    success: function(data) {
			    		var list = data.data;
			    		$("#danhSachSanPham").html("");
			    		var content = "";
			    		content += "<option  value='-1'>-Chọn sản phẩm-</option>";
			    		for(var i = 0; i < list.length; i++){
			    			content += "<option  value='"+list[i].maSP+"'>"+ list[i].tenSP +"</option>";
			    		}
			    		$("#danhSachSanPham").html(content);
			    		$('.selectpicker').selectpicker('refresh');
			    		tempRow = $("#tablePhieuBanHang").children("tr:nth-child(1)").html();
			    		danhSachSanPham = list;
			    },
			    error: function(xhr, ajaxOptions, thrownError){
			    	console.log(thrownError);
			    }
			  });
			$.LoadingOverlay("hide");
		}
		
		
		$('#danhSachSanPham').on('changed.bs.select', function (e) {
			 var id = $("#danhSachSanPham").selectpicker('val');
			 console.log(id);
			 var sp = getProduct(id);
			 console.log("San pham: " + sp);
			 console.log(this);
			 var donGiaBan = getTdTable(3);
			 donGiaBan.html(sp == null ? "" : sp.donGiaBan);
			});
		$("#themSanPham").click(function(){
			themDongMoi();
		});
		
		function getProduct(maSP){
			for(var i = 0; i < danhSachSanPham.length; i++){
				if(danhSachSanPham[i].maSP == maSP) return danhSachSanPham[i];
			}
			return null;
		}
		
		function getTdTable(index){
			return $("#danhSachSanPham").closest("tr").children("td:nth-child("+index+")");
		}
		
		function tinhTien(soLuong){
			var thanhTien = getTdTable(4);
			var donGia = getTdTable(3).html();
			thanhTien.html(soLuong*Number(donGia));
		}
		
		function themDongMoi(){

			var newRow = '<tr>'+
							tempRow
							'</tr>';
				
			$("#tablePhieuBanHang").append(newRow);
		}
		</script>

</body>
