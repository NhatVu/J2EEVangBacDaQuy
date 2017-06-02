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
					<h4 style="margin-bottom: 25px !important;">Phiếu mua hàng</h4>
				</div>
				<hr />
			</section>
			<section class="content">
				<div class="container customer-infor">
					<div class="row">
						<div class="col-md-1">Mã phiếu</div>
						<div class="col-md-3">
							<input id="maPhieu" type="text" disabled="disabled"
								class="form-control" value='<s:property value="maPhieu"/>'>
						</div>
						<div class="col-md-2"></div>
						<div class="col-md-1"></div>
						<div class="col-md-3"></div>
					</div>
					<div class="row">
						<div class="col-md-1">Ngày bán</div>
						<div class="col-md-3">
							<div class="form-group pull-left">
								<div class='input-group date''>
									<input type='text' disabled="disabled" class="form-control"
										id="ngayBan" /> <span class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="col-md-2"></div>
						<div class="col-md-2">Ngày thanh toán</div>
						<div class="col-md-2">
							<div class="form-group pull-left">
								<div class='input-group date' ' id="pickerNgayThanhToan">
									<input type='text' class="form-control" id="ngayThanhToan" />
									<span class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-1">Mã KH</div>
						<div class="col-md-3">
							<input id="maKhachHang" type="text" class="form-control">
						</div>
						<div class="col-md-2">
							<button id="kiemtra" type="button" class="btn btn-info btn-block">Kiểm
								tra KH quen</button>
						</div>
						<div class="col-md-2">Họ tên</div>
						<div class="col-md-2">
							<input id="hoten" type="text" class="form-control">
						</div>
					</div>
					<div class="row" id="message" style="display: none">
						<div class="col-md-1"></div>
						<div class="col-md-5">
							<p style="color: #dd4b39;">Bạn không phải là khách quen</p>
						</div>
						<div class="col-md-4"></div>
					</div>
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-5">
							<button id="layMaKH" type="button"
								class="btn btn-primary btn-block">Lấy mã khách hàng
								tiếp theo</button>
						</div>
						<div class="col-md-2"></div>
						<div class="col-md-2"></div>
					</div>
					<div class="row">
						<div class="col-md-1">Địa chỉ</div>
						<div class="col-md-9">
							<input id="diaChi" type="text" class="form-control">
						</div>
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
													<th><a href="javascript:void(0)" id="themSanPham"><i
															class="fa fa-plus-square"></i> Thêm sản phẩm</a></th>
												</tr>
											</thead>
											<tbody id="tablePhieuBanHang">
												<tr id="row-1">
													<td style="width: 200px;"><select
														class="selectSanPham form-control">
															<option value="-1">-Chọn sản phẩm-</option>
													</select></td>
													<td style="width: 200px;"><input type="number"
														oninput="tinhTien(this);"
														class="form-control inputSoLuong"></input></td>
													<td></td>
													<td></td>
													<td><a style="color: #dd4b39;"
														href="javascript:void(0)" id="xoaSanPham"
														onClick="xoaMotDong(this)"><i class="fa fa-remove"></i>
															Xóa sản phẩm</a></td>
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
						<div class="col-md-6">
							<p id="messageInfo" class="" style="display: none"></p>
						</div>
						<div id="tongCong" class="col-md-1">
							<strong>Tổng cộng</strong>
						</div>
						<div class="col-md-3">
							<input type="text" id="tongtien" disabled="disabled"
								class="form-control">
						</div>
					</div>

					<div class="row">
						<div class="col-md-2"></div>
						<div class="col-md-3"></div>
						<div class="col-md-2">
							<button id="taoMoiPhieu" type="button"
								class="btn btn-info btn-block">Tạo mới phiếu</button>
						</div>
						<div class="col-md-3">
							<button id="luuPhieu" type="button"
								class="btn btn-primary btn-block">Lưu phiếu mua hàng</button>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->

		</div>
		<jsp:include page="../../../layout/Footer.jsp" flush="true"></jsp:include>
		<style>
input.form-control.input-sm {
	width: 200px;
}

