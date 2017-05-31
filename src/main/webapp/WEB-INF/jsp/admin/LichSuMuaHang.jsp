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
					<h4 style="margin-bottom: 25px !important;">Danh sách phiếu
						mua hàng</h4>
				</div>
				<hr />
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
												<th>Mã Phiếu mua hàng</th>
												<th>Mã khách hàng</th>
												<th>Ngày mua</th>
												<th>Ngày thanh toán</th>
												<th>Tổng tiền</th>
												<th>Action </th>
											</tr>
										</thead>
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
input.form-control.input-sm {
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




	<!-- Modal edit keyword -->
	<!-- Modal keyword -->
	<div id="modalChiTietPhieu" class="modal fade">
		<div class="modal-dialog" style="margin-top: 150px;">
			<div class="modal-content">
			<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
								<h3>Chi tiết phiếu</h3>
						</div>
						<div class="modal-body">
		
						<table id="tableChiTietPhieu"
							class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Mã CT Phiếu mua hàng</th>
									<th>Mã Sản phẩm</th>
									<th>Số lượng</th>
									<th>Thành tiền</th>

								</tr>
							</thead>
						</table>
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- .Model keywords -->
	<!-- .Model edit keyword -->

	<script>
		$(function() {
			initTable();
		});

		function initTable() {
			var detail = "<a href=\"javascript:void(0)\" onClick=\"detail(this);\"><i class=\"fa fa-info-circle \"></i> Detail</a>";
			$('#tableSanPham').DataTable({
				fixedHeader : true,
				destroy : true,
				"ajax" : "getAllPhieuMuaHang",
				"columns" : [ {
					"data" : "maP_MH"
				}, {
					"data" : "maP_MH"
				}, {
					"data" : "ngayMua"
				}, {
					"data" : "ngayThanhToan"
				}, {
					"data" : "tongCong"
				}, {
					"defaultContent" : detail
				} ]
			});
		}

		function detail(keyword) {
			$("#modalChiTietPhieu").modal('show');

			var table = $("#tableSanPham").DataTable();
			var data = table.row($(keyword).parents('tr')).data();
			console.log(data);
			$.ajax({
				url : 'getCTPMuaHangByMaPMH?maPMH=' + data.maP_MH,
				type : 'GET',
				success : function(data) {
					if (data.error == true) {
						alert(data.message);
					}
					$('#tableChiTietPhieu').DataTable({
						fixedHeader : true,
						destroy : true,
						data : data.data,
						"columns" : [ {
							"data" : "maCTP_MH"
						}, {
							"data" : "maSP"
						}, {
							"data" : "soLuong"
						}, {
							"data" : "thanhTien"
						} ]
					});
				},
				error : function(xhr, ajaxOptions, thrownError) {
					console.log(thrownError);
				}
			});

		}

	
	</script>
</body>