.customer-infor .row {
	margin-bottom: 10px;
}
</style>

	</div>

	<script>
		$(document).ready(function() {
			$('#pickerNgayThanhToan').datepicker({
				forceParse : false,
				format : 'dd/mm/yyyy',
				todayHighlight : true,
				"setDate" : new Date(),
				autoclose : true,
				onSelect : $.noop
			});
			var danhSachSanPham = null;
			var tempRow = "";
			getListSanPham();
			bindingEventSelect();
			bindingEventInput();
			$('#luuPhieu').prop('disabled', false);
		});
		$("#ngayBan").val(moment().format("DD/MM/YYYY"));

		$("#layMaKH").click(function() {
			$.LoadingOverlay("show");
			$.ajax({
				url : 'mhgetNextCustomerId',
				type : 'POST',
				success : function(data) {
					$("#maKhachHang").val(data.data);
				},
				error : function(xhr, ajaxOptions, thrownError) {
					console.log(thrownError);
				}
			});
			$.LoadingOverlay("hide");
		});

		$("#kiemtra").click(function() {
			$.LoadingOverlay("show");
			$("#message").css("display", "none");
			var maKH = $("#maKhachHang").val();
			$.ajax({
				url : 'mhcheckKhachQuen?maKH=' + maKH,
				type : 'GET',
				success : function(data) {
					if (data.error == false) {
						$("#message").css("display", "none");
						$("#hoten").val(data.data.hoTen);
						$("#diaChi").val(data.data.diaChi);
					} else {
						$("#message").css("display", "block");
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {
					console.log(thrownError);
				}
			});
			$.LoadingOverlay("hide");
		})

		function getListSanPham() {
			$.LoadingOverlay("show");
			$.ajax({
				url : 'getAllSanPham',
				type : 'POST',
				success : function(data) {
					var list = data.data;
					$(".selectSanPham").html("");
					var content = "";
					content += "<option  value='-1'>-Chọn sản phẩm-</option>";
					for (var i = 0; i < list.length; i++) {
						content += "<option  value='"+list[i].maSP+"'>"
								+ list[i].tenSP + "</option>";
					}
					$(".selectSanPham").html(content);
					// 			    		$('.selectSanPham').selectpicker('refresh');
					tempRow = $("#tablePhieuBanHang").children(
							"tr:nth-child(1)").html();
					danhSachSanPham = list;
				},
				error : function(xhr, ajaxOptions, thrownError) {
					console.log(thrownError);
				}
			});
			$.LoadingOverlay("hide");
		}

		$("#themSanPham").click(function() {
			themDongMoi();
		});
		$("#taoMoiPhieu").click(function() {
			location.href = "/VangBacDaQuy/admin/quanlymuahang";
		});
		$("#luuPhieu").click(function() {
			luuPhieuBanHang();
		});

		function getProduct(maSP) {
			for (var i = 0; i < danhSachSanPham.length; i++) {
				if (danhSachSanPham[i].maSP == maSP)
					return danhSachSanPham[i];
			}
			return null;
		}

		function getTdTable(e, index) {
			return $(e.target.closest('tr')).children(
					"td:nth-child(" + index + ")");
		}

		function getTdTableByThis(e, index) {
			return $(e.closest('tr')).children("td:nth-child(" + index + ")");
		}

		function getTdTableByParent(e, index) {
			return document.getElementById(e).children[index].textContent
					.trim();
		}

		function tinhTien(e) {
			var soLuong = e.value;
			$(e).html(e.value).change();
			$(e).val(e.value).change();
			console.log(e);
			var thanhTien = getTdTableByThis(e, 4);
			var donGia = getTdTableByThis(e, 3).html();
			thanhTien.html(soLuong * Number(donGia));
			tongTien();
		}

		function tongTien() {
			var listTr = $("#tablePhieuBanHang").children("tr");
			var sum = 0;
			for (var i = 0; i < listTr.length; i++) {
				sum += Number(getTdTableByThis(listTr[i], 4).html());
			}
			$("#tongtien").val(sum);
		}

		function themDongMoi() {
			var index = $("#tablePhieuBanHang").children("tr").length + 1;
			var newRow = '<tr id="row-' + index +'" >' + tempRow
			'</tr>';

			$("#tablePhieuBanHang").append(newRow);
			bindingEventSelect();
			bindingEventInput();
		}

		function xoaMotDong(a) {
			$(a).closest("tr").remove();
		}
		function bindingEventSelect() {
			$('.selectSanPham').on('change', function(e) {
				console.log(e);
				var id = e.target.value;
				console.log(id);
				var sp = getProduct(id);
				console.log("San pham: " + sp);
				console.log(this);
				var donGiaBan = getTdTable(e, 3);
				donGiaBan.html(sp == null ? "" : sp.donGiaBan);
			});
		}

		function bindingEventInput() {
			$(".inputSoLuong").keypress(function(event) {
				var keycode = (event.keyCode ? event.keyCode : event.which);
				if (keycode == '13') {
					themDongMoi();
				}
			});
		}

		function getListSPBanHang() {
			var list = $("#tablePhieuBanHang").children("tr");
			var listSP = new Array();
			for (var i = 0; i < list.length; i++) {
				var object = list[i];
				var SanPhamDTO = new Object();
				var maSP = $($(object).children("td")[0]).children("select")[0].value;
				if (maSP != -1) {
					console.log("maSP: " + maSP);
					var soLuong = $($(object).children("td")[1]).children(
							"input")[0].value;
					if(soLuong == null || soLuong == "")
						return new Array();
					console.log("soLuong: " + soLuong);
					SanPhamDTO.maSP = maSP;
					SanPhamDTO.soLuong = soLuong;
					listSP.push(SanPhamDTO);
				}
				console.log(listSP);
			}
			return listSP;
		}

		function luuPhieuBanHang() {
			$("#messageInfo").css("display", "none");
			var listSP = new Array();
			listSP = getListSPBanHang();
			listSP["_varname_"] = "listSP";
			listSP = getSimpleObject(listSP);
			var o = new Object();
			o.maPhieu = $("#maPhieu").val();
			o.ngayBan = $("#ngayBan").val();
			o.ngayThanhToan = $("#ngayThanhToan").val();

			if (moment(o.ngayThanhToan, "DD-MM-YYYY").diff(
					moment(o.ngayBan, "DD-MM-YYYY"), "days") < 0) {
				alert("Kiểm tra lại ngày thanh toán.");
				return;
			}

			o.maKhachHang = $("#maKhachHang").val();
			o.hoTen = $("#hoten").val();
			o.diaChi = $("#diaChi").val();
			o.tongTien = $("#tongtien").val();
			$.LoadingOverlay("show");
			$.ajax({
				url : 'mhluuPhieuMuaHang?maPhieu=' + o.maPhieu + '&ngayBan='
						+ o.ngayBan + '&maKH=' + o.maKhachHang
						+ '&ngayThanhToan=' + o.ngayThanhToan + '&hoTen='
						+ o.hoTen + '&diaChi=' + o.diaChi + '&tongTien='
						+ o.tongTien,
				type : 'POST',
				async : false,
				data : listSP,
				success : function(data) {
					$("#messageInfo").css("display", "block");
					$("#messageInfo").html(data.message);
					$("#messageInfo")
					if (data.error == false) {
						$("#messageInfo").remove("label-danger");
						$("#messageInfo").addClass("label-success");
						$('#luuPhieu').prop('disabled', true);
					} else {
						$("#messageInfo").addClass("label-danger");
						$("#messageInfo").remove("label-success");
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {
					console.log(thrownError);
				}
			});
			$.LoadingOverlay("hide");
		}

		function convertToSimpleObject(out, obj, prefix) {
			if (obj instanceof Array) {
				for (var index = 0; index < obj.length; index++) {
					var item = obj[index];
					var tmpPrefix = prefix + "[" + index + "]";
					if (item instanceof Array || item instanceof Object) {
						arguments.callee(out, item, tmpPrefix);
					} else {
						out[tmpPrefix] = item;
					}
				}
			} else if (obj instanceof Object) {
				for ( var propName in obj) {
					if (propName.toString() !== "_varname_") {
						var tmpPrefix;
						if (prefix && prefix.length > 0) {
							tmpPrefix = prefix + "." + propName;
						} else {
							tmpPrefix = propName;
						}
						var item = obj[propName];
						if (item instanceof Array || item instanceof Object) {
							arguments.callee(out, item, tmpPrefix);
						} else if (item != undefined && item != null) {
							out[tmpPrefix] = item;
						}
					}
				}
			}
		}
		function getPrefix(data) {
			var prefix = null;
			try {
				data.hasOwnProperty("_varname_");
			} catch (e) {
				throw 'Please check your data or browser support.';
			}
			if (data.hasOwnProperty("_varname_")) {
				try {
					prefix = data["_varname_"];
					delete data["_varname_"];
				} catch (e) {
				}
			} else {
				throw 'Missing "_varname_". Please check your data.';
			}
			if (prefix === null || prefix === undefined
					|| prefix.toString().trim().length === 0) {
				throw 'Missing "_varname_". Please check your data.';
			}
			return prefix;
		}

		function getSimpleObject(data) {
			var prefix = getPrefix(data);
			var out = {};
			convertToSimpleObject(out, data, prefix);
			return out;
		}
	</script>

</body>
